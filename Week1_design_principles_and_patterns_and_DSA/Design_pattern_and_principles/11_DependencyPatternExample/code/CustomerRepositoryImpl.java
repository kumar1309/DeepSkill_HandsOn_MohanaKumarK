public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
      
        if (id == 1) {
            return "Customer with ID 1: Mohan Kumar";
        } else if (id == 2) {
            return "Customer with ID 2: Ajith Kumar";
        } else {
            return "Customer not found";
        }
    }
}