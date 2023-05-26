<template>
  <div id="container">
    <b-card title="아이디 찾기" tag="article" style="width: 400px" class="mb-2">
      <b-form v-if="show">
        <b-form-group id="input-group-1" label="이름" label-for="input-1">
          <b-form-input
            id="input-1"
            v-model="user.userName"
            type="text"
            placeholder="이름을 작성해주세요."
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-2" label="이메일" label-for="input-2">
          <b-form-input
            id="input-2"
            v-model="user.email"
            type="email"
            placeholder="이메일을 작성해주세요."
            required
          ></b-form-input>
        </b-form-group>

        <span
          ><router-link :to="{ name: 'UserSearchPassword' }"
            >비밀번호 찾기</router-link
          ></span
        >
        <br /><br />

        <b-button class="btn" variant="primary" @click="searchId"
          >아이디 찾기</b-button
        >
        <br /><br />
        <b-form-group
          id="input-group-2 userIdDiv"
          label="아이디"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="searchedId"
            type="text"
            placeholder="아이디입니다."
            readonly
          ></b-form-input>
        </b-form-group>
      </b-form>
    </b-card>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "UserSearchId",
  data() {
    return {
      user: {
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
    searchId() {
      this.$store.dispatch("searchId", this.user);
    },
  },
  computed: {
    ...mapState(["searchedId"]),
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
