import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./pages/home/home/home.component";
import {QuestionStartComponent} from "./pages/question/question-start/question-start.component";
import {QuizStartComponent} from "./pages/quiz/quiz-start/quiz-start.component";

const routes: Routes = [
  {path:"home", component:HomeComponent},
  {path:"question-start",component:QuestionStartComponent},
  {path:"quiz-start",component:QuizStartComponent},
  {path:"",redirectTo:"home",pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
