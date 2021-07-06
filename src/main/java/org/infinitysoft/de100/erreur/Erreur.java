package org.infinitysoft.de100.erreur;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.infinitysoft.de100.machine.Machine;

import javax.persistence.*;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Erreur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String type ;
    private String message ;
    private Date date_erreur ;
    @ManyToOne
   // @JsonBackReference
    private Machine machine;
}
