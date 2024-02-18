import java.util.ArrayList;
import java.util.List;

public class Convert {

    public static int convert(String s){
        StringBuilder sb = new StringBuilder(s);
        int count=1;
        return toInt(sb, 0, count);
    }

    private static int toInt(StringBuilder sb, int target, int count){
        if(sb.isEmpty()) return target;
        char val = sb.charAt(sb.length()-1);
        target += ((int) val - '0') * count;
        count*=10;
        sb.deleteCharAt(sb.length()-1);
        return toInt( sb, target, count);
    }

    public static void main(String[] args){
        String s = "1234567";
        System.out.println(convert(s));

    }



    public static int computeSum(int[][] array, int row, int col) {
        // 基本情况：当遍历到数组的最后一行时，返回当前行的和
        if (row == array.length - 1) {
            return computeRowSum(array[row]);
        }

        // 递归调用：计算当前行的和并加上下一行的递归结果
        return computeRowSum(array[row]) + computeSum(array, row + 1, col);
    }

    // 计算一维数组中所有元素的和
    private static int computeRowSum(int[] row) {
        int sum = 0;
        for (int num : row) {
            sum += num;
        }
        return sum;
    }

    public static List<List<Integer>> generateSubsets(int[] elements, int index) {
        // 基本情况：当索引达到数组的末尾时，返回一个包含空集的集合
        if (index == elements.length) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>()); // 空集
            return result;
        }

        // 递归调用：生成包含当前元素的所有子集，并加上不包含当前元素的所有子集
        int currentElement = elements[index];
        List<List<Integer>> subsetsWithoutCurrent = generateSubsets(elements, index + 1);
        List<List<Integer>> subsetsWithCurrent = new ArrayList<>();

        for (List<Integer> subset : subsetsWithoutCurrent) {
            List<Integer> subsetWithCurrent = new ArrayList<>(subset);
            subsetWithCurrent.add(currentElement);
            subsetsWithCurrent.add(subsetWithCurrent);
        }

        // 合并两个集合
        subsetsWithoutCurrent.addAll(subsetsWithCurrent);

        return subsetsWithoutCurrent;
    }
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        char firstChar = s.charAt(0);
        char lastChar = s.charAt(s.length() - 1);
        return (firstChar == lastChar) && isPalindrome(s.substring(1, s.length() - 1));
    }



    public static boolean moreVowelsThanConsonants(String s) {
        s = s.toLowerCase();
        if (s.isEmpty()) {
            return true;
        }
        char firstChar = s.charAt(0);

        if (isVowel(firstChar)) {
            return moreVowelsThanConsonants(s.substring(1));
        } else {
            return false;
        }
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void range(int[] array, int k){
        rearrangeArray(array, k, 0, array.length - 1);
    }
    public static void rearrangeArray(int[] A, int k, int start, int end) {
        if (start >= end) {
            return;
        }
        while (start < end && A[start] <= k) {
            start++;
        }
        while (start < end && A[end] > k) {
            end--;
        }
        if (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
        }
        rearrangeArray(A, k, start, end);
    }

    public static boolean find(int[] array,int targetSum){
        return findTwoSum(array, targetSum, 0, array.length - 1);
    }

    public static boolean findTwoSum(int[] A, int k, int start, int end) {
        // 基本情况：索引范围越界，无法找到两个整数
        if (start >= end) {
            return false;
        }

        // 计算当前两个元素的和
        int sum = A[start] + A[end];

        // 如果和等于 k，则找到了两个整数，返回 true
        if (sum == k) {
            System.out.println("找到两个整数：" + A[start] + " 和 " + A[end]);
            return true;
        }

        // 如果和小于 k，则递归查找右侧元素
        if (sum < k) {
            return findTwoSum(A, k, start + 1, end);
        }

        // 如果和大于 k，则递归查找左侧元素
        return findTwoSum(A, k, start, end - 1);
    }


    public class ReverseLinkedList {

        static class ListNode {
            int value;
            ListNode next;

            public ListNode(int value) {
                this.value = value;
            }
        }

        // 递归反转单链表
        public static ListNode reverseList(ListNode head) {
            // 基本情况：空链表或只有一个节点
            if (head == null || head.next == null) {
                return head;
            }

            // 递归调用：反转后的头节点是原链表的尾节点
            ListNode reversedHead = reverseList(head.next);

            // 反转当前节点的指针
            head.next.next = head;
            head.next = null;

            return reversedHead;
        }

        // 打印链表
        public static void printList(ListNode head) {
            while (head != null) {
                System.out.print(head.value + " ");
                head = head.next;
            }
            System.out.println();
        }


    }

}
