import Vue from "vue";
import VueRouter from "vue-router";
import MainView from "../views/MainView.vue";
import SsafitView from "../views/SsafitView.vue";
import SsalogView from "../views/SsalogHomeView.vue";
import SsalogProfileView from "../views/SsalogProfileView.vue";
import UserLogin from "@/components/user/UserLogin.vue";
import UserRegist from "@/components/user/UserRegist.vue";
import UserSearchId from "@/components/user/UserSearchId.vue";
import UserSearchPassword from "@/components/user/UserSearchPassword.vue";
import UserUpdatePassword from "@/components/user/UserUpdatePassword.vue";
import BoardRegist from "@/components/board/BoardRegist.vue";
import BoardDetail from "@/components/board/BoardDetail.vue";
import SsafitBoardDetail from "@/components/board/SsafitBoardDetail.vue";
import UserDelete from "@/components/user/UserDelete.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "MainView",
    component: MainView,
  },
  {
    path: "/SSAFIT",
    name: "SsafitView",
    component: SsafitView,
  },
  {
    path: "/SSALOG",
    name: "SsalogView",
    component: SsalogView,
  },
  {
    path: "/login",
    name: "UserLogin",
    component: UserLogin,
  },
  {
    path: "/regist",
    name: "UserRegist",
    component: UserRegist,
  },
  {
    path: "/searchId",
    name: "UserSearchId",
    component: UserSearchId,
  },
  {
    path: "/searchPwd",
    name: "UserSearchPassword",
    component: UserSearchPassword,
  },
  {
    path: "/updatePwd",
    name: "UserUpdatePassword",
    component: UserUpdatePassword,
  },
  {
    path: "/SsalogProfile/:id",
    name: "SsalogProfile",
    component: SsalogProfileView,
  },
  {
    path: "/boardRegist",
    name: "BoardRegist",
    component: BoardRegist,
  },
  {
    path: "/boardDetail",
    name: "BoardDetail",
    component: BoardDetail,
  },
  {
    path: "/ssafitBoardDetail",
    name: "SsafitBoardDetail",
    component: SsafitBoardDetail,
  },
  {
    path: "/deleteUser",
    name: "UserDelete",
    component: UserDelete,
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
