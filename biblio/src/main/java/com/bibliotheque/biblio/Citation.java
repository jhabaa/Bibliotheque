package com.bibliotheque.biblio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Citation {
    private Value value;

    public Citation(){}

    public Value getValue(){
        return value;
    }
    public void setValue(Value value){
        this.value = value;
    }

    @Override
    public String toString(){
        return "" + value;
    }
}
