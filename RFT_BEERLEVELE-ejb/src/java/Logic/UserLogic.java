/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Entities.User;
import Exceptions.NoSuchAUserException;
import Facades.UserFacade;
import java.util.List;
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

public class UserLogic {
    
    @Inject
    UserFacade facade;
    
    public void insertUser(String name, String role, String password) throws Exception {
        User user = new User(name, role, password);
        Logger logger = LoggerFactory.getLogger(UserLogic.class);
        logger.debug("Check, if the user is persistable");
        if (CheckIfCorrectUser(user)) {
            facade.create(user);
        } else {
            throw new Exception("This user already exists, or the values are not correct");
        }
    }
    
    public void deleteUserById(Integer id) throws Exception {
        User cu = facade.findUserById(id);
        if (cu != null) {
            facade.remove(cu);
        } else {
            throw new Exception("No such a user");
            
        }
    }
    
    public void editUser(String name, String role, String password, Integer id) throws NoSuchAUserException {
        User user = facade.findUserById(id);
        if (user == null) {
            throw new NoSuchAUserException("No such a user!");
        }
        if (name != null) {
            user.setName(name);
        }
        if (role != null) {
            user.setRole(role);
        }
        if (password != null) {
            user.setPassword(password);
        }
        
        facade.edit(user);
    }
    
    public List<User> findAllUser() {
        return facade.findAll();
        
    }
    
    private boolean CheckIfCorrectUser(User user) {
        if (user.getName() == null || user.getPassword() == null || user.getRole() == null) {
            return false;
        }
        return true;
        
    }
    
    public User findUserById(int id) {
        return facade.findUserById(id);
        
    }
    
}
