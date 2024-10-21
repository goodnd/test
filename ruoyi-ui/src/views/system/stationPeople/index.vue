<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="人员编号" prop="stationpeopleId">
        <el-input
          v-model="queryParams.stationpeopleId"
          placeholder="请输入人员编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-select v-model="queryParams.sex" placeholder="请选择性别" clearable>
          <el-option label="男" value="男"/>
          <el-option label="女" value="女"/>
        </el-select>
      </el-form-item>
      <el-form-item label="工作地区" prop="area">
        <el-input
          v-model="queryParams.area"
          placeholder="请输入工作地区"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="回收站" prop="station">
<!--        <template>-->
<!--          <el-select v-model="form.station" placeholder="请选择所属回收站">-->
<!--            <el-option-->
<!--              v-for="item in options"-->
<!--              :key="item.id"-->
<!--              :label="item.stationName"-->
<!--              :value="item.stationName">-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </template>-->
        <el-input
          v-model="queryParams.station"
          placeholder="请输入所属回收站"
          clearable
          @keyup.enter.native="handleQuery" />
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
          v-hasPermi="['system:stationPeople:add']"
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
          v-hasPermi="['system:stationPeople:edit']"
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
          v-hasPermi="['system:stationPeople:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:stationPeople:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="stationPeopleList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="人员编号" align="center" prop="stationpeopleId" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="性别" align="center" prop="sex">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.sex"/>
        </template>
      </el-table-column>
      <el-table-column label="电话号码" align="center" prop="phone" />
      <el-table-column label="家庭地址" align="center" prop="homeAddress" />
      <el-table-column label="岗位" align="center" prop="job" />
      <el-table-column label="工作地区" align="center" prop="area" />
      <el-table-column label="回收站" align="center" prop="station" />
      <el-table-column label="备注" align="center" prop="notes" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:stationPeople:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:stationPeople:remove']"
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

    <!-- 添加或修改回收站点人员对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="人员编号" prop="stationpeopleId">
          <el-input v-model="form.stationpeopleId" placeholder="请输入人员编号" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择性别">
            <el-option label="男" value="男"/>
            <el-option label="女" value="女"/>
          </el-select>
        </el-form-item>
        <el-form-item label="电话号码" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入电话号码" maxlength="11"/>
        </el-form-item>
        <el-form-item label="家庭地址" prop="homeAddress">
          <el-input v-model="form.homeAddress" placeholder="请输入家庭地址" />
        </el-form-item>
        <el-form-item label="岗位" prop="job">
          <el-input v-model="form.job" placeholder="请输入岗位" />
        </el-form-item>
        <el-form-item label="工作地区" prop="area">
          <el-input v-model="form.area" placeholder="请输入工作地区" />
        </el-form-item>
        <el-form-item label="回收站" prop="station">
          <template>
            <el-select v-model="form.station" placeholder="请选择所属回收站">
              <el-option
                v-for="item in options"
                :key="item.id"
                :label="item.stationName"
                :value="item.stationName">
              </el-option>
            </el-select>
          </template>
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
import { listStationPeople, getStationPeople, delStationPeople, addStationPeople, updateStationPeople } from "@/api/system/stationPeople";
import { listAllStation} from "@/api/system/station";

export default {
  name: "StationPeople",
  dicts: ['sys_user_sex'],
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
      // 回收站点人员表格数据
      stationPeopleList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        stationpeopleId: null,
        name: null,
        sex: null,
        area: null,
        station: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        phone: [
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur"
          }
        ],
        stationpeopleId: [
          { required: true, message: "人员编号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getAllStation();
  },
  methods: {
    getAllStation(){
      listAllStation().then(response => {
        this.options = response.data;
      });
    },
    /** 查询回收站点人员列表 */
    getList() {
      this.loading = true;
      listStationPeople(this.queryParams).then(response => {
        this.stationPeopleList = response.rows;
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
        stationpeopleId: null,
        name: null,
        sex: null,
        phone: null,
        homeAddress: null,
        job: null,
        area: null,
        station: null,
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
      this.title = "添加回收站点人员";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getStationPeople(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改回收站点人员";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateStationPeople(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStationPeople(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除回收站点人员编号为"' + ids + '"的数据项？').then(function() {
        return delStationPeople(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/stationPeople/export', {
        ...this.queryParams
      }, `stationPeople_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
