package com.example.ads_assignment1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("operator")
public class Operator implements Token {

    private String value;


    public void setValue(String value) {
        this.value = value;
    }

    @JsonCreator
    public Operator(@JsonProperty("value") String symbol) {
        this.value = symbol;
    }

    @Override
    public String getValue() {
        return value;
    }
}
