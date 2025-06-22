// Thi is the adapter class for BGateway
public class BAdapter implements PaymentProcessor{
    private BGateway bgateway;
    public BAdapter(BGateway bgateway){
        this.bgateway=bgateway;
    }
    @Override
    public void processingPayment(double amount){
        System.out.println("Processing payment through BAdapter");
        bgateway.sendingPayment(amount);
    }
}