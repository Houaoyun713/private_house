<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择类型" clearable>
          <el-option
            v-for="dict in dict.type.t_paper_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item prop="subjects">
        <el-select v-model="queryParams.subjects" placeholder="请选择所属课题/子课题" clearable>
          <el-option
            v-for="dict in dict.type.t_paper_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item prop="dateOfPublics">
        <el-date-picker
          v-model="queryParams.dateOfPublics"
          type="datetimerange"
          value-format="yyyy-MM-dd"
          range-separator="至"
          start-placeholder="发表/出版开始日期"
          end-placeholder="发表/出版结束日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item prop="paperName">
        <el-input
          v-model="queryParams.paperName"
          placeholder="请输入论文/专著名称"
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
          v-hasPermi="['pap:pap:add']"
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
          v-hasPermi="['pap:pap:remove']"
        >批量删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['pap:pap:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="papList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" type="index" :index="indexMethod" width="50"/>
      <el-table-column label="编号" align="center" prop="number" />
      <el-table-column label="论文/专著名称" align="center" prop="paperName" width="80"/>
      <el-table-column label="作者单位" align="center" prop="authorUnit" />
      <el-table-column label="期刊名称" align="center" prop="journalName" />
      <el-table-column label="出版社" align="center" prop="press" />
      <el-table-column label="发表/出版时间" align="center" prop="dateOfPublic" width="120">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.dateOfPublic, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="卷/期/页码" align="center" prop="issue" width="80" />
      <el-table-column label="影响因子"width="220"  align="center" prop="influenceFactor" />
      <el-table-column label="所属课题/子课题" align="center" prop="subjects" width="80">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_paper_type" :value="scope.row.subjects"/>
        </template>
      </el-table-column>
      <el-table-column label="类型" align="center" prop="type" width="50">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_paper_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['pap:pap:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['pap:pap:remove']"
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

    <!-- 添加或修改论文对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="编号" prop="number">
          <el-input v-model="form.number" placeholder="请输入编号" />
        </el-form-item>
        <el-form-item label="论文名称" prop="paperName">
          <el-input v-model="form.paperName" placeholder="请输入论文/专著名称" />
        </el-form-item>
        <el-form-item label="作者单位" prop="authorUnit">
          <el-input v-model="form.authorUnit" placeholder="请输入作者单位" />
        </el-form-item>
        <el-form-item label="类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择类型">
            <el-option
              v-for="dict in dict.type.t_paper_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="期刊名称" prop="journalName">
          <el-input v-model="form.journalName" placeholder="请输入期刊名称" />
        </el-form-item>
        <el-form-item label="出版社" prop="press">
          <el-input v-model="form.press" placeholder="请输入出版社" />
        </el-form-item>
        <el-form-item label="发表时间" prop="dateOfPublic">
          <el-date-picker clearable
            v-model="form.dateOfPublic"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择发表/出版时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="卷/期/页码" prop="issue">
          <el-input v-model="form.issue" placeholder="请输入卷/期/页码" />
        </el-form-item>
        <el-form-item label="所属课题" prop="subjects">
          <el-select v-model="form.subjects" placeholder="请选择所属课题/子课题">
            <el-option
              v-for="dict in dict.type.t_paper_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="影响因子">
          <editor v-model="form.influenceFactor" :min-height="192"/>
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
import { listPap, getPap, delPap, addPap, updatePap } from "@/api/pap/pap";

export default {
  name: "Pap",
  dicts: ['t_paper_type'],
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
      // 论文表格数据
      papList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        number: null,
        type: null,
        paperName: null,
        authorUnit: null,
        journalName: null,
        press: null,
        dateOfPublic: null,
        issue: null,
        influenceFactor: null,
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
    /** 查询论文列表 */
    getList() {
      this.loading = true;
      listPap(this.queryParams).then(response => {
        this.papList = response.rows;
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
        type: null,
        paperName: null,
        authorUnit: null,
        journalName: null,
        press: null,
        dateOfPublic: null,
        issue: null,
        influenceFactor: null,
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
      this.title = "添加论文";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPap(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改论文";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePap(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPap(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除论文数据项？').then(function() {
        return delPap(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('pap/pap/export', {
        ...this.queryParams
      }, `论文.xlsx`)
    }
  }
};
</script>
