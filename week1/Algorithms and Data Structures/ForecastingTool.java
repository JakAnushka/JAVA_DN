
public class ForecastingTool {

    // Recursive method to compute future value
    public static double predictFutureValue(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue; // Base case
        }
        return predictFutureValue(initialValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double initialValue = 10000.0; // Starting capital
        double growthRate = 0.05; // 5% annual growth
        int years = 5; // Forecast for 5 years

        double futureValue = predictFutureValue(initialValue, growthRate, years);
        System.out.printf("Projected value after %d years: %.2f%n", years, futureValue);
    }
}
