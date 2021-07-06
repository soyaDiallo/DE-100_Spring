package org.infinitysoft.de100.client;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.infinitysoft.de100.employe.Employe;
import org.infinitysoft.de100.site.Site;

import javax.persistence.*;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    private String nom ;
    private String adresse ;
    private String email ;
    private String tel ;
    @OneToMany(mappedBy = "client")
    private List<Employe> employes;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
   // @JsonBackReference
    private List<Site> sites;
}
