<template>
  <footer
    class="row row-cols-1 row-cols-sm-2 row-cols-md-5 py-5 my-5 border-top"
  >
    <div class="col mb-3">
      <div style="margin-left: 50px">
        <h4>
          <a
            href="/"
            class="d-flex align-items-center mb-3 link-body-emphasis text-decoration-none"
            style="color: rgb(233, 220, 1)"
          >
            SSAFITLOG
          </a>
        </h4>
        <p class="text-body-secondary">
          &copy; 2023 SSAFY 9기 5반<br />
          김봉준 한장민
        </p>
      </div>
    </div>

    <div class="col mb-3"></div>

    <div class="col mb-3">
      <h5>SSAFITLOG</h5>
      <ul class="nav flex-column">
        <li class="nav-item mb-2">
          <a href="#" class="nav-link p-0 text-body-secondary">양명균</a>
        </li>
        <li class="nav-item mb-2">
          <a href="#" class="nav-link p-0 text-body-secondary">김봉준</a>
        </li>
        <li class="nav-item mb-2">
          <a href="#" class="nav-link p-0 text-body-secondary">한장민</a>
        </li>
      </ul>
    </div>

    <div class="col mb-3">
      <h5>회사 정보</h5>
      <ul class="nav flex-column">
        <li class="nav-item mb-2">
          <a href="#" class="nav-link p-0 text-body-secondary">오시는 길</a>
        </li>
        <li class="nav-item mb-2">
          <a href="#" class="nav-link p-0 text-body-secondary">이용약관</a>
        </li>
        <li class="nav-item mb-2">
          <a href="#" class="nav-link p-0 text-body-secondary"
            >개인정보처리방침</a
          >
        </li>
        <li class="nav-item mb-2">
          <a href="#" class="nav-link p-0 text-body-secondary">FAQs</a>
        </li>
        <li class="nav-item mb-2">
          <a href="#" class="nav-link p-0 text-body-secondary">About</a>
        </li>
      </ul>
    </div>

    <div class="col mb-3">
      <h5></h5>
      <ul class="nav flex-column">
        <li class="nav-item mb-2">
          <a href="#" class="nav-link p-0 text-body-secondary"
            >본 사이트의 콘텐츠는 저작권법의 보호를 받는 바 무단 전재, 복사,
            배포 등을 금합니다.</a
          >
        </li>
        <li class="nav-item mb-2">
          <a href="#" class="nav-link p-0 text-body-secondary"
            >Copyright © SAMSUNG All Rights Reserved.</a
          >
        </li>
      </ul>
    </div>
  </footer>
</template>

<script>
export default {
  name: "footerNav",

  data() {
    return {};
  },

  mounted() {},

  methods: {},
};
</script>

<style scoped>
footer {
  background-color: #071844;
  width: 100vw;
}
.text-body-secondary {
  color: rgb(233, 220, 1);
}
h5 {
  color: rgb(233, 220, 1);
}
.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}

@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}

.b-example-divider {
  width: 100%;
  height: 3rem;
  background-color: rgba(255, 255, 255, 0.1);
  border: solid rgba(0, 0, 0, 0.15);
  border-width: 1px 0;
  box-shadow: inset 0 0.5em 1.5em rgba(0, 0, 0, 0.1),
    inset 0 0.125em 0.5em rgba(0, 0, 0, 0.15);
}

.b-example-vr {
  flex-shrink: 0;
  width: 1.5rem;
  height: 100vh;
}

.bi {
  vertical-align: -0.125em;
  fill: currentColor;
}

.nav-scroller {
  position: relative;
  z-index: 2;
  height: 2.75rem;
  overflow-y: hidden;
}

.nav-scroller .nav {
  display: flex;
  flex-wrap: nowrap;
  padding-bottom: 1rem;
  margin-top: -1px;
  overflow-x: auto;
  text-align: center;
  white-space: nowrap;
  -webkit-overflow-scrolling: touch;
}

.btn-bd-primary {
  --bd-violet-bg: #712cf9;
  --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

  --bs-btn-font-weight: 600;
  --bs-btn-color: var(--bs-white);
  --bs-btn-bg: var(--bd-violet-bg);
  --bs-btn-border-color: var(--bd-violet-bg);
  --bs-btn-hover-color: var(--bs-white);
  --bs-btn-hover-bg: #6528e0;
  --bs-btn-hover-border-color: #6528e0;
  --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
  --bs-btn-active-color: var(--bs-btn-hover-color);
  --bs-btn-active-bg: #5a23c8;
  --bs-btn-active-border-color: #5a23c8;
}
.bd-mode-toggle {
  z-index: 1500;
}
</style>
