package org.infinitysoft.de100.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    private final ClientRepository clientRepository;

    public ClientConfig(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //@Bean
    public CommandLineRunner startClient(){
        return args -> {
            clientRepository.save(new Client(null,"brings","ain sbaaa","bring@contact.com","055",null,null));
        };
    }
}
