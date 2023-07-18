package com.example.medicalsupplieswebsite.error;

public class NotFoundById extends Exception{
    public NotFoundById(String error){
        super(error);
    }
}
