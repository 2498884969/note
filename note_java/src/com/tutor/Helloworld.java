package com.tutor;

public class Helloworld {
    private String message;
    public Helloworld(){
        System.out.println("Helloworld's constructor...");
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void getMessage(){
        System.out.println("your message:"+this.message);
    }
}
