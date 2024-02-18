import org.w3c.dom.Node;

import java.util.*;

public class TestProgram {

    private static int seqStart;
    private static int seqEnd;

    public static int maxSubsequenceSum(int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;

            for (int j = i; j < a.length; j++) {
                thisSum += a[j];

                if (thisSum > maxSum) {
                    maxSum = thisSum;
                    seqStart = i;
                    seqEnd = j;
                }
            }
        }

        return maxSum;
    }


    public static int getSeqStart() {
        return seqStart;
    }


    public static int getSeqEnd() {
        return seqEnd;
    }

    private static int count(int num){
        if(num==1) return 1;
        if(num==2) return 1;
        //judge even or odd
        if(num%2==0){
            return count(num/2);
        }
        else{
            return count(num/2)+1;
        }
    }

    public static int maxSubarraySum(int[] arr) {
        return maxSubarrayRecursive(arr, 0, arr.length - 1);
    }

    private static int maxSubarrayRecursive(int[] arr, int low, int high) {
        if (low == high) {
            return arr[low];
        }
        int mid = (low + high) / 2;
        int leftMax = maxSubarrayRecursive(arr, low, mid - 1);
        int rightMax = maxSubarrayRecursive(arr, mid + 1, high);
        int crossingMax = maxCrossingSubarray(arr, low, mid, high);
        return Math.max(Math.max(leftMax, rightMax), crossingMax);
    }

    private static int maxCrossingSubarray(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;

        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

    private static boolean findGroup(int[] arr, int k){
        ArrayList<Integer> list = new ArrayList<>();
        return backTrack(arr,k,list);
    }

    private static boolean backTrack(int[] arr, int k, ArrayList<Integer> list){
        //sort
        if(k==0) return true;
        for(int i=0;i<arr.length;i++){
            if(list.contains(i)) continue;
            list.add(i);
            boolean s=backTrack(arr, k-arr[i],list);
            if(s) return true;
            list.remove(list.size()-1);
        }
        return false;
    }

    public static boolean hasSubsetSum(int[] arr, int K) {
        int N = arr.length;
        boolean[][] dp = new boolean[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= arr[i-1]) {
                    dp[i][j] = dp[i][j] || dp[i-1][j - arr[i-1]];
                }
            }
        }

        return dp[N][K];
    }

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void permute( String str ){

        char[] arr = new char[str.length()];
        for(int i=0;i<str.length();i++){
            arr[i]=str.charAt(i);
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        backTrack1(arr, list1 );
        for(ArrayList<Integer> arrList : list){
            for (Integer c : arrList){
                System.out.print(arr[c]);
            }
            System.out.println();
        }
    }
    private static void backTrack1(char[] arr,  ArrayList<Integer> list1){
        if(list1.size()==arr.length){
            list.add(new ArrayList<>(list1));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(list1.contains(i)) continue;
            list1.add(i);
            backTrack1(arr,list1);
            list1.remove(list1.size()-1);
        }
    }


    public static void printReverse(Scanner scanner) {
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            printReverse(scanner);
            System.out.println(line);
        } else {
            scanner.close();
        }
    }

    public static double[] findMaxAndMin(double[] arr) {
        if (arr.length == 1) {
            return new double[]{arr[0], arr[0]};
        }

        return findMaxAndMinHelper(arr, 0, arr.length - 1);
    }

    private static double[] findMaxAndMinHelper(double[] arr, int start, int end) {
        if (start == end) {
            return new double[]{arr[start], arr[start]};
        }

        int mid = (start + end) / 2;

        double[] leftResult = findMaxAndMinHelper(arr, start, mid);
        double[] rightResult = findMaxAndMinHelper(arr, mid + 1, end);

        double max = Math.max(leftResult[0], rightResult[0]);
        double min = Math.min(leftResult[1], rightResult[1]);

        return new double[]{max, min};
    }


    public static Set<String> getAllWords(String word) {
        Set<String> substrings = new HashSet<>();
        getAllWordsHelper(word, 0, new StringBuilder(), substrings);
        return substrings;
    }

    private static void getAllWordsHelper(String word, int index, StringBuilder current, Set<String> substrings) {
        if (index == word.length()) {
            substrings.add(current.toString());
            return;
        }
        getAllWordsHelper(word, index + 1, current, substrings);
        current.append(word.charAt(index));
        getAllWordsHelper(word, index + 1, current, substrings);
        current.deleteCharAt(current.length() - 1);
    }


    // a. 计算给定组的大小
    public static int getGroupSize(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        int groupSize = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            if (currentRow >= 0 && currentRow < grid.length && currentCol >= 0 && currentCol < grid[0].length
                    && grid[currentRow][currentCol] == 1 && !visited[currentRow][currentCol]) {
                visited[currentRow][currentCol] = true;
                groupSize++;

                // 添加相邻的未访问的方块
                queue.offer(new int[]{currentRow - 1, currentCol});
                queue.offer(new int[]{currentRow + 1, currentCol});
                queue.offer(new int[]{currentRow, currentCol - 1});
                queue.offer(new int[]{currentRow, currentCol + 1});
            }
        }

        return groupSize;
    }

    // b.
    public static int getNumberOfGroups(int[][] grid) {
        int numberOfGroups = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    numberOfGroups++;
                    getGroupSize(grid, i, j);
                }
            }
        }

        return numberOfGroups;
    }

    // c. 列出所有组
    public static void listAllGroups(int[][] grid) {
        ArrayList<ArrayList<int[]>> allGroups = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ArrayList<int[]> currentGroup = new ArrayList<>();
                    getAllGroupsHelper(grid, i, j, visited, currentGroup);
                    allGroups.add(currentGroup);
                }
            }
        }

        for (int i = 0; i < allGroups.size(); i++) {
            System.out.println("Group " + (i + 1) + ": " + allGroups.get(i));
        }
    }

    private static void getAllGroupsHelper(int[][] grid, int row, int col, boolean[][] visited, ArrayList<int[]> currentGroup) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        currentGroup.add(new int[]{row, col});

        getAllGroupsHelper(grid, row - 1, col, visited, currentGroup);
        getAllGroupsHelper(grid, row + 1, col, visited, currentGroup);
        getAllGroupsHelper(grid, row, col - 1, visited, currentGroup);
        getAllGroupsHelper(grid, row, col + 1, visited, currentGroup);
    }

    public static String reverse(String str) {
        if (str.isEmpty()) {
            return "";
        } else {
            // 取字符串的第一个字符，然后递归地反转剩余部分，并将两者连接起来
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }

    public static String reverse1(String str) {
        StringBuffer buffer = new StringBuffer();
        reverseHelper(str, buffer);
        return buffer.toString();
    }

    private static void reverseHelper(String str, StringBuffer buffer) {
        if (str.isEmpty()) {
            return;
        } else {
            // 将字符串的最后一个字符添加到StringBuffer中，然后递归地反转剩余部分
            buffer.append(str.charAt(str.length() - 1));
            reverseHelper(str.substring(0, str.length() - 1), buffer);
        }
    }

    public static class ListNode{
        ListNode next;
        int val;
    }

    public boolean hasCycleWithExtraSpace(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }

        return false;
    }


    public boolean hasCycleConstantSpace(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }


    public void deleteCur(ListNode cur){
        ListNode next = cur.next;
        ListNode next1 = next.next;
        cur=next;
        cur.next=next1;
    }


    public void insertBeforePosition(ListNode p, int x) {
        ListNode newNode = new ListNode();
        newNode.val=x;
        newNode.next = p.next;
        p.next = newNode;
    }

    public ListNode findLastOccurrence(int x, ListNode head) {
        ListNode lastOccurrence = null;
        ListNode current = head;

        while (current != null) {
            if (current.val == x) {
                lastOccurrence = current;
            }
            current = current.next;
        }

        return lastOccurrence;
    }


    public static void main(String[] args) {
        System.out.println(count(4));
        System.out.println(count(7));

        int[] arr = {2, -4, 1, 9, -6, 7, -3};
        int result = maxSubarraySum(arr);
        System.out.println("最大连续子序列和为: " + result);


        System.out.println(findGroup(arr,3));


        permute("abc");
        String input = "Line 1\nLine 2\nLine 3\n";
        Scanner scanner = new Scanner(input);
        printReverse(scanner);
        String word = "cabb";
        Set<String> result1 = getAllWords(word);
        System.out.println(result1);

        ListNode head = new ListNode();
        head.val=3;
        head.next = new ListNode();
        head.next.val=4;
        head.next.next = new ListNode();
        head.next.next.val=5;
        head.next.next.next = new ListNode();
        head.next.next.next.val=6;
        System.out.println(findLast(head).val);
    }

    private static ListNode findLast(ListNode head){
        if(head==null || head.next==null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null&&cur.next!=null){
            pre=cur;
            cur=cur.next;
        }
        return pre;
    }

    private ListNode concateated(ListNode l, ListNode m){
        if(l==null) return m;
        if(m==null) return l;
        ListNode head=l;
        ListNode tail=null;
        while (l!=null&&l.next!=null){
            l=l.next;
        }
        tail=l;
        tail.next=m;
        return head;
    }









    static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        return array;
    }


    static boolean algorithm1(int[] array) {
        for (int i : array) {
            if (Arrays.binarySearch(array, -i) >= 0) {
                return true;
            }
        }
        return false;
    }


    static boolean algorithm2(int[] array) {
        for (int i : array) {
            if (binarySearch(array, -i)) {
                return true;
            }
        }
        return false;
    }


    static boolean binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // 算法 #3：双指针法
    static boolean algorithm3(int[] array) {
        int i = 0, j = array.length - 1;
        while (i <= j) {
            int sum = array[i] + array[j];
            if (sum == 0) {
                return true;
            } else if (sum < 0) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }


    static int A(int m, int n){
        if(m==0) return n+1;
        else if(m>0&&n==0){
            return A(m-1,n);
        }
        else if(m>0&&n>0){
            return A(m-1,A(m,n-1));
        }
        return -1;
    }





}
