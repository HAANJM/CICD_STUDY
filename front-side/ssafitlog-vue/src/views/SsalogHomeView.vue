<template>
  <div id="container">
    <div id="tabSearchNav">
      <b-row class="text-center">
        <b-col cols="9">
          <b-tabs content-class="mt-3">
            <b-tab title="최신글" active @click="getRecently"></b-tab>
            <b-tab title="인기글" @click="getPopular"></b-tab>
          </b-tabs>
        </b-col>
        <b-col class="searchDiv">
          <b-form-input
            v-model="searchText"
            placeholder="검색어를 입력해주세요"
          />
          <b-button @click="ssalogSearch" class="btn" variant="primary"
            >검색</b-button
          >
        </b-col>
      </b-row>
    </div>
    <div id="boardList">
      <b-row
        :items="boardList"
        id="boardListDetail"
        cols="1"
        cols-sm="2"
        cols-md="4"
      >
        <b-card
          v-for="(board, index) in pageBoardList"
          :key="index"
          :title="board.boardTitle"
          :img-src="`https://img.youtube.com/vi/${board.link}/0.jpg`"
          img-alt="Image"
          img-top
          tag="article"
          style="max-width: 20rem"
          class="mb-2 boardCard"
          @click="moveToDetail($event, board)"
        >
        
          <b-card-text>
            <b-list-group flush>
              <b-list-group-item>By {{ board.userId }}</b-list-group-item>
              <b-list-group-item>♥ {{ board.favoriteCount }}</b-list-group-item>
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
  name: "SsalogView",

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
    ...mapState(["boardList"]),
    boardCount() {
      return this.boardList.length;
    },
    pageBoardList() {
      return this.boardList.slice(
        (this.currentPage - 1) * this.perPage,
        this.currentPage * this.perPage
      );
    },
  },
  methods: {
    getRecently() {
      this.$store.dispatch("getSsalogListRecently");
    },
    getPopular() {
      (this.type = "hot"),
        this.$store.dispatch("getSsalogListPopular", this.type);
    },
    moveToDetail(event, board) {
      event;
      // console.log(board);
      this.$store.state.board = board;
      this.$router.push({ name: "BoardDetail"});
    },
    ssalogSearch() {
      this.$store.dispatch("ssalogSearch", this.searchText);
    },
  },
  created() {
    this.$store.dispatch("getSsalogListRecently");
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
