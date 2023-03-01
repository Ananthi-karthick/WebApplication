<template>
     <div class="login">
    <h1>Login Page</h1>
     <label for="username">Username:</label>
      <input type="text" v-model="username" >
      <br>
      <label for="password">Password:</label>
      <input type="password" v-model="password" >
      <br>
      <label for="role">Role:</label>
      <select v-model="role" required>
        <option value="admin">Admin</option>
        <option value="user">User</option>
      </select>
      <br>
    <p class="errMsg">{{errorMsg}}</p>
    <button :disabled="hasEmptyFields" class="btn btn-primary" v-on:click="login">Login</button>
    <router-link to='/signUp'>New User</router-link>
  </div> 
        </template>

        <script>
        export default {
            name:'Login',
            data(){
                return{
                    username:'',
                    password:'',
                    role:'',
                    errorMsg: '',
                }
            },
            computed:{
                hasEmptyFields() {
                   return !(this.username.length >=3 && this.password.length>=8 && !(!this.role))
            }     
            },
            methods:{
               login(){
                 const credentials = {
        userName: this.username,
        password: this.password,
        role: this.role,
      };
      this.$store.dispatch('login',{credentials, router: this.$router });
               }

}
       
        }
        </script>
      
<style scoped>
      * {
  margin: 0;
  padding: 0;
  outline: none;
  line-height: 1.5;
  font-family: "Josefin Sans", Arial;
  color:#333;
  
}
.login{
  min-height: 400px;
   max-width: 500px;
  margin: auto;
  border-radius: 15px;
  background-color: #a4dee2;
  padding:10px;
}
.login label {
  display: inline-block;
  width: 150px;
  text-align: right;
  margin-right: 10px; 
  font-weight:bold;
  
}
input[type=text],[type='email'],[type='tel'],[type='password']{
  width: 60%;
  box-sizing: border-box;
  padding: 10px;
  margin: 5px 0;
  border: 1px solid #333;
  border-radius: 4px;
}
button {
  padding: 10px 20px;
  border-radius: 4px;
  border: none;
  background-color:#fff;
  color:#333;
  font-size: 16px;
  cursor: pointer;
}
button:disabled {
  cursor: not-allowed; 
}
button:enabled {
  background-color: blue;
  color: white;
}

button:enabled:hover {
  background-color: darkblue;
}
</style>