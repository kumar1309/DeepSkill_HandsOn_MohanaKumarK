
public class Main{
    public static void main(String[] args){
        Logger logger_1=Logger.getInstance();
        Logger logger_2=Logger.getInstance();
        logger_1.log("This is the first log");
        logger_2.log("This is the second log");
        // Checking both the instance are same or not
        if (logger_1 == logger_2){
            System.out.println("Singleton works as both the instace are same ");
        }
        else{
            System.out.println("Singleton failed as both the instance are different ");
        }
    }

}