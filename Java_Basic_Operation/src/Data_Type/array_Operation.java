/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Type;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 15469
 */
public class array_Operation {
    private String[] strArray;
    private ArrayList<String> strArrayList;
    
    /*initialize reference using new keyword*/
    public array_Operation(){
        // 0-4 range
        this.strArray=new String[5];
        this.strArrayList = new ArrayList<>();
        Arrays.sort(strArray, 0, 0);

    }

    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isUnique(String str){
        boolean[] list = new boolean[256];
        for(int i=0;i<str.length();i++){
            int val=str.charAt(i);
            if(list[val]==false) list[val]=true;
            else return false;
        }

        return true;
    }




    private void array_Basic_Operation(){
        for(String str : strArray){
            str.indexOf("0");               //find index
        }
        StringBuilder str = new StringBuilder();
        strArrayList.add("dadad");            //add
        strArrayList.remove("dadad");         //delete
        strArrayList.contains("sdada");       //find if exist

    }

    public static String removeDuplicated(String str){
        StringBuilder sb = new StringBuilder(str);
        boolean[] table = new boolean[256];
        for(int i=0;i<sb.length();i++){
            int val = sb.charAt(i);
            if(!table[val]) table[val]=true;
            else sb.deleteCharAt(i);
        }
        return sb.toString();
    }


    public static void main(String[] args){
        String str = "abcc";
        str=reverse(str);
        System.out.println(str);
        System.out.println(isUnique(str));
        System.out.println(removeDuplicated(str));
    }

}
