/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.User;
import Exceptions.NoSuchAUserException;
import Interfaces.FacadeInterface;
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

public class UserFacade implements FacadeInterface<User> {

    @PersistenceContext(name = "RFT_BEERLEVELE-ejbPU")
    EntityManager em;

    @Override
    public void create(User user) {
        Logger logger = LoggerFactory.getLogger(UserFacade.class);
        logger.debug("Create user, ID : ", user.getId());
        em.persist(user);
    }

    @Override
    public void remove(User user) {
        Logger logger = LoggerFactory.getLogger(UserFacade.class);
        logger.debug("Remove user, ID : ", user.getId());
        em.remove(user);
    }

    @Override
    public void edit(User user) {
        Logger logger = LoggerFactory.getLogger(UserFacade.class);
        logger.debug("Edit user, ID : ", user.getId());
        em.merge(user);
    }
    public List<User> findAll(){
        Logger logger = LoggerFactory.getLogger(UserFacade.class);
        logger.debug("Listing all the users");
        return em.createNamedQuery("User.findAll").getResultList();
    }
    public User findByUsername(String username) throws  NoSuchAUserException{
        Logger logger = LoggerFactory.getLogger(UserFacade.class);
        logger.debug("Finding user by username");
        
        List result = em.createNamedQuery("User.findByName").setParameter("name", username).getResultList();
        if (!result.isEmpty())
            return (User)em.createNamedQuery("User.findByName").setParameter("name", username).getResultList().get(0);
        else
            throw new NoSuchAUserException("User does not exist!");
        
    }
    
    public User findUserById(Integer id) {
        Logger logger = LoggerFactory.getLogger(UserFacade.class);
        logger.debug("findUserbyId");
        return (User) em.createNamedQuery("User.findById").setParameter("id", id).getResultList().get(0);

    }

}
