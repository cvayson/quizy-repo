import { Component, OnInit } from '@angular/core';
import {QuizService} from "../shared/quiz.service";
import {Quiz} from "../shared/quiz.model";
import {Question} from "../shared/quiz.model";
import {lastValueFrom} from "rxjs";
@Component({
  selector: 'app-quiz-start',
  templateUrl: './quiz-start.component.html',
  styleUrls: ['./quiz-start.component.css']
})
export class QuizStartComponent {
  categories = ["Arts & Literature", "Film & TV", "Food & Drink", "General Knowledge",
    "Geography", "History", "Music", "Science", "Society & Culture", "Sport & Leisure"];
  difficulties = ["easy", "medium", "hard"];
  categoryShow = false;
  difficultyShow = false;
  showStart = false;
  showPlay = false;
  showCorrect = false;
  showWrong = false;
  showEnd = false;
  category: String;
  difficulty: String;
  quiz: Quiz[];
  temp: Quiz;
  id: Number;
  last = false;
  question: Question[];
  currentQuestion: Question;
  questionNumber = 0;
  answer: String;
  correct = 0;
  temp2: Quiz;

  constructor(public service: QuizService) {
  }

  chooseCategory(category: String) {
    this.category = category;
    this.categoryShow = false;
    this.difficultyShow = true;
  }

  chooseDifficulty(difficulty: string) {
    this.difficulty = difficulty;
    this.save(this.category,this.difficulty);
    this.showStart = true;
    this.difficultyShow = false;


  }
  wait = (ms:any) => {
    return new Promise(resolve => setTimeout(resolve, ms));
  };
  start() {
    //this.getById(this.id);
    this.currentQuestion=this.question[this.questionNumber++];
    this.showStart = false;
    this.showPlay = true;
  }
  guess(finalAnswer: String) {
    if (this.currentQuestion.answer.correctAnswer === finalAnswer) {
      this.correct++;
      this.showCorrect = true;
      this.showPlay=false;
    } else {
      this.showWrong = true;
      this.showPlay=false;
    }
  }

  next() {
    
    if (this.showCorrect)
      this.showCorrect = false;
    else
      this.showWrong = false;
    this.currentQuestion=this.question[this.questionNumber++];
    this.showPlay = true;
    if(this.questionNumber==this.question.length&&this.questionNumber!=0)
    {
      this.showEnd=true;
      this.showPlay=false;
    }

  }

  /*chooseDifficulty(difficulty:String){
    this.difficulty=difficulty;
    this.save(this.category,this.difficulty);
  }
*/

  async save(category:String,difficulty:String) {;
    let tQuiz=new Quiz(category,difficulty);

    let tkac= this.service.saveQuiz(tQuiz);
    let p=await lastValueFrom(tkac);
    this.id=p.id;
    this.getQuestions();
  }

  async getQuestions()
  {

    let tQuestion=this.service.getQuestionsByQuiz(this.id);
    this.question=await  lastValueFrom(tQuestion);

  }


  getData() {
    this.service.getQuiz().subscribe(
        (data) => {
          this.quiz = data
        });
  }


  quizy: Quiz;

  async getById() {
    let temp=this.service.getQuizById(this.id);
    this.quizy=await lastValueFrom(temp);

  }
  end()
  {
    this.categoryShow=true;
    this.showPlay=false;

    this.showEnd=false;
  }


  ngOnInit(): void {
    this.categoryShow=true;
  }

}
