import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "../router";

Vue.use(Vuex);

const REST_API = "http://localhost:9998/ssafitlog";

export default new Vuex.Store({
  state: {
    loginUser: {},
    boardList: [],
    ssafitList: [],
    idCheckFlag: "",
    searchedId: "아이디가 없습니다.",
    board: {},
    randomCode: "-1",
    expArr: [],
  },
  getters: {},
  mutations: {
    USER_LOGIN(state, loginUser) {
      (loginUser.password = ""),
        (loginUser.email = ""),
        localStorage.setItem("loginUser", JSON.stringify(loginUser));
      state.loginUser = loginUser;
      router.push("/");
    },
    LOGOUT(state) {
      state.loginUser = null;
      sessionStorage.removeItem("access-token");
      localStorage.removeItem("loginUser");
      router.go(-1);
    },
    SEND_EMAIL(state, randomCode) {
      state.randomCode = randomCode;
    },
    GET_SSALOG_LIST_RECENTLY(state, boards) {
      state.boardList = boards;
    },
    GET_SSALOG_LIST_POPULAR(state, boards) {
      state.boardList = boards;
    },
    USERID_CHECK(state, flag) {
      state.idCheckFlag = flag;
    },
    SEARCHID(state, userId) {
      state.searchedId = userId;
    },
    REGIST_USER(state) {
      state.randomCode = "";
      router.push("/login");
    },

    /////////////////////////////////////////////////////////////////////////////////////////////////
    // board part
    /////////////////////////////////////////////////////////////////////////////////////////////////
    GET_SSAFIT_LIST(state, list) {
      state.ssafitList = list;
    },
    GET_REVIEW_CNT(state, expArr) {
      localStorage.setItem("expArr", JSON.stringify(expArr));
      state.expArr = expArr;
    },
    SEARCH_BOARD_BY_DATE(state, boards) {
      state.boardList = boards;
    },
    SSALOG_SEARCH(state, list) {
      state.boardList = list;
    },
    SEARCH_BOARD(state, board) {
      // state.board = board;
      Vue.set(state.board, "favoriteCount", board.favoriteCount);
    },
    UPDATE_USER(state, user) {
      localStorage.setItem("loginUser", JSON.stringify(user));
      state.loginUser = user;
    },
    REGIST_BOARD(state, board) {
      state.board = board;
      router.push({ name: "BoardDetail" });
    },
  },
  actions: {
    userLogin({ commit }, user) {
      const API_URL = `${REST_API}/user/login`;
      axios({
        url: API_URL,
        method: "post",
        params: user,
      })
        .then((res) => {
          sessionStorage.setItem("access-token", res.data["access-token"]);

          const API_URL2 = `${REST_API}/exp/${user.userId}`;
          axios({
            url: API_URL2,
            method: "get",
          })
            .then((res) => {
              let arr = res.data;
              let expArr = arr.slice(arr.length - 7);
              commit("GET_REVIEW_CNT", expArr);
            })
            .catch((err) => {
              console.log(err);
            });

          commit("USER_LOGIN", res.data.loginUser);
        })
        .catch((err) => {
          alert("아이디 혹은 비밀번호를 확인해주세요.");
          console.log(err);
        });
    },
    getSsalogListRecently({ commit }) {
      const API_URL = `${REST_API}/board`;
      axios({
        url: API_URL,
        method: "get",
      })
        .then((res) => {
          console.log(res.data);
          commit("GET_SSALOG_LIST_RECENTLY", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getSsalogListPopular({ commit }, type) {
      const API_URL = `${REST_API}/board`;
      const searchCondition = {
        type: type,
      };
      axios({
        url: API_URL,
        method: "get",
        params: searchCondition,
      })
        .then((res) => {
          commit("GET_SSALOG_LIST_POPULAR", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    sendEmail({ commit }, email) {
      const API_URL = `${REST_API}/user/email`;
      console.log(email);
      axios({
        url: API_URL,
        method: "post",
        params: { email: email },
      })
        .then((res) => {
          console.log(res);
          commit("SEND_EMAIL", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    userIdCheck({ commit }, userId) {
      const API_URL = `${REST_API}/user/${userId}`;
      if (userId == "") {
        return;
      }
      return axios({
        url: API_URL,
        method: "get",
      })
        .then((res) => {
          let flag = "";
          if (res.data == "") {
            flag = true;
          } else if (res.data == true) {
            flag = false;
          }
          commit("USERID_CHECK", flag);
        })
        .then((err) => {
          console.log(err);
        });
    },
    searchId({ commit }, user) {
      const API_URL = `${REST_API}/user/search`;
      this.state.searchedId = "아이디가 없습니다.";
      axios({
        url: API_URL,
        method: "get",
        params: user,
      })
        .then((res) => {
          // console.log(res.data);
          commit("SEARCHID", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    registUser({ commit }, user) {
      const API_URL = `${REST_API}/user/regist`;

      axios({
        url: API_URL,
        method: "post",
        params: user,
      })
        .then((res) => {
          console.log(res);
          commit("REGIST_USER");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    updateUser({ commit }, formData) {
      axios({
        method: "post",
        url: `${REST_API}/user`,
        params: formData,
        headers: {
          "Content-Type": "multipart/form-data",
        },
        transformRequest: [
          function () {
            return formData;
          },
        ],
      })
        .then((res) => commit("UPDATE_USER", res.data))
        .catch((err) => console.log(err));
    },
    getSsafitListstretching({ commit }) {
      const API_URL = "https://www.googleapis.com/youtube/v3/search";
      const API_KEY = "AIzaSyArLUiigknT0qcs4M33dyTAt766ENRtdbM";
      // const API_KEY = "AIzaSyArLUiigknT0qcs4M33dyTAt766ENRtdbM";
      axios({
        url: `${API_URL}?key=${API_KEY}&part=snippet&q=스트레칭&type=video&maxResults=30`,
        method: "get",
      })
        .then((res) => {
          console.log(res.data.items);
          commit("GET_SSAFIT_LIST", res.data.items);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getSsafitListAerobic({ commit }) {
      const API_URL = "https://www.googleapis.com/youtube/v3/search";
      const API_KEY = "AIzaSyArLUiigknT0qcs4M33dyTAt766ENRtdbM";
      axios({
        url: `${API_URL}?key=${API_KEY}&part=snippet&q=유산소&type=video&maxResults=30`,
        method: "get",
      })
        .then((res) => {
          console.log(res.data.items);
          commit("GET_SSAFIT_LIST", res.data.items);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getSsafitListWeight({ commit }) {
      const API_URL = "https://www.googleapis.com/youtube/v3/search";
      const API_KEY = "AIzaSyArLUiigknT0qcs4M33dyTAt766ENRtdbM";
      axios({
        url: `${API_URL}?key=${API_KEY}&part=snippet&q=웨이트&type=video&maxResults=30`,
        method: "get",
      })
        .then((res) => {
          console.log(res.data.items);
          commit("GET_SSAFIT_LIST", res.data.items);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getSsafitListSearch({ commit }, searchText) {
      const API_URL = "https://www.googleapis.com/youtube/v3/search";
      const API_KEY = "AIzaSyArLUiigknT0qcs4M33dyTAt766ENRtdbM";
      const search = searchText + "운동";
      axios({
        url: `${API_URL}?key=${API_KEY}&part=snippet&q=${search}&type=video&maxResults=30`,
        method: "get",
      })
        .then((res) => {
          console.log(res.data.items);
          commit("GET_SSAFIT_LIST", res.data.items);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    updatePwd({ commit }, user) {
      const API_URL = `${REST_API}/user/pwd`;
      axios({
        url: API_URL,
        method: "put",
        params: user,
      })
        .then((res) => {
          console.log(res);
          alert("비밀번호가 변경되었습니다. 다시 로그인해주세요.");
          router.push("/login");
          commit;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    /////////////////////////////////////////////////////////////////////////////////////////////////
    // board part
    /////////////////////////////////////////////////////////////////////////////////////////////////
    registBoard({ commit }, board) {
      const API_URL = `${REST_API}/board`;
      axios({
        url: API_URL,
        method: "post",
        data: board,
      })
        .then((res) => commit("REGIST_BOARD", res.data))
        .catch((err) => console.log(err));
    },
    registReview({ commit }, review) {
      const API_URL = `${REST_API}/review`;
      console.log("객체확인", review);
      axios({
        url: API_URL,
        method: "post",
        data: review,
      })
        .then((res) => res)
        .catch((err) => console.log("asdf", err));
      commit;
    },
    getReviewCnt({ commit }, userId) {
      const API_URL = `${REST_API}/exp/${userId}`;
      axios({
        url: API_URL,
        method: "get",
      })
        .then((res) => {
          let arr = res.data;
          let expArr = arr.slice(arr.length - 7);
          commit("GET_REVIEW_CNT", expArr);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    searchBoardByDate(context, date) {
      const API_URL = `${REST_API}/board/date`;
      const searchCondition = {
        userId: context.state.loginUser.userId,
        regDate: date,
      };
      axios({
        url: API_URL,
        method: "get",
        params: searchCondition,
      })
        .then((res) => context.commit("SEARCH_BOARD_BY_DATE", res.data))
        .catch((err) => console.log(err));
    },
    searchBoard({ commit }, boardNumber) {
      const API_URL = `${REST_API}/board/${boardNumber}`;
      axios({
        url: API_URL,
        method: "get",
      })
        .then((res) => commit("SEARCH_BOARD", res.data))
        .catch((err) => console.log(err));
    },
    ssalogSearch({ commit }, searchText) {
      const API_URL = `${REST_API}/board/`;
      const searchCondition = {
        word: searchText,
        type: "word",
      };
      axios({
        url: API_URL,
        method: "get",
        params: searchCondition,
      })
        .then((res) => {
          console.log(res.data);
          commit("SSALOG_SEARCH", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
});
