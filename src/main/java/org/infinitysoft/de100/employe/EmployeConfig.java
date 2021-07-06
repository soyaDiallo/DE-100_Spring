package org.infinitysoft.de100.employe;

import org.infinitysoft.de100.client.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EmployeConfig {

    private final ClientRepository clientRepository;
    private final EmployeRepository employeRepository;
    //  private final PasswordEncoder passwordEncoder;

    public EmployeConfig(ClientRepository clientRepository, EmployeRepository employeRepository){//, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.employeRepository = employeRepository;
        //this.passwordEncoder = passwordEncoder;
    }

    //@Bean
    public CommandLineRunner startEmploye(){
        return args -> {
            employeRepository.save(new Employe(null,"chebihi","faycal","f.chebihi", "azerty123","NORMAL",clientRepository.findById(1L).get(),null));
        };
    }
}
