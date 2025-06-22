public class SMSNotifierDecorator extends NotifierDecorator{
    public SMSNotifierDecorator(Notifier notifier){
        super(notifier);

    }
    @Override
    public void send(String message){
        notifier.send(message);
        sendSMS(message);
    }
    private void sendSMS(String message){
        System.out.println("Sending SMS with this message: " +message);
    }
}