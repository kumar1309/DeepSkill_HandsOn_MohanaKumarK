import java.util.HashMap;
public class InventoryManager{
    private HashMap<String,Product> inventory=new HashMap<>();
    public void add_Product(Product product){
        if(inventory.containsKey(product.get_Product_id())){
            System.out.println("Product with ID " + product.get_Product_id() + "is already existing.");
        } else {
            inventory.put(product.get_Product_id(), product);
            System.out.println("Product added: " + product.get_Product_name());
        }
    }
    public void update_Product(String product_id, int quantity, double price){
        if(inventory.containsKey(product_id)){
            Product product = inventory.get(product_id);
            product.set_Quantity(quantity);
            product.set_Price(price);
            System.out.println("Product updated: " + product.get_Product_name());
        } else {
            System.out.println("Product with ID " + product_id + " does not exist.");
        }
    }
    public void delete_Product(String product_id){
        if(inventory.containsKey(product_id)){
            Product removedProduct = inventory.remove(product_id);
            System.out.println("Product deleted: " + removedProduct.get_Product_name());
        } else {
            System.out.println("Product with ID " + product_id + " does not exist.");
        }
    }
    public void display_all_Products(){
        if(inventory.isEmpty()){
            System.out.println("No products in inventory.");
        } else {
            System.out.println("Inventory Products:");
            for(Product product : inventory.values()){
                product.displayProductDetails();
                System.out.println("-----------------------");
            }
        }
    }
}
