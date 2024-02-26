import java.util.*;

public class DebtOptimization {



    /*
    **构建余额映射表：**首先，将输入的欠债数组转换为一个映射表，其中键是人员编号，值是他们的余额。对于每一笔债务，根据借款人和贷款人更新他们的余额。

**识别欠款人和贷款人：**遍历余额映射表，将欠款人和贷款人分别放入两个列表中。

**使用贪心策略进行交易：**从欠款人列表和贷款人列表中选取一对欠款人和贷款人，计算出可以交易的最小金额，并将此交易信息添加到结果列表中。然后根据交易金额更新欠款人和贷款人的余额。不断重复此过程，直到其中一个列表遍历完成。

**返回结果：**返回优化后的交易列表。

这个算法的关键是在每次交易中选择欠款人和贷款人，使得交易金额最小化，从而尽可能减少交易次数。通过贪心地选择每次交易中涉及的欠款人和贷款人，可以在保证总交易金额最小的前提下完成优化。
     */
    public static List<List<Integer>> optimizeDebt(int[][] debts) {
        Map<Integer, Integer> balanceMap = new HashMap<>();
        for (int[] debt : debts) {
            int borrower = debt[0];
            int lender = debt[1];
            int amount = debt[2];
            balanceMap.put(borrower, balanceMap.getOrDefault(borrower, 0) - amount);
            balanceMap.put(lender, balanceMap.getOrDefault(lender, 0) + amount);
        }

        List<Integer> borrowers = new ArrayList<>();
        List<Integer> lenders = new ArrayList<>();
        for (int person : balanceMap.keySet()) {
            int balance = balanceMap.get(person);
            if (balance < 0) {
                borrowers.add(person);
            } else if (balance > 0) {
                lenders.add(person);
            }
        }

        List<List<Integer>> transactions = new ArrayList<>();
        int i = 0, j = 0;
        while (i < borrowers.size() && j < lenders.size()) {
            int borrower = borrowers.get(i);
            int lender = lenders.get(j);
            int debt = balanceMap.get(borrower);
            int loan = balanceMap.get(lender);
            int amount = Math.min(-debt, loan);
            transactions.add(Arrays.asList(borrower, lender, amount));
            if (amount == -debt) {
                i++;
            }
            if (amount == loan) {
                j++;
            }
            balanceMap.put(borrower, debt + amount);
            balanceMap.put(lender, loan - amount);
        }

        return transactions;
    }

    public static void main(String[] args) {
        int[][] debts = {{1, 3, 10}, {4, 5, 3},{4,6,5}};
        List<List<Integer>> optimizedDebts = optimizeDebt(debts);
        System.out.println("Optimized transactions:");
        for (List<Integer> transaction : optimizedDebts) {
            System.out.println(transaction);
        }
    }
}
