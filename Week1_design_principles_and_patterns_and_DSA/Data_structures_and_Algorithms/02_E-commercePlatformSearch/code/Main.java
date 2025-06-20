public class Main{
    public static void main(String[] args){
        Product[] products={
            new Product(104, "Laptop", "Electronics"),
            new Product(101, "Smartphone", "Electronics"),
            new Product(105, "Headphones", "Accessories"),
            new Product(102, "Coffee Maker", "Home Appliances"),
            new Product(103, "Blender", "Home Appliances")
        };
        int searchId = 103;
        // using Linear Search
        Product found=LinearSearch.searchById(products, searchId);
        System.out.println("Using Linear Search:");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Product not found.");
        }
        // using Binary Search
        BinarySearch.sortProduct(products);
        Product foundBinary = BinarySearch.searchById(products, searchId);
        System.out.println("\n Using Binary Search ");
        if (foundBinary != null){
            System.out.println("Found: " + foundBinary);
        
        }
        else{
            System.out.println("Product not found");
        }
    }
}