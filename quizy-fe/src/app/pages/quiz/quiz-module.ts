import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import { QuestionStartComponent } from './question-start/question-start.component';
import {MatButton, MatButtonModule} from "@angular/material/button";
import {MatCard, MatCardModule} from "@angular/material/card";



@NgModule({
  declarations: [
    QuestionStartComponent
  ],
  imports: [
    CommonModule,
    MatButtonModule,
    MatCardModule

  ],

})
export class QuestionModule { }
