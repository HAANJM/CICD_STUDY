<template>
  <div id="container">
    <div id="tabSearchNav">
      <b-row class="text-center">
        <b-col cols="9">
          <b-tabs content-class="mt-3">
            <b-tab title="스트레칭" active @click="getStretching"></b-tab>
            <b-tab title="유산소" @click="getAerobic"></b-tab>
            <b-tab title="웨이트" @click="getWeight"></b-tab>
          </b-tabs>
        </b-col>
        <b-col class="searchDiv">
          <b-form-input
            v-model="searchText"
            placeholder="검색어를 입력해주세요"
          />
          <b-button @click="ssafitSearch" class="btn" variant="primary"
            >검색</b-button
          >
        </b-col>
      </b-row>
    </div>
    <div id="boardList">
      <b-row
        :items="ssafitList"
        id="boardListDetail"
        cols="1"
        cols-sm="2"
        cols-md="4"
      >
        <b-card
          v-for="(board, index) in pageBoardList"
          :key="index"
          :title="board.snippet.title"
          :img-src="`https://img.youtube.com/vi/${board.id.videoId}/0.jpg`"
          img-alt="SSAFIT"
          img-top
          tag="article"
          style="max-width: 20rem"
          class="mb-2 boardCard"
          @click="moveToDetail($event, board)"
        >
        <hr>
          <b-card-text>
            <b-list-group flush>
              <b-list-group-item
                > <h5>By {{ board.snippet.channelTitle }}</h5></b-list-group-item
              >
            </b-list-group>
          </b-card-text>
        </b-card>
      </b-row>
    </div>
    <div>
      <b-pagination
        v-model="currentPage"
        :total-rows="boardCount"
        :per-page="perPage"
        align="center"
      ></b-pagination>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "SsafitView",

  data() {
    return {
      searchText: "",
      type: "",
      currentPage: 1,
      perPage: 12,
    };
  },

  mounted() {},
  computed: {
    ...mapState(["ssafitList"]),
    boardCount() {
      console.log(this.ssafitList.length);
      return this.ssafitList.length;
    },
    pageBoardList() {
      return this.ssafitList.slice(
        (this.currentPage - 1) * this.perPage,
        this.currentPage * this.perPage
      );
    },
  },
  methods: {
    getStretching() {
      this.$store.dispatch("getSsafitListstretching");
    },
    getAerobic() {
      this.$store.dispatch("getSsafitListAerobic");
    },
    getWeight() {
      this.$store.dispatch("getSsafitListWeight");
    },
    getPopular() {
      (this.type = "hot"),
        this.$store.dispatch("getSsalogListPopular", this.type);
    },
    moveToDetail(event, board) {
      event;
      console.log(board);
      this.$router.push({ name: "SsafitBoardDetail", params: { board } });
    },
    ssafitSearch() {
      this.$store.dispatch("getSsafitListSearch", this.searchText);
    },
  },
  created() {
    this.$store.dispatch("getSsafitListstretching");
  },
};
</script>

<style scoped>
#container {
  width: 100%;
}
#tabSearchNav {
  width: 100%;
  height: 100px;
  margin-top: 20px;

}


#boardListDetail {
  
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.boardCard {
  margin: 5px auto;
  border: 3px solid #4365ba;
}
</style>
