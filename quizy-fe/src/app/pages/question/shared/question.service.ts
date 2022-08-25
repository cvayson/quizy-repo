import { Injectable } from '@angular/core';
import {Question} from "./question.model";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {QuestionApi} from "./question-api";
@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  constructor(private http:HttpClient) { }
  getAll():Observable<Question[]>
    {
      return this.http.get<Question[]>(QuestionApi.GET_ALL,);
    }

}
