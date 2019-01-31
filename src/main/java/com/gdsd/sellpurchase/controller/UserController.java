/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdsd.sellpurchase.controller;

import java.util.List;
import com.gdsd.sellpurchase.model.User;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import util.Helper;

/**
 *
 * @author Neha V Thawani
 */
@RestController
@RequestMapping("/user")
public class UserController {
    public String orderBy;
    @Autowired
    MongoOperations mongoOperations;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        Query query = new Query();
//        query.fields().exclude("description");
        return mongoOperations.find(query, User.class);
    }

    @RequestMapping(value = "/sortByName", method = RequestMethod.GET)
    public List<User> getAllSortedUsersByName(@RequestParam("orderby")String order) {
        Query query = new Query();
//        query.fields().exclude("description");
        List<User> users = mongoOperations.find(query, User.class);
//        String[] charArray = userInput.toCharArray();
        int n = users.size();
        int i, j;
        
        for (i = 0; i < n - 1; i++) // Last i elements are already in place    
        {
            for (j = 0; j < n - i - 1; j++) {
                if (order.equals("asc")) {
                    if (Helper.compareStrings(users.get(j).getUsername(), users.get(j + 1).getUsername()) > 1) {
                        User temp = users.get(j);
                        users.set(j, users.get(j + 1));
                        users.set(j + 1, temp);
                    }
                } else {
                    if (Helper.compareStrings(users.get(j).getUsername(), users.get(j + 1).getUsername()) < 1) {
                        User temp = users.get(j);
                        users.set(j, users.get(j + 1));
                        users.set(j + 1, temp);
                    }
                }
            }
        }

        return users;
    }
    @RequestMapping(value = "/sortByAge", method = RequestMethod.GET)
    public List<User> getAllSortedUsersByAge(@RequestParam("orderby")String order) {
        Query query = new Query();
//        query.fields().exclude("description");
        List<User> users = mongoOperations.find(query, User.class);
//        String[] charArray = userInput.toCharArray();
        int n = users.size();
        int i, j;
     
        for (i = 0; i < n - 1; i++) // Last i elements are already in place    
        {
            for (j = 0; j < n - i - 1; j++) {
                if(order.equals("asc")){
                if (users.get(j).getAge() > users.get(j+1).getAge()) {
                    User temp = users.get(j);
                    users.set(j, users.get(j + 1));
                    users.set(j + 1, temp);
                }
                
            }
                else if (users.get(j).getAge() < users.get(j+1).getAge()) {
                    User temp = users.get(j);
                    users.set(j, users.get(j + 1));
                    users.set(j + 1, temp);
                }
        }
        }
        return users;
    }  
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User getUserById(@PathVariable("id") ObjectId id) {
   return mongoOperations.findById(id, User.class);
  }
  
 @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public User modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody User user) {
   user.set_id(id);
   mongoOperations.save(user);
   return user;
  }
  
 @RequestMapping(value = "/", method = RequestMethod.POST)
  public User createUser(@Valid @RequestBody User user) {
  user.set_id(ObjectId.get());
  mongoOperations.save(user);
    return user;
  }  
  
  
 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
 public void deleteUser(@PathVariable ObjectId id) {
     User user = mongoOperations.findById(id, User.class);
      mongoOperations.remove(user);
}  
}



 
