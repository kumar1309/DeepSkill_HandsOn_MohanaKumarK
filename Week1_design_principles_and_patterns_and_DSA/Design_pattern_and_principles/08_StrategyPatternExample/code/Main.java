public class Main{
    public static void main(String[] args){
        PaymentContext paymentContext = new PaymentContext();
        System.out.println(" Payment using Credit Card:");
        PaymentStrategy creditCardPayment = new CreditCardPayment("1111-2222-3333-4444", "Mohankumar", "12/25");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(100); 
        System.out.println();
        System.out.println(" Payment using PayPal:");
        PaymentStrategy paypalPayment = new PayPalPayment("mohankumar@gmail.com");
        paymentContext.setPaymentStrategy(paypalPayment);
        paymentContext.executePayment(200);
}
}