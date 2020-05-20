package com.atul.usermovierating.DAO;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atul.usermovierating.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Serializable> {

}
