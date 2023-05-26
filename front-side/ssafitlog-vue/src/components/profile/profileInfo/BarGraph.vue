<template>
  <Bar
    :chartData="chartData"
    :width="width"
    :height="height"
    :chart-id="chartId"
    :chart-options="chartOptions"
    :dataset-id-key="datasetIdKey"
    :plugins="plugins"
    :css-classes="cssClasses"
    :styles="styles"
  />
</template>

<script>
import { Bar } from "vue-chartjs/legacy";
import { mapState } from "vuex";

import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  BarElement,
  CategoryScale,
  LinearScale,
} from "chart.js";

ChartJS.register(
  Title,
  Tooltip,
  Legend,
  BarElement,
  CategoryScale,
  LinearScale
);

export default {
  name: "BarGraph",
  components: {
    Bar,
  },
  props: {
    chartId: {
      type: String,
      default: "bar-chart",
    },
    chartData: {
      type: Object,
    },
    datasetIdKey: {
      type: String,
      default: "label",
    },
    width: {
      type: Number,
      default: 600,
    },
    height: {
      type: Number,
      default: 300,
    },
    cssClasses: {
      default: "",
      type: String,
    },
    styles: {
      type: Object,
      default: () => {},
    },
    plugins: {
      type: Array,
      default: () => [],
    },
  },

  data() {
    return {
      chartOptions: {
        responsive: true,
        maintainAspectRatio: false,
      },
      // BarchartData: {
      //   labels: [],
      //   datasets: [],
      // },
    };
  },
  computed: {
    ...mapState(["loginUser", "expArr"]),
  },
  created() {
    // this.$store.state.expArr = JSON.parse(localStorage.getItem("expArr"));
    // console.log(123);
    // console.log(this.loginUser.userId);
    // console.log(this.$store.state.expArr);
    // console.log(this.expArr);
    // this.BarchartData.labels = [
    //   alert(this.expArr[0].regDate.split(" ")[0]),
    //   this.expArr[0].regDate.split(" ")[0],
    //   this.expArr[1].regDate.split(" ")[0],
    //   this.expArr[2].regDate.split(" ")[0],
    //   this.expArr[3].regDate.split(" ")[0],
    //   this.expArr[4].regDate.split(" ")[0],
    //   this.expArr[5].regDate.split(" ")[0],
    //   this.expArr[6].regDate.split(" ")[0],
    // ];
    // this.BarchartData.datasets = [
    //   {
    //     label: "기여 경험치",
    //     backgroundColor: "#f87979",
    //     data: [
    //       this.expArr[0].reviewExp,
    //       this.expArr[1].reviewExp,
    //       this.expArr[2].reviewExp,
    //       this.expArr[3].reviewExp,
    //       this.expArr[4].reviewExp,
    //       this.expArr[5].reviewExp,
    //       this.expArr[6].reviewExp,
    //     ],
    //   },
    // ];
    // const exp = this.loginUser.totalExp;
    // if (exp < 335) {
    //   this.BarchartData.datasets[0].backgroundColor = "#905a38";
    // } else if (exp < 2160) {
    //   this.BarchartData.datasets[0].backgroundColor = "#859594";
    // } else if (exp < 6200) {
    //   this.BarchartData.datasets[0].backgroundColor = "#e9c265";
    // } else if (exp < 10830) {
    //   this.BarchartData.datasets[0].backgroundColor = "#5ce99d";
    // } else {
    //   this.BarchartData.datasets[0].backgroundColor = "#7accff";
    // }
    // console.log(11322);
    // console.log("tim12e");
    // console.log(this.expArr);
  },
};
</script>

<style lang="scss" scoped></style>
