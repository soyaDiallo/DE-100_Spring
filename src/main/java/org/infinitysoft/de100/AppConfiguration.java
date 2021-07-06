package org.infinitysoft.de100;

import org.infinitysoft.de100.client.Client;
import org.infinitysoft.de100.deplacement.Deplacement;
import org.infinitysoft.de100.employe.Employe;
import org.infinitysoft.de100.erreur.Erreur;
import org.infinitysoft.de100.machine.Machine;
import org.infinitysoft.de100.piece.Piece;
import org.infinitysoft.de100.reparation.Reparation;
import org.infinitysoft.de100.sac.Sac;
import org.infinitysoft.de100.site.Site;
import org.infinitysoft.de100.transaction.Transactions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import javax.transaction.Transaction;

@Configuration
public class AppConfiguration {

    private final RepositoryRestConfiguration configuration;

    public AppConfiguration(RepositoryRestConfiguration configuration) {
        this.configuration = configuration;
    }

    @Bean
    CommandLineRunner initConfig(){
        configuration.exposeIdsFor(Client.class,Machine.class, Transactions.class,Employe.class, Site.class, Sac.class
        , Reparation.class, Piece.class, Erreur.class, Deplacement.class);
     return args -> {};
    }
}
