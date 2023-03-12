<template>
  <div>
    <!-- <Navigation /> -->
    <b-container fluid class="dashboard bg-dark">
      <b-row>
        <b-col md="3">
          <b-nav vertical class="sidebar border-light">
            <b-nav-item  to="/dashboard" >Dashboard</b-nav-item>
            <b-nav-item to="/questions" >Questions</b-nav-item>
            <b-nav-item to="/users" >Users</b-nav-item>
          </b-nav>
        </b-col>

        <b-col md="9">
          <b-container fluid class="main-content">
            <router-view></router-view>
          </b-container>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import Navigation from "@/components/Navigation.vue";
import { BNav, BContainer, BRow, BCol,BNavItem} from 'bootstrap-vue';

export default {
  name: "AdminDashboard",
  components: { Navigation, BNav, BContainer, BRow, BCol,BNavItem },
};
</script>

<style scoped>
.dashboard {
  top: 50px;
  height: 100vh;
}

.sidebar {
  position: fixed;
  top: 60px;
  left: 0;
  bottom: 0;
  width: 250px;
  background-color: #20555c;
  overflow-y: auto;
}
.nav-link {
  font-size:20px;
  color :#fff;
  margin-bottom:20px;
}


.nav-link:hover {
  color:#333;
  font-weight:bold;
}


</style>
