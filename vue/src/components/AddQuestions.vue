<template>
     <div class="text-light">
      <h2>Add Question</h2>
      <form >
        <div class="form-group ">
          <textarea id="question" class="form-control bg-dark text-light" v-model="question" placeholder=" Question"></textarea>
        </div><br><br>
        <div class="form-group">
          <input id="option1" class="form-control bg-dark text-light" v-model="options[0]" placeholder=" Option1">
        </div><br>
        <div class="form-group">
          <input id="option2" class="form-control bg-dark text-light" v-model="options[1]" placeholder=" Option2">
        </div><br>
        <div class="form-group">
          <input id="option3" class="form-control bg-dark text-light" v-model="options[2]" placeholder=" Option3">
        </div><br>
        <div class="form-group">
          <input id="option4" class="form-control bg-dark text-light" v-model="options[3]" placeholder=" Option4">
        </div><br>
        <div class="form-group">
            <label for="answer" >Correct Answer:</label>
          <select id="answer" class="form-control bg-dark text-light" v-model="answer" >
            <option v-for="(option, index) in options" :key="index" :value="option">{{ option }}</option>
          </select>
        </div><br>
        <button type="button" class="btn btn-primary" @click="addQuestion()">Add Question</button>
        <button type="button" class="btn btn-secondary" @click="resetForm()">Reset Form</button>
      </form>
    </div>
</template>
<script>
export default {
    name:'AddQuestions',
    data() {
    return {
      question: '',
      options: ['', '', '', ''],
      answer: ''
    };
  },
   methods: {
    addQuestion() {
        console.log(this.question);
        console.log(this.options);
        console.log(this.answer);
       fetch("http://localhost:8081/WebApp/QuestionServlet", {
		    method: "POST",
		    body: JSON.stringify({
                question:this.question,
                options:this.options,
                correctAnswer:this.answer,
            }),
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
            console.log(data);
           })
    },

    resetForm() {
      this.question = '';
      this.options = ['', '', '', ''];
      this.answer = '';
    }
  },
}
</script>
<style scoped>
 h2{
    color: aqua;
    font-weight: bold;
    text-shadow: rgb(121, 168, 168) 1px 2px;
  }
</style>