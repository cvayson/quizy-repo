import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HomeModule} from "./pages/home/home.module";
import {MatButtonModule} from "@angular/material/button";
import {HttpClientModule} from "@angular/common/http";
import {QuestionModule} from "./pages/question/question.module";
import {QuizModule} from "./pages/quiz/quiz.module"
import {NgForOf} from "@angular/common";

@NgModule({
  declarations: [
    AppComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HomeModule,
    MatButtonModule,
    HttpClientModule,
    QuestionModule,
    QuizModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
