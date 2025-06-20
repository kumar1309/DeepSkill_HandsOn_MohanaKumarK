import java.util.Scanner;
public class FinancialForecastRecursive{
    public static double forecastpredict(double investment, double rategrowth, int forecastyears){
        //This is the base condition
        if(forecastyears==0){
            return investment;
        }
        // The function calling again and again 
        return forecastpredict(investment*(1+rategrowth), rategrowth, forecastyears-1);
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the intial investment for the forecast: ");
        double investment=in.nextDouble();
        System.out.println("Enter the growth rate for the forecast: " );
        double growthrate=in.nextDouble();
        System.out.println("Enter the number of years for the forecast :");
        int forecastyears=in.nextInt();
        double finalprediction=forecastpredict(investment, growthrate, forecastyears);
        System.out.println("The final Growth Prediction for the investment of "+investment+"  for "
                           +forecastyears+ " years at a growth rate of " + growthrate*100 + 
                           "  is " + finalprediction);
    }
}