public class NotificationTest{
    public static void main(String [] arge){
        Notifier emailnoti=new EmailNotifier();
        Notifier smsplusemailnoti=new SMSNotifierDecorator(new EmailNotifier());
        Notifier allnoti=new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        System.out.println("Only Email Notification: ");
        emailnoti.send("Message for email only ");
        System.out.println("................................");
        System.out.println("Email and SMS Notifcation: " );
        smsplusemailnoti.send("Message for email and SME ");
        System.out.println("................................");
        System.out.println("Email, SMS and Slack Notification:");
        allnoti.send("Message for email, SMS and SLack ");


    }
}