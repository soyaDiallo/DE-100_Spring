package org.infinitysoft.de100.employe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.infinitysoft.de100.client.Client;
import org.infinitysoft.de100.transaction.Transactions;

import javax.persistence.*;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Employe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private String prenom ;
    private String login ;
    private String password ;
    private String type ; // CIT / Simple
    @ManyToOne
    private Client client ;
    @OneToMany(mappedBy = "employe")
    private List<Transactions> transactions;
}
