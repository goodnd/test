<template>
  <div class="app-container home">
      <el-col :sm="24" :lg="24">
        <blockquote class="text-warning" style="font-size: 14px">
          <el-card class="update-log">
            <div class="body">
              <img
                src="@/assets/images/top.jpg"
                alt="donate"
                width="100%"
                height="200"
              />
            </div>
          </el-card>
        </blockquote>

        <hr />
      </el-col>

    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>欢迎来到城市垃圾站点管理系统</h2>
        <p>
          在当今城市化进程加速的背景下，城市垃圾管理正面临前所未有的挑战。为了应对日益增加的垃圾产生量和复杂的收集运输需求，城市垃圾站点管理系统应运而生，成为提升城市环境质量和管理效率的重要工具。
          该系统旨在实现垃圾管理的智能化、实时化与系统化。其核心功能包括对垃圾站点的实时监控、数据采集与分析、智能调度管理、用户反馈机制等。
          首先，系统通过部署传感器和监控设备，对垃圾站点的填满程度和垃圾类型进行实时监控。这种实时数据采集不仅为管理决策提供了科学依据，也为垃圾收集的时效性和针对性提供了保障。其次，系统利用大数据分析技术，深入挖掘垃圾产生的规律和趋势，从而优化垃圾收集路线与频率，降低运营成本。
          在调度管理方面，该系统能够根据实时数据，智能化地调配垃圾收集车辆，确保资源的最优配置。这种智能调度机制显著提升了垃圾处理效率，减少了不必要的资源浪费。同时，系统还设置了便捷的用户反馈渠道，使市民能够直接参与到垃圾管理中，及时报告垃圾站点存在的问题，增强了公众参与感与责任感。
          综上所述，城市垃圾站点管理系统不仅是现代城市管理的一个重要组成部分，更是实现可持续发展目标的有效手段。随着智能城市建设的不断深入，该系统将发挥愈加重要的作用，为提升城市环境质量、优化资源配置以及增强居民生活品质做出积极贡献。
          </p>
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="12">
            <h2>技术选型</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <h4>基于springboot和vue</h4>

          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>联系信息</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-s-promotion"></i> 官网：<el-link
                href="http://www."
                target="_blank"
                >http://www</el-link
              >
            </p>

          </div>
        </el-card>
      </el-col>

      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">

          <div class="body">
            <img
              src="@/assets/images/pay.png"
              alt="donate"
              width="100%"
            />

          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.8"
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    }
  }
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

