    <!-- Vue.js CDN -->
   
<template>
<div>
    <!-- Side Navbar -->
    <nav class="side-navbar  bg-dark text-white">
      <div class="side-navbar-inner">
        <!-- Sidebar Header    -->
        <div class="sidebar-header d-flex align-items-center justify-content-center p-3 mb-3">
          <!-- User Info-->
          <div class="sidenav-header-inner text-center"><img class="img-fluid rounded-circle avatar mb-3" src="img/avatar-7.jpg" alt="person">
            <h2 class="h5 text-white text-uppercase mb-0">Nathan Andrews</h2>
            <p class="text-sm mb-0 text-muted">Web Developer</p>
          </div>
          <!-- Small Brand information, appears on minimized sidebar--><a class="brand-small text-center" href="index.html">
            <p class="h1 m-0">BD</p></a>
        </div>
        <!-- Sidebar Navigation Menus--><span class="text-uppercase text-gray-500 text-sm fw-bold letter-spacing-0 mx-lg-2 heading">Main</span>
        <ul class="list-unstyled">                  
          <li class="sidebar-item"><a class="sidebar-link" href="index.html"> 
              Home </a></li>
          <li class="sidebar-item"><a class="sidebar-link" href="forms.html"> 
             Forms </a></li>
          <li class="sidebar-item"><a class="sidebar-link" href="charts.html"> 
              Charts </a></li>
          <li class="sidebar-item"><a class="sidebar-link" href="tables.html"> 
              Tables </a></li>
          <li class="sidebar-item"><a class="sidebar-link" href="#exampledropdownDropdown" data-bs-toggle="collapse"> 
             Example dropdown </a>
            <ul class="collapse list-unstyled  bg-dark text-white" id="exampledropdownDropdown">
              <li><a class="sidebar-link" href="#">Page</a></li>
              <li><a class="sidebar-link" href="#">Page</a></li>
              <li><a class="sidebar-link" href="#">Page</a></li>
            </ul>
          </li>
          <li class="sidebar-item"><a class="sidebar-link" href="login.html"> 
             </a></li>
        </ul>
      </div>
    </nav>
</div>
</template>

    <script>
    export default{
        name:'AdminPanel',
    }
      
    </script>
    
    <style>
      

    </style>