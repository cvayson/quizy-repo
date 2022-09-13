import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {QuizApi} from "./quiz.api";
import {Observable} from "rxjs";
import {Question, Quiz, QuizRequest} from "./quiz.model";
@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private http:HttpClient) { }

  saveQuiz(request:Quiz):Observable<Quiz>
  {
    return this.http.post<Quiz>(QuizApi.SAVE,request);
  }
  getQuizById(id:Number):Observable<Quiz>
  {
    return this.http.get<Quiz>(QuizApi.GET_BY_ID.replace("#",id.toString()));
  }
  getQuiz():Observable<Quiz[]>
  {
    return this.http.get<Quiz[]>(QuizApi.GET);
  }
  getQuestionsByQuiz(id:Number):Observable<Question[]>
  {
    return this.http.get<Question[]>(QuizApi.GET_ALL_QUESTIONS.replace("#",id.toString()));
  }

}
