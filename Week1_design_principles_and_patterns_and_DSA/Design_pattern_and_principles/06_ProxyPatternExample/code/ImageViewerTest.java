public class ImageViewerTest {
    public static void main(String[] args) {
        Image image_1 = new ProxyImage("image_1.png");
        Image image_2 = new ProxyImage("image_2.png");

        image_1.display();
        System.out.println(" Again displaying image_1");
        image_1.display();
        System.out.println("Displaying image_2");
        image_2.display();
    }
}