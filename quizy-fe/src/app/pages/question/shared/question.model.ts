
export class Question
{
  id:String;
  category:String;
  correctAnswer:String;
  incorrectAnswers:String[];
  question:String;
  type:String;
  difficulty:String;

  getIncorect()
  {
    return this.incorrectAnswers;
  }
}
