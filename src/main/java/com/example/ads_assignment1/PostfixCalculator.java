package com.example.ads_assignment1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostfixCalculator {

    private Stack tokens = new Stack<>();

    public int getResult(ArrayList<Token> tokenList) {

        for (Token token: tokenList) {

            // if token is a number, we push to the stack
            if (token instanceof Operand) {
                tokens.push(new Operand(Integer.parseInt(token.getValue())));
            }
            else {
                // if token is an operator, we pop 2 values, perform corresponding operation and then push the result to the stack
                Operator current = new Operator(token.getValue());

                Operand a = (Operand) tokens.pop();
                Operand b = (Operand) tokens.pop();

                int A = Integer.parseInt(a.getValue());
                int B = Integer.parseInt(b.getValue());
                Operand result = null;

                switch (current.getValue()) {
                    case "+":
                        result = new Operand(A+B);
                        break;
                    case "-":
                        result = new Operand(B-A);
                        break;
                    case "*":
                        result = new Operand(A*B);
                        break;
                    case "/":
                        result = new Operand(B/A);
                        break;
                }

                tokens.push(result);
            }

        }

        return Integer.parseInt(((Operand)tokens.pop()).getValue());
    }

}
