<template>
  <div id="personalInfo">
    <b-container class="pDiv">
      <b-row>
        <b-col cols="3">
          <b-img v-if="selectUser.img != 'default'"
            :src="`http://localhost:9998/ssafitlog/user/img/${selectUser.img}`"
            fluid
            alt="profileImg"
            id="profile"
          ></b-img>
        </b-col>
        <b-col cols="5">
          <div>
            <b>{{ selectUser.userId }}</b>
            <b-icon
              v-if="`${loginUser.userId} == ${selectUser.userId}`"
              icon="pencil-square"
              scale="2"
              @click="showFix()"
            ></b-icon>
          </div>

          <hr />
          <div>{{ selectUser.userComment }}</div>
        </b-col>
        <b-col>
          <Doughnut :chartData="chartData" :width="width" :height="height" />
        </b-col>
      </b-row>
      <b-row v-if="isShow">
        <b-form inline>
        <b-form-group
          id="input-group-1"
          label=""
          label-for="input-1"
        >
          <b-form-input
            id="input-1"
            v-model="userComment"
            type="text"
            placeholder="자기소개를 작성해주세요."

          ></b-form-input>
        </b-form-group>
        <input type="file" id="file" @change="fileSelect" name="file" ref="upload">
        <!-- <b-form-file v-model="img" ref="upload" @change="fileSelect" plain name="file"></b-form-file> -->
        <b-button class="btn" variant="primary" @click="updateUserInfo"
            >수정</b-button>
        </b-form>
      </b-row>
    </b-container>
    <div></div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import Doughnut from "./profileInfo/DoughnutGraph.vue";

export default {
  name: "ProfilePersonalInfo",
  components: {
    Doughnut,
  },
  props: {
    selectUserTransfer: String,
  },
  data() {
    return {
      chartData: {},
      width: 250,
      height: 250,
      userComment: "",
      img: "",
      isShow: false,
      selectUser: JSON.parse(this.selectUserTransfer),
    };
  },

  computed: {
    ...mapState(["loginUser"]),
  },
  methods: {
    showFix() {
      this.isShow = !this.isShow;
    },
    fileSelect() {
      this.img = this.$refs.upload.files[0];
      console.log(this.img);
    },
    updateUserInfo() {
      const formData = new FormData();

      formData.append("userComment", this.userComment);
      formData.append("userId", this.loginUser.userId);
      formData.append("file", this.img);
      this.$store.dispatch("updateUser", formData);
      this.isShow = false;
    }
  },
  mounted() {
  },  
  created() {
    const exp = this.selectUser.totalExp;
    if (exp < 335) {
      this.chartData = {
        labels: ["브론즈", "다음 등급까지"],
        datasets: [
          {
            backgroundColor: ["#905a38", "#071844"],
            data: [exp, 335 - exp],
          },
        ],
      };
    } else if (exp < 2160) {
      this.chartData = {
        labels: ["실버", "다음 등급까지"],
        datasets: [
          {
            backgroundColor: ["#859594", "#071844"],
            data: [exp, 2160 - exp],
          },
        ],
      };
    } else if (exp < 6200) {
      this.chartData = {
        labels: ["골드", "다음 등급까지"],
        datasets: [
          {
            backgroundColor: ["#e9c265", "#071844"],
            data: [exp, 6200 - exp],
          },
        ],
      };
    } else if (exp < 10830) {
      this.chartData = {
        labels: ["플레티넘", "다음 등급까지"],
        datasets: [
          {
            backgroundColor: ["#5ce99d", "#071844"],
            data: [exp, 10830 - exp],
          },
        ],
      };
    } else {
      this.chartData = {
        labels: ["다이아몬드"],
        datasets: [
          {
            backgroundColor: ["#7accff", "#071844"],
            data: [exp, 16000 - exp],
          },
        ],
      };
    }
  }
}
</script>

<style>
#personalInfo {
  margin: 0 auto;
  margin-top: 50px;
  height: 400px;
}
#profile {
  width: 250px;
  height: 250px;
}
Doughnut {
  width: 250px;
  height: 250px;
}
.pDiv{
  
}
</style>
