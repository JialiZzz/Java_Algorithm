import java.util.HashMap;
import java.util.Map;

public class unique {
    public static int findMissingNumber(int[] A) {
        int n = A.length + 1; // 数组应该包含 n 个元素，但是现在只有 n-1 个元素
        int xorSum = 0;

        // 对数组 A 中的所有元素进行异或运算
        for (int num : A) {
            xorSum ^= num;
        }

        // 对 [0, n-1] 范围内的所有数字进行异或运算
        for (int i = 0; i < n; i++) {
            xorSum ^= i;
        }

        return xorSum;
    }

    public static void main(String[] args) {
        // 示例数组，缺失数字为 4
        int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9};

        int missingNumber = findMissingNumber(array);
        System.out.println("缺失的数字是：" + missingNumber);
    }

    public static int findMostFrequent(int[] A) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int mostFrequent = -1;
        int maxFrequency = 0;

        for (int num : A) {
            // 检查整数是否在哈希表中
            if (frequencyMap.containsKey(num)) {
                // 更新出现次数
                int frequency = frequencyMap.get(num) + 1;
                frequencyMap.put(num, frequency);

                // 更新最频繁出现的整数
                if (frequency > maxFrequency) {
                    mostFrequent = num;
                    maxFrequency = frequency;
                }
            } else {
                // 将整数添加到哈希表并设置出现次数为1
                frequencyMap.put(num, 1);
            }
        }

        return mostFrequent;
    }



    public static int findMax(int[] A, int start, int end) {
        // 基本情况：当数组中只有一个元素时，返回该元素
        if (start == end) {
            return A[start];
        }

        // 将数组分成两半
        int mid = (start + end) / 2;

        // 递归地在左半部分和右半部分寻找最大元素
        int maxLeft = findMax(A, start, mid);
        int maxRight = findMax(A, mid + 1, end);

        // 返回左右两半部分中的较大值
        return Math.max(maxLeft, maxRight);
    }

    public static int binarySearch(int[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (array[mid] == target) {
            return mid;
        }

        if (target < array[mid]) {
            return binarySearch(array, target, start, mid - 1);
        }
        return binarySearch(array, target, mid + 1, end);
    }

}
