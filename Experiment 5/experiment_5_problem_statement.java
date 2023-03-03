/*
Implement Fractional Knapsack Algorithm
*/

/**
 * experiment_5_problem_statement
 */
public class experiment_5_problem_statement {

    public static void fractionalKnapsackAlgorithm(int[] weight, int[] profit, int maxWeight) {
        int n = weight.length;
        double[] ratio = new double[n];
        for (int i = 0; i < n; i++) {
            ratio[i] = (double) profit[i] / weight[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {
                    double temp = ratio[j];
                    ratio[j] = ratio[i];
                    ratio[i] = temp;

                    int temp2 = weight[j];
                    weight[j] = weight[i];
                    weight[i] = temp2;

                    temp2 = profit[j];
                    profit[j] = profit[i];
                    profit[i] = temp2;
                }
            }
        }

        double totalProfit = 0;
        for (int i = 0; i < n; i++) {
            if (weight[i] <= maxWeight) {
                maxWeight -= weight[i];
                totalProfit += profit[i];
            } else {
                totalProfit += (ratio[i] * maxWeight);
                break;
            }
        }
        System.out.println("The maximum profit that can be obtained is " + totalProfit);

    }

    public static void main(String[] args) {
        int[] weight = { 10, 40, 20, 30 };
        int[] profit = { 60, 40, 100, 120 };
        int maxWeight = 50;

        fractionalKnapsackAlgorithm(weight, profit, maxWeight);
    }
}
