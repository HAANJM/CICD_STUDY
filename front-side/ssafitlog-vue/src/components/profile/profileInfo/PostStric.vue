<template>
  <div>
    <div>
      <h4>운동 {{ nowStric }} 일차</h4>
    </div>
    <b-container id="stric" ref="stric">
      <b-row> </b-row>
      <b-row id="bigBox">
        <b-col
          v-for="(arr, y) in stateValue"
          :key="y"
          class="blockCol"
          ref="cols"
        >
          <b-row v-for="(ele, x) in arr" :key="x" class="block">
            <!-- <b-icon v-if="selectState(idx1, idx2)" icon="square"></b-icon> -->
            <b-icon
              v-if="stateValue[y][x][0] == 0"
              icon="square-fill"
              class="empty icons"
            ></b-icon>
            <!--빈칸-->
            <b-icon
              v-else-if="stateValue[y][x][0] == 6"
              icon="square-fill"
              class="level0 icons"
            ></b-icon>
            <!--빈게시글-->
            <b-icon
              v-else-if="stateValue[y][x][0] == 1"
              icon="square-fill"
              class="level1 icons"
              v-b-popover.hover.top="`${stateValue[y][x][1]}`"
              @click="searchBoardByDate(y, x)"
            ></b-icon>
            <!--1단계-->
            <b-icon
              v-else-if="stateValue[y][x][0] == 2"
              icon="square-fill"
              class="level2 icons"
              v-b-popover.hover.top="`${stateValue[y][x][1]}`"
              @click="searchBoardByDate(y, x)"
            ></b-icon>
            <!--2단계-->
            <b-icon
              v-else-if="stateValue[y][x][0] == 3"
              icon="square-fill"
              class="level3 icons"
              v-b-popover.hover.top="`${stateValue[y][x][1]}`"
              @click="searchBoardByDate(y, x)"
            ></b-icon>
            <!--3단계-->
            <b-icon
              v-else-if="stateValue[y][x][0] == 4"
              icon="square-fill"
              class="level4 icons"
              v-b-popover.hover.top="`${stateValue[y][x][1]}`"
              @click="searchBoardByDate(y, x)"
            ></b-icon>
            <!--4단계-->
            <b-icon
              v-else-if="stateValue[y][x][0] == 5"
              icon="square-fill"
              class="level5 icons"
              v-b-popover.hover.top="`${stateValue[y][x][1]}`"
              @click="searchBoardByDate(y, x)"
            ></b-icon>
            <!--5단계-->
            <b-iconstack v-else>
              <b-icon stacked icon="square-fill" class="level0"></b-icon>
              <b-icon
                stacked
                icon="shield-fill"
                class="shield"
                scale="0.8"
              ></b-icon>
            </b-iconstack>
          </b-row>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
