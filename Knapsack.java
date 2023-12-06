import java.util.*;

public class Knapsack {
    public static void main(String args[]) {
        int profit[] = {10,20,21,30,16};
        int weight[] = {3,5,5,8,4};
        int W = 20;

        double ratio[][] = new double[profit.length][2];
        //0th col => idx; 1st col => ratio
        for(int i=0; i<profit.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = profit[i]/(double)weight[i];
        }
        //ascending orderS
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int maxProfit = 0;
        for(int i=ratio.length-1; i>=0; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]) {
                maxProfit += profit[idx];
                capacity -= weight[idx];
            } else {
                //include fractinal item
                maxProfit += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Max profit = " + maxProfit);
    }

}
