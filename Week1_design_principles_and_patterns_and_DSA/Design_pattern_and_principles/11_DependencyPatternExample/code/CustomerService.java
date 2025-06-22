public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerDetails(int id) {
        if (customerRepository == null) {
            return "Customer repository not set.";
        }
        return customerRepository.findCustomerById(id);
    }
}