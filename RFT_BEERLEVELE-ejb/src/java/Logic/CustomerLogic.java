/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Entities.Customer;
import Entities.Stock;
import Exceptions.NoSuchACustomer;
import Facades.CustomerFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danida
 */
@ManagedBean
@Stateless

public class CustomerLogic {

    @Inject
    CustomerFacade facade;

    public void insertCustomer(String name, String country, String city, String address, String postalcode, String email, String phone, Boolean loyaltycard, Integer discount) throws Exception   {
        Customer customer = new Customer(name, country, city, address, postalcode, email, phone, loyaltycard, discount);
        Logger logger = LoggerFactory.getLogger(CustomerLogic.class);
        logger.debug("Check, if the customer is persistable");
        if (CheckIfCorrectCustomer(customer) && !CheckIfDuplicatedCustomer(customer)) {
            facade.create(customer);
        } else {
            throw new Exception("This customer already exists, or the values are not correct");
        }
    }

    public void deleteCustomerById(Integer id) throws Exception {
        Customer cu = facade.findById(id);
        if (cu != null) {
            facade.remove(cu);
        } else {
            throw new Exception("No such a customer");

        }
    }

    public void editCustomer(Customer cu) {
        facade.edit(cu);
    }

    public List<Customer> findAllCustomer() {
        return facade.findAll();

    }

    public Customer findCustomerById(int id) throws NoSuchACustomer{
        return facade.findById(id);
    }

    
      public List<Customer> filterCustomerByName(String searchpattern) {
        List<Customer> allCustomer = facade.findAll();
        List<Customer> r = new ArrayList<>();
        String pattern = ".*" + searchpattern.toLowerCase() + ".*";
        allCustomer.stream().filter((s) -> (Pattern.matches(pattern, s.getName().toLowerCase()))).forEach((s) -> {
            r.add(s);
        });
        return r;
    }
    
    private boolean CheckIfCorrectCustomer(Customer customer) {
        if (customer.getLoyaltycard() == null || customer.getAddress() == null || customer.getDiscount() == null || customer.getEmail() == null || customer.getName() == null) {
            return false;
        }
        return true;

    }

    private boolean CheckIfDuplicatedCustomer(Customer customer) {

        if (facade.findByName(customer.getName()).isEmpty()) {
            return false;
        }
        return true;

    }

}
