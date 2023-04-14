package com.LocationApplications.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LocationApplications.Entity.User;
import com.LocationApplications.Entity.UserRole;
import com.LocationApplications.Entity.UserRolePK;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRolePK>{

	
}
