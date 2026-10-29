package lk.shan.model;

interface Expression{
    public String interpret();
}

class NumberToTextTerminalExpression implements Expression{

    private int number;

    public NumberToTextTerminalExpression(int number) {
        this.number = number;
    }

    public String interpret(){

        switch (this.number){

            case 0:
              return "Zero";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";

            default:
                return "";

        }

    }
}

class TextToNumberTerminalExpression implements Expression{

    private String text;

    public TextToNumberTerminalExpression(String text) {
        this.text = text;
    }

    @Override
    public String interpret() {

        switch (this.text) {

            case "Zero":
                return "0";
            case "One":
                return "1";
            case "Two":
                return "2";
            case "Three":
                return "3";
            case "Four":
                return "4";
            case "Five":
                return "5";
            case "Six":
                return "6";
            case "Seven":
                return "7";
            case "Eight":
                return "8";
            case "Nine":
                return "9";

            default:
                return "";
        }
    }
}

class NonTerminalExpression implements Expression{

    Expression e1;
    Expression e2;

    public NonTerminalExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public String interpret() {
        return e1.interpret()+ " "+ e2.interpret();
    }
}


public class Test {

    public static void main(String[] args) {

        Expression e1 = new NonTerminalExpression(new TextToNumberTerminalExpression("One"),new TextToNumberTerminalExpression("Two"));
        System.out.println(e1.interpret());

        Expression e2 = new NonTerminalExpression(new NumberToTextTerminalExpression(1),new NumberToTextTerminalExpression(2));
        System.out.println(e2.interpret());
    }


}
