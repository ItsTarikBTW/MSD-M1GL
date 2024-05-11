package com.api.Model;
import java.io.Serializable;
public class Address implements Serializable {
    private String name;
    private int numRue;
    private String ville;
    public Address(){
        this.name="";
        this.numRue=0;
        this.ville="";
    }
    public Address(String name,int numRue,String ville){
        this.name=name;
        this.numRue=numRue;
        this.ville=ville;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getNumRue(){
        return this.numRue;
    }
    public void setNumRue(int numRue){
        this.numRue=numRue;
    }
    public String getVille(){
        return this.ville;
    }
    public void setVille(String ville){
        this.ville=ville;
    }

    public String toString(){
        return "{ "+this.name + " ** " + this.numRue + " ** " + this.ville+" }";
    }

    public void print(){
        System.out.println(this);
    }
}
