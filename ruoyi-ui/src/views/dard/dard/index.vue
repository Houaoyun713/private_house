<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.t_guide_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item prop="number">
        <el-input
          v-model="queryParams.number"
          placeholder="请输入编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item prop="preparedUnit">
        <el-input
          v-model="queryParams.preparedUnit"
          placeholder="请输入编制单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item prop="subjects">
        <el-select v-model="queryParams.subjects" placeholder="请选择归属课题" clearable>
          <el-option
            v-for="dict in dict.type.t_guide_company"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入名称"
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
          v-hasPermi="['dard:dard:add']"
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
          v-hasPermi="['dard:dard:remove']"
        >批量删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['dard:dard:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="dardList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" type="index" :index="indexMethod" width="50"/>
      <el-table-column label="编号" align="center" prop="number" />
      <el-table-column label="编制单位" align="center" prop="preparedUnit" />
      <el-table-column label="名称" align="center" prop="name" />
      <el-table-column label="内容简介" width="220" align="center" prop="contentValidity" />
      <el-table-column label="适用范围" width="220" align="center" prop="scopeApplication" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_key_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="技术规范类型" align="center" prop="technicalType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_guide_type" :value="scope.row.technicalType"/>
        </template>
      </el-table-column>
      <el-table-column label="发布单位" align="center" prop="issuedBy">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_guide_company" :value="scope.row.issuedBy"/>
        </template>
      </el-table-column>
      <el-table-column label="编制人员" align="center" prop="preparedBy" />
      <el-table-column label="归属课题" align="center" prop="subjects" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['dard:dard:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['dard:dard:remove']"
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

    <!-- 添加或修改导则规范对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="编号" prop="number">
          <el-input v-model="form.number" placeholder="请输入编号" />
        </el-form-item>
        <el-form-item label="编制单位" prop="preparedUnit">
          <el-input v-model="form.preparedUnit" placeholder="请输入编制单位" />
        </el-form-item>
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称" />
        </el-form-item>
        <el-form-item label="适用范围" prop="scopeApplication">
          <el-input v-model="form.scopeApplication" type="textarea" placeholder="请输入适用范围" />
        </el-form-item>
        <el-form-item label="技术规范类型" prop="technicalType" label-width="80">
          <el-select v-model="form.technicalType" placeholder="技术规范类型">
            <el-option
              v-for="dict in dict.type.t_guide_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="发布单位" prop="issuedBy">
          <el-select v-model="form.issuedBy" placeholder="发布单位">
            <el-option
              v-for="dict in dict.type.t_guide_company"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="编制人员" prop="preparedBy">
          <el-input v-model="form.preparedBy" placeholder="请输入编制人员" />
        </el-form-item>
        <el-form-item label="归属课题" prop="subjects">
          <el-input v-model="form.subjects" placeholder="请输入归属课题" />
        </el-form-item>
        <el-form-item label="内容简介">
          <editor v-model="form.contentValidity" :min-height="192"/>
        </el-form-item>
<!--        <el-form-item label="内容简介" prop="contentValidity">-->
<!--          <el-input v-model="form.contentValidity" type="textarea" placeholder="请输入内容简介" />-->
<!--        </el-form-item>-->
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
import { listDard, getDard, delDard, addDard, updateDard } from "@/api/dard/dard";

export default {
  name: "Dard",
  dicts: ['t_guide_status', 't_guide_type', 't_guide_company'],
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
      // 导则规范表格数据
      dardList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        number: null,
        preparedUnit: null,
        name: null,
        contentValidity: null,
        scopeApplication: null,
        status: null,
        technicalType: null,
        issuedBy: null,
        preparedBy: null,
        subjects: null,
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
    /** 查询导则规范列表 */
    getList() {
      this.loading = true;
      listDard(this.queryParams).then(response => {
        this.dardList = response.rows;
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
        preparedUnit: null,
        name: null,
        contentValidity: null,
        scopeApplication: null,
        status: null,
        technicalType: null,
        issuedBy: null,
        preparedBy: null,
        subjects: null,
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
      this.title = "添加导则规范";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDard(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改导则规范";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDard(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDard(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除导则规范数据项？').then(function() {
        return delDard(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('dard/dard/export', {
        ...this.queryParams
      }, `导则规范.xlsx`)
    }
  }
};
</script>
