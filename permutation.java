import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class permutation {
    class Solution {
        List<List<Integer>> substring = new ArrayList<>();
        HashMap<Integer,Character>hm = new HashMap<>();

        public int countSubstrings(String s) {
            //get all subStrings
            //judge if it is palindromic
            if(s.length()==1) return 1;

            for(int i=0;i<s.length();i++){
                hm.put(i,s.charAt(i));
            }
            List<Integer> list1 = new ArrayList<>();

            backTrack(list1,s.length());
            int count=0;
            for(List<Integer> sub : substring){
                if(judge(sub)) count++;
            }
            return count;
        }

        public void backTrack(List<Integer>list1,int len){
            if(list1.size()==len) return;
            for(int i=0;i<len;i++){
                if(list1.contains(i)) continue;
                list1.add(i);
                substring.add(new ArrayList<>(list1));
                backTrack(list1,len);
                list1.remove(list1.size()-1);
            }
        }

        public boolean judge(List<Integer>sub){
            if(sub.size()==1) return true;
            int left=0;
            int right=sub.size()-1;
            while(left<right){
                if(hm.get(sub.get(left))!=hm.get(sub.get(right))) return false;
                left++;
                right--;
            }
            return true;
        }


    }


}
