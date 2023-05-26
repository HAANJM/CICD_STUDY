<template>
  <b-container>
    <b-card-group deck>
      <b-card id="mainCard" header-tag="header" footer-tag="footer">
        <template #header>
          <b-row id="header">
            <b-container>
              <b-row>
                <b-col cols="12" style="text-align: center">
                  <h4>
                    <b>{{ board.snippet.title }}</b>
                  </h4>
                </b-col>
              </b-row>
              <hr>
              <b-row>
                <b-col cols="9"><h6>{{ board.snippet.channelTitle }}</h6></b-col>
                <b-col><h6>{{ board.snippet.publishTime }}</h6></b-col>
              </b-row>
            </b-container>
          </b-row>
        </template>
        <b-card-text>
          <b-row id="main">
            <b-container>
              <b-row>
                <b-col cols="12" style="text-align: center">
                  <iframe
                    width="560"
                    height="315"
                    :src="src"
                    title="YouTube video player"
                    frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                    allowfullscreen
                  ></iframe>
                </b-col>
                <!-- <b-img class="cropped2" src="https://img.youtube.com/vi/UPuLcQTkFwc/0.jpg"></b-img> -->
              </b-row>
              <br /><hr>
              <b-row><h6>{{ board.snippet.description }}</h6></b-row>
            </b-container>
          </b-row>
        </b-card-text>
      </b-card>
    </b-card-group>
  </b-container>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "SsafitBoardDetail",
  computed: {
    ...mapState(["loginUser"]),
    // rereviews() {
    //   return this.reviews;
    // }
  },
  data() {
    return {
      src: "https://www.youtube.com/embed/",
      up: "hand-thumbs-up",
      down: "hand-thumbs-down",
      board: {},
    };
  },
  mounted() {},
  methods: {
    showFix(index) {
      this.show = !this.show;
      this.sindex = index;
    },
  },
  created() {
    this.src = `https://www.youtube.com/embed/${this.$route.params.board.id.videoId}`;
    this.board = this.$route.params.board;
    console.log(this.board.snippet);
  },
};
</script>

<style scoped>
.cropped2 {
  width: 400px;
  height: 200px;
  object-fit: cover;
  object-position: 20% 10%;
  border: 5px solid black;
}
.raBtn {
  opacity: 0;
}
#mainCard{
  border: 3px solid #071844;
  margin-top : 20px;
}
*{
  color : #071844;
}

</style>
