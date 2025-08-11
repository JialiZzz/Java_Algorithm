package Leetcode_Solution.binarySearch;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int num = piles.length;
        if(num>h)
            return -1;
        int total=0;
        int mostItem=0;
        int minSpeed;
        int maxSpeed;
        for(int i : piles){
            total+=i;
            mostItem=Math.max(mostItem,i);
        }
        maxSpeed = mostItem;
        minSpeed = total/h;
        int speed;
        while(minSpeed<=maxSpeed){
            speed=(maxSpeed+minSpeed)/2;
            if(!isFinished(speed,piles,h))
                minSpeed=speed+1;
            else
                maxSpeed=speed-1;
        }
        return minSpeed;
    }

    public boolean isFinished(int speed, int[] piles, int h){
        int totalHour=0;
        for(int i : piles){
            totalHour+=(int)Math.ceil(i/speed);
        }
        if(totalHour>h)
            return false;
        return true;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] piles = new int[]{3,6,7,11};
        int h = 8;
        s.minEatingSpeed(piles,h);
    }

}