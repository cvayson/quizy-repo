import { Component, OnInit } from '@angular/core';
import {Question} from "../shared/quiz.model";
import {QuizService} from "../shared/quiz.service";
enum Category
{
  art="Arts & Literature",
  film="Film & TV",
  food="Food & Drink",
  general="General Knowledge",
  geography="Geography",
  history="History",
  music="Music",
  science="Science",
  culture="Society & Culture",
  sport="Sport & Leisure"
}

@Component({
  selector: 'app-quiz-start',
  templateUrl: './question-start.component.html',
  styleUrls: ['./question-start.component.css']
})
export class QuestionStartComponent implements OnInit {
  questions:Question[];
  categories=["Arts & Literature","Film & TV","Food & Drink","General Knowledge",
    "Geography","History","Music","Science","Society & Culture","Sport & Leisure"];
  difficulties=["easy","medium","hard"];
  cCategory:String;
  dDifficulty:String;
  categoryShow=true;
  difficultyShow=false;
  showStart=false;
  showPlay=false;
  currentQuestion:Question;
  answer:String;
  correct=0;
  showCorrect=false;
  showWrong=false;
  showEnd=false;
  questionNumber=0;
  message:String;

  constructor(public service:QuizService) { }

  chooseCategory(category:String)
  {
    this.cCategory=category;
    this.categoryShow=false;
    this.difficultyShow=true;
  }
  chooseDifficulty(difficulty:String)
  {
    this.dDifficulty=difficulty;
    this.difficultyShow=false;
    this.showStart=true;


  }
  next()
  {
    if(this.showCorrect)
      this.showCorrect=false;
    else if(this.showWrong)
      this.showWrong=false;
    this.showPlay=true;
    this.play();
  }
  start()
  {
    if(this.showEnd)
      this.showEnd=false;
    this.showStart=false;
    this.showPlay=true;
    this.play();
  }

  loadQuestions()
  {
    this.service.getAll().subscribe(data=>
    {
      this.questions=data;
    });

  }
  play(){
    if(this.questionNumber%5==0&&this.questionNumber>0) {

      this.questionNumber=0;
      this.end();

    }
    else {
      this.currentQuestion = this.questions[this.questionNumber++];
      if (this.answer === this.currentQuestion.correctAnswer)
        this.correct++;
    }

  }
  end()
  {
    if(this.correct<2)
      this.message="You can surely do better!"
    else if(this.correct<4)
      this.message="Not bad.You almost got all the questions right!"
    else
      this.message="Excellent!!!! You got all the questions right."
    this.showPlay=false;
    this.showEnd=true;
    this.loadQuestions();
  }
  guess(finalAnswer:String) {
    this.answer = finalAnswer;
    if (this.answer != null)
    {
      if (this.currentQuestion.correctAnswer === this.answer) {
        this.showCorrect = true;
      }
      else
        this.showWrong = true;
      this.showPlay=false;
    }
  }
  ngOnInit(): void {
    this.loadQuestions();
  }

}
