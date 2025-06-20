
public class Logger {
    // Creation of private static instance 
    private static Logger instance;
    //Creation of pricvate constructor
    private Logger(){
        System.out.println("Instance of logger is created ");
    }
    //creation of public static instance method
    public static Logger getInstance(){
        if (instance==null){
            instance=new Logger();
        }
        return instance;
    }
    public void log(String message){
        System.out.println("log:"+message);
    }
}