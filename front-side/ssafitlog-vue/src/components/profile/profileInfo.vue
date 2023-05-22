<template>
  <div id="info">
    <b-row class="text-center">
      <b-col cols="9">
        <b-tabs content-class="mt-3">
          <b-tab title="포스트" active ><profile-info-post></profile-info-post></b-tab>
          
          <b-tab title="팔로잉" ><profile-info-follow></profile-info-follow></b-tab>
          <b-tab title="그래프"><profile-info-graph></profile-info-graph></b-tab>
        </b-tabs>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import ProfileInfoPost from "@/components/profile/profileInfo/profileInfoPost.vue";
import ProfileInfoGraph from './profileInfo/profileInfoGraph.vue';
import ProfileInfoFollow from './profileInfo/profileInfoFollow.vue';
export default {
    name : "ProfileInfo",
    components: {
      ProfileInfoPost,
      ProfileInfoGraph,
      ProfileInfoFollow,
    }
}
</script>
        ProfileInfoFollow

<style>
#info{
    margin : 0 auto;
    height: 800px;
    border: 1px solid black;
}
</style>