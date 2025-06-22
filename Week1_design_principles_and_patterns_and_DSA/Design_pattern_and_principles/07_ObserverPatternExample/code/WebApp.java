public class WebApp implements Observer {
    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(double newPrice) {
        System.out.println("[Web] " + appName + ": Updated dashboard with price RS"+ newPrice);
    }
}
