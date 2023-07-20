package com.example.medicalsupplieswebsite.repository;

import com.example.medicalsupplieswebsite.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Long> {
    /*
     * ThanhNV - login, xac thuc va phan quyen
     */
    @Query(nativeQuery = true, value =
            "select account_id, username, email, encrypt_password, is_enable " +
                    "from account " +
                    "where username = :username")
    Optional<Account> findAccountByUsername(@Param("username") String username);

    /*
     * NhanTQ
     * @param username
     * @param pass -> new pass
     */
    @Modifying
    @Query(value = "update `account` a set a.encrypt_password =:pass " +
            "where (a.is_enable = true) and (username = :username) ",
            nativeQuery = true)
    void changePassword(@Param("username") String username,
                        @Param("pass") String pass);
}
