public class Main{
    public static void main(String[] args) {
        Order[] orders = new Order[5];
        orders[0] = new Order("001", "Mohan", 250.75);
        orders[1] = new Order("002", "Kumar", 150.50);
        orders[2] = new Order("003", "Thirisha", 300.00);
        orders[3] = new Order("004", "Nithin", 200.25);
        orders[4] = new Order("005", "Saravanan", 175.00);

        System.out.println("Orders before sorting:");
        for (Order order : orders) {
            order.display();
        }

        Sorting.bubble_sort(orders);

        System.out.println("\nOrders after bubble sort:");
        for (Order order : orders) {
            order.display();
        }

        Sorting.quick_sort(orders, 0, orders.length - 1);

        System.out.println("\nOrders after quick sort:");
        for (Order order : orders) {
            order.display();
        }
    }
}