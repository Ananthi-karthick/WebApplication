<template>
     <div class="container my-1 bg-dark text-white">
    <table class="table table-striped table-hover">
      <thead class="table-header">
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Email</th>
          <th>Gender</th>
          <th>ContactNo</th>
        </tr>
      </thead>
      <tbody class="table-data">
        <tr v-for="user in userList" :key="user.id">
          <td class="text-success">{{ user.userId }}</td>
          <td class="text-white">{{ user.name }}</td>
          <td class="text-white">{{ user.gender }}</td>
          <td class="text-white">{{ user.email }}</td>
          <td class="text-white">{{ user.contactNo }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
export default {
    name:'AllUsers',

    data(){
        return{
            userList:[],
        }
    },
    mounted(){
        this.getAllUsers();
    },
    methods:{
       getAllUsers(){
            fetch('http://localhost:8081/WebApp/ViewUserServlet')
            .then(response=>response.json())
            .then(data=>{
                console.log(data);
                this.userList=data;
            })
        }
    }
}
</script>
<style scoped>
.container{
    font-size: 13px;
}
.table-header{
    color:crimson;
    text-shadow: rgb(175, 106, 106) 1px 1px;
}
.table-data td {
  padding: 0.5rem;
  color:white;
}
.fade-enter-active {
  transition: all 1s ease;
}

.fade-enter {
  opacity: 0;
  transform: translateY(30px);
}
</style>