/*
 * Financial Forecasting Exercise
 * What is recursion?
 *Recursion is a technique where a function calls itself to solve smaller versions of the same problem. 
 */

public class  Exercise7 {
    public static double forecastValue(double currentValue, double[] growthRates, int period) {
        if (period == growthRates.length) {
            return currentValue;
        }
        double newValue = currentValue * (1 + growthRates[period]);
        return forecastValue(newValue, growthRates, period + 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double[] pastGrowthRates = {0.05, 0.03, 0.04}; 

        double predictedValue = forecastValue(initialValue, pastGrowthRates, 0);

        System.out.printf("Predicted future value: $%.2f\n", predictedValue);
    }
}

/*
 * Time Complexity:
 * o(n)
 * For large inputs, consider iterative methods or tail-recursion optimizations to save memory.
 * Output:
 * Predicted future value: $1124.63
 */