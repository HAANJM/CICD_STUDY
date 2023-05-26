<template>
  <b-container>
    <!-- ########################################## -->
    <b-card-group deck>
      <b-card id="mainCard" header-tag="header" footer-tag="footer">
        <template #header>
          <h6 class="mb-0">
            <b-row id="header">
              <b-container>
                <b-row>
                  <b-col cols="10" style="text-align: center"
                    ><h4>
                      <b>{{ board.boardTitle }}</b>
                    </h4></b-col
                  >
                  <b-col>{{ board.regDate }}</b-col>
                </b-row>
                <hr>
                <b-row>
                  &nbsp; &nbsp; &nbsp;
                  <b-col cols="9">{{ board.userId }} 님</b-col>
                  <b-col cols="1">
                    <b-row><b-icon icon="bar-chart-fill"></b-icon></b-row>
                    <b-row>{{ board.scoreCount }}</b-row>
                  </b-col>
                  <b-col>
                    <b-row
                      ><b-icon
                        v-if="isFavorite"
                        icon="heart-fill"
                        @click="deleteFavorite"
                      ></b-icon>
                      <b-icon
                        v-else
                        icon="heart"
                        @click="registFavorite"
                      ></b-icon
                    ></b-row>
                    <b-row>{{ favoriteCount }}</b-row>
                  </b-col>
                </b-row>
              </b-container>
            </b-row>
          </h6>
        </template>
        <b-card-text>
          <b-row id="main">
            <b-container>
              <b-row>
                <b-col cols="12" style="text-align: center">
                  <!--.split('=')[1] -->
                  <iframe
                    width="560"
                    height="315"
                    :src="`https://www.youtube.com/embed/${
                      board.link
                    }`"
                    title="YouTube video player"
                    frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                    allowfullscreen
                  ></iframe>
                </b-col>
                <!-- <b-img class="cropped2" src="https://img.youtube.com/vi/UPuLcQTkFwc/0.jpg"></b-img> -->
              </b-row>
              <br /><hr>
              <b-row>
                &nbsp;&nbsp;&nbsp;&nbsp;{{ board.boardContent }}
              </b-row>
            </b-container>
          </b-row>
        </b-card-text>
        <template #footer>
          <em>
            <b-row id="reviewList">
              <b-container>
                <b-row>
                  <b-form v-if="loginUser && !show" @submit="registReview" inline id="reviewIn">
                    <!-- @submit="onSubmit" @reset="onReset" -->
                    <!-- <b-row>
                      <b-col> -->
                        <b-form-group
                          id="input-group-1"
                          :label="loginUser.userId"
                          label-for="input-1"
                          class="temp"
                        >
                          <b-form-input
                            id="input-1"
                            type="text"
                            placeholder="댓글"
                            v-model="reviewContent"
                            required
                          ></b-form-input>
                        </b-form-group>
                      <!-- </b-col>
                      <b-col> -->
                        <div class="d-flex flex-row btns">
                          <input
                            type="radio"
                            class="raBtn temp"
                            id="upBtn"
                            value="1"
                            v-model="reviewScore"
                            ref="upBtn"
                          />
                          <label for="one"
                            ><b-icon :icon="up" @click="onUp"></b-icon
                          ></label>
                          <input
                            type="radio"
                            class="raBtn temp"
                            id="downBtn"
                            value="-1"
                            v-model="reviewScore"
                            ref="downBtn"
                          />
                          <label for="two"
                            ><b-icon :icon="down" @click="onDown"></b-icon
                          ></label>
                          <input
                            type="radio"
                            class="raBtn temp"
                            id="zeroBtn"
                            value="0"
                            v-model="reviewScore"
                            ref="zeroBtn"
                          />
                          <label for="tt" class="temp"
                            ><b-icon icon="dash" class="temp" @click="onZero"></b-icon
                          ></label>
                          <b-button
                            class="positive temp"
                            type="submit"
                            variant="primary"
                            >등록</b-button
                          >
                        </div>
                      <!-- </b-col>
                    </b-row> -->
                  </b-form>
                </b-row>
                <b-row v-for="(review, index) in reviews" :key="index">
                  <!-- http://localhost:9999/ssafitlog/???/${review.img} -->
                  <b-container>
                    <b-row>
                      <b-col><b-img :src="`http://localhost:9998/ssafitlog/user/img/${review.img}`"></b-img></b-col>
                      <b-col>{{ review.userId }}</b-col>
                      <b-col @mouseover="hovered(index)">
                        {{ review.reviewContent }}
                        <b-icon
                          v-if="
                            hindex == index &&
                            loginUser !== null &&
                            loginUser.userId == review.userId
                          "
                          icon="pencil-square"
                          scale="2"
                          @click="showFix(index)"
                        ></b-icon>
                      </b-col>
                      <b-col>
                        <b-icon
                          v-if="review.reviewScore == 1"
                          icon="hand-thumbs-up-fill"
                        ></b-icon>
                        <b-icon
                          v-else-if="review.reviewScore == -1"
                          icon="hand-thumbs-down-fill"
                        ></b-icon>
                        <b-icon v-else icon="dash"></b-icon>
                      </b-col>
                      <b-col>
                        {{ review.regDate }}
                      </b-col>
                    </b-row>
                    <b-row
                      v-if="
                        show &&
                        loginUser.userId == review.userId &&
                        sindex == index
                      "
                    >
                      <b-form @submit="modifyReview" inline align-h="end">
                        <b-form-input
                          id="input-1"
                          type="text"
                          :placeholder="review.reviewContent"
                          v-model="reviewContent"
                          required
                        ></b-form-input>
                        <div class="d-flex flex-row">
                          <input
                            type="radio"
                            class="raBtn"
                            id="upBtn"
                            value="1"
                            v-model="reviewScore"
                            ref="upBtn"
                          />
                          <label for="one"
                            ><b-icon :icon="up" @click="onUp"></b-icon
                          ></label>
                          <input
                            type="radio"
                            class="raBtn"
                            id="downBtn"
                            value="-1"
                            v-model="reviewScore"
                            ref="downBtn"
                          />
                          <label for="two"
                            ><b-icon :icon="down" @click="onDown"></b-icon
                          ></label>
                          <input
                            type="radio"
                            class="raBtn"
                            id="zeroBtn"
                            value="0"
                            v-model="reviewScore"
                            ref="zeroBtn"
                          />
                          <label for="tt"
                            ><b-icon icon="dash" @click="onZero"></b-icon
                          ></label>
                          <b-button
                            class="positive"
                            @click="modifyReview"
                            variant="primary"
                            >수정</b-button
                          >
                          <b-button
                            class="positive"
                            @click="deleteReview"
                            variant="danger"
                            >삭제</b-button
                          >
                        </div>
                      </b-form>
                    </b-row>
                  </b-container>
                </b-row>
              </b-container>
            </b-row>
          </em>
        </template>
      </b-card>
    </b-card-group>
    <!-- ########################################## -->
  </b-container>
