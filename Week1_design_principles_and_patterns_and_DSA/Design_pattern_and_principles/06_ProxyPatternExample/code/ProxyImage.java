public class ProxyImage implements Image{
    private String file_name;
    private RealImage real_image;
    public ProxyImage(String file_name){
        this.file_name=file_name;
    }
    @Override
    public void display(){
        if(real_image==null){
            System.out.println("Creating an object for the RealImage");
            real_image=new RealImage(file_name);
        }
        else{

            System.out.println("Using the Cached RealImage obj");
        }
        real_image.display();
    }
}