<template>
  <div class="container d-flex  mt-sm-5 my-1 row ">
     <div class="question ml-sm-5 pl-sm-5 pt-2">
        <div class="info flex">
           <div class="d-flex align-items-center">
             <p class="num mr-2">{{ currentIndex + 1 }})</p>
             <p class="py-2 h5 ml-2"><b>{{ currentQuestion.question }}</b></p>
           </div>
        </div>
        <!-- <div> 
            <p class="timer">{{timeLeft}}</p>
        </div>    -->
     </div>

     <div class="ml-md-3 ml-sm-3 pl-md-5 pt-sm-0 pt-3" id="options">
        <div class="row">
           <div class="col-sm-5">
             <label class="options d-flex align-items-center">
             <input type="radio" name="radio" v-model="selectedOption" :value="currentQuestion.a">
             <p class="option">{{ currentQuestion.options[0]}}</p>
             </label>

             <label class="options d-flex align-items-center">
             <input type="radio" name="radio" v-model="selectedOption" :value="currentQuestion.b">
             <p class="option">{{ currentQuestion.options[1] }}</p>
             </label>
           </div>
           <div class="col-sm-5">
             <label class="options d-flex  align-items-center">
             <input type="radio" name="radio" v-model="selectedOption" :value="currentQuestion.c">
             <p class="option">{{ currentQuestion.options[2] }}</p>
             </label>

             <label class="options d-flex align-items-center">
             <input type="radio" name="radio" v-model="selectedOption" :value="currentQuestion.d">
             <p class="option">{{ currentQuestion.options[3] }}</p>
             </label>
            </div>
       </div>
     </div>

     <div class="d-flex align-items-center pt-3">
           <div id="prev">
             <button class="btn btn-primary" @click="previousQuestion" :disabled="currentIndex === 0">Previous</button>
           </div>
           <div class="ml-auto mr-sm-5 col-sm-10">
             <button class="btn btn-success" @click="nextQuestion">{{ buttonLabel }}</button>
           </div>
     </div>
             
    
  </div>

</template>

<script>
export default {

    data() {
           return {
                  questionList: [], 
                  currentIndex: 0,
                  selectedOption: null,
                  timeLeft:30,
                  selectedOptionsArray: [],
                   }
            },

    mounted(){
             this.getQuestions();
             this.startTimer();
             },

    computed: {
             currentQuestion() {
                       return this.questionList[this.currentIndex];
             },
             buttonLabel() {
                       return this.currentIndex === this.questionList.length - 1 ? 'Finish' : 'Next';
             },
            },

    methods: {
             startTimer() {
                        let timer = setInterval(() => {
                 if (this.timeLeft > 0) {
                        this.timeLeft--;
                } 
                 else {
                        clearInterval(timer);
                        this.nextQuestion();
                }
             }, 1000);
            },

             getQuestions(){
        
                       fetch('http://localhost:8081/WebApp/ExamServlet')
                       .then(response=>{
                                if(response.ok){
                                      return response.json();
                                 }
                                else{
                                      throw new Error("Sorry...");
                                 }
                           })
                       .then(data=>{
                                 console.log(data);
                                 this.questionList=data;
                           })
                      .catch(error=>{
                                 console.error(error);
                           })
                 },

             nextQuestion() {
                       if (this.currentIndex < this.questionList.length - 1) {
                             this.selectedOptionsArray.push(this.selectedOption);
                             this.startTimer();
                             this.currentIndex += 1;
                             this.selectedOption = null;
                     }
                       else {
                             alert('Quiz finished!');
                     }
                 },

             previousQuestion() {
                       if (this.currentIndex > 0) {
                             this.currentIndex -= 1;
                             this.selectedOption = null;
                     }
                 }
        }
}

</script>
<style scoped>

.num {
  font-size: 24px;
}

.progress-bar {
  height: 100%;
  background-color: green;
  transition: background-color 0.5s ease-out;
}

.progress-bar.progress-50 {
  background-color: yellow;
}

.progress-bar.progress-90 {
  background-color: red;
}

</style>