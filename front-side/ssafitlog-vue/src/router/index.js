import Vue from "vue";
import VueRouter from "vue-router";
import MainView from "../views/MainView.vue";
import SsafitView from "../views/SsafitView.vue";
import SsalogView from "../views/SsalogHomeView.vue";
import SsalogProfileView from "../views/SsalogProfileView.vue";
import SsalogDetailView from "../views/SsalogDetailView.vue";
import UserLogin from "@/components/user/userLogin.vue";
import UserRegist from "@/components/user/userRegist.vue";
import UserSearchId from "@/components/user/userSearchId.vue";
import UserSearchPassword from "@/components/user/userSearchPassword.vue";
import UserUpdatePassword from "@/components/user/userUpdatePassword.vue";
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
    path: "/SsalogProfile",
    name: "SsalogProfile",
    component: SsalogProfileView,
  },
  {
    path: "/ssalogDetail",
    name: "SsalogDetail",
    component: SsalogDetailView
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
