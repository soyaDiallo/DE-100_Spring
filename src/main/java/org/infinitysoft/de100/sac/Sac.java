package org.infinitysoft.de100.sac;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.infinitysoft.de100.deplacementSac.DeplacementSac;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Sac {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private int capacite;
    @Column(unique = true)
    private String num;
    private int valeur;
    @OneToMany(mappedBy = "sac") //@JsonManagedReference
    private List<DeplacementSac> deplacementSacs;
}
