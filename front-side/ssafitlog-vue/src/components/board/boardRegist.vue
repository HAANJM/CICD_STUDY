<template>
    <div>
      <b-container>
        <b-row>
            <b-col class="text-center">SSAFITLOG 글 작성</b-col>
        </b-row>
        <b-row>
            <b-col>
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group
          id="input-group-1"
          label="글 제목"
          label-for="input-1"
          description="We'll never share your email with anyone else."
        >
          <b-form-input
            id="input-1"
            v-model="form.boardTitle"
            type="text"
            placeholder="제목을 입력해주세요."
            required
          ></b-form-input>
        </b-form-group>
  
        
        <b-form-group id="input-group-2" label="글 내용" label-for="input-2">
          <b-form-textarea
           id="input-2"
           v-model="form.boardContent"
           placeholder="내용을 입력해주세요"
            rows="6"
            max-rows="6"
         ></b-form-textarea>
          
        </b-form-group>
  
        <b-form-group id="input-group-3" label="Youtube 링크" label-for="input-3">
            <b-form-input
            id="input-3"
            v-model="form.link"
            type="text"
            placeholder="유튜브 링크를 입력해주세요."
            required
          ></b-form-input>
        </b-form-group>
        <div class="d-flex flex-row-reverse">
            <b-button class="negative" type="back" variant="secondary">뒤로가기</b-button>
            <b-button class="negative" type="reset" variant="danger">초기화</b-button>
            <b-button class="positive" type="submit" variant="primary">등록</b-button>
        </div>
      </b-form>
    </b-col>
    </b-row>
    </b-container>
    </div>
  </template>
  
  <script>
  import { mapState } from 'vuex';

  export default {
      computed: {
        ...mapState(['loginUser'])
      },
      data() {
        return {
          form: {
            boardTitle: '',
            boardContent: '',
            link: '',
          },
        }
      },
      methods: {
        onSubmit(event) {
            event.preventDefault();
          const board = {
            boardTitle: this.form.boardTitle,
            boardContent: this.form.boardContent,
            userId: this.$store.state.loginUser.userId,
            link: this.form.link.split('=')[1],
          }

          this.$store.dispatch("registBoard", board);

        },
        onReset(event) {
          event.preventDefault();
          this.form.boardTitle = '';
          this.form.boardContent = '';
          this.form.link = '';
        },
        onback() {
            event.preventDefault();
            window.history.back();
        }
      }
  }
  </script >

  <style scoped>

  .positive {

  }
  .negative {

  }
  </style>