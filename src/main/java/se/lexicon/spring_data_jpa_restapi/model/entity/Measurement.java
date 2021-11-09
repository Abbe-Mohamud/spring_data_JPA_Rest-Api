package se.lexicon.spring_data_jpa_restapi.model.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Measurement {

//    TSP(5),
//    G(1),
//    HG(100),
//    KG(1000),
//    ML(1000),
//    CL(100),
//    DL(10);


    TSP("tsp"),
    G("g"),
    HG("hg"),
    KG("kg"),
    ML("ml"),
    CL("cl"),
    DL("dl");

//    TSP,
//    G,
//    KG,
//    ML,
//    CL,
//    DL




//    private final int value;
//
//    Measurement(int value) {
//        this.value = value;
//    }
//
//    public int getValue() {
//        return value;
//    }

    private final String value;

    Measurement(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }









}
