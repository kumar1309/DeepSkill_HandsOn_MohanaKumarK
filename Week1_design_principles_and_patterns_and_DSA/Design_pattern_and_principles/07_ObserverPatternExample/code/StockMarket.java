import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double currentPrice;

    public void setStockPrice(double newPrice) {
        System.out.println("StockMarket: Price changed to RS:"+newPrice);
        this.currentPrice = newPrice;
        notifyObservers(); 
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Observer added: " + observer.getClass().getSimpleName());
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer removed: " + observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(currentPrice);
        }
    }
}
