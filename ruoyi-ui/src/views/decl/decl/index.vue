<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item prop="fileType">
        <el-select v-model="queryParams.fileType" placeholder="请选择类型" clearable>
          <el-option
            v-for="dict in dict.type.t_declare_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item prop="documentTitle">
        <el-input
          v-model="queryParams.documentTitle"
          placeholder="请输入文件标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item prop="dateOfIssues">
        <el-date-picker
          v-model="queryParams.dateOfIssues"
          type="datetimerange"
          value-format="yyyy-MM-dd"
          range-separator="至"
          start-placeholder="发文开始日期"
          end-placeholder="发文结束日期">
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
          v-hasPermi="['decl:decl:add']"
        >新增</el-button>
      </el-col>
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="success"-->
<!--          plain-->
<!--          icon="el-icon-edit"-->
<!--          size="mini"-->
<!--          :disabled="single"-->
<!--          @click="handleUpdate"-->
<!--          v-hasPermi="['decl:decl:edit']"-->
<!--        >修改</el-button>-->
<!--      </el-col>-->
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['decl:decl:remove']"
        >批量删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['decl:decl:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="declList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" type="index" :index="indexMethod" width="50"/>
      <el-table-column label="文件标题" align="center" prop="documentTitle" />
      <el-table-column label="文件号" align="center" prop="documentNo" />
      <el-table-column label="文件类型" align="center" prop="fileType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_declare_type" :value="scope.row.fileType"/>
        </template>
      </el-table-column>
      <el-table-column label="编制单位" align="center" prop="preparedBy" />
      <el-table-column label="发文日期" align="center" prop="dateOfIssue" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.dateOfIssue, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" width="250" align="center" prop="remarks" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['decl:decl:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['decl:decl:remove']"
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

    <!-- 添加或修改项目申报书对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="编制单位" prop="preparedBy">
          <el-input v-model="form.preparedBy" placeholder="请输入编制单位" />
        </el-form-item>
        <el-form-item label="文件标题" prop="documentTitle">
          <el-input v-model="form.documentTitle" placeholder="请输入文件标题" />
        </el-form-item>
        <el-form-item label="文件号" prop="documentNo">
          <el-input v-model="form.documentNo" placeholder="请输入文件号" />
        </el-form-item>
        <el-form-item label="文件类型" prop="fileType">
          <el-select v-model="form.fileType" placeholder="文件类型">
            <el-option
              v-for="dict in dict.type.t_declare_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="发文日期" prop="dateOfIssue">
          <el-date-picker clearable
            v-model="form.dateOfIssue"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择发文日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注">
          <editor v-model="form.remarks" :min-height="150"/>
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
import { listDecl, getDecl, delDecl, addDecl, updateDecl } from "@/api/decl/decl";

export default {
  name: "Decl",
  dicts: ['t_declare_type'],
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
      // 项目申报书表格数据
      declList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        fileType: null,
        preparedBy: null,
        documentTitle: null,
        documentNo: null,
        dateOfIssue: null,
        remarks: null,
        dateOfIssues: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        documentTitle: [
          { required: true, message: "文件标题不能为空", trigger: "blur" }
        ],
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
    /** 查询项目申报书列表 */
    getList() {
      this.loading = true;
      listDecl(this.queryParams).then(response => {
        this.declList = response.rows;
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
        fileType: null,
        preparedBy: null,
        documentTitle: null,
        documentNo: null,
        dateOfIssue: null,
        remarks: null,
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
      this.title = "添加项目申报书";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDecl(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改项目申报书";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDecl(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDecl(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除项目申报书数据项？').then(function() {
        return delDecl(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('decl/decl/export', {
        ...this.queryParams
      }, `项目申报书.xlsx`)
    }
  }
};
</script>
