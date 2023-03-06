<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.t_key_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item prop="keyWord">
        <el-input
          v-model="queryParams.keyWord"
          placeholder="请输入关键词"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item prop="subjects">
        <el-select v-model="queryParams.subjects" placeholder="请选择归属课题" clearable>
          <el-option
            v-for="dict in dict.type.t_key_depart"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item prop="publicTimes">
        <el-date-picker
          v-model="queryParams.publicTimes"
          type="datetimerange"
          value-format="yyyy-MM-dd"
          range-separator="至"
          start-placeholder="发表开始日期"
          end-placeholder="发表结束日期">
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
          v-hasPermi="['projec:projec:add']"
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
          v-hasPermi="['projec:projec:remove']"
        >批量删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['projec:projec:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="projecList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" type="index" :index="indexMethod" width="50"/>
      <el-table-column label="成果名称" align="center" prop="achieName" />
      <el-table-column label="关键词" align="center" prop="keyWord" />
      <el-table-column label="上报公司" align="center" prop="reportComp">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_key_status" :value="scope.row.reportComp"/>
        </template>
      </el-table-column>
      <el-table-column label="发布时间" align="center" prop="releaseDate" width="120">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.releaseDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="发表时间" align="center" prop="publicTime" width="120">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.publicTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="拟竣工时间" align="center" prop="propoTime" width="120">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.propoTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="总投资" align="center" prop="totalInve" />
      <el-table-column label="项目主管部门" align="center" prop="projectDepart">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_key_direct" :value="scope.row.projectDepart"/>
        </template>
      </el-table-column>
      <el-table-column label="级别" align="center" prop="levels">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_key_level" :value="scope.row.levels"/>
        </template>
      </el-table-column>
      <el-table-column label="归属课题" align="center" prop="subjects">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_key_depart" :value="scope.row.subjects"/>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status" width="80">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_key_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['projec:projec:edit']"
          >编辑</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['projec:projec:remove']"
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

    <!-- 添加或修改关键技术对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="成果名称" prop="achieName">
          <el-input v-model="form.achieName" placeholder="请输入成果名称" />
        </el-form-item>
        <el-form-item label="关键词" prop="keyWord">
          <el-input v-model="form.keyWord" placeholder="请输入关键词" />
        </el-form-item>
        <el-form-item label="上报公司" prop="reportComp">
          <el-select v-model="form.reportComp" placeholder="上报公司">
            <el-option
              v-for="dict in dict.type.t_key_projects"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="总投资" prop="totalInve">
          <el-input v-model="form.totalInve" placeholder="请输入总投资" />
        </el-form-item>
        <el-form-item label="主管部门" prop="projectDepart">
          <el-select v-model="form.projectDepart" placeholder="项目主管部门">
            <el-option
              v-for="dict in dict.type.t_key_direct"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="级别" prop="levels">
          <el-select v-model="form.levels" placeholder="级别">
            <el-option
              v-for="dict in dict.type.t_key_level"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="归属课题" prop="subjects">
          <el-select v-model="form.subjects" placeholder="归属课题">
            <el-option
              v-for="dict in dict.type.t_key_depart"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="发布时间" prop="releaseDate">
          <el-date-picker clearable
            v-model="form.releaseDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择发布时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="发表时间" prop="publicTime">
          <el-date-picker clearable
            v-model="form.publicTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择发表时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="拟竣工时间" prop="propoTime"label-width="80">
          <el-date-picker clearable
            v-model="form.propoTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择拟竣工时间">
          </el-date-picker>
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
import { listProjec, getProjec, delProjec, addProjec, updateProjec } from "@/api/projec/projec";

export default {
  name: "Projec",
  dicts: ['t_key_direct', 't_key_level', 't_key_depart', 't_key_projects', 't_key_status'],
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
      // 关键技术表格数据
      projecList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        releaseDate: null,
        status: null,
        achieName: null,
        keyWord: null,
        reportComp: null,
        publicTime: null,
        propoTime: null,
        totalInve: null,
        projectDepart: null,
        levels: null,
        subjects: null,
        publicTimes: null,
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
    /** 查询关键技术列表 */
    getList() {
      this.loading = true;
      listProjec(this.queryParams).then(response => {
        this.projecList = response.rows;
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
        releaseDate: null,
        status: null,
        achieName: null,
        keyWord: null,
        reportComp: null,
        publicTime: null,
        propoTime: null,
        totalInve: null,
        projectDepart: null,
        levels: null,
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
      this.title = "添加关键技术";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getProjec(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改关键技术";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateProjec(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProjec(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除关键技术数据项？').then(function() {
        return delProjec(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('projec/projec/export', {
        ...this.queryParams
      }, `关键技术.xlsx`)
    }
  }
};
</script>
