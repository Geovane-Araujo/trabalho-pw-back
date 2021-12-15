package com.trabalhopw.trabalhopw.service;

import com.trabalhopw.trabalhopw.model.Livro;
import com.trabalhopw.trabalhopw.repository.LivrosRepository;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivrosRepository livrosRepository;

    public List<Livro> getAll(){
        List<Livro> obj = livrosRepository.findAll();
        return  obj;
    }

    public Livro getByID(Integer id){
        Optional<Livro> obj = livrosRepository.findById(id);
        return  obj.orElse(new Livro());
    }

    public void save(Livro livro){
        livrosRepository.save(livro);
    }
    public void delete(int id){
        livrosRepository.deleteById(id);
    }

    public void getFIlter(String filtro){


    }
}
