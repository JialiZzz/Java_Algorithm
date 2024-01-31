import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Result {

    /*
     * Complete the 'stockPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY stocksProfit
     *  2. LONG_INTEGER target
     */

    public static int stockPairs(List<Integer> stocksProfit, long target) {
        // Write your code here
        //HashMap<>   profit and count
        int num = (int) target;
        HashMap<Integer,Integer> hm = new HashMap<>();
        HashMap<Integer,Boolean>hm1 = new HashMap<>();
        for(Integer profit: stocksProfit){
            if(hm.containsKey(profit)){
                int count = hm.get(profit);
                hm.put(profit, count+1);
            }
            else{
                hm.put(profit, 1);
            }
            hm1.put(profit, false);
        }
        int res=0;
        for(Integer val : hm.keySet()){
            System.out.println("val "+val);
            System.out.println("visited "+hm1.get(val));
            System.out.println();
            int i=val;
            if(hm1.get(i)) continue;
            if(hm.containsKey(num-i)){
                if(i==(int)num-i){
                    if(hm.get(i)>1){
                        System.out.println("val is"+i+" "+(num-i));
                        res++;
                    }

                }
                else{
                    res++;
                    System.out.println("val is "+i+" "+(num-i));
                }
            }
            hm1.put(i, true);
            hm1.put((int)target-i, true);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        List<Integer> stocksProfit = new ArrayList<>();
        stocksProfit.add(6);
        stocksProfit.add(1);
        stocksProfit.add(1);
        stocksProfit.add(3);
        stocksProfit.add(3);
        stocksProfit.add(9);
        stocksProfit.add(46);
        stockPairs(stocksProfit,47);
    }


}