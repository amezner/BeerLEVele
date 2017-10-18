/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entities.Customer;
import Facades.CustomerFacade;
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
  

public class CustomerBean {
  @Inject
    CustomerFacade facade;
 
   
  
    public void insertCustomer(String name,String address,String email,int phone,boolean loyaltycard,int discount) throws Exception{
        Customer customer = new Customer(name, address, email, phone, loyaltycard, discount);
        if (CheckIfCorrectCustomer(customer)&&!CheckIfDuplicatedCustomer(customer)){
            Logger logger = LoggerFactory.getLogger(CustomerBean.class);
            logger.debug("Before Persist");
            facade.saveCustomer(customer);
        }
        throw new Exception("NotPossible");
    
    }
    
    
    
    private   boolean CheckIfCorrectCustomer(Customer customer){
        if (customer.getLoyaltycard()==null || customer.getAddress()==null || customer.getDiscount()==null || customer.getEmail()==null ||customer.getName()==null){
            return false;
        }
            return true;
    
    }
    private  boolean CheckIfDuplicatedCustomer(Customer customer){
        if(facade.findByName(customer.getName()).isEmpty())
        {   return false;
        }
        return true;
    
    }
    
}
