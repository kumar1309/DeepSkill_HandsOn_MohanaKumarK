// Product.java 
public class Product{
    int product_id;
    String product_name;
    String category;
    // Constructor
    public Product(int product_id, String product_name, String category) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.category = category;
    }
    @Override
    public String toString(){
        return "Prodct ID:" + product_id + ", Product Name:" + product_name + ",Category:" + category;
    }
}