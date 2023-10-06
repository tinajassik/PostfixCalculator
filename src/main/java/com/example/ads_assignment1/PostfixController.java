package com.example.ads_assignment1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PostfixController {

    @Autowired
    private PostfixCalculator calculator;

    @PostMapping ("/evaluate")
    public int evaluateExpression(@RequestBody ArrayList<Token> tokenArrayList) {
        return calculator.getResult(tokenArrayList);
    }



}
