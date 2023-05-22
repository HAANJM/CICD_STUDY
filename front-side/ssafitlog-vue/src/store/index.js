import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import router from "../router";

Vue.use(Vuex)

const REST_API = "http://localhost:9998/ssafitlog"

export default new Vuex.Store({
  state: {
    loginUser : {},
    boardList: [],
  },
  getters: {
  },
  mutations: {
    USER_LOGIN(state, loginUser){
      state.loginUser = loginUser;
    },
    LOGOUT(state){
      state.loginUser = null;
      sessionStorage.setItem("access-token", null);
    },
    GET_SSALOG_LIST_RECENTLY(state, boards){
      state.boardList = boards;
    },
    GET_SSALOG_LIST_POPULAR(state, boards){
      state.boardList = boards;
    }
  },
  actions: {
    userLogin({commit}, user){
      const API_URL = `${REST_API}/user/login`;
      axios({
        url: API_URL,
        method: "post",
        params: user,
      })
      .then((res) =>{
        sessionStorage.setItem("access-token", res.data["access-token"]);
        commit("USER_LOGIN", res.data.loginUser);
        router.push("/");
      })
      .catch((err) =>{
        alert("아이디 혹은 비밀번호를 확인해주세요.")
        console.log(err);
      })
    },
    getSsalogListRecently({commit}){
      const API_URL = `${REST_API}/board`;
      axios({
        url: API_URL,
        method: "get",
      })
      .then((res)=>{
        commit("GET_SSALOG_LIST_RECENTLY", res.data);
      })
      .catch((err)=>{
        console.log(err);
      })

    },
    getSsalogListPopular({commit}, type){
      const API_URL = `${REST_API}/board`;
      const searchCondition = {
        type : this.type,
      }
      axios({
        url: API_URL,
        method: "get",
        params: searchCondition,
      })
      .then((res)=>{
        commit("GET_SSALOG_LIST_POPULAR", res.data);
      })
      .catch((err)=>{
        console.log(err);
      })
    }
    
  },
  modules: {
  }
})
