<template>
<body>
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
  </div>
      </body> 
        </template>

        <script>
        export default {
            name:'Login',
            data(){
                return{
                    username:'',
                    password:'',
                    role:'',
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
      this.$store.dispatch('login',credentials);
               }

}
       
        }
        </script>
      
       <style scoped>
       .login button {
           background-color: blue; /* Green background color */
  color: white; /* White text color */
  padding: 12px 20px; /* Padding around the text */
  border: none; /* Remove the button border */
  border-radius: 5px; /* Rounded corners */
  cursor: pointer; /* Change cursor to a hand on hover */
  box-shadow: 0px 3px 0px  #444944; /* Add a box shadow effect */
}

.login button:hover {
  background-color: #22d1ae; /* Darker green background color on hover */
  box-shadow: 0px 5px 0px #444944; /* Increase the shadow effect on hover */
  font-weight:bold;
}
       </style>