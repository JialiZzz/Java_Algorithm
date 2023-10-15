/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 15469
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int val1 = Integer.parseInt(a);
        int val2 = Integer.parseInt(b);
        int carry=0;
        int num=0;
        int count=1;
        while(val1!=0||val2!=0||carry!=0){
            int digital1 = val1%10;
            int digital2 = val2%10;
            int sum = digital1+digital2+carry;
            if(sum==0){
                carry = 0;

            }
            if(sum==1){
                num = num+count;
                carry = 0;
            }
            if(sum==2){
                carry = 1;
            }
            if(sum==3){
                carry = 1;
                num = num+count;
            }
            count*=10;
            val1/=10;
            val2/=10;
        }
        String str3 = ""+num;
        return str3;
    }
    
    public static void main(String[] args){
        
        String a = "11111";
        String b = "101010";
        AddBinary add = new AddBinary();
        String str3 = add.addBinary(a, b);
        System.out.print(str3);
    }
    
}