// import { mapState } from "vuex";
import axios from "axios";
export default {
  name: "PostStric",
  computed: {
    // ...mapState(["loginUser"]),
  },
  data() {
    return {
      stricData: [],
      cursor: {},
      yearStart: {},
      dataIdx: 0,
      hasShield: false,
      shiledStack: 0,
      exp: 3,
      startFlag: false,
      test: 0,
      stateValue: [],
      maxStric: 0,
      nowStric: 0,
      endFlag: false,
    };
  },
  methods: {
    selectState(y, x) {
      this.maxStric = Math.max(this.maxStric, this.nowStric);
      // console.log(this.cursor.toLocaleDateString())
      if (this.cursor.getDay() === 0) {
        // 일요일이니 실드스택 0부터 시작
        this.shiledStack = 0;
      }
      if (this.isStarted() === false) {
        // console.log("af",this.cursor.toLocaleDateString())
        this.stateValue[y][x][0] = 0;
        this.cursor.setDate(this.cursor.getDate() + 1);
        return 0;
      } else if (this.isEmpty()) {
        this.nowStric = 0;
        if (this.hasShield) {
          this.hasShield = false;
          this.stateValue[y][x][0] = 7;
          // console.log("엠티", this.hasShield)
          // console.log("실드",this.cursor.toLocaleDateString())
          // console.log("실드스택", this.shiledStack)
          this.cursor.setDate(this.cursor.getDate() + 1);
          return 7;
        }
        this.stateValue[y][x][0] = 6;
        this.cursor.setDate(this.cursor.getDate() + 1);
        return 6;
      } else if (this.selectLevel() == 1) {
        this.stateValue[y][x][0] = 1;
        this.stateValue[y][x][1] = this.stricData[this.dataIdx].regDate;
        this.dataIdx = this.dataIdx + 1;
        this.nowStric++;
        this.shiledStack = this.shiledStack + 1;
        this.cursor.setDate(this.cursor.getDate() + 1);
        return 1;
      } else if (this.selectLevel() == 2) {
        this.stateValue[y][x][0] = 2;
        this.stateValue[y][x][1] = this.stricData[this.dataIdx].regDate;
        this.dataIdx = this.dataIdx + 1;
        this.nowStric++;
        this.shiledStack = this.shiledStack + 1;
        this.cursor.setDate(this.cursor.getDate() + 1);
        return 2;
      } else if (this.selectLevel() == 3) {
        this.stateValue[y][x][0] = 3;
        this.stateValue[y][x][1] = this.stricData[this.dataIdx].regDate;
        this.dataIdx = this.dataIdx + 1;
        this.nowStric++;
        this.shiledStack = this.shiledStack + 1;
        this.cursor.setDate(this.cursor.getDate() + 1);
        return 3;
      } else if (this.selectLevel() == 4) {
        this.stateValue[y][x][0] = 4;
        this.stateValue[y][x][1] = this.stricData[this.dataIdx].regDate;
        this.dataIdx = this.dataIdx + 1;
        this.nowStric++;
        this.shiledStack = this.shiledStack + 1;
        this.cursor.setDate(this.cursor.getDate() + 1);
        return 4;
      } else {
        this.stateValue[y][x][0] = 5;
        this.stateValue[y][x][1] = this.stricData[this.dataIdx].regDate;
        this.dataIdx = this.dataIdx + 1;
        this.nowStric++;
        this.shiledStack = this.shiledStack + 1;
        this.cursor.setDate(this.cursor.getDate() + 1);
        return 5;
      }
      // this.cursor.setDate(this.cursor.getDate() + 1);
      // this.dataIdx++;
    },
    isEnd() {
      if (this.compareDate(this.cursor, new Date())) {
        this.endFlag = true;
        return false;
      }
      return this.endFlag;
    },
    isStarted() {
      if (this.isEnd()) return false;
      if (this.startFlag) {
        // console.log("asdg", this.stricData.length, this.dataIdx)
        return this.startFlag;
      }
      // console.log(this.cursor.toLocaleDateString())

      // console.log("플래그확인", this.startFlag);
      if (this.compareDate(this.cursor, this.yearStart)) {
        this.startFlag = true;
      }
      //  확인해볼것       this.startFlag |= this.compareDate(this.cursor, this.yearStart);
      //   return this.startFlag;
      // this.startFlag |= this.compareDate(this.cursor, this.yearStart);
      return this.startFlag;
    },
    isEmpty() {
      console.log("Before", this.stricData[this.dataIdx]);
      let regDate = this.stricData[this.dataIdx].regDate;
      console.log("AFter", regDate, this.dataIdx);
      // console.log(this.cursor.toLocaleDateString());
      // console.log("test",regDate);
      if (this.compareDate(this.cursor, new Date(regDate)) === false) {
        return true; // 커서랑 데이터 날짜랑 안맞음
      } else if (this.stricData[this.dataIdx].stricExp === 0) {
        this.dataIdx++;
        return true;
      } else {
        return false;
      }
      // 커서에 해당하는 날짜와 stricData[index]
    },

    selectLevel() {
      // console.log("셀렉트레벨t",this.stricData[this.dataIdx].regDate, this.dataIdx);

      if (this.shiledStack >= 5) {
        console.log("생성되는 시점", this.cursor.toLocaleDateString());
        console.log("실드스택", this.shiledStack);
        this.hasShield = true;
        this.shiledStack = 0;
      } // 스트릭 프리즈 생성
      let score = this.stricData[this.dataIdx].stricExp / this.exp;
      score = score >= 5 ? 5 : score;
      return score;
    },
    compareDate(day1, day2) {
      if (
        day1.getDate() === day2.getDate() &&
        day1.getMonth() === day2.getMonth() &&
        day1.getFullYear() === day2.getFullYear()
      ) {
        return true;
      }
      return false;
    },
    searchBoardByDate(y, x) {
      this.$store.dispatch("searchBoardByDate", this.stateValue[y][x][1]);
    },
  },
  created() {
    let temp = JSON.parse(localStorage.getItem("loginUser"));
    let API_URL = `http://localhost:9998/ssafitlog/exp/stric/${temp.userId}`;
    // let API_URL = `http://localhost:9998/ssafitlog/exp/stric/silverTester`
    axios({
      url: API_URL,
      method: "get",
    })
      .then((res) => {
        this.stricData = res.data;
        /*console.log(res.data)*/
      })
      .catch((err) => console.log(err));
  },
  mounted() {
    setTimeout(() => {
      let now = new Date();
      let day = now.getDay();
      // let startFactor = 365 + day;
      this.now = new Date();
      this.cursor = new Date(now.setFullYear(now.getFullYear() - 1));
      this.cursor = new Date(now.setDate(now.getDate() - day));
      // console.log("커서확인",this.cursor.toLocaleDateString());
      now = new Date();
      this.yearStart = new Date(now.setFullYear(now.getFullYear() - 1));
      this.stric = new Date(this.stricData[0]);
      this.stateValue = Array.from(Array(53), () =>
        Array.from({ length: 7 }, () => [0, 0])
      );
      let i = 0;
      for (let y = 0; y < 53; y++) {
        for (let x = 0; x < 7; x++) {
          this.selectState(y, x);
          console.log(i++);
        }
      }
    }, 100);
  },
};
</script>

<style scoped>
#stric {
  overflow: auto;
  white-space: nowrap;
  /* flex-grow: 0; */
}
/* #stric::-webkit-scrollbar {
    display: none; /* Chrome, Safari, Opera*/
/* } */

#bigBox {
  min-width: 1070px;
  background-color: rgb(234, 237, 253);
  opacity: 0.8;
}
.icons {
  margin: 0;
  padding: 0;
  width: 16px;
}
.shield {
  color: rgb(114, 193, 245);
  width: 3px;
}
.block {
  margin: 2px;
  padding: 0;
  width: 16px;
}
.blockCol {
  margin: 2px;
  padding: 0;
  border: 0;
  width: 16px;
  flex-grow: 0;
}

.empty {
  color: red;
  visibility: hidden;
}
.level0 {
  color: rgba(131, 131, 131, 0.911);
}
.level1 {
  color: rgb(183, 183, 255);
}
.level2 {
  color: rgb(139, 139, 252);
}
.level3 {
  color: rgb(92, 92, 255);
}
.level4 {
  color: rgb(58, 58, 255);
}
.level5 {
  color: blue;
}
</style>
