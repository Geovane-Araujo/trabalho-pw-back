package com.trabalhopw.trabalhopw.repository;

import com.trabalhopw.trabalhopw.model.Livro;
import com.trabalhopw.trabalhopw.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivrosRepository extends JpaRepository<Livro,Integer> {
}
