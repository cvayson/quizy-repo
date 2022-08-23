import { Component, OnInit } from '@angular/core';
import {Question} from "../shared/question.model";
import {QuestionService} from "../shared/question.service";
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
  selector: 'app-question-start',
  templateUrl: './question-start.component.html',
  styleUrls: ['./question-start.component.css']
})
export class QuestionStartComponent implements OnInit {
  questions:Question[];
  categories=["Arts & Literature","Film & TV","Food & Drink","General Knowledge",
    "Geography","History","Music","Science","Society & Culture","Sport & Leisure"];
  constructor(public service:QuestionService) { }

  ngOnInit(): void {

  }

}
