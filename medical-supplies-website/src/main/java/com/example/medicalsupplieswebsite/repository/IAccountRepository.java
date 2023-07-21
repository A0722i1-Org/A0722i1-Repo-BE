package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "INSERT INTO account (username, encrypt_password, is_enable) " +
            "VALUES (:username, :encryptPassword, :isEnable)", nativeQuery = true)
    @Modifying
    @Transactional
    void addAccount(@Param("username") String username, @Param("encryptPassword") String encryptPassword, @Param("isEnable") boolean isEnable);

    @Query(value = "INSERT INTO account_roles (account_id, role_id) " +
            "VALUES (:accountId, :roleId)", nativeQuery = true)
    @Modifying
    @Transactional
    void setRoleForAccount(@Param("accountId") Long accountId, @Param("roleId") Long roleId);
}
