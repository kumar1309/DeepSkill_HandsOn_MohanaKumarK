// implementation of Linera search algorithm
public class LinearSearch{
    public static Product searchById(Product [] products, int searchId ){
        for(Product p: products) {
            if(p.product_id == searchId) {
                return p;
            }
        }
        return null;
    }
}