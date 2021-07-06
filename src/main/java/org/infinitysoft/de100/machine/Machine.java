package org.infinitysoft.de100.machine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.infinitysoft.de100.deplacement.Deplacement;
import org.infinitysoft.de100.deplacementSac.DeplacementSac;
import org.infinitysoft.de100.erreur.Erreur;
import org.infinitysoft.de100.piece.Piece;
import org.infinitysoft.de100.reparation.Reparation;
import org.infinitysoft.de100.transaction.Transactions;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"d","ds","p","r","e","t"})
public class Machine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String num ; //UNIQUE
    private String status ; //ON, OF
    private Date date_arrivee;
    private String image ;
    @OneToMany(mappedBy = "machine",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonProperty("t")
    private List<Transactions> transactions;
    @OneToMany(mappedBy = "machine",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonProperty("d")
    private List<Deplacement> deplacements;
    @OneToMany(mappedBy = "machine",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonProperty("ds")
    //@JsonManagedReference
    private List<DeplacementSac> deplacementSacs;
    @OneToMany(mappedBy = "machine",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   // @JsonManagedReference
    @JsonProperty("e")
    private List<Erreur> erreurs;
    @OneToMany(mappedBy = "machine",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //@JsonManagedReference
    @JsonProperty("p")
    private List<Piece> pieces;
    @OneToMany(mappedBy = "machine",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //@JsonManagedReference
    @JsonProperty("r")
    private List<Reparation> reparations;
}
