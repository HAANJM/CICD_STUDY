<template>
  <div id="container">
    <b-card
      title="비밀번호 재설정"
      tag="article"
      style="width: 400px"
      class="mb-2"
    >
      <b-form v-if="show">
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

        <b-button class="btn" variant="primary" @click="searchId"
            >인증 번호 발송</b-button
          > &nbsp;
          

        <br><br>

        <b-form-group id="input-group-2" label="인증번호" label-for="input-2">
          <b-form-input
            id="input-2"
            class="emailInput"
            v-model="emailCode"
            type="text"
            placeholder="인증번호를 작성해주세요."
            required
          ></b-form-input>
        </b-form-group>

        <b-button class="btn" variant="primary" @click="checkEmail"
            >인증 번호 확인</b-button
          >

        <hr>

        <b-button class="btn" variant="primary" @click="checkUser(user.userId)"
          >비밀번호 재설정</b-button
        >
      </b-form>
    </b-card>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: "UserSearchPassword",
  data() {
    return {
      user: {
        userId: "",
        userName: "",
        email: "",
        emailFlag : false,
      },
      emailCode : "",
      show: true,
    };
  },
  methods: {
    searchId() {
      setTimeout(async () => {
        await this.$store.dispatch("searchId", this.user);
      }, 1000); 
      console.log(this.user.userId== this.searchedId);
      
      if(this.user.userId == this.searchedId){
        alert("인증번호가 발송되었습니다. 확인 후 입력해주세요.")
        this.$store.dispatch("sendEmail", this.user.email);
      }else{
        alert("해당하는 유저가 없습니다!");
      }
    },
  checkEmail(){
      console.log(this.emailCode);
      console.log(this.$store.state.randomCode);
      if(this.emailCode == this.$store.state.randomCode){
        alert("인증번호가 일치합니다.");
        this.emailFlag = true;
      }else{
        alert("인증번호가 일치하지 않습니다."); 
      }
    },
  checkUser(userId){
    if(!this.emailFlag){
      alert("이메일 인증을 진행해주세요.");
    }else{
      console.log(userId);
      this.$router.push({name : 'UserUpdatePassword', params : {userId}});
    }
  }
  },
  computed :{
    ...mapState(["searchedId"]),
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
