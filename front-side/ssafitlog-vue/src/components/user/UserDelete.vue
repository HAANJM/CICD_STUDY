<template>
  <div id="container">
    <b-card
      title="회원 탈퇴"
      tag="article"
      style="width: 400px"
      class="mb-2"
    >
      <b-form v-if="show">
        <b-form-group
          id="input-group-1"
          label="비밀번호"
          label-for="input-1"
        >
          <b-form-input
            id="input-1"
            v-model="user.password"
            type="password"
            placeholder="비밀번호를 작성해주세요."
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="input-group-1"
          label="비밀번호 확인"
          label-for="input-1"
        >
          <b-form-input
            id="input-1"
            v-model="user.checkPassword"
            type="password"
            placeholder="비밀번호를 확인해주세요."
            required
          ></b-form-input>
        </b-form-group>
        <hr>
        <b-form-group>
            <b-form-checkbox
              id="checkbox-1"
              v-model="status"
              name="checkbox-1"
              value="accepted"
              unchecked-value="not_accepted"
            >
              회원 탈퇴 시 개인 정보 및 SSAFITLOG에서 만들어진 모든 데이터(스트릭, 게시글 등)은 모두 삭제됩니다.
              해당 내용을 모두 확인했으며, 회원탈퇴에 동의합니다.
            </b-form-checkbox>
        </b-form-group>
        <b-button class="btn" variant="primary" @click="deleteUser"
          >회원 탈퇴</b-button
        >
      </b-form>
    </b-card>
  </div>
</template>

<script>
export default {
  name: "UserDelete",
  data() {
    return {
      user: {
        userId: "",
        password: "",
        checkPassword: "",
      },
      show: true,
      status : false,
    };
  },
  methods: {
    deleteUser(){
      
    }
  },
  created(){
    this.user.userId = this.$route.params.userId;
    console.log(this.user.userId);
  }
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
