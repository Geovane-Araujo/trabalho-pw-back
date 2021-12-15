package com.trabalhopw.trabalhopw.controller;

import com.trabalhopw.trabalhopw.model.Livro;
import com.trabalhopw.trabalhopw.repository.LivroCustomRepository;
import com.trabalhopw.trabalhopw.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api")
public class LivroController {

    @Autowired
    LivroService livroService;

    @Autowired
    LivroCustomRepository livroCustomRepository;

    @GetMapping("livro")
    public ResponseEntity<?> getAllLivros(){
        return ResponseEntity.ok().body(livroService.getAll());
    }

    @GetMapping("livro/{id}")
    public ResponseEntity<?> getAllbyId(@PathVariable int id){
        return ResponseEntity.ok().body(livroService.getByID(id));
    }

    @PostMapping ("livro")
    public ResponseEntity<?> save(@RequestBody Livro livro){
        livroService.save(livro);
        return ResponseEntity.ok().body("OK");
    }

    @DeleteMapping ("livro/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        livroService.delete(id);
        return ResponseEntity.ok().body("OK");
    }

    @GetMapping("filtrolivro/{valor}")
    public ResponseEntity<?> getFilter(@PathVariable String valor){
        return ResponseEntity.ok().body(livroCustomRepository.busca(valor));
    }
}
