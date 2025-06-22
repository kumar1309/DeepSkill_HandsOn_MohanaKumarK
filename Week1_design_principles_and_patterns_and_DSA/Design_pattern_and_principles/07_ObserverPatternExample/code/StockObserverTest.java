public class StockObserverTest {
    public static void main(String[] args) {
      
        StockMarket tcsStock = new StockMarket();

        
        Observer mobileApp = new MobileApp("Meta Stacks ");
        Observer webApp = new WebApp("Groww");

   
        tcsStock.registerObserver(mobileApp);
        tcsStock.registerObserver(webApp);

        System.out.println("\n--- Updating price to RS 18000.0 ---");
        tcsStock.setStockPrice(1800.0);

        System.out.println("\n--- Updating price to RS 18250.0 ---  ");
        tcsStock.setStockPrice(1825.5);

       
        tcsStock.removeObserver(webApp);

        System.out.println("\n--- Updating price to RS 18750.75 ---");
        tcsStock.setStockPrice(1850.75);
    }
}
