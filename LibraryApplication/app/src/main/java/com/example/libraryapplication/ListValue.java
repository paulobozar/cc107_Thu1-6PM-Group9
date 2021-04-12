package com.example.libraryapplication;


public class ListValue {
    private String codename;
//    private String dl;

    public ListValue(String codename){  //String dl
        this.codename = codename;
//        this.dl = dl;

    }
    public String getCodename(){
        return codename;
    }
    public void setCodename(String codename){
        this.codename = codename;

    }
//    public String getDl(){
//        return dl;
//    }
//    public void setDl(String dl){
//        this.dl = dl;


    public String GetFileName(){

        return codename;
    }
}
