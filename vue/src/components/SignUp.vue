<template>
  <div class="container-fluid p-0">
      <div class="flash-message" v-if="flashMessage">{{ message }}</div>

    <div class="video-container">
      <video autoplay muted loop class="fullscreen-bg__video">
        <source src="@/assets/black.mp4" type="video/mp4">
      </video>

      <b-form @submit.prevent="submit" class="container-sm text-center text-white">
        <h2 class="text-uppercase text-center mb-4">SignUp</h2>
        
        <b-form-group>
          <b-form-input id="name" v-model="name" class="bg-dark text-white" required placeholder="Name"/>
        </b-form-group>

        <br />

        <b-form-group>
          <b-form-input id="email" v-model="email" class="bg-dark text-white" type="email" required placeholder="Email"/>
        </b-form-group>

        <br />

        <b-form-group>
          <div class="form-check form-check-inline">
            <b-form-radio v-model="gender" value="male" name="gender" inline>Male</b-form-radio>
          </div>
          <div class="form-check form-check-inline">
            <b-form-radio v-model="gender" value="female" name="gender" inline>Female</b-form-radio>
          </div>
        </b-form-group>

        <br />

        <b-form-group>
          <b-form-input id="username" v-model="username" class="bg-dark text-white" required placeholder="Username"/>
        </b-form-group>

        <br />

        <b-form-group>
          <b-form-input id="password" v-model="password" class="bg-dark text-white" type="password" required placeholder="Password"/>
        </b-form-group>

        <br />

        <b-form-group>
          <b-form-input
            id="confirmPassword"
            v-model="confirmPassword"
            class="bg-dark text-white"
            type="password"
            placeholder="Confirm Password"
            required
          />
        </b-form-group>

        <br />

        <b-form-group>
          <b-form-input id="contact" v-model="contact" class="bg-dark text-white" type="tel" required placeholder="Contact No"/>
        </b-form-group>

        <br />

      
        <b-button
          :disabled="!passwordsMatch"
          type="submit"
          variant="primary"
          class="d-grid gap-2 col-2 mx-auto"
        >
          SignUp
        </b-button>

         <br />
         <br />

        <h6 class="mt-4 mb-0">Already have an account?</h6>
        <b-button variant="success" size="sm" class="mt-2" @click="login">Login</b-button>


      </b-form>
    </div>
 <!-- <div class="footer">
      <Footer />
    </div> -->
</div>
</template>

<script>
import Navigation from '@/components/Navigation.vue';
import Footer from "@/components/Footer.vue";
import {
    BForm,
    BFormGroup,
    BFormInput,
    BFormRadio,
    BButton
  } from 'bootstrap-vue';

 export default {
      name:'SignUp',
      components: {
      Navigation,
      BForm,
      BFormGroup,
      BFormInput,
      BFormRadio,
      BButton
    },
    data(){
        return{
             
             name: '',
             email: '',
             gender: '',
             username: '',
             password: '',
             confirmPassword: '',
             contact: '',
             message: '',
        }
    },
    computed: {
       flashMessage() {
      return this.message;
    },
    passwordsMatch() {
      return this.password === this.confirmPassword;
    },
  },
    methods:{
        submit(){
          if (this.password !== this.confirmPassword) {
        alert('Passwords do not match')
        return;
        } 
        else {
            const userData={
                name:this.name,
                email:this.email,
                gender:this.gender,
                userName:this.username,
                password:this.password,
                contactNo:this.contact,
            }
            console.log(userData);
           fetch('http://localhost:8081/WebApp/UserRegisterServlet',{
            method:'post',
            body:JSON.stringify(
                userData),
            headers:{'content-type':'application/json'},
           })
           .then(response=>{
            if(response.ok){
                return response.json();
            }
            else{
                throw new Error('sorry');
            }
           })
           .then(data=>{
            if(data.message==='Success'){
                 
                this.$router.push('/login');
            }
            else{
                this.message=data.message+"."+" Please Login...";
            }
           })
           .catch(error=>{
             console.error(error);
           })
        }
        },
        login(){
          this.$router.push('/login');
        }
    }
}
   
</script>
<style>
.container-fluid {
  position:fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  overflow: auto;
}
.navigation {
  position: relative;
  z-index: 1;
}
.container-sm {
  position: relative;
  z-index: 1;
}
  .form-group{
    margin-right:20%;
    margin-left:20%;
     
  }
  h2{
    color: aqua;
    font-weight: bold;
    text-shadow: rgb(121, 168, 168) 1px 2px;
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
  .footer{
    bottom:0;
  }
  .flash-message {
  height:35px;
  animation: flash 1s infinite;
  color:red;
}

@keyframes flash {
  0% {
    background-color: rgb(233, 185, 27);
  }
  50% {
    background-color: white;
  }
  100% {
    background-color: rgb(233, 185, 27);
  }
}
</style>

