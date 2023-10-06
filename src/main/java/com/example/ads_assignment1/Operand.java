package com.example.ads_assignment1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("operand")
public class Operand implements Token{

    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    @JsonCreator
    public Operand(@JsonProperty("value") int value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return Integer.toString(value);
    }
}
