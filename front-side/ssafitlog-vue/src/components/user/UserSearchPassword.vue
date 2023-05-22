<template>
  <div id="container">
    <b-card
      title="비밀번호 재설정"
      tag="article"
      style="width: 400px"
      class="mb-2"
    >
      <b-form @submit="onSubmit" v-if="show">
        <b-form-group id="input-group-1" label="아이디" label-for="input-1">
          <b-form-input
            id="input-1"
            v-model="user.userId"
            type="text"
            placeholder="아이디를 작성해주세요."
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-1" label="이름" label-for="input-1">
          <b-form-input
            id="input-1"
            v-model="user.userName"
            type="text"
            placeholder="아이디를 작성해주세요."
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-2" label="이메일" label-for="input-2">
          <b-form-input
            id="input-2"
            v-model="user.email"
            type="password"
            placeholder="비밀번호를 작성해주세요."
            required
          ></b-form-input>
        </b-form-group>

        <span><router-link :to="{}">아이디 찾기</router-link></span> |
        <span><router-link :to="{}">비밀번호 찾기</router-link></span>
        <br /><br />

        <b-button type="submit" class="btn" variant="primary">로그인</b-button>
      </b-form>
    </b-card>
  </div>
</template>

<script>
export default {
  name: "UserSearchPassword",
  data() {
    return {
      user: {
        userId: "",
        userName: "",
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
