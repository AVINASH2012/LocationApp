package com.LocationApplications.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LocationApplications.Entity.User;
import com.LocationApplications.Entity.UserRole;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{

}
