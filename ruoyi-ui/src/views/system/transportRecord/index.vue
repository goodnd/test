<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="运输编号" prop="transportId">
        <el-input
          v-model="queryParams.transportId"
          placeholder="请输入运输编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="运输日期" prop="transportDay">
        <el-date-picker clearable
          v-model="queryParams.transportDay"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择运输日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="负责站点" prop="transportSites">
        <el-input
          v-model="queryParams.transportSites"
          placeholder="请输入负责站点"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="回收站" prop="transportStation">
<!--        <el-input-->
<!--          v-model="queryParams.transportStation"-->
<!--          placeholder="请输入目标回收站"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
        <template>
          <el-select v-model="form.transportStation" placeholder="请选择目标回收站">
            <el-option
              v-for="item in options"
              :key="item.id"
              :label="item.stationName"
              :value="item.stationName">
            </el-option>
          </el-select>
        </template>
      </el-form-item>
<!--       <el-table-column label="运输状态" align="center" prop="transportStatus" />-->
      <el-form-item label="运输状态" prop="transportStatus">
        <el-select v-model="form.transportStatus" placeholder="请选择运输状态">
          <el-option label="未运输" value="未运输" />
          <el-option label="正在运输中" value="正在运输中" />
          <el-option label="运输完成" value="运输完成" />
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
          v-hasPermi="['system:transportRecord:add']"
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
          v-hasPermi="['system:transportRecord:edit']"
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
          v-hasPermi="['system:transportRecord:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:transportRecord:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="transportRecordList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="运输编号" align="center" prop="transportId" />
      <el-table-column label="运输日期" align="center" prop="transportDay" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.transportDay, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="负责站点" align="center" prop="transportSites" />
      <el-table-column label="目标回收站" align="center" prop="transportStation" />
      <el-table-column label="开始时间" align="center" prop="transportStartTime" width="180">
        <template slot-scope="scope">
          <span>{{scope.row.transportStartTime}}</span>
        </template>
      </el-table-column>
      <el-table-column label="运输司机" align="center" prop="driver" />
      <el-table-column label="车辆车牌号" align="center" prop="vehiclePlateNumber" />
      <el-table-column label="运输状态" align="center" prop="transportStatus" />
      <el-table-column label="完成时间" align="center" prop="transportFinishTime" width="180">
        <template slot-scope="scope">
          <span>{{scope.row.transportFinishTime}}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:transportRecord:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:transportRecord:remove']"
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

    <!-- 添加或修改垃圾运输记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="运输编号" prop="transportId">
          <el-input v-model="form.transportId" placeholder="请输入运输编号" />
        </el-form-item>
        <el-form-item label="运输日期" prop="transportDay">
          <el-date-picker clearable
            v-model="form.transportDay"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择运输日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="负责站点" prop="transportSites">
<!--          <el-input v-model="form.transportSites" placeholder="请输入负责站点" />-->
          <el-select v-model="form.transportSites" multiple placeholder="请选择负责站点">
            <el-option
              v-for="item in siteOptions"
              :key="item.id"
              :label="item.siteName"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="目标回收站" prop="transportStation">
<!--          <el-input v-model="form.transportStation" placeholder="请输入目标回收站" />-->
          <template>
            <el-select v-model="form.transportStation" placeholder="请选择目标回收站">
              <el-option
                v-for="item in options"
                :key="item.id"
                :label="item.stationName"
                :value="item.id">
              </el-option>
            </el-select>
          </template>
        </el-form-item>
<!--        <el-form-item label="开始时间" prop="transportStartTime" @change="checkChange">-->
<!--          <el-time-picker  v-model="form.transportStartTime"-->
<!--          format="HH:mm:ss"-->
<!--          value-format="HH:mm:ss"-->
<!--          :picker-options='{"selectableRange":"00:00:00-23:59:59"}'-->
<!--          :style="{width: '100%'}"-->
<!--          placeholder="请选择时间选择"-->
<!--          clearable>-->

<!--          </el-time-picker>-->
<!--        </el-form-item>-->
        <el-form-item label="开始时间" prop="transportStartTime">
          <el-time-select
            v-model="form.transportStartTime"
            :picker-options="{
          start: '08:30',
          step: '00:15',
          end: '18:30'
          }"
            placeholder="选择时间">
          </el-time-select>
        </el-form-item>
        <el-form-item label="运输司机" prop="driver">
          <el-input v-model="form.driver" placeholder="请输入运输司机" />
        </el-form-item>
        <el-form-item label="车辆车牌号" prop="vehiclePlateNumber">
          <el-input v-model="form.vehiclePlateNumber" placeholder="请输入车辆车牌号" />
        </el-form-item>
     <el-form-item label="运输状态" prop="transportStatus">
          <el-select
            v-model="form.transportStatus"
            placeholder="请选择运输状态"
            @change="handleTransportStatusChange"
          >
            <el-option label="未运输" value="未运输" />
            <el-option label="正在运输中" value="正在运输中" />
            <el-option label="运输完成" value="运输完成" />
          </el-select>

      </el-form-item>


        <el-form-item label="完成时间" prop="transportFinishTime">
          <el-time-select
            v-model="form.transportFinishTime"
            :disabled="form.transportStatus !== '运输完成'"
            :picker-options="{
      start: '08:30',
      step: '00:15',
      end: '18:30'
    }"

            placeholder="选择时间"

          >
          </el-time-select>
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
import { listTransportRecord, getTransportRecord, delTransportRecord, addTransportRecord, updateTransportRecord } from "@/api/system/transportRecord";
import { listAllStation} from "@/api/system/station";
import { listAllSite } from "@/api/system/site";


