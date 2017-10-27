/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Customer;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danida
 */
@LocalBean
@Stateless
public class CustomerFacade {

    @PersistenceContext(name="RFT_BEERLEVELE-ejbPU")
    EntityManager em;

    public void saveCustomer(Customer cu) {
        Logger logger = LoggerFactory.getLogger(CustomerFacade.class);
        logger.debug("Persist customer");
        em.persist(cu);
    }
    public void deleteCustomer(Customer cu){
        Logger logger = LoggerFactory.getLogger(CustomerFacade.class);
        logger.debug("Remove customer");
        em.remove(cu);
    }
    public void editCustomer (Customer cu){
        Logger logger = LoggerFactory.getLogger(CustomerFacade.class);
        logger.debug("Editting customer");
        em.merge(cu);
    }

    public List<Customer> findAll() {
        return em.createNamedQuery("Customer.findAll").getResultList();
    }
    public List<Customer> findByName(String name){
        Logger logger = LoggerFactory.getLogger(CustomerFacade.class);
        logger.debug("findCustomerbyname");
        return em.createNamedQuery("Customer.findByName").setParameter("name", name).getResultList();
    }
    public Customer findById(Integer id){
        Logger logger = LoggerFactory.getLogger(CustomerFacade.class);
        logger.debug("findCustomerbyId");
        return (Customer)em.createNamedQuery("Customer.findById").setParameter("id", id).getResultList().get(0);
    }
    public List<Customer> findByEmail(String email){
        Logger logger = LoggerFactory.getLogger(CustomerFacade.class);
        logger.debug("findByEmail");
        return em.createNamedQuery("Customer.findByEmail").setParameter("email", email).getResultList();
    }
     public List<Customer> findByAddress(String address){
        Logger logger = LoggerFactory.getLogger(CustomerFacade.class);
        logger.debug("findByAddress");
        return em.createNamedQuery("Customer.findByEmail").setParameter("address", address).getResultList();
    }
    
    
    
}
