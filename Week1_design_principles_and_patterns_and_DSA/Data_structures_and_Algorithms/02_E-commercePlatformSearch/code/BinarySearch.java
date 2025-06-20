    // Implementation of Binary Search 
    import java.util.Arrays;
    import java.util.Comparator;
    public class BinarySearch{
        public static void sortProduct(Product[] products){
            Arrays.sort(products, new Comparator<Product>(){
                @Override
                public int compare(Product p1, Product p2){
                    return Integer.compare(p1.product_id, p2.product_id);
                }
            });
        }
        public static Product searchById(Product[] products, int searchId){
            int l=0;
            int r=products.length-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if (products[mid].product_id==searchId){
                    return products[mid];
                }
                else if (products[mid].product_id < searchId){
                    l=mid+1;

                }
                else {
                    r=mid-1;
                }
            }
            return null;
        }
    }