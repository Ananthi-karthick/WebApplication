<template>
    <div class="SignUp">
        <h1> Sign Up</h1>
         <label for="name">Name:</label>
         <input type="text" v-model="name">
         <br>
         <label for="email">Email Id:</label>
         <input type="email" v-model="email" >
         <br>
         <div class='genderStyle'>
         <label for="gender">Gender:</label>  
         <div v-for="(gender, index) in genders" :key="index">
         <input type="radio" :value="gender" v-model="selectedGender" :class='{label}' >
         {{ gender }}
         </div>
         </div>
         <label for="username">Username:</label>
         <input type="text" v-model="username" >
         <br>
         <label for="password">Password:</label>
         <input type="password" v-model="password" >
         <br>
         <label for="contact">Contact No:</label>
         <input type="tel" v-model="contactNo" >
         <br>
         <button v-on:click="submit">Submit</button>
        </div>
</template>
<script>
export default {
    name:'SignUp',
    data(){
        return{
             selectedGender: '',
             genders: ['Male', 'Female', 'Other'],
             name:'',
             email:'',
             username:'',
             password:'',
             contactNo:'',
        }
    },
    methods:{
        submit(){
            const userData={
                name:this.name,
                email:this.email,
                gender:this.selectedGender,
                userName:this.username,
                password:this.password,
                contactNo:this.contactNo,
            }
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
            if(data.message=='Success'){
                this.$router.push('/');
            }
            else{
                this.$router.push('/');
            }
           })
           .catch(error=>{
             console.error(error);
           })
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
.SignUp{
  min-height: 400px;
   max-width: 500px;
  margin: auto;
  border-radius: 15px;
  background-color: #a4dee2;
  padding:10px;
}
.SignUp label {
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
.genderStyle{
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  margin-right: 50px;
}

button {
  padding: 10px 20px;
  border-radius: 4px;
  border: none;
  background-color: #4CAF50;
  color: #fff;
  font-size: 16px;
  cursor: pointer;
}

button:hover {
  background-color: #3e8e41;
}

button:active {
  background-color: #29783f;
  transform: translateY(1px);
}

</style>