public class Main{
    public static void main(String[] args){
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);
        System.out.println("Customer Details for ID 1: " + customerService.getCustomerDetails(1));
        System.out.println("Customer Details for ID 2: " + customerService.getCustomerDetails(2));
        System.out.println("Customer Details for ID 3: " + customerService.getCustomerDetails(3));

    }
}