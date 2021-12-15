package com.trabalhopw.trabalhopw.repository;

import com.trabalhopw.trabalhopw.model.Livro;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class LivroCustomRepository {

    private final EntityManager entityManager;

    public LivroCustomRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Livro> busca(String valor){
        String sql = "select l.* from Livro as L where L.nome_autor like '%"+valor+"%' or L.isbn like '%"+valor+"%' or L.livro like '%"+valor+"%'";

        var q = entityManager.createNativeQuery(sql, Livro.class);

        return q.getResultList();
    }
}
