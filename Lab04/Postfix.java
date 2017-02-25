package Lab04;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * A class that represents a postfix expression.
 *
 * @author Maciek Bieszczad
 * @version 01/02/2017
 */
public class Postfix
{
    /**
     * Creates a postfix expression that represents a given infix expression.
     * Segment 5.16
     *
     * @param infix a string that is a valid infix expression
     * @return a string that is the postfix expression equivalent to infix
     */
    public void convertToPostfix(String infix)
    {
        // TODO PROJECT #5
        infix = infix.replaceAll("\\s","");
        System.out.println("Infix:   " + infix);
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        int characterCount = infix.length();
        char topOperator;

        for (int i = 0; i < characterCount; i++) {
            char next = infix.charAt(i);
            switch (next) {
                case '^':
                    operatorStack.push(next);
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!operatorStack.isEmpty() && getPrecedence(next) <= getPrecedence(operatorStack.peek())) {
                        postfix.append(operatorStack.peek());
                        operatorStack.pop();
                    }
                    operatorStack.push(next);
                    break;
                case '(':
                    operatorStack.push(next);
                    break;
                case ')':
                    try {
                        topOperator = operatorStack.pop();
                        while (topOperator != '(') {
                            postfix.append(topOperator);
                            topOperator = operatorStack.pop();
                        }
                    } catch (EmptyStackException ese) {
                        System.out.println("empty stack");
                    }
                    break;
                default:
                    if (Character.isLetter(next)) {
                        postfix.append(next);
                    }
                    break;
            }
        }

        while (!operatorStack.isEmpty()) {
            topOperator = operatorStack.pop();
            postfix.append(topOperator);
        }

        System.out.println("Postfix: " + postfix.toString());
        System.out.println("\n");
    } // end convertToPostfix

    /**
     * Indicates the precedence of a given operator.
     *
     * @param operator a character that is (, ), +, -, *, /, or ^
     * @return an integer that indicates the precedence of operator:
     *         0 if ( or ), 1 if + or -, 2 if * or /, 3 if ^, -1 if
     *         anything else
     */
    private int getPrecedence(char operator)
    {
        switch (operator)
        {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        } // end switch

        return -1;
    } // end getPrecedence

    /**
     * Evaluates a postfix expression.
     * Segment 5.18
     *
     * @param postfix a string that is a valid postfix expression
     * @return the value of the postfix expression
     */
    public double evaluatePostfix(String postfix)
    {
        // TODO PROJECT #5
        Stack<Double> valueStack = new Stack<>();
        int characterCount = postfix.length();

        for (int i = 0; i < characterCount; i++) {
            char next = postfix.charAt(i);
            if (Character.isLetter(next)) {
                valueStack.push(valueOf(next));
            } else {
                switch (next) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                    case '^':
                        double operandOne = valueStack.pop();
                        double operandTwo = valueStack.pop();
                        double result = compute(operandTwo, operandOne, next);
                        valueStack.push(result);
                        break;
                    default:
                        break;
                }
            }
        }

        return valueStack.peek();
    } // end evaluatePostfix

    private double valueOf(char variable)
    {
        switch (variable)
        {
            case 'a':
                return 2.0;
            case 'b':
                return 3.0;
            case 'c':
                return 4.0;
            case 'd':
                return 5.0;
            case 'e':
                return 6.0;
        } // end switch

        return 0;
    } // end valueOf

    private double compute(double operandOne, double operandTwo, char operator)
    {
        double result = 0;

        switch (operator)
        {
            case '+':
                result = operandOne + operandTwo;
                break;

            case '-':
                result = operandOne - operandTwo;
                break;

            case '*':
                result = operandOne * operandTwo;
                break;

            case '/':
                if (operandTwo != 0)
                    result = operandOne / operandTwo;
                break;

            case '^':
                result = Math.pow(operandOne, operandTwo);
                break;
        } // end switch

        return result;
    } // end compute

    public static void main(String[] args)
    {
        Postfix tester = new Postfix();
        System.out.println("Converting infix expressions to postfix expressions:\n");
        tester.convertToPostfix("a+b");
        tester.convertToPostfix("(a + b) * c");
        tester.convertToPostfix("a * b / (c - d)");
        tester.convertToPostfix("a / b + (c - d)");
        tester.convertToPostfix("a / b + c - d");
        tester.convertToPostfix("a^b^c");
        tester.convertToPostfix("(a^b)^c");
        tester.convertToPostfix("a*(b/c+d)");
        tester.convertToPostfix("(a+b)/(c-d)");
        tester.convertToPostfix("a/(b-c)*d");
        tester.convertToPostfix("a-(b/(c-d)*e+f)^g");
        tester.convertToPostfix("(a-b*c)/(d*e^f*g+h)");

        System.out.println("Evaluating postfix expressions with\n" +
                "a = 2, b = 3, c = 4, d = 5, e = 6");
        System.out.println("Assuming correct input!!!\n\n");
        System.out.println("ae+bd-/ : " + tester.evaluatePostfix("ae+bd-/") + "\n");
        System.out.println("abc*d*- : " + tester.evaluatePostfix("abc*d*-") + "\n");
        System.out.println("abc-/d* : " + tester.evaluatePostfix("abc-/d*") + "\n");
        System.out.println("ebca^*+d- : " + tester.evaluatePostfix("ebca^*+d-") + "\n");
        System.out.println("Done.");
    }  // end main
} // end Postfix
                 