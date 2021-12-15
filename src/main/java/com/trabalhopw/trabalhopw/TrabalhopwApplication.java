package com.trabalhopw.trabalhopw;

import com.trabalhopw.trabalhopw.enuns.Perfil;
import com.trabalhopw.trabalhopw.model.Login;
import com.trabalhopw.trabalhopw.repository.LoginRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TrabalhopwApplication implements CommandLineRunner {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	LoginRepository loginRepository;

	public static void main(String[] args) {

		SpringApplication.run(TrabalhopwApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		Login login = new Login(null,"Geovane Araujo","geovane",bCryptPasswordEncoder.encode("123"), Perfil.ROLE_ADMIN);
		loginRepository.save(login);

		login = new Login(null,"Edna Souza Araujo","edna",bCryptPasswordEncoder.encode("123"), Perfil.ROLE_CLIENTE);
		loginRepository.save(login);
	}
}
