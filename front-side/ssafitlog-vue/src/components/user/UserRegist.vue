<template>
  <div id="container">
    <b-card title="회원가입" tag="article" style="width: 400px" class="mb-2">
      <b-form v-if="show">
        <b-form-group
          id="input-group-1"
          label="아이디"
          label-for="input-1"
          :description="checkIdString"
        >
          <b-form-input
            id="input-1"
            v-model="user.userId"
            type="text"
            placeholder="아이디를 작성해주세요."
            required
            @keyup="userIdCheck"
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="비밀번호"
          label-for="input-2"
          :description="checkPwdString"
        >
          <b-form-input
            id="input-2"
            v-model="user.password"
            type="password"
            placeholder="비밀번호를 작성해주세요."
            @keyup="testPwd"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="비밀번호 재확인"
          label-for="input-2"
          :description="checkString"
        >
          <b-form-input
            id="input-2"
            v-model="user.checkPassword"
            type="password"
            placeholder="비밀번호를 확인해주세요."
            @keyup="CheckPwd"
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

        <b-form-group
          id="input-group-2"
          label="이메일"
          label-for="input-2"
          :description="checkEmailString"
        >
          <b-form-input
            id="input-2"
            v-model="user.email"
            type="text"
            placeholder="이메일을 작성해주세요."
            required
          ></b-form-input>
          <br />
          <b-form-input
            id="input-2"
            class="emailInput"
            v-model="emailCode"
            type="text"
            placeholder="인증번호를 작성해주세요."
            required
          ></b-form-input>
          <br />
          <b-button class="btn" variant="primary" @click="sendEmail"
            >인증 번호 발송</b-button
          >
          &nbsp;
          <b-button class="btn" variant="primary" @click="checkEmail"
            >인증 번호 확인</b-button
          >
        </b-form-group>

        <hr />

        <b-button
          type="submit"
          class="btn"
          variant="primary"
          @click="registUser"
          >회원가입</b-button
        >
      </b-form>
    </b-card>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "UserRegist",

  data() {
    return {
      user: {
        userId: "",
        password: "",
        checkPassword: "",
        userName: "",
        nickName: "",
        email: "",
      },
      show: true,
      emailCode: "",
      checkPwdString: "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.",
      checkString: "비밀번호를 확인해주세요.",
      checkIdString: "8~16자의 아이디를 작성해주세요.",
      checkEmailString: "",
      idFlag: false,
      pwdFlag: false,
      pwdCheckFlag: false,
      emailFlag: false,
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      alert(JSON.stringify(this.form));
    },
    sendEmail() {
      this.$store.dispatch("sendEmail", this.user.email);
    },
    checkEmail() {
      console.log(this.emailCode);
      console.log(this.$store.state.randomCode);
      if (this.emailCode == this.$store.state.randomCode) {
        this.checkEmailString = "인증번호가 일치합니다.";
        this.emailFlag = true;
      } else {
        this.checkEmailString = "인증번호가 일치하지 않습니다.";
      }
    },
    userIdCheck() {
      setTimeout(async () => {
        // alert(this.user.userId);
        await this.$store.dispatch("userIdCheck", this.user.userId);

        this.flagCheck();
      }, 100);
    },
    flagCheck() {
      let flag = this.$store.state.idCheckFlag;

      if (this.user.userId.length < 6) {
        this.checkIdString = "6~16자의 아이디를 작성해주세요.";
      } else if (flag == false) {
        this.checkIdString = "중복되는 아이디가 있습니다.";
      } else {
        this.checkIdString = "사용가능한 아이디입니다.";
        this.idFlag = true;
      }
    },
    CheckPwd() {
      if (this.user.checkPassword === "") {
        this.checkString = "비밀번호를 확인해주세요.";
      } else if (this.user.checkPassword == this.user.password) {
        this.checkString = "비밀번호가 일치합니다.";
        this.pwdCheckFlag = true;
      } else {
        this.checkString = "비밀번호가 일치하지 않습니다.";
      }
    },
    testPwd() {
      var regExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
      if (regExp.test(this.user.password)) {
        this.checkPwdString = "비밀번호의 보안이 높습니다.";
        this.pwdFlag = true;
      } else {
        this.checkPwdString =
          "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
      }
    },
    registUser() {
      if (!this.idFlag) {
        alert("아이디를 확인해주세요.");
      } else if (!this.pwdFlag) {
        alert("비밀번호 양식을 확인해주세요.");
      } else if (!this.pwdCheckFlag) {
        alert("비밀번호 재확인을 해주세요.");
      } else if (!this.emailCode) {
        alert("이메일 인증코드를 확인해주세요.");
      } else {
        this.$store.dispatch("registUser", this.user);
      }
    },
  },
  computed: {
    ...mapState(["idCheckFlag"]),
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
