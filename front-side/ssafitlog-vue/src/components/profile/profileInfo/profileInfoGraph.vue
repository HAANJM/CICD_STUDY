<template>
  <div id="graphDiv">
    <b-container id="barContainer">
      <b-row id="stricDiv">
        <div>이거 클릭</div>
      </b-row>
      <b-row id="barDiv">
        <Bar
          :chartData="BarchartData"
          :width="width"
          :height="height"
          :chart-id="chartId"
          :chart-options="chartOptions"
          :dataset-id-key="datasetIdKey"
          :plugins="plugins"
          :css-classes="cssClasses"
          :styles="styles"
        />
      </b-row>
    </b-container>
  </div>
</template>
<script>
import { mapState } from "vuex";

export default {
  name: "ProfileInfoGraph",

  data() {
    return {};
  },
  methods: {},
};
</script>
<style></style>
