package com.trabalhopw.trabalhopw.service;

import com.trabalhopw.trabalhopw.enuns.Perfil;
import com.trabalhopw.trabalhopw.model.Login;
import com.trabalhopw.trabalhopw.repository.LoginRepository;
import com.trabalhopw.trabalhopw.security.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Login log = loginRepository.findByLogin(login);

        if(log == null){
            throw  new UsernameNotFoundException(login);
        }

        List<Perfil> p = new ArrayList<>();
        p.add(log.getOerfil());
        Collection<? extends GrantedAuthority> autoridade = new ArrayList<>();
        autoridade = p.stream().map(x -> new SimpleGrantedAuthority(x.name())).collect(Collectors.toList());
        return new Usuario(log.getId(),log.getLogin(),log.getSenha(),autoridade);
    }
}
