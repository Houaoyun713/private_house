<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item prop="patentName">
        <el-input
          v-model="queryParams.patentName"
          placeholder="请输入专利名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item prop="patentee">
        <el-input
          v-model="queryParams.patentee"
          placeholder="请输入专利权人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item prop="patentInventor">
        <el-input
          v-model="queryParams.patentInventor"
          placeholder="请输入专利发明人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item prop="authorization">
        <el-input
          v-model="queryParams.authorization"
          placeholder="请输入授权公告"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item prop="authorizedDates">
        <el-date-picker
          v-model="queryParams.authorizedDates"
          type="datetimerange"
          value-format="yyyy-MM-dd"
          range-separator="至"
          start-placeholder="公告日开始日期"
          end-placeholder="公告日结束日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['paree:paree:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['paree:paree:remove']"
        >批量删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['paree:paree:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="pareeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" type="index" :index="indexMethod" width="50"/>
      <el-table-column label="编号" align="center" prop="number" />
      <el-table-column label="专利名称" align="center" prop="patentName" />
      <el-table-column label="专利权人" align="center" prop="patentee" />
      <el-table-column label="专利发明人" align="center" prop="patentInventor" />
      <el-table-column label="授权公告"width="220"  align="center" prop="authorization" />
      <el-table-column label="授权公告日" align="center" prop="authorizedDate" width="120">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.authorizedDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="所属课题" align="center" prop="subject" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['paree:paree:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['paree:paree:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改专利对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="编号" prop="number">
          <el-input v-model="form.number" placeholder="请输入编号" />
        </el-form-item>
        <el-form-item label="专利名称" prop="patentName">
          <el-input v-model="form.patentName" placeholder="请输入专利名称" />
        </el-form-item>
        <el-form-item label="专利权人" prop="patentee">
          <el-input v-model="form.patentee" placeholder="请输入专利权人" />
        </el-form-item>
        <el-form-item label="发明人" prop="patentInventor">
          <el-input v-model="form.patentInventor" placeholder="请输入专利发明人" />
        </el-form-item>
        <el-form-item label="授权公告">
          <editor v-model="form.authorization" :min-height="130"/>
        </el-form-item>
        <el-table-column label="影响因子"width="220"  align="center" prop="authorization" />
        <el-form-item label="授权公告日" prop="authorizedDate" label-width="80">
          <el-date-picker clearable
            v-model="form.authorizedDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择授权公告日">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="所属课题" prop="subject">
          <el-input v-model="form.subject" placeholder="请输入所属课题" />
        </el-form-item>
        <el-form-item label="相关附件" prop="uploadName">
          <file-upload v-model="form.uploadName"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listParee, getParee, delParee, addParee, updateParee } from "@/api/paree/paree";

export default {
  name: "Paree",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 专利表格数据
      pareeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        number: null,
        patentName: null,
        patentee: null,
        patentInventor: null,
        authorization: null,
        authorizedDate: null,
        subject: null,
        authorizedDates: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    indexMethod(index) {
      return this.queryParams.pageSize*(this.queryParams.pageNum-1)+1+ index;
    },
    /** 查询专利列表 */
    getList() {
      this.loading = true;
      listParee(this.queryParams).then(response => {
        this.pareeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        number: null,
        patentName: null,
        patentee: null,
        patentInventor: null,
        authorization: null,
        authorizedDate: null,
        subject: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加专利";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getParee(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改专利";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateParee(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addParee(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除专利数据项？').then(function() {
        return delParee(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('paree/paree/export', {
        ...this.queryParams
      }, `专利.xlsx`)
    }
  }
};
</script>
