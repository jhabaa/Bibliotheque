package com.bibliotheque.biblio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
    private String quote;

    public Value(){
    }

    public String getCitation(){
        return this.quote;
    }
    public void setQuote(String quote){
        this.quote = quote;
    }

    @Override
    public String toString(){
        return "" + quote ;
    }
}
