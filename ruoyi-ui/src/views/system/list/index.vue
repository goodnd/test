<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="车辆编号" prop="vehicleId">
        <el-input
          v-model="queryParams.vehicleId"
          placeholder="请输入车辆编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车牌号" prop="vehiclePlateNumber">
        <el-input
          v-model="queryParams.vehiclePlateNumber"
          placeholder="请输入车牌号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车辆状态" prop="vehicleStatus">
        <el-select v-model="queryParams.vehicleStatus" placeholder="请选择车辆状态" clearable>
          <el-option label="正常" value="正常"></el-option>
          <el-option label="正在维修中" value="正在维修中"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="使用人" prop="driver">
        <el-input
          v-model="queryParams.driver"
          placeholder="请输入使用人"
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
          v-hasPermi="['system:list:add']"
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
          v-hasPermi="['system:list:edit']"
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
          v-hasPermi="['system:list:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:list:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="listList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="车辆编号" align="center" prop="vehicleId" />
      <el-table-column label="车牌号" align="center" prop="vehiclePlateNumber" />
      <el-table-column label="车辆状态" align="center" prop="vehicleStatus" />
      <el-table-column label="车辆类型" align="center" prop="vehicleType" />
      <el-table-column label="使用人" align="center" prop="driver" />
      <el-table-column label="容纳量" align="center" prop="vehicleCapacity" />
      <el-table-column label="备注" align="center" prop="notes" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:list:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:list:remove']"
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

    <!-- 添加或修改运输车辆对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="车辆编号" prop="vehicleId">
          <el-input v-model="form.vehicleId" placeholder="请输入车辆编号" />
        </el-form-item>
        <el-form-item label="车牌号" prop="vehiclePlateNumber">
          <el-input v-model="form.vehiclePlateNumber" placeholder="请输入车牌号" />
        </el-form-item>
        <el-form-item label="车辆状态" prop="vehicleStatus">
<!--          <el-select v-model="form.vehicleStatus" placeholder="请选择车辆状态" clearable>-->
<!--            <el-option-->
<!--              v-for="option in vehicleOptions"-->
<!--              :key="option.value"-->
<!--              :label="option.label"-->
<!--              :value="option.value"-->
<!--              v-slot="{ option }">-->
<!--              <span :style="{ color: option.value === '正常' ? 'green' : 'red' }">{{ option.label }}</span>-->
<!--            </el-option>-->
<!--          </el-select>-->
          <el-select v-model="form.vehicleStatus" placeholder="请选择车辆状态" clearable>
            <el-option label="正常" value="正常"></el-option>
            <el-option label="正在维修中" value="正在维修中"></el-option>
          </el-select>
        </el-form-item>
<!--        <el-table-column label="车辆类型" align="center" prop="vehicleType" />-->
        <el-form-item label="车辆类型" prop="vehicleType">
          <el-select v-model="form.vehicleType" placeholder="请选择车辆类型" clearable>
            <el-option label="压缩式垃圾车" value="压缩式垃圾车"></el-option>
            <el-option label="自卸式垃圾车" value="自卸式垃圾车"></el-option>
            <el-option label="摆臂式垃圾车" value="摆臂式垃圾车"></el-option>
            <el-option label="自装卸式垃圾车" value="自装卸式垃圾车"></el-option>
            <el-option label="密封式垃圾车" value="密封式垃圾车"></el-option>
            <el-option label="拉臂式垃圾车" value="拉臂式垃圾车"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="使用人" prop="driver">
          <el-input v-model="form.driver" placeholder="请输入使用人" />
        </el-form-item>
        <el-form-item label="容纳量" prop="vehicleCapacity">
          <el-input v-model="form.vehicleCapacity" placeholder="请输入容纳量" />
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
import { listList, getList, delList, addList, updateList } from "@/api/system/list";

export default {
  name: "List",
  dicts: ['sys_job_status'],
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
      // 运输车辆表格数据
      listList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        vehicleId: null,
        vehiclePlateNumber: null,
        vehicleStatus: null,
        vehicleType: null,
        driver: null,
      },
      // 表单参数
      form: {
        vehicleStatus: ''
      },
      vehicleOptions: [
        { label: '正常', value: '正常' },
        { label: '正在维修中', value: '正在维修中' }
      ],
      // 表单校验
      rules: {
        vehicleId: [
          { required: true, message: "车辆编号不能为空", trigger: "blur" }
        ],
        vehiclePlateNumber: [
          { required: true, message: "车牌号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询运输车辆列表 */
    getList() {
      this.loading = true;
      listList(this.queryParams).then(response => {
        this.listList = response.rows;
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
        vehicleId: null,
        vehiclePlateNumber: null,
        vehicleStatus: null,
        vehicleType: null,
        driver: null,
        vehicleCapacity: null,
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
      this.title = "添加运输车辆";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getList(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改运输车辆";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateList(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addList(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除运输车辆编号为"' + ids + '"的数据项？').then(function() {
        return delList(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/list/export', {
        ...this.queryParams
      }, `list_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
