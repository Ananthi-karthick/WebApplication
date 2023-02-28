import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
    
    state:{
        userRole:null,
    },
    mutations:{
        setUserRole(state,userRole){
            state.userRole=userRole;
        }
    },
    actions:{
        login({commit},credentials){
            const url=(credentials.role==='admin')? 'http://localhost:8081/WebApp/AdminServlet' : 'http://localhost:8081/WebApp/UsersServlet';
           
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(credentials),
        })
        .then(response=>{
            if(response.ok){
                return response.json();
            }
            else{
                throw new Error("Sorry!! Something went Wrong....");
            }
        })
        .then(data=>{
            if(data.message==='Success'){
                commit(setUserRole,credentials.role);
                if(credentials.role==='admin')
                {
                    this.$router.push('/AdminPanel');
                }
                else if(credentials.role==='user'){
                    this.$router.push('/UserPanel');
                }
            }
            else{
                throw new Error("Failed to login as   "+credentials.role);
            }
        })
        .catch(error=>{
            console.log(error);
        })
    },
},
getters:{
    userRole:(state)=>state.userRole,
}
});

