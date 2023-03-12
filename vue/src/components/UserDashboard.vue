<template>
<div>
  <Navigation />
  <div class="dashboard bg-dark ">
    <div class="sidebar border-light ">
      <ul class="nav flex-column ">
        <li class="nav-item ">
          <router-link to="/dashboard" class="nav-link">Dashboard</router-link>
        </li>
        <li class="nav-item ">
          <router-link to="/exam" class="nav-link ">Test</router-link>
        </li>
        <li class="nav-item  ">
          <router-link to="/testResults" class="nav-link ">Previous Test Results</router-link>
        </li>
      </ul>
    </div>

   
    <div class="main-content">
      <div class="container my-1">
        <router-view></router-view>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import Navigation from '@/components/Navigation.vue';

export default {
  name: 'AdminDashboard',
    components:{Navigation},

};
</script>

<style scoped>
.dashboard {
  display: flex;
  top:50px;
  height: 100vh;
}

.sidebar {
  position:fixed;
  top:60px;
  left: 0;
  bottom: 0;
  width: 200px;
  background-color: #20555c;
  color: #fff;
  overflow-y: auto;
}

.nav-item {
  margin-top :1rem;
  margin-bottom: 1rem;
  text-shadow: rgb(192, 182, 182) 1px 1px;
  font-size:18px;
}
.nav-link {
  color:#fff;
}
.nav-link:hover {
  color:#fff;
}

.main-content {
   margin-left:20%;
   flex:1;
  padding: 1rem;
}
</style>
