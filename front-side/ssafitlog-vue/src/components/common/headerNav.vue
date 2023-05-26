<template>
  <header>
    <nav class="header-nav">
      <div>
        <router-link to="/" class="logo">SSAFITLOG</router-link>
      </div>
      <div v-if="getUser">
        <a href="#">{{ loginUser.userName }} 님 환영합니다.</a>
        <router-link :to="`/SsalogProfile/${JSON.stringify(loginUser)}`">마이페이지</router-link>
        <a href="#" @click="logout">로그아웃</a>
        <router-link :to="{ name: 'BoardRegist' }"> 글 등록</router-link>
      </div>
      <div v-else>
        <router-link :to="{ name: 'UserLogin' }">로그인</router-link>
        <router-link :to="{ name: 'UserRegist' }">회원가입</router-link>
      </div>
      <div></div>
    </nav>
  </header>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "HeaderNav",

  data() {
    return {};
  },

  mounted() {},

  methods: {
    logout() {
      this.$store.commit("LOGOUT");
    },
    selectMine() {
      // alert('a')
      console.log("asfsaf", this.$store.state.loginUser)
      this.$store.state.selectUser = this.$store.state.loginUser;
    }
  },
  created() {
    this.$store.state.loginUser = JSON.parse(localStorage.getItem("loginUser"));
  },
  computed: {
    ...mapState(["loginUser"]),
    getUser() {
      if (this.loginUser) {
        return true;
      } else {
        return false;
      }
    },
  },
};
</script>

<style scoped>
header {
  height: 70px;
  background-color: #071844;
  line-height: 70px;
  padding: 0px 30px;
}

header a {
  margin: 10px;
  text-decoration: none;
  color: rgb(233, 220, 1);
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: rgb(233, 220, 1);
  margin: 0;
}
</style>
