import Vue from 'vue'
import Router from 'vue-router'
import Navigation from '@/components/Navigation.vue'
import Home from '@/components/Home.vue'
import Login from '@/components/Login.vue'
import SignUp from '@/components/SignUp.vue'
import Exam from '@/components/Exam.vue'
import LeaderBoard from '@/components/LeaderBoard.vue'
import AdminDashboard from '@/components/AdminDashboard.vue'
import AllUsers from '@/components/AllUsers.vue'
import AddQuestions from '@/components/AddQuestions.vue'
import Dashboard from '@/components/Dashboard.vue'
import Footer from '@/components/Footer.vue'
Vue.use(Router)

export default new Router({
  routes: 
    [{
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path:'/login',
      name:'login',
      component:Login,
    },
    {
      path:'/signUp',
      name:'signUp',
      component:SignUp,
    },
    {
      path:'/navigation',
      name:'navigation',
      component:Navigation,
    },
    {
      path:'/leaderBoard',
      name:'leaderBoard',
      component:LeaderBoard,
    },
    {
      path:'/exam',
      name:'Exam',
      component:Exam,
    },
    {
      path:'/footer',
      name:'Footerl',
      component:Footer,
    },
    {
      path:'/adminDashboard',
      name: 'AdminDashboard',
    component: AdminDashboard,
    children: [
      {
        path:'/dashboard',
        component:Dashboard,

      },
      {
        path:'/questions',
        component:AddQuestions,

      },
      
      {
        path: '/users',
        name: 'AllUsers',
        component:AllUsers,
      },
      
    ]
  }
    
  ]
})
