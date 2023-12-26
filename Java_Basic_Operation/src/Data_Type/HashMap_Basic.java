/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Type;

import java.util.*;

/**
 *
 * @author 15469
 * FIFO
 */
public class HashMap_Basic {
    private Map<String,Integer> dict;
    
    public HashMap_Basic(){
        this.dict =  new HashMap<>();
    }
    
    public void Add(){
        dict.put("Key", 12);  //add key
    }
    
    public void Delete(){
        dict.remove("Key");     //delete key
    }
    
    public void Contain(){
        dict.containsKey("Key");    //if exist key
        dict.containsValue(12);    //if exist value
        for(String s : dict.keySet()){

        }
        HashSet<Integer>hm=new HashSet<>();
        
        Object[][] array1 = new Object[8][8];
        Arrays.fill(array1,-1);
    }
    public void isEmpty(){             //return true if empty
        dict.isEmpty();
    }
    
    public void get(){
        dict.get("Key");            //return obj
    }

}
