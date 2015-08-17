package com.lam.coursera.princeton.algorithms.applications;

import com.lam.coursera.princeton.algorithms.stack.LinkedStack;
import com.lam.coursera.princeton.algorithms.stack.Stack_I;

public class InFixExpressions {
	// Two-stack algorithm. [E. W. Dijkstra]

	private Stack_I<Double> operands;
	private Stack_I<Character> operators;

	// ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
	// 101.0
	// Bottom line. Postfix or "reverse Polish" notation.
	public InFixExpressions() {
		this.operands = new LinkedStack<Double>();
		this.operators = new LinkedStack<Character>();
	}

	public Double process(String expression) {
		// XXX how to deal with unary operators ?
		expression = expression.replaceAll(" ", "");

		Character c;
		String n = "";

		for (int i = 0; i < expression.length(); i++) {
			c = expression.charAt(i);
			if (Character.isDigit(c) || c == '.' ) {
				n = n + c;
			} else {
				if (n.length() > 0) {
					this.operands.push(new Double(n));
					n = "";
				}
				if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
					this.operators.push(c);
				} else if (c == '(') {
					// ignore left parenthesis.
				} else if (c == ')') {
					// Pop one operator and two values.
					// Push the result from that operation onto the operand
					// stack.
					this.operands.push(this.operation(this.operands.pop(),
							this.operands.pop(), this.operators.pop()));
				} else if (c == ' ') {
				}
			}
		}

		if (n.length() > 0) {
			this.operands.push(new Double(n));
			n = "";
		}
		
		while (this.operators.iterator().hasNext()) {
			this.operands.push(this.operation(this.operands.pop(), this.operands.pop(),
					this.operators.pop()));
		}

		return this.operands.pop();
	}

	private Double operation(Double op1, Double op2, char operator) {
		Double data = new Double(0);

		switch (operator) {
		case '+':
			data = op1 + op2;
			break;
		case '-':
			data = op1 - op2;
			break;
		case '*':
			data = op1 * op2;
			break;
		case '/':
			data = op1 / op2;
			break;
		case '^':
			data = Math.pow(op1, op2);
			break;
		default:
			break;
		}

		return data;
	}

	public static void main(String[] args) {
		System.out.println(Math.pow(3, 4));
		System.out.println(Character.getNumericValue('1'));
	}

}
