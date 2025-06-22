// This is the class to implement the main method 
public class PaymentTest{
    public static void main(String[] args){
        AGateway agateway=new AGateway();
        BGateway bgateway=new BGateway();
        PaymentProcessor aAdapter=new AAdapter(agateway);
        PaymentProcessor bAdapter=new BAdapter(bgateway);
        aAdapter.processingPayment(1000);
        bAdapter.processingPayment(2000);
    }
}