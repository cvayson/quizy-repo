import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuizStartComponent } from './quiz-start/quiz-start.component';
import {HttpClientModule} from "@angular/common/http";
import {QuestionModule} from "../question/question.module";



@NgModule({
  declarations: [
    QuizStartComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    QuestionModule
  ]
})
export class QuizModule { }
