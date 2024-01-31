/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Type;

/**
 *
 * @author 15469
 */
public class Str_Operation {
    private String str;      //declare

    /*Java declare var in anyway, initial a var in method */
    
    public Str_Operation() {    
        this.str = "abab";  //initialize
    }
    
    public void Str_Basic_Operation(){
        int len = str.length();
        StringBuilder k = new StringBuilder();

        String upperStr = str.toUpperCase();
        String lowerStr = str.toLowerCase();
        String replaceStr = str.replace("Target", "Replacement");
        str = str+10;   //String str10
        String txt = "   New Line \n   Carriage Return \r   Tab\t*** Backspace\b ";
        if(txt.equals(txt)){}
        String s = "asdd";

    }
    
    
    
}
