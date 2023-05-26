<template lang="">
    <b-container id="postDiv">

        <b-row>
            <post-stric></post-stric>
        </b-row>
        <hr>
        
        <b-row id="plzList">
            <div >
                <b-row
                :items="boardList"
                id="boardListDetail"
                
                >
                <b-card
                v-for="(board, index) in boardList"
                :key="index"
                :title="board.boardTitle"
                :img-src="`https://img.youtube.com/vi/${board.link}/0.jpg`"
                img-alt="Image"
                img-top
                tag="article"
                style="max-width: 20rem"
                class="mb-2 boardCard"
                @click="moveToDetail($event, board)"
                >
                <b-card-text>
                    <b-list-group flush>
                        <b-list-group-item>By {{ board.userId }}</b-list-group-item>
                        <b-list-group-item>♥ {{ board.favoriteCount }}</b-list-group-item>
                    </b-list-group>
                </b-card-text>
                
                <b-button href="/SSAFIT" variant="primary">SSAFIT</b-button>
            </b-card>
        </b-row>
    </div>
</b-row>

    </b-container>
</template>
<script>
import PostStric from "./PostStric.vue"
import { mapState } from "vuex";

export default {
    name: "ProfileInfoPost",
    computed: {
        ...mapState(["boardList"])
    },
    components: {
        PostStric,
    },
    methods: {
        moveToDetail(event, board) {
      event;
      // console.log(board);
      this.$store.state.board = board;
      this.$router.push({ name: "BoardDetail"});
    },
    }
}
</script>
<style scoped>
    #postDiv{
        height: 1200px;
    }
    #plzList{
        height: 50vw;
    }
</style>

