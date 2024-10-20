<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="编号" prop="siteId">
        <el-input
          v-model="queryParams.siteId"
          placeholder="请输入编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="站点名称" prop="siteName">
        <el-input
          v-model="queryParams.siteName"
          placeholder="请输入站点名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属小区" prop="plot">
        <el-input
          v-model="queryParams.plot"
          placeholder="请输入所属小区"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="回收站" prop="sitRecyclingStation">
<!--        <el-input-->
<!--          v-model="queryParams.sitRecyclingStation"-->
<!--          placeholder="请输入所属回收站"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--  <template>
 />-->
        <template>
          <el-select v-model="form.sitRecyclingStation" placeholder="请选择所属回收站">
            <el-option
              v-for="item in options"
              :key="item.id"
              :label="item.stationName"
              :value="item.stationName">
            </el-option>
          </el-select>
        </template>
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
          v-hasPermi="['system:site:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:site:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:site:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:site:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="siteList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="序号" align="center" prop="id" />-->
      <el-table-column label="编号" align="center" prop="siteId" />
      <el-table-column label="站点名称" align="center" prop="siteName" />
      <el-table-column label="地址" align="center" prop="address" />
      <el-table-column label="所属小区" align="center" prop="plot" />
      <el-table-column label="所属回收站" align="center" prop="sitRecyclingStation" />
      <el-table-column label="可回收垃圾容纳量" align="center" prop="recyclableCapacity" />
      <el-table-column label="厨余垃圾容纳量" align="center" prop="kitchenWasteCapacity" />
      <el-table-column label="有害垃圾容纳量" align="center" prop="hazardousWasteCapacity" />
      <el-table-column label="其他垃圾容纳量" align="center" prop="otherWasteCapacity" />
      <el-table-column label="备注" align="center" prop="notes" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:site:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:site:remove']"
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

    <!-- 添加或修改垃圾站点管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="编号" prop="siteId">
          <el-input v-model="form.siteId" placeholder="请输入编号" />
        </el-form-item>
        <el-form-item label="站点名称" prop="siteName">
          <el-input v-model="form.siteName" placeholder="请输入站点名称" />
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="所属小区" prop="plot">
          <el-input v-model="form.plot" placeholder="请输入所属小区" />
        </el-form-item>
        <el-form-item label="回收站" prop="sitRecyclingStation">
          <template>
            <el-select v-model="form.sitRecyclingStation" placeholder="请选择所属回收站">
              <el-option
                v-for="item in options"
                :key="item.id"
                :label="item.stationName"
                :value="item.stationName">
              </el-option>
            </el-select>
          </template>
        </el-form-item>
        <el-form-item label="可回收垃圾容纳量" prop="recyclableCapacity">
          <el-input v-model="form.recyclableCapacity" placeholder="请输入可回收垃圾容纳量" />
        </el-form-item>
        <el-form-item label="厨余垃圾容纳量" prop="kitchenWasteCapacity">
          <el-input v-model="form.kitchenWasteCapacity" placeholder="请输入厨余垃圾容纳量" />
        </el-form-item>
        <el-form-item label="有害垃圾容纳量" prop="hazardousWasteCapacity">
          <el-input v-model="form.hazardousWasteCapacity" placeholder="请输入有害垃圾容纳量" />
        </el-form-item>
        <el-form-item label="其他垃圾容纳量" prop="otherWasteCapacity">
          <el-input v-model="form.otherWasteCapacity" placeholder="请输入其他垃圾容纳量" />
        </el-form-item>
        <el-form-item label="备注" prop="notes">
          <el-input v-model="form.notes" placeholder="请输入备注" />
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
import { listSite, getSite, delSite, addSite, updateSite } from "@/api/system/site";
import { listAllStation} from "@/api/system/station";

export default {
  name: "Site",
  data() {
    return {
      options:[

      ],
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
      // 垃圾站点管理表格数据
      siteList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        siteId: null,
        siteName: null,
        plot: null,
        sitRecyclingStation: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        siteId: [
          { required: true, message: "编号不能为空", trigger: "blur" }
        ],
        siteName: [
          { required: true, message: "站点名称不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "地址不能为空", trigger: "blur" }
        ],
        plot: [
          { required: true, message: "所属小区不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getAllStation();
  },
  methods: {
    /**查询所有回收站点 listAllPrize().then(response => {
        this.options = response.data;

        // this.options = response.rows;
      });
     },*/
    getAllStation(){
      listAllStation().then(response => {
        this.options = response.data;
      });
    },
    /** 查询垃圾站点管理列表 */
    getList() {
      this.loading = true;
      listSite(this.queryParams).then(response => {
        this.siteList = response.rows;
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
        siteId: null,
        siteName: null,
        address: null,
        plot: null,
        sitRecyclingStation: null,
        recyclableCapacity: null,
        kitchenWasteCapacity: null,
        hazardousWasteCapacity: null,
        otherWasteCapacity: null,
        notes: null
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
      this.title = "添加垃圾站点管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSite(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改垃圾站点管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSite(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSite(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除垃圾站点管理编号为"' + ids + '"的数据项？').then(function() {
        return delSite(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/site/export', {
        ...this.queryParams
      }, `site_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
