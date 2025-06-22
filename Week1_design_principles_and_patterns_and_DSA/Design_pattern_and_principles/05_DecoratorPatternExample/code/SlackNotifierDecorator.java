public class SlackNotifierDecorator extends NotifierDecorator{
    public SlackNotifierDecorator(Notifier notifier){
        super(notifier);
    }
    public void send(String message){
        notifier.send(message);
        sendSlack(message);
    }
    private void sendSlack(String message){
        System.out.println("Sending slask with this message : " + message);
    }
}