export default {

  name: "TransportRecord",

  data() {
    return {
      value: '',
      siteOptions:[],
      options: [],
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
      // 垃圾运输记录表格数据
      transportRecordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        transportId: null,
        transportDay: null,
        transportSites: [],
        transportStation: null,
        transportStatus: null,
      },
      // 表单参数
      form: {

        transportId: '',
        driver: '',
        vehiclePlateNumber: '',
        transportStartTime: null,// 初始化开始时间
        transportFinishTime: null,
        transportStatus: ''
      },
      // 表单校验
      rules: {
        transportId: [
          { required: true, message: "运输编号不能为空", trigger: "blur" }
        ],

      }
    };
  },
  computed: {
    isFinishTimeDisabled() {
      // 如果运输状态不等于“运输完成”，则禁用选择器
      return this.form.transportStatus !== '运输完成';
    }
  },
  created() {
    this.getList();
    this.getAllStation();
    this.getAllSite();
  },
  methods: {
    handleTransportStatusChange() {
      // 当运输状态变化时，如果状态不等于“运输完成”，则将完成时间设置为 null
      if (this.form.transportStatus !== '运输完成') {
        this.form.transportFinishTime = null; // 设置完成时间为 null
      }

  },
    getAllSite(){
      listAllSite().then(response => {
        this.siteOptions = response.data;
      });
    },
    parseTime(time, format) {
      if (!time) return ''; // 处理空值
      const date = new Date(time);
      if (isNaN(date.getTime())) return '时间格式错误'; // 处理错误时间格式

      // 使用正则表达式进行格式化
      const hours = date.getHours().toString().padStart(2, '0');
      const minutes = date.getMinutes().toString().padStart(2, '0');
      const seconds = date.getSeconds().toString().padStart(2, '0');
      const year = date.getFullYear();
      const month = (date.getMonth() + 1).toString().padStart(2, '0'); // 月份从0开始
      const day = date.getDate().toString().padStart(2, '0');

      // 根据传入的格式返回对应的时间
      return format
        .replace('{h}', hours)
        .replace('{i}', minutes)
        .replace('{s}', seconds)
        .replace('{y}', year)
        .replace('{m}', month)
        .replace('{d}', day);
    },

    getAllStation(){
      listAllStation().then(response => {
        this.options = response.data;
      });
    },
    /** 查询垃圾运输记录列表 */
    getList() {
      this.loading = true;
      listTransportRecord(this.queryParams).then(response => {
        this.transportRecordList = response.rows;
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
        transportId: null,
        transportDay: null,
        transportSites: null,
        transportStation: null,
        transportStartTime: null,
        driver: null,
        vehiclePlateNumber: null,
        transportStatus: null,
        transportFinishTime: null
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
      this.title = "添加垃圾运输记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      console.log("this is :",this.form)
      if (this.form.transportSites) {
        // 如果 transportSites 是字符串，则将其转换为数组
        if (typeof this.form.transportSites === "string") {
          this.form.transportSites = row.transportSites.split(",").map(site => site.trim());
        }
      }
      console.log("this is asd:",this.form.transportSites)

      getTransportRecord(id).then(response => {
        this.form = response.data;
        if (this.form.transportSites) {
          // 如果 transportSites 是字符串，则将其转换为数组
          if (typeof this.form.transportSites === "string") {
            this.form.transportSites = this.form.transportSites.split(",").map(site => site.trim());
          }
        }
        this.open = true;
        this.title = "修改垃圾运输记录";
      });
    },
    checkChange(value){
      console.log("this is :",value)
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            console.log("this is form")
            if (this.form.transportSites && this.form.transportSites.length > 0) {
              this.form.transportSites = this.form.transportSites.join(", ");
            } else {
              this.form.transportSites = null; // 或者可以设置为 ""
            }

            console.log( "this is asd",this.form.transportSites)
            updateTransportRecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTransportRecord(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除垃圾运输记录编号为"' + ids + '"的数据项？').then(function() {
        return delTransportRecord(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/transportRecord/export', {
        ...this.queryParams
      }, `transportRecord_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
