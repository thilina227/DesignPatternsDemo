package designpatternsdemo.interpreter;

import java.util.ArrayList;
import java.util.List;


public class Client {
    public static void main(String[] args) {
        String text = "Hey, hru?, sup?";
        System.out.println(interpret(text));
    }
    
    public static String interpret(String context) {
        List<Expression> expressions = new ArrayList<>();
        expressions.add(new SupExpression());
        expressions.add(new HruExpression());

        for (Expression expression : expressions) {
            context = expression.interpret(context);
        }

        return context;
    }
}

abstract class Expression {
    public abstract String interpret(String context);
}

class SupExpression extends Expression {
	 
   private static final String SHORT_CODE = "sup";
   private static final String PHRASE = "what's up";
   

   @Override
   public String interpret(String context) {	
      return context.replace(SHORT_CODE, PHRASE);
   }
}

class HruExpression extends Expression {
    private static final String SHORT_CODE = "hru";
    private static final String PHRASE = "how are you";


    @Override
    public String interpret(String context) {	
      return context.replace(SHORT_CODE, PHRASE);
    }

}

