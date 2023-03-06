<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item prop="copyrightOwner">
        <el-input
          v-model="queryParams.copyrightOwner"
          placeholder="请输入著作权人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item prop="authorUnit">
        <el-input
          v-model="queryParams.authorUnit"
          placeholder="请输入作者单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item prop="dateOfPubs">
        <el-date-picker
          v-model="queryParams.dateOfPubs"
          type="datetimerange"
          value-format="yyyy-MM-dd"
          range-separator="至"
          start-placeholder="首次发表开始日期"
          end-placeholder="首次发表结束日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item prop="registrationNo">
        <el-input
          v-model="queryParams.registrationNo"
          placeholder="请输入登记号"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['softwa:softwa:add']"
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
          v-hasPermi="['softwa:softwa:remove']"
        >批量删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['softwa:softwa:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="softwaList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" type="index" :index="indexMethod" width="50"/>
      <el-table-column label="编号" align="center" prop="number" />
      <el-table-column label="著作权人" align="center" prop="copyrightOwner" />
      <el-table-column label="软件名称" align="center" prop="softwareName" />
      <el-table-column label="作者" align="center" prop="author" />
      <el-table-column label="作者单位" align="center" prop="authorUnit" />
      <el-table-column label="开发完成日期" align="center" prop="completionDate" width="120">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.completionDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="首次发表日期" align="center" prop="dateOfPub" width="120">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.dateOfPub, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="权利取得方式" align="center" prop="rightMethod" width="80" />
      <el-table-column label="登记号" align="center" prop="registrationNo" />
      <el-table-column label="证书号" align="center" prop="certificateNo" />
      <el-table-column label="软件代码行数" align="center" prop="numberOfSoftware" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['softwa:softwa:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['softwa:softwa:remove']"
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

    <!-- 添加或修改软件著作权对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="编号" prop="number">
          <el-input v-model="form.number" placeholder="请输入编号" />
        </el-form-item>
        <el-form-item label="著作权人" prop="copyrightOwner">
          <el-input v-model="form.copyrightOwner" placeholder="请输入著作权人" />
        </el-form-item>
        <el-form-item label="软件名称" prop="softwareName">
          <el-input v-model="form.softwareName" placeholder="请输入软件名称" />
        </el-form-item>
        <el-form-item label="作者" prop="author">
          <el-input v-model="form.author" placeholder="请输入作者" />
        </el-form-item>
        <el-form-item label="作者单位" prop="authorUnit">
          <el-input v-model="form.authorUnit" placeholder="请输入作者单位" />
        </el-form-item>
        <el-form-item label="开发完成日期" prop="completionDate" label-width="80">
          <el-date-picker clearable
            v-model="form.completionDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开发完成日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="首次发表日期" prop="dateOfPub" label-width="80">
          <el-date-picker clearable
            v-model="form.dateOfPub"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择首次发表日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="权利取得方式" prop="rightMethod">
          <el-input v-model="form.rightMethod" placeholder="请输入权利取得方式" />
        </el-form-item>
        <el-form-item label="登记号" prop="registrationNo">
          <el-input v-model="form.registrationNo" placeholder="请输入登记号" />
        </el-form-item>
        <el-form-item label="证书号" prop="certificateNo">
          <el-input v-model="form.certificateNo" placeholder="请输入证书号" />
        </el-form-item>
        <el-form-item label="软件代码行数" prop="numberOfSoftware">
          <el-input v-model="form.numberOfSoftware" placeholder="请输入软件代码行数" />
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
import { listSoftwa, getSoftwa, delSoftwa, addSoftwa, updateSoftwa } from "@/api/softwa/softwa";

export default {
  name: "Softwa",
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
      // 软件著作权表格数据
      softwaList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        number: null,
        copyrightOwner: null,
        softwareName: null,
        author: null,
        authorUnit: null,
        completionDate: null,
        dateOfPub: null,
        rightMethod: null,
        registrationNo: null,
        certificateNo: null,
        numberOfSoftware: null,
        dateOfPubs: null,
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
    /** 查询软件著作权列表 */
    getList() {
      this.loading = true;
      listSoftwa(this.queryParams).then(response => {
        this.softwaList = response.rows;
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
        copyrightOwner: null,
        softwareName: null,
        author: null,
        authorUnit: null,
        completionDate: null,
        dateOfPub: null,
        rightMethod: null,
        registrationNo: null,
        certificateNo: null,
        numberOfSoftware: null,
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
      this.title = "添加软件著作权";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSoftwa(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改软件著作权";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSoftwa(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSoftwa(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除软件著作权数据项？').then(function() {
        return delSoftwa(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('softwa/softwa/export', {
        ...this.queryParams
      }, `软件著作权.xlsx`)
    }
  }
};
</script>
