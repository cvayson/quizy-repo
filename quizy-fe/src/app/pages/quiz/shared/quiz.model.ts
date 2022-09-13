export class Question {
  id: String;
  category: String;
  answer:Answer;
  question: String;
  type: String;
  difficulty: String;
}
  export class Quiz
{
  id:Number;
  category:String;
  difficulty:String;
  question:Question[];

  constructor(category:String,difficulty:String) {
    this.category=category;
    this.difficulty=difficulty;
  }
  public getId()
  {
    return this.id;
  }
  public getCategory()
  {
    return this.category;
  }
  public getDifficulty(){
    return this.difficulty;
  }


}
export class QuizRequest
{
  category:String;
  difficulty:String;

  constructor(category:String,difficulty:String) {
    this.category=category;
    this.difficulty=difficulty;
  }


}
export class Answer
{
  answerId:Number;
  questionId:String;
  firstAnswer:String;
  secondAnswer:String;
  thirdAnswer:String;
  correctAnswer:String;
}
