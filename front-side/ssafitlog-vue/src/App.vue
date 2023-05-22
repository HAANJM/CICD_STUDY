<template>
  <div id="app">
    <header-nav></header-nav>
    <router-view />
    <footer-nav></footer-nav>
  </div>
</template>

<script>
import headerNav from "@/components/common/headerNav.vue";
import footerNav from "@/components/common/footerNav.vue";

export default {
  name: "App",
  components: {
    headerNav,
    footerNav,
  },
};
</script>

<style></style>
