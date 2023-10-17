
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 15469
 */
public class romanToInt {
    public int romanToInt(String s) {
        HashMap <Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        int num=0;
        int num1=0;
        int num2=0;
        int i=0;
        while((2*i+1)<s.length()){
            num1=hm.get(s.charAt(2*i+1));
            num2=hm.get(s.charAt(2*i));
            if(num2<num1){
                num+=num1-num2;
            }else{
            num+=num1+num2;
            }
            i++;
        }
        if(s.length()%2!=0){
            num+=hm.get(s.charAt(s.length()-1));
        }
        return num;
    }
    
    public static void main(String[] args){
        romanToInt cw = new romanToInt();
        System.out.print(cw.romanToInt("IV"));

    }
}