</template>

<script>
import { mapState } from "vuex";
import axios from "axios";
const REST_API = "http://localhost:9998/ssafitlog";

export default {
  name: "BoardDetail",
  computed: {
    ...mapState(["loginUser", "board"]),
  },
  data() {
    return {
      userImg: {},
      reviews: [],
      reviewContent: "",
      show: false,
      sindex: 0,
      reviewScore: 0,
      reviewStatus: 0,
      reviewCount: 0,
      up: "hand-thumbs-up",
      down: "hand-thumbs-down",
      btns: { upChecked: false, downChecked: false, zeroChecked: false },
      isFavorite: false,
      favoriteCount: 0,
      isHovered: false,
      hindex: 0,
    };
  },
  mounted() {
    // this.registReview();
  },
  methods: {
    hovered(index) {
      this.hindex = index;
    },
    onUp() {
      if (this.up === "hand-thumbs-up-fill") {
        this.up = "hand-thumbs-up";
        this.btns.upChecked = false;
        this.reviewScore = 0;
      } else {
        this.up = "hand-thumbs-up-fill";
        this.down = "hand-thumbs-down";
        this.reviewScore = 1;
      }
    },
    onDown() {
      if (this.down === "hand-thumbs-down-fill") {
        this.down = "hand-thumbs-down";
        this.btns.downChecked = false;
        this.reviewScore = 0;
      } else {
        this.up = "hand-thumbs-up";
        this.down = "hand-thumbs-down-fill";
        this.reviewScore = -1;
      }
    },
    onZero() {
      this.up = "hand-thumbs-up";
      this.down = "hand-thumbs-down";
      this.reviewScore = 0;
    },
    showFix(index) {
      this.show = !this.show;
      this.sindex = index;
    },
    registReview(event) {
      event.preventDefault();
      if (this.reviewCount >= 5 && this.reviewScore != 0) {
        alert("오늘은 더이상 평가가 불가능합니다.");
        return;
      }
      const board = this.board;
      const review = {
        boardRegDate: board.regDate,
        boardUserId: board.userId,
        boardNumber: board.boardNumber,
        userId: this.loginUser.userId,
        reviewContent: this.reviewContent,
        reviewScore: this.reviewScore == undefined ? 0 : this.reviewScore,
        reviewStatus: this.reviewScore == 0 ? 0 : 1,
      };
      this.$store.dispatch("registReview", review);
      let API_URL = `${REST_API}/review/${review.boardNumber}`;
      axios({
        url: API_URL,
        method: "get",
      })
        .then((res) => {
          this.reviews = res.data;
        })
        .catch((err) => console.log(err));
      setTimeout(() => {
        API_URL = `${REST_API}/review/${review.boardNumber}`;
        axios({
          url: API_URL,
          method: "get",
        })
          .then((res) => {
            this.reviews = res.data;
          })
          .catch((err) => console.log(err));
        API_URL = `${REST_API}/user/userInfo/${review.userId}`;
        console.log('asdf',review.userId);
        axios({
          url: API_URL,
          method: "get",
        })
          .then((res) => {
            this.reviewCount = res.data;
          })
          .catch((err) => console.log(err));
      }, 100);
      // API_URL = `${REST_API}/review/${review.boardNumber}`;
      // axios({
      //           url: API_URL,
      //           method: "get",
      //         }).then((res) => {this.reviews = res.data;
      //         }).catch((err) => console.log(err));
      // API_URL = `${REST_API}/user/userInfo/${review.userId}`;
      // axios({
      //           url: API_URL,
      //           method: "get",
      //         }).then((res) => {this.reviewCount = res.data;
      //         }).catch((err) => console.log(err));
    },

    // registReview() {
    //   // if (this.reviewContent.length == 0) return;
    //   const board = this.$route.params.board;
    //   const review = {
    //     boardRegDate: board.regDate,
    //     boardUserId: board.userId,
    //     boardNumber: board.boardNumber,
    //     userId: this.loginUser.userId,
    //     reviewContent: this.reviewContent,
    //     reviewScore: this.reviewScore == undefined ? 0 : this.reviewScore,
    //     reviewStatus: this.reviewScore == 0 ? 0 : 1,
    //   }
    //   this.$store.dispatch("registReview", review);
    //   // 등록된 리뷰 불러오기
    //   // 리뷰 카운트 불러오기용 getUser
    //   let API_URL = `${REST_API}/review/${review.boardNumber}`;
    //   axios({
    //             url: API_URL,
    //             method: "get",
    //           }).then((res) => {this.reviews = res.data; alert(1);
    //           }).catch((err) => console.log(err));
    //   API_URL = `${REST_API}/user/userInfo/${review.userId}`;
    //   axios({
    //             url: API_URL,
    //             method: "get",
    //           }).then((res) => {this.reviewCount = res.data; alert('ok')
    //           }).catch((err) => console.log(err));
    //   },

    modifyReview(event) {
      event.preventDefault();
      const board = this.board;
      const review = {
        boardRegDate: board.regDate,
        boardUserId: board.userId,
        boardNumber: board.boardNumber,
        userId: this.loginUser.userId,
        reviewContent: this.reviewContent,
        reviewNumber: this.reviews[this.sindex].reviewNumber,
        reviewScore: this.reviewScore == undefined ? 0 : this.reviewScore,
        reviewStatus: this.reviewScore == 0 ? 0 : 1,
      };

      // 리뷰 수정
      let API_URL = `${REST_API}/review`;
      axios({
        url: API_URL,
        method: "put",
        data: review,
      })
        .then(() => {})
        .catch((err) => console.log(err));

      // 리뷰 목록 가져오기
      API_URL = `${REST_API}/review/${review.boardNumber}`;
      setTimeout(() => {
        axios({
          url: API_URL,
          method: "get",
        })
          .then((res) => {
            this.reviews = res.data;
          })
          .catch((err) => console.log(err));

        // 리뷰 카운트 반영
        API_URL = `${REST_API}/user/userInfo/${review.userId}`;
        axios({
          url: API_URL,
          method: "get",
        })
          .then((res) => {
            this.reviewCount = res.data;
          })
          .catch((err) => console.log(err));
        this.show = !this.show;
        this.onZero();
      }, 100);
      // axios({
      //     url: API_URL,
      //     method: "get",
      // }).then((res) => {this.reviews = res.data; this.$router.replace(this.$router.push({name: "BoardDetail", params: {board}}).catch(()=>{}))})
      // .catch((err) => console.log(err));
      // API_URL = `${REST_API}/user/userInfo/${review.userId}`;
      // axios({
      //   url: API_URL,
      //   method: "get",
      //   }).then((res) => {this.reviewCount = res.data; alert('tq')
      //   }).catch((err) => console.log(err));
    },

    deleteReview(event) {
      if (!confirm("정말 삭제하시겠습니까?")) return;
      event.preventDefault();

      const board = this.board;
      const review = {
        boardRegDate: board.regDate,
        boardUserId: board.userId,
        boardNumber: board.boardNumber,
        userId: this.loginUser.userId,
        reviewContent: this.reviewContent,
        reviewNumber: this.reviews[this.sindex].reviewNumber,
        reviewScore: this.reviewScore == undefined ? 0 : this.reviewScore,
        reviewStatus: this.reviewScore == 0 ? 0 : 1,
      };
      let API_URL = `${REST_API}/review`;
      axios({
        url: API_URL,
        method: "delete",
        data: review,
      })
        .then(() => {})
        .catch((err) => console.log(err));
      // 리뷰 목록 가져오기
      API_URL = `${REST_API}/review/${review.boardNumber}`;
      setTimeout(() => {
        axios({
          url: API_URL,
          method: "get",
        })
          .then((res) => {
            this.reviews = res.data;
          })
          .catch((err) => console.log(err));

        // 리뷰 카운트 반영
        API_URL = `${REST_API}/user/userInfo/${review.userId}`;
        axios({
          url: API_URL,
          method: "get",
        })
          .then((res) => {
            this.reviewCount = res.data;
          })
          .catch((err) => console.log(err));
        this.show = !this.show;
        this.onZero();
      }, 100);
    },

    registFavorite() {
      if (this.loginUser === null) return;
      const API_URL = `${REST_API}/favorite`;
      console.log(this.board.boardNumber);
      console.log(this.loginUser.userId)
      axios({
        url: API_URL,
        method: "post",
        data: {
          boardNumber: this.board.boardNumber,
          userId: this.loginUser.userId,
        },
      })
        .then(() => {
          alert("좋아요를 등록하셨습니다.")
          this.isFavorite = true;
          this.favoriteCount = this.favoriteCount + 1;
          this.$store.dispatch("searchBoard", this.board.boardNumber);
        })
        .catch((err) => console.log(err));
    },

    deleteFavorite() {
      const API_URL = `${REST_API}/favorite`;
      axios({
        url: API_URL,
        method: "delete",
        data: {
          boardNumber: this.board.boardNumber,
          userId: this.loginUser.userId,
        },
      })
        .then(() => {
          alert("좋아요를 취소하셨습니다.");
          this.isFavorite = false;
          this.favoriteCount = this.favoriteCount - 1;
          this.$store.dispatch("searchBoard", this.board.boardNumber)
        })
        .catch((err) => console.log(err));
    },
  },
  created() {
    let API_URL;
    this.favoriteCount = this.board.favoriteCount;

    //
    if (this.loginUser) {
      // reivewCount 초기화
      this.reviewCount = this.loginUser.reviewCount;

      // 프사 초기화
      API_URL = `${REST_API}/user/searchImg`;
      axios({
        url: API_URL,
        method: "get",
        params: this.loginUser,
      })
        .then((res) => (this.userImg = res.data))
        .catch((err) => console.log(err));
        // 좋아요 상태 확인
      API_URL = `${REST_API}/favorite`;
      const favorite = {
        boardNumber: this.board.boardNumber,
        userId: this.loginUser.userId,
      };
      axios({
        url: API_URL,
        method: "get",
        params: favorite,
      })
        .then((res) => {this.isFavorite = res.data;
        console.log("체크",res.data)})
        .catch((err) => console.log(err));
    }

    // searchReviewAll(this.$route.params.board.boardNumber);
    API_URL = `${REST_API}/review/${this.board.boardNumber}`;
    axios({
      url: API_URL,
      method: "get",
    })
      .then((res) => {
        this.reviews = res.data;
      })
      .catch((err) => console.log(err));
  },
};
</script>

<style scoped>
.cropped2 {
  width: 400px;
  height: 200px;
  object-fit: cover;
  object-position: 20% 10%;
  border: 5px solid black;
}
.raBtn {
  opacity: 0;
}
#mainCard{
  border: 3px solid #071844;
  margin-top : 20px;
}
*{
  color : #071844;
}
#input-1 {
  width : 15cm;
}
#reviewIn {
  display:flex;
  margin: auto;
}
.temp {
  flex-grow: 1;
}
.btns {
  width: 5cm;
}
.positive {
  margin: 0 5px;
}
b-form {
  margin: 3cm 1cm;
}
</style>
