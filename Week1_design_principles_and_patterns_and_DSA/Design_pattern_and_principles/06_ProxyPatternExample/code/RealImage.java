public class RealImage implements Image{
    private String file_name;
    public RealImage(String file_name){
        this.file_name=file_name;
        loadremoteserver();
    }
    public void loadremoteserver(){
        System.out.println("Image loading from remote server " +file_name);
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
             System.out.println("Error loading image: " +e.getMessage());
        }
    }
    @Override
    public void display(){
        System.out.println("Displaying image " +file_name);
    }
}