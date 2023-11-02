
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 15469
 */
public class letterCombinations {
        public List<String> letterCombinations(String digits) {
        
        int len = digits.length();
        List<String> list = new ArrayList<>();
        List<List<Character>> list1 = new ArrayList<>();
        list1.add(Arrays.asList('a','b','c'));  //2
        list1.add(Arrays.asList('d','e','f'));
        list1.add(Arrays.asList('g','h','i'));
        list1.add(Arrays.asList('j','k','l'));
        list1.add(Arrays.asList('m','n','o'));
        list1.add(Arrays.asList('p','q','r','s'));
        list1.add(Arrays.asList('t','u','v'));
        list1.add(Arrays.asList('w','x','y','z'));  //9
        
        
        for(int i=0;i<len;i++){
            int k = digits.charAt(i)-'0';
            
        }
        
        
    }
        
        
    public static void main(String[] args){
        
    }
}
