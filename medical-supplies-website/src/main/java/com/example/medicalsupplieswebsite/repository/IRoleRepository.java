package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
