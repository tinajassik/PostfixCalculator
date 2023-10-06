package com.example.ads_assignment1;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Operand.class, name = "operand"),
        @JsonSubTypes.Type(value = Operator.class, name = "operator")
})
public interface Token {

    String getValue();
}
