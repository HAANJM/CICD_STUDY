<template>
  <div id="container">
    <div>
      <b-card
        title="SSAFIT"
        img-src="./SSAFIT.png"
        img-alt="Image"
        img-top
        tag="article"
        style="max-width: 20rem"
        class="mb-2"
      >
        <b-card-text> 인기있는 운동 동영상을 볼 수 있는 SSAFIT </b-card-text>

        <b-button href="/SSAFIT" variant="primary">SSAFIT</b-button>
      </b-card>
    </div>
    &nbsp; &nbsp; &nbsp;
    <div>
      <b-card
        title="SSALOG"
        img-src="./SSALOG.png"
        img-alt="Image"
        img-top
        tag="article"
        style="max-width: 20rem"
        class="mb-2"
      >
        <b-card-text>
          나의 운동 영상을 게시하고 서로 피드백을 주고받을 수 있는 SSALOG
        </b-card-text>

        <b-button href="/SSALOG" variant="primary">SSALOG</b-button>
      </b-card>
    </div>
  </div>
</template>

<script>
export default {
  name: "MainView",

  data() {
    return {};
  },

  mounted() {},

  methods: {},
};
</script>

<style scoped>
#container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 800px;
}
.mb-2{
  border : 5px solid #071844;
}
</style>
