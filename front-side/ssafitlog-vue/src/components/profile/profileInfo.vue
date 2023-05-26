<template>
  <div id="info">
    <!-- <b-row class="text-center">
      <b-col> -->
              <b-container id="barContainer">
                <b-row id="postDiv">
                <profile-info-post></profile-info-post>
                </b-row>
              <hr>
                <b-row id="stricDiv">
                  <LineChart :LineChartData="LineChartData" />
                </b-row>
              <hr />
                <b-row id="barDiv">
                  <Bar :chartData="BarchartData" />
                </b-row>
              
            </b-container>

      <!-- </b-col>
    </b-row> -->
  </div>
</template>

<script>
import { mapState } from "vuex";
import ProfileInfoPost from "@/components/profile/profileInfo/ProfileInfoPost.vue";
import Bar from "./profileInfo/BarGraph.vue";
import LineChart from "./profileInfo/LineGraph.vue";

export default {
  name: "ProfileInfo",
  components: {
    ProfileInfoPost,
    Bar,
    LineChart,
  },
  props: {
    selectUserTransfer2: String,
  },
  data() {
    return {
      BarchartData: {
        labels: [],
        datasets: [],
      },
      LineChartData: {
        labels: [],
        datasets: [],
      },
      selectUser: JSON.parse(this.selectUserTransfer2),
    };
  },

  methods: {},
  computed: {
    ...mapState(["loginUser", "expArr"]),
  },
  beforeCreate() {},
  created() {
    this.$store.state.expArr = JSON.parse(localStorage.getItem("expArr"));
    // setTimeout(() => {
    // console.log(this.loginUser.userId);
    // console.log(this.$store.state.expArr);
    // console.log(this.expArr);

    this.BarchartData.labels = [
      this.expArr[0].regDate.split(" ")[0],
      this.expArr[1].regDate.split(" ")[0],
      this.expArr[2].regDate.split(" ")[0],
      this.expArr[3].regDate.split(" ")[0],
      this.expArr[4].regDate.split(" ")[0],
      this.expArr[5].regDate.split(" ")[0],
      this.expArr[6].regDate.split(" ")[0],
    ];
    this.BarchartData.datasets = [
      {
        label: "기여 경험치",
        backgroundColor: "#f87979",
        data: [
          this.expArr[0].reviewExp,
          this.expArr[1].reviewExp,
          this.expArr[2].reviewExp,
          this.expArr[3].reviewExp,
          this.expArr[4].reviewExp,
          this.expArr[5].reviewExp,
          this.expArr[6].reviewExp,
        ],
      },
    ];

    // }, 500);

    const LineArr = [];
    for (var i = 0; i < 7; i++) {
      var temp = 0;
      for (var j = 0; j < i; j++) {
        temp = temp + this.expArr[6 - j].stricExp;
      }
      // console.log(this.loginUser.totalExp - temp);
      LineArr[6 - i] = this.selectUser.totalExp - temp;
    }

    // console.log(1);
    // console.log(LineArr);
    // console.log(LineArr[0]);

    this.LineChartData.labels = [
      this.expArr[0].regDate.split(" ")[0],
      this.expArr[1].regDate.split(" ")[0],
      this.expArr[2].regDate.split(" ")[0],
      this.expArr[3].regDate.split(" ")[0],
      this.expArr[4].regDate.split(" ")[0],
      this.expArr[5].regDate.split(" ")[0],
      this.expArr[6].regDate.split(" ")[0],
    ];
    this.LineChartData.datasets = [
      {
        label: "경험치 추이 그래프",
        backgroundColor: "#f87979",
        data: [
          LineArr[0],
          LineArr[1],
          LineArr[2],
          LineArr[3],
          LineArr[4],
          LineArr[5],
          LineArr[6],
        ],
      },
    ];
    const exp = this.selectUser.totalExp;
    if (exp < 335) {
      this.BarchartData.datasets[0].backgroundColor = "#905a38";
      this.LineChartData.datasets[0].backgroundColor = "#905a38";
    } else if (exp < 2160) {
      this.BarchartData.datasets[0].backgroundColor = "#859594";
      this.LineChartData.datasets[0].backgroundColor = "#859594";
    } else if (exp < 6200) {
      this.BarchartData.datasets[0].backgroundColor = "#e9c265";
      this.LineChartData.datasets[0].backgroundColor = "#e9c265";
    } else if (exp < 10830) {
      this.BarchartData.datasets[0].backgroundColor = "#5ce99d";
      this.LineChartData.datasets[0].backgroundColor = "#5ce99d";
    } else {
      this.BarchartData.datasets[0].backgroundColor = "#7accff";
      this.LineChartData.datasets[0].backgroundColor = "#7accff";
    }
  },
};
</script>

<style>
#info {
  margin: 0 auto;
  height: 1500px;
}
#barContainer {
  margin: 0 auto;

}
#stricDiv {
  height: 350px;
  display: flex;
  justify-content: center;
}
#barDiv  {
  height: 350px;
  display: flex;
  justify-content: center;
}
#postDiv{
  height: 600px;
  /* display: flex;
  justify-content: center; */
}
</style>
