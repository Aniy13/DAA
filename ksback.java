import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnapsackBacktracking {
    private static int max_value = Integer.MIN_VALUE;
    private static List<Integer> selected_items = new ArrayList<>();

    public static void knapsack(int[] weights, int[] values, int capacity, int index, int current_weight, int current_value, List<Integer> current_selection) {
        if (index == weights.length) {
            if (current_value > max_value) {
                max_value = current_value;
                selected_items = new ArrayList<>(current_selection);
            }
            return;
        }

        if (current_weight + weights[index] <= capacity) {
            current_selection.add(index);
            knapsack(weights, values, capacity, index + 1, current_weight + weights[index], current_value + values[index], current_selection);
            current_selection.remove(current_selection.size() - 1);
        }

        knapsack(weights, values, capacity, index + 1, current_weight, current_value, current_selection);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        System.out.println("Enter the weights of the items:");
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        System.out.println("Enter the values of the items:");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        System.out.print("Enter the knapsack capacity: ");
        int capacity = scanner.nextInt();

        List<Integer> current_selection = new ArrayList<>();
        knapsack(weights, values, capacity, 0, 0, 0, current_selection);
        System.out.println("Maximum Value: " + max_value);
        System.out.println("Selected Items: " + selected_items);

        scanner.close();
    }
