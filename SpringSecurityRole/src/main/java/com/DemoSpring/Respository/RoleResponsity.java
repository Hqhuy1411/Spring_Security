package com.DemoSpring.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DemoSpring.Model.Role;

public interface RoleResponsity extends JpaRepository<Role, Integer>{
	@Query("SELECT a FROM Role a WHERE a.name=:sp")
	Role findOneByName(@Param("sp") String name);
}
