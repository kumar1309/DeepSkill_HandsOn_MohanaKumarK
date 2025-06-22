// This is the adapter  class for AGateway
public class AAdapter implements PaymentProcessor{
    private AGateway agateway;
    public AAdapter (AGateway agateway){
        this.agateway=agateway;
    }
    @Override
    public void processingPayment(double amount){
        System.out.println("Processing payment through AAdapter");
        agateway.sendingPayment(amount);
    }
}