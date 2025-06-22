public class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(double newPrice) {
        System.out.println("[Mobile] " + appName + ": Stock price is now RS"+ newPrice);
    }
}
