/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Type;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 15469
 */

/*
Basic data type
*/

public class Basic_Type {
    private final int constant = 10;    //unchanged keyword "final"
    /*
    Primitive Data Type     don't have relative method
    */
    
    private void initNum(){
        byte myByte = 100;     // range from -128 to 127
        short myShort = 5000;  // -32768 to 32767
        int x = 0;             //  big range
        long myLong = 1000;    //  very big range
        float myFloat = 5.24f; //  7 decimal digitals
        double myDouble =1.22f;//  15 to 16 decimal digitals
    }
    
    private void initBoolean(){
        boolean isCorrect = false;   // true or false
    }
    
    private void init_Char(){
        char myVar = 'C';   //one character
    }
    
    /*
    Non-Primitive Type  Reference
    String & Arrays & Classes & Interface
    */
    
    private void init_Str(){
        String str = "string1"; //a sentence
    }
    
    private void init_Arrays(){
        String[] strArray;  //store string
        int[] intArray;     //store int
        Object[] objArray;  //store obj
        Class[] classArray; //store class type
    }
    
    private void init_ArrayList(){
        ArrayList<String> car = new ArrayList<String>();
        ArrayList<Basic_Type> type = new ArrayList<Basic_Type>();   //ArrayList<Type> var = new ArrayList<>();
    }
    
    private void init_List(){
        List<String> list = new ArrayList<>();  //List is abstract in Java, must be implemented by other type
    }
}
