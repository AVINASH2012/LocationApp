package com.LocationApplications.Models;

import com.LocationApplications.Entity.Role;
import com.LocationApplications.Entity.User;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class UserRoleDTO {	

	String userName;
	Integer roleId;
}
