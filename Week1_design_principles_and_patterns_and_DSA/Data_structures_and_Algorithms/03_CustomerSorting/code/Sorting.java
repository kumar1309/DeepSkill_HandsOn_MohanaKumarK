public class Sorting{
    public static void bubble_sort(Order[] orders){
        int n=orders.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(orders[j].getOrderAmount()>orders[j+1].getOrderAmount()){
                    
                    Order temp=orders[j];
                    orders[j]=orders[j+1];
                    orders[j+1]=temp;
                }
            }
        }
    }
    public static void quick_sort(Order[] orders, int low, int high){
        if(low<high){
            int pi=partition(orders,low,high);
            quick_sort(orders,low,pi-1);
            quick_sort(orders,pi+1,high);
        }
    }
    private static int partition(Order[] orders, int low, int high){
        double pivot=orders[high].getOrderAmount();
        int i=(low-1);
        for(int j=low;j<high;j++){
            if(orders[j].getOrderAmount()<=pivot){
                i++;
                Order temp=orders[i];
                orders[i]=orders[j];
                orders[j]=temp;
            }
        }
        Order temp=orders[i+1];
        orders[i+1]=orders[high];
        orders[high]=temp;
        return i+1;
    }
}