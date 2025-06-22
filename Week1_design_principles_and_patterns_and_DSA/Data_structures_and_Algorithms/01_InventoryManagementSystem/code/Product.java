public class Product{
    private String product_id;
    private String product_name;
    private int quantity;
    private double price;
    public Product(String product_id, String product_name, int quantity, double price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;
        this.price = price;
    }
    public String get_Product_id(){
        return product_id;
    }
    public String get_Product_name(){
        return product_name;
    }
    public int get_Quantity(){
        return quantity;
    }
    public double get_Price(){
        return price;

    }
    public void set_Quantity(int quantity){
        this.quantity=quantity;
    }
    public void set_Price(double price){
        this.price=price;
    }
    public void displayProductDetails(){
        System.out.println("Product ID: " + product_id);
        System.out.println("Product Name: " + product_name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: $" + price);
    }
}