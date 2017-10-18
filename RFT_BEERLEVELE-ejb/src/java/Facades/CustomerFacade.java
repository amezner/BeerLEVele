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
        logger.debug("persisitng");
        em.persist(cu);

    }

    public List<Customer> findAll() {
        return em.createNamedQuery("Customer.findAll").getResultList();
    }
    public List<Customer> findByName(String name){
        Logger logger = LoggerFactory.getLogger(CustomerFacade.class);
        logger.debug("findbyname");
        return em.createNamedQuery("Customer.findByName").setParameter("name", name).getResultList();
    }

}
