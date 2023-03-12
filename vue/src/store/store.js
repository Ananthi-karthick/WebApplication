import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
    name:'store',
    state:{
        user_id:null,
        flash_message: null,
    },
    mutations:{
        setUserId(state,user_id){
            state.user_id=user_id;
            console.log(state.user_id);
        },
        setFlashMessage(state, message){
            state.flash_message = message;
        }
       
    },
    actions:{
        login({commit},{credentials,router}){
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

                commit('setUserId',data.user_id);
                if(credentials.role==='admin')
                {
                    router.push('/');

                }
                else if(credentials.role==='user'){
                    router.push('/');
                }
            }
            else{
                throw new Error("Failed to login as   "+credentials.role +"  Or Invalid username and password");
            }
        })
        .catch(error=>{
            commit('setFlashMessage', error.message);
        })
    },
},
getters:{
    user_id:(state)=>state.user_id,
    
}
});

