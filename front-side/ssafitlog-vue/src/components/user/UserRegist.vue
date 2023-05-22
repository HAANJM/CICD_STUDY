<template>
  <div id="container">
    <b-card title="회원가입" tag="article" style="width: 400px" class="mb-2">
      <b-form @submit="onSubmit" v-if="show">
        <b-form-group id="input-group-1" label="아이디" label-for="input-1">
          <b-form-input
            id="input-1"
            v-model="user.userId"
            type="text"
            placeholder="아이디를 작성해주세요."
            required
          ></b-form-input>
          <br />
          <b-button class="btn" variant="primary">아이디 중복 체크</b-button>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="비밀번호"
          label-for="input-2"
          description="8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요."
        >
          <b-form-input
            id="input-2"
            v-model="user.password"
            type="password"
            placeholder="비밀번호를 작성해주세요."
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="비밀번호 재확인"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="user.checkPassword"
            type="password"
            placeholder="비밀번호를 확인해주세요."
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-2" label="이름" label-for="input-2">
          <b-form-input
            id="input-2"
            v-model="user.userName"
            type="text"
            placeholder="이름을 작성해주세요."
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-2" label="닉네임" label-for="input-2">
          <b-form-input
            id="input-2"
            v-model="user.nickName"
            type="text"
            placeholder="닉네임을 작성해주세요."
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-2" label="이메일" label-for="input-2">
          <b-form-input
            id="input-2"
            v-model="user.email"
            type="password"
            placeholder="이메일을 작성해주세요."
            required
          ></b-form-input>
          <br />
          <b-button class="btn" variant="primary">인증 번호 발송</b-button>
        </b-form-group>

        <hr />

        <b-button type="submit" class="btn" variant="primary"
          >회원가입</b-button
        >
      </b-form>
    </b-card>
  </div>
</template>

<script>
export default {
  name: "UserRegist",

  data() {
    return {
      user: {
        userId: "",
        password: "",
        checkPassword: "",
        email: "",
      },
      show: true,
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      alert(JSON.stringify(this.form));
    },
    onReset(event) {
      event.preventDefault();
      // Reset our form values
      this.form.email = "";
      this.form.name = "";
      this.form.food = null;
      this.form.checked = [];
      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
</script>

<style scoped>
#container {
  width: 100%;
  height: 1000px;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
}
.btn {
  background-color: #071844;
  border: #071844;
  color: rgb(233, 220, 1);
}
</style>
