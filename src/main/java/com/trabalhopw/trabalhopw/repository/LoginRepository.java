package com.trabalhopw.trabalhopw.repository;

import com.trabalhopw.trabalhopw.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {

    @Transactional
    Login findByLogin(String login);
}
