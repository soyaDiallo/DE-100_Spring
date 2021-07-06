package org.infinitysoft.de100.deplacementSac;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.infinitysoft.de100.machine.Machine;
import org.infinitysoft.de100.sac.Sac;

import javax.persistence.*;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class DeplacementSac {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @ManyToOne
   // @JsonBackReference
    private Sac sac;
    @ManyToOne
    //@JsonBackReference
    private Machine machine;
    private Date date_changement;
}
