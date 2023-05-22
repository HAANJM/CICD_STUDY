<template>
  <div id="container">
    <div id="tabSearchNav">
      <b-row class="text-center">
        <b-col cols="9">
          <b-tabs content-class="mt-3">
            <b-tab title="최신글" active @click="getRecently"></b-tab>
            <b-tab title="인기글" @click="getPopular"></b-tab>
            <b-tab title="팔로잉"></b-tab>
          </b-tabs>
        </b-col>
        <b-col class="searchDiv">
          <b-form-input v-model="searchText" placeholder="검색어를 입력해주세요" />
          <b-button type="submit" class="btn" variant="primary">검색</b-button>
        </b-col>
      </b-row>
    </div>
    <div id="boardList" @scroll="handleNotificationListScroll">
      <b-row :items="boardList" id="boardListDetail" cols="1" cols-sm="2" cols-md="4">
        <b-card v-for="(board, index) in boardList" :key="index"
        :title="board.boardTitle"
        img-src="./SSAFIT.png"
        img-alt="Image"
        img-top
        tag="article"
        style="max-width: 20rem"
        class="mb-2 boardCard"
        >
        <b-card-text> 
          <b-list-group flush>
            <b-list-group-item>By {{board.userId}}</b-list-group-item>
            <b-list-group-item>♥  {{board.favoriteCnt}}</b-list-group-item>
        </b-list-group>
        </b-card-text>

        <b-button href="/SSAFIT" variant="primary">SSAFIT</b-button>
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
import { mapState } from 'vuex';

export default {
  name: "SsalogView",

  data() {
    return {
      searchText : "",
      type : "",
      currentPage:1,
      perPage: 8,
    };
  },

  mounted() {},
  computed:{
    ...mapState(["boardList"]),
      boardCount() {
        console.log(this.boardList.length);
      return this.boardList.length;
     },
      pageBoardList(){
      return this.boardList.slice(
        (this.currentPage-1) * this.perPage,
        this.currentPage*this.perPage
      )
    }
  },
  methods: {
    getRecently(){
      this.$store.dispatch("getSsalogListRecently");
    },
    getPopular(){
      this.type = "hot",
      this.$store.dispatch("getSsalogListPopular", this.type)
    },
      handleNotificationListScroll(e) {
      const { scrollHeight, scrollTop, clientHeight } = e.target;
      const isAtTheBottom = scrollHeight === scrollTop + clientHeight;
      // 일정 이상 밑으로 내려오면 함수 실행 / 반복된 호출을 막기위해 1초마다 스크롤 감지 후 실행
      if(isAtTheBottom) {
        console.log("오냐?");
        setTimeout(() => this.handleLoadMore(), 500)
      }
    },

    // 내려오면 api를 호출하여 아래에 더 추가,
    handleLoadMore() {
      console.log("리스트 추가")
      // api를 호출하여 리스트 추가하면 됨, 현재는 pushList에 1개의 index 추가
      this.pushList.push(this.currentPage+1);
      this.currentPage += 1;
    },
  },
  created(){
    this.$store.dispatch("getSsalogListRecently");
  }
};
</script>

<style scoped>
#container {
  width: 100%;
}
#tabSearchNav{
  width: 100%;
  height : 100px;
  margin-top: 20px;
  border : 1px solid black;
  
}

#boardList{

  border: 1px solid black;
}
#boardListDetail{
  border: 1px solid black;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.boardCard{
  margin: 5px auto;
}
</style>
