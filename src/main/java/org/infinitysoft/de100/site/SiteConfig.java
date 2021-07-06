package org.infinitysoft.de100.site;

import org.infinitysoft.de100.client.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SiteConfig {
    private final SiteRepository siteRepository;
    private final ClientRepository clientRepository;

    public SiteConfig(SiteRepository siteRepository, ClientRepository clientRepository) {
        this.siteRepository = siteRepository;
        this.clientRepository = clientRepository;
    }

    //yii@Bean
    public CommandLineRunner startSite(){
        return args -> {
          siteRepository.save(new Site(null,"MSB","ain diab","casablanca","maroc",clientRepository.findById(1L).get(),null));
        };
    }
}
