package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "INSERT INTO account_roles (account_id, role_id) " +
            "VALUES (:accountId, :roleId)", nativeQuery = true)
    @Modifying
    @Transactional
    void setRoleForAccount(@Param("accountId") Long accountId, @Param("roleId") Long roleId);

    /*
     * ThanhNV - login, xac thuc va phan quyen
     */
    @Query(nativeQuery = true, value =
            "select account_id, username, email, encrypt_password, is_enable " +
                    "from account " +
                    "where username = :username")
    Optional<Account> findAccountByUsername(@Param("username") String username);

    boolean existsByUsername(String username);
}
