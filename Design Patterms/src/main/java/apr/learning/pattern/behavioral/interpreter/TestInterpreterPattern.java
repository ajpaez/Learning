package apr.learning.pattern.behavioral.interpreter;

import java.util.Stack;

public class TestInterpreterPattern {

	public static void main(String[] args) {

		String tokenString = "7 3 - 2 1 + *";
		Stack<Expression> stack = new Stack<Expression>();
		String[] tokenArray = tokenString.split(" ");
		for (String s : tokenArray) {
			if (ExpressionUtils.isOperator(s)) {
				Expression rightExpression = stack.pop();
				Expression leftExpression = stack.pop();
				Expression operator = ExpressionUtils.getOperator(s.charAt(0), leftExpression,rightExpression);
				int result = operator.interpret();
				stack.push(new Number(result));
			} else {
				Expression i = new Number(Integer.parseInt(s));
				stack.push(i);
			}
		}
		System.out.println("( "+tokenString+" ): "+stack.pop().interpret());

	}


}
