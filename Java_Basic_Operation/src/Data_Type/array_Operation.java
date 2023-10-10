/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Type;

import java.util.ArrayList;

/**
 *
 * @author 15469
 */
public class array_Operation {
    private String[] strArray;
    private ArrayList<String> strArrayList;
    
    /*initialize reference using new keyword*/
    public array_Operation(){
        this.strArray=new String[5];
        this.strArrayList = new ArrayList<>();
    }
    
    private void array_Basic_Operation(){
        for(String str : strArray){
            str.indexOf("0");               //find index
        }
        strArrayList.add("dadad");            //add
        strArrayList.remove("dadad");         //delete
        strArrayList.contains("sdada");       //find if exist

    }
}
