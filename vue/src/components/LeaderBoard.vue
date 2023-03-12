<template>
  <div class="card one fade-in">
    <b-card-header class="header">
      <b-button variant="link" class="arrow" @click="goBack">
        <i class="fas fa-chevron-left"></i>
      </b-button>
      <h3 class="title">Leaderboard</h3>
    </b-card-header>
    <b-card-body class="profile">
      <b-row v-for="(person, index) in leaderBoard.slice(0,3)" :key="index" :class="{ 'first': index === 0 }" class="person">
        <b-col cols="auto">
          <div class="num">{{ index + 1 }}</div>
          <i class="fas fa-crown"></i>
        </b-col>
        <b-col cols="auto">
          <b-img :src="getPhotoUrl(person.gender)" fluid rounded class="photo"></b-img>
        </b-col>
        <b-col>
          <p class="link double-shaded">{{ person.user_name }}</p>
          <p class="points">{{ person.score }}</p>
        </b-col>
      </b-row>
    </b-card-body>
    <b-card-body class="rest">
      <b-row v-for="(person, index) in leaderBoard.slice(3)" :key="index" class="person">
        <b-col cols="auto">
          <div class="rank">
            <i class="fas fa-caret-up"></i>
            <div class="num">{{ index + 4 }}</div>
          </div>
        </b-col>
        <b-col cols="auto">
          <b-img :src="getPhotoUrl(person.gender)" fluid rounded class="photo"></b-img>
        </b-col>
        <b-col>
          <p class="link double-shaded">{{ person.user_name }}</p>
          <p class="points">{{ person.score }}</p>
        </b-col>
      </b-row>
    </b-card-body>
  </div>
</template>

<script>
import { BCard, BCardBody, BCardHeader, BButton, BRow, BCol, BImg } from 'bootstrap-vue';

const malePhotoUrls = [
  'https://cdn-icons-png.flaticon.com/512/3135/3135715.png',
  'https://cdn-icons-png.flaticon.com/512/4140/4140048.png',
  'https://cdn-icons-png.flaticon.com/512/4140/4140050.png',
  'https://cdn-icons-png.flaticon.com/512/4140/4140052.png'
];

const femalePhotoUrls = [
  'https://cdn-icons-png.flaticon.com/512/2922/2922561.png',
  'https://cdn-icons-png.flaticon.com/512/4140/4140047.png',
  'https://cdn-icons-png.flaticon.com/512/4140/4140049.png',
  'https://cdn-icons-png.flaticon.com/512/4140/4140051.png',
];

export default {
  name: 'LeaderBoard',
  components: { BCard, BCardBody, BCardHeader, BButton, BRow, BCol, BImg },
  data() {
    return {
      leaderBoard: [],
    };
  },
  mounted() {
    this.getRankList();
  },
  methods: {
    getRankList() {
      fetch('http://localhost:8081/WebApp/ScoreServlet')
        .then(response => {
          if (response.ok) {
            return response.json();
            }
            else{
                throw new Error("Sorry...");
            }
        })
        .then(data=>{
          this.leaderBoard=data;
         })
        .catch(error=>{
            console.error(error);
        })
         setTimeout(function() {
    document.querySelector('.fade-in').classList.add('show');
  }, 1000);
    document.querySelector('.arrow').addEventListener('click', function() {
    history.back();
  });

       },
      
    },
  computed: {
    getPhotoUrl() {
      return (gender) => {
        const photoUrls = gender === 'male' ? malePhotoUrls : femalePhotoUrls;
        const randomIndex = Math.floor(Math.random() * photoUrls.length);
        return photoUrls[randomIndex];
      };
    }
  }
};
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap');
@import '@fortawesome/fontawesome-free/css/all.css';

.fade-in {
  opacity: 0;
  transition: opacity 0.5s ease-in-out;
}

.fade-in.show {
  opacity: 1;
}
*{
  margin: 0;
  padding: 0;
  outline: none;
  box-sizing: border-box;
  line-height: 1.5;
  transition: all .3s ease-in-out;
  font-family: "Josefin Sans", Arial;
  color:#fff;
}
.card{
  min-height: 700px;
  width: 600px;
  margin: auto;
  border-radius: 15px;
  background-color: #02383C;
  padding:10px;
}

.card .header{
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 2rem;
  color: #ddd;
  background: rgba(210, 255, 213, 0.2);
}

.card .header .title{
  font-weight: bold;
  display: inline-block;
  width: 100%;
}
.profile .photo{
  width: 100px;
  background: #fff;
  border-radius: 50%;
  border: 5px solid cyan;
  box-shadow: 0 0 20px cyan;
  margin: 1rem 0;
}
.photo{
  width: 75px;
  background: #fff;
  border-radius: 50%;
  border: 5px solid cyan;
  box-shadow: 0 0 20px cyan;
  margin: 1rem 0;
  animation: sparkle 1s linear infinite;
}
@keyframes sparkle {
  0% {
    border-color: cyan;
  }
  50% {
    border-color: gold;
  }
  100% {
    border-color: cyan;
  }
}
.profile{
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 1rem;
  border-radius: 0 0 50% 50% ;
  overflow: hidden;
  background: rgba(210, 255, 213, 0.1);
 
}.profile .person.first {

  transform: translateY(-5%);
}
.profile .person:nth-child(3) {
 
  transform: translateY(-5%);
}
.profile .link{
   font-size:20px;
}
.profile .person{
  display: flex;
  margin: 1rem 0;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  font-size:20px;
}

.fa-crown{
  color: gold;
  filter: drop-shadow(0px 0px 5px gold);
}

.num{
  color: white;
}

.fa-caret-up{
  color: cyan;
  font-size: 21px;
}

.link{
  margin: 0.2rem 0;
  color: #fff;
  margin-top: -0.3rem;
  font-size: 25px;
  font-weight:bold;
}
.double-shaded {
  background: linear-gradient(to right, #ff6b6b, #ffb347);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  
}
.points{
  color: cyan;
  font-size: 20px;
}
.rest .points{
  border-radius: 50%;
  width: 2.5rem;
  height: 2.5rem;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color:#333;
  color: cyan;
  font-size: 20px;
}
.flex{
  display: flex;
  align-items: center;
  width:400px;
}


.others{
  display: flex;
  width: 500px;
  margin-top: 2rem;
  align-items: center;
  justify-content: center;
}

.info{
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-radius: 30px;
  background: rgba(210, 255, 213, 0.3);
}

.info .points{
  margin-left: 0.2rem;
  margin-right: 1.2rem;
}

.info .link{
  margin: 0 1rem;
}

.rank{
  display: flex;
  align-items: center;
  margin: 0 1rem;
  flex-direction: column-reverse;
}

.rank i{
  margin-top: -5px !important;
}

.rank .num{
  margin: 0 !important; 
}


</style>