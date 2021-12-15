package com.trabalhopw.trabalhopw.service;

import com.trabalhopw.trabalhopw.model.Login;
import com.trabalhopw.trabalhopw.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    
    @Autowired
    private LoginRepository loginRepository;
    
    public Login verificaLogin(Login log){
        Optional<Login> obj = loginRepository.findById(log.getId());
        return obj.orElse(null);
    }
    
    public void salvar(Login log){
        loginRepository.save(log);
    }
}
