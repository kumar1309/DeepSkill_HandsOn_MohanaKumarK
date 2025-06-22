public class Main{
    public static void main(String[] args){
        InventoryManager inventoryManager = new InventoryManager();
        Product product_1 = new Product("3001", "Mobile", 10, 15000.0);
        Product product_2 = new Product("3002", "Laptop", 5, 50000.0);
        inventoryManager.add_Product(product_1);
        inventoryManager.add_Product(product_2);
        System.out.println("Displaying current Inventory:");
        inventoryManager.display_all_Products();
        inventoryManager.update_Product("3001", 15, 14000.0);
        System.out.println("Displaying updated Inventory:");
        inventoryManager.display_all_Products();
        System.out.println("Deleting  product");
        inventoryManager.delete_Product("3002");
        System.out.println("Displaying final Inventory:");
        inventoryManager.display_all_Products();
    }
}