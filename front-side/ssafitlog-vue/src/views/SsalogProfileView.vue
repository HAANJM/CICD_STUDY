<template>
  <div id="container">
    <profile-personal-info :selectUserTransfer="`${$route.params.id}`"></profile-personal-info>
    <profile-info :selectUserTransfer2="`${$route.params.id}`"></profile-info>
  </div>
</template>

<script>
import ProfileInfo from "@/components/profile/ProfileInfo.vue";
import ProfilePersonalInfo from "@/components/profile/ProfilePersonalInfo.vue";
import { mapState } from "vuex";
export default {
  name: "SsalogProfile",
  components: {
    ProfileInfo,
    ProfilePersonalInfo,
  },

  data() {
    return {};
  },

  mounted() {},

  methods: {},
  created() {
    this.$store.state.expArr = JSON.parse(localStorage.getItem("expArr"));
    console.log("abc",this.loginUser.userId);
    console.log("abc",this.$route.params.id)
    // this.$store.dispatch("getReviewCnt", this.loginUser.userId);
  },
  computed: {
    ...mapState(["loginUser"]),
  },
};
</script>

<style scoped>
#container {
  width: 100%;
  height: 125vw;
  margin-top: 20px;
}
</style>
