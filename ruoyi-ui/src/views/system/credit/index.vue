<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户账号" prop="userAccount">
        <el-input
          v-model="queryParams.userAccount"
          placeholder="请输入用户账号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="小区" prop="cellAddress">
        <el-input
          v-model="queryParams.cellAddress"
          placeholder="请输入所属小区地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建人" prop="createBy">
        <el-input
          v-model="queryParams.createBy"
          placeholder="请输入创建人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="奖品状态" prop="prizeStatus">
        <el-select v-model="queryParams.prizeStatus" placeholder="请选择奖品状态" clearable>
          <el-option label="未发放" value="notIssued"></el-option>
          <el-option label="已发放" value="issued"></el-option>
          <el-option label="已过期" value="expired"></el-option>
          <el-option label="已领取" value="received"></el-option>
        </el-select>
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
          v-hasPermi="['system:credit:add']"
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
          v-hasPermi="['system:credit:edit']"
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
          v-hasPermi="['system:credit:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:credit:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="creditList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="用户账号" align="center" prop="userAccount" />
      <el-table-column label="所属小区地址" align="center" prop="cellAddress" />
      <el-table-column label="积分余额" align="center" prop="points" />
      <el-table-column label="兑换奖品" align="center" prop="prize" />
      <el-table-column label="奖品状态" align="center" prop="prizeStatus" />
      <el-table-column label="创建人" align="center" prop="createBy" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:credit:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:credit:remove']"
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

    <!-- 添加或修改用户积分管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户账号" prop="userAccount">
          <el-input v-model="form.userAccount" placeholder="请输入用户账号" />
        </el-form-item>
        <el-form-item label="小区地址" prop="cellAddress">
          <el-input v-model="form.cellAddress" placeholder="请输入所属小区地址" />
        </el-form-item>
        <el-form-item label="积分余额" prop="points">
          <el-input v-model="form.points" placeholder="请输入积分余额" />
        </el-form-item>
        <el-form-item label="兑换奖品" prop="prize">
<!--          <el-input v-model="form.prize" placeholder="请输入兑换奖品" />-->
          <template>
            <el-select v-model="form.prize" placeholder="请选择奖品">
              <el-option
                v-for="item in options"
                :key="item.id"
                :label="item.prizeName"
                :value="item.prizeName">
              </el-option>
            </el-select>
          </template>
        </el-form-item>
        <el-form-item label="奖品状态" prop="prizeStatus">
<!--          <el-input v-model="form.prizeStatus" placeholder="请输入奖品状态" />-->
<el-select v-model="form.prizeStatus" placeholder="请选择奖品状态">
            <el-option label="未发放" value="未发放" />
            <el-option label="已发放" value="已发放" />
            <el-option label="已过期" value="已过期" />
            <el-option label="已领取" value="已领取" />
          </el-select>
        </el-form-item>
        <el-form-item label="创建人" prop="createBy">
          <el-input v-model="form.createBy" placeholder="请输入创建人" />
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
import { listCredit, getCredit, delCredit, addCredit, updateCredit } from "@/api/system/credit";
import { listAllPrize} from "@/api/system/prize";

export default {
  name: "Credit",
  data() {
    return {
      //奖品选择列表
      options: [

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
      // 用户积分管理表格数据
      creditList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userAccount: null,
        cellAddress: null,
        prizeStatus: null,
        createBy: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userAccount: [
          { required: true, message: "用户账号不能为空", trigger: "blur" }
        ],
        createBy: [
          { required: true, message: "创建人不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
    this.getPrizeList();
  },
  methods: {
    /** 查询所有奖品列表 */

    getPrizeList() {

      listAllPrize().then(response => {
        this.options = response.data;

        // this.options = response.rows;
      });
    },

    /** 查询用户积分管理列表 */
    getList() {
      this.loading = true;
      listCredit(this.queryParams).then(response => {
        this.creditList = response.rows;
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
        userAccount: null,
        cellAddress: null,
        points: null,
        prize: null,
        prizeStatus: null,
        createBy: null
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
      this.title = "添加用户积分管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCredit(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户积分管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCredit(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCredit(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除用户积分管理编号为"' + ids + '"的数据项？').then(function() {
        return delCredit(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/credit/export', {
        ...this.queryParams
      }, `credit_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
