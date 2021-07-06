package org.infinitysoft.de100.site;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.infinitysoft.de100.client.Client;
import org.infinitysoft.de100.deplacement.Deplacement;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Site {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private String adresse ;
    private String ville ;
    private String pays ;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "site",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //@JsonManagedReference
    private List<Deplacement> deplacements;
}
