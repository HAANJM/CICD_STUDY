<template>
  <div id="container">
    <profile-personal-info></profile-personal-info>
    <profile-info></profile-info>
  </div>
</template>

<script>
import profileInfo from '@/components/profile/profileInfo.vue';
import profilePersonalInfo from '@/components/profile/profilePersonalInfo.vue';

export default {
  name: "SsalogProfile",
  components:{
    profileInfo,
    profilePersonalInfo,
  },

  data() {
    return {};
  },

  mounted() {},

  methods: {},
};
</script>

<style scoped>
#container {
  width: 100%;
  height: 1200px;
  margin-top: 20px;
}
</style>
