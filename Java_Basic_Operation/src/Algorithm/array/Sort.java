/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithm.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author 15469
 */
public class Sort {
    
    public static String[] sort(){
        String[] s1 = {"flower","flow","flight"};
        String[] s2 = {"dog","racecar","car"};
        Arrays.sort(s1);
        Arrays.sort(s2);
        for(String s : s1){
            System.out.print(s);
        }
        System.out.println();
        for(String s : s2){
            System.out.print(s);
        }
        return s1;
    }
    
    
    public static void main(String[] args) {
        sort();
    }
}
