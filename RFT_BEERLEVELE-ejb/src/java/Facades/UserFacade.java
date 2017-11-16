/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.User;
import Interfaces.FacadeInterface;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.security.auth.login.LoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danida
 */
@LocalBean
@Stateless

public class UserFacade implements FacadeInterface<User> {

    @PersistenceContext(name = "RFT_BEERLEVELE-ejbPU")
    EntityManager em;

    @Override
    public void create(User t) {
        Logger logger = LoggerFactory.getLogger(UserFacade.class);
        logger.debug("Creating user");
        em.persist(t);
    }

    @Override
    public void remove(User t) {
        Logger logger = LoggerFactory.getLogger(UserFacade.class);
        logger.debug("Remove user");
        em.remove(t);
    }

    @Override
    public void edit(User t) {
        Logger logger = LoggerFactory.getLogger(UserFacade.class);
        logger.debug("Editting user");
        em.merge(t);
    }
    public List<User> findAll(){
        Logger logger = LoggerFactory.getLogger(UserFacade.class);
        logger.debug("Listing all the users");
        return em.createNamedQuery("User.findAll").getResultList();
    }
    public User findByUsername(String username) throws LoginException{
        Logger logger = LoggerFactory.getLogger(UserFacade.class);
        logger.debug("Finding user by username");
        
        List result = em.createNamedQuery("User.findByName").setParameter("name", username).getResultList();
        if (!result.isEmpty())
            return (User)em.createNamedQuery("User.findByName").setParameter("name", username).getResultList().get(0);
        else
            throw new LoginException("User does not exist!");
        
    }

}
