<template>
  <div class="container-fluid p-0 ">
    <b-navbar variant="dark" type="dark" expand="lg">
      <b-container>
        <b-row class="w-100">
          <b-col md="4" class="d-flex align-items-center">
            <ul class="navbar-nav flex-row">
              <li class="nav-item">
                <b-link class="nav-link text-white" @click="showRankList">
                  <i class="fa fa-trophy trophy-icon"></i>
                </b-link>
              </li>
              <li class="nav-item">
                <router-link to="/" class="nav-link text-white">Home</router-link>
              </li>
              <li class="nav-item">
                <router-link to="/about" class="nav-link text-white">About</router-link>
              </li>
              <li class="nav-item">
                <router-link to="/contact" class="nav-link text-white">ContactUs</router-link>
              </li>
            </ul>
          </b-col>
          <b-col md="8" class="d-flex justify-content-end align-items-center">
            <b-dropdown>
              <template #button-content>
                <i class="fas fa-user-plus"></i>
              </template>
              <b-dropdown-item v-if="!loggedIn" :to="{path: '/login'}">Login</b-dropdown-item>
              <b-dropdown-item v-if="loggedIn" @click="logout">Logout</b-dropdown-item>
            </b-dropdown>
          </b-col>
        </b-row>
      </b-container>
    </b-navbar>
  </div>
</template>

<script>
import { BNavbar, BContainer, BRow, BCol, BLink, BDropdown, BDropdownItem } from 'bootstrap-vue';
import store from '@/store/store';

export default {
  name: 'Navigation',
  components: {
    BNavbar,
    BContainer,
    BRow,
    BCol,
    BLink,
    BDropdown,
    BDropdownItem,
  },
  computed: {
    loggedIn() {
      return this.$store.getters.user_id != null;
    },
  },
  methods: {
    login() {
      this.$router.push('/login');
    },
    showRankList() {
      this.$router.push('/leaderBoard');
    },
    logout() {
      store.commit('setUserId', null);
      this.$router.push('/');
    },
  },
};
</script>

<style scoped>
  .container-fluid {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    overflow: hidden;
    z-index: 1;
  }

  .nav-link {
    margin-left: 20px;
    margin-right: 20px;
    transition: transform 0.2s ease-in-out;
  }

  .nav-link:hover {
    transform: scale(1.1);
  }

  .trophy-icon {
    font-size: 30px;
    color: aqua;
    transform: rotate(0deg);
    transition: transform 0.5s ease-in-out;
    filter: drop-shadow(0px 0px 2px rgb(39, 216, 148));
    cursor: pointer;
  }

  .trophy-icon:hover {
    transform: rotate(360deg);
  }
</style>
