<template>
  <div id="app">
    <header-nav></header-nav>
    <router-view />
    <footer-nav></footer-nav>
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";
import FooterNav from "@/components/common/FooterNav.vue";

export default {
  name: "App",
  components: {
    HeaderNav,
    FooterNav,
  },
};
</script>

<style></style>
