package sort;

import Customers.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class CustomerSort implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getNameCustomer().equals(o2.getNameCustomer())) {
            try {
                Date birthDay1 = new SimpleDateFormat("dd/MM/yyyy").parse(o1.getDayOfBirth());
                Date birthDay2 = new SimpleDateFormat("dd/MM/yyyy").parse(o2.getDayOfBirth());
                return birthDay1.compareTo(birthDay2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
            return o1.getNameCustomer().compareTo(o2.getNameCustomer());
    }
}
