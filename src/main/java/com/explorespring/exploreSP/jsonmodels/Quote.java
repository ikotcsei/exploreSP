package com.explorespring.exploreSP.jsonmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.h2.value.Value;

//Json consumer
//https://spring.io/guides/gs/consuming-rest/
//Jackson JSON processing library to indicate that any properties not bound in this type should be ignored.
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private String type;
    private Value value;

    public Quote() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
