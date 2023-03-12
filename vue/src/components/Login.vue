<template>
  <div class="container-fluid p-0">
      <div class="flash-message" v-if="flashMessage">{{ flashMessage }}</div>
   <div class="video-container">
      <video autoplay muted loop class="fullscreen-bg__video">
        <source src="@/assets/black.mp4" type="video/mp4">
      </video>

      <b-form @submit.prevent="submit" class="container-sm text-center text-white">
        <h2 class="text-uppercase text-center mb-4">LOGIN</h2>
       

         <br />

        <b-form-group >
          <b-form-input id="username" v-model="username" class="bg-dark text-white" required placeholder="Username"/>
       </b-form-group>

         <br />
<b-form-group>
          <b-form-input id="password" v-model="password" class="bg-dark text-white" type="password" required placeholder="Password"/>
        </b-form-group>

         <br />
          <b-form-group label ="Role">
                   <b-form-select  class="bg-dark text-white"
                         v-model="role"
                         :options="[
                               { text: 'User', value: 'user' },
                               { text: 'Admin', value: 'admin' }
                                  ]"
                          required />
               
               </b-form-group>
               <br />
                <b-button variant="primary" size="sm" class="mt-2" @click="login">Login</b-button>

               <br />

        <h6 class="mt-4 mb-0">New User</h6>
        <b-button variant="success" size="sm" class="mt-2" @click="signup">Register</b-button>
      </b-form>
    </div>
 <!-- <div class="footer">
      <Footer />
    </div> -->
</div>
</template>

<script>
  import Footer from "@/components/Footer.vue";
  import {
   
    BForm,
    BFormGroup,
    BFormInput,
    BFormSelect,
    BButton
  } from 'bootstrap-vue';

  export default {
    name: "Login",
    data() {
      return {
        username: '',
        password: '',
        role: '',
      }
    },
    components: {
      Footer,
      BForm,
      BFormGroup,
      BFormInput,
      BFormSelect,
      BButton
    },
    methods: {
      login() {
        const credentials = {
          userName: this.username,
          password: this.password,
          role: this.role,
        };
        this.$store.dispatch('login', { credentials, router: this.$router });
      },
      signup() {
        this.$router.push('/signUp');
      },
    },
    computed: {
    flashMessage() {
      return this.$store.state.flash_message;
    },
  },
  }
</script>

<style scoped>
 
.container-fluid {
  position:fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  overflow: auto;
}
.video-container {
    position: relative;
    height: 0;
    overflow: hidden;
    padding-bottom: 56.25%;
  }

  .video-container video {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    min-width: 100%;
    min-height: 100%;
    width: auto;
    height: auto;
    z-index: -1;
   
  }
   
 .title{
    font-size:30px;
    color: aqua;
    font-weight: bold;
    text-shadow: rgb(121, 168, 168) 1px 2px;
  }
  .footer {
  position:relative;
  bottom: 0;
  left: 0;
  width: 100%;
}
.flash-message {
  height:35px;
  animation: flash 1s infinite;
  color:red;
}

@keyframes flash {
  0% {
    background-color:rgb(233, 185, 27);
  }
  50% {
    background-color: white;
  }
  100% {
    background-color: rgb(233, 185, 27);
  }
}
</style>
 