package org.infinitysoft.de100.transaction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.infinitysoft.de100.employe.Employe;
import org.infinitysoft.de100.machine.Machine;

import javax.persistence.*;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"employe","machine"})
public class Transactions {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Date date_transaction ;
    private double montant ;
    private String status;
    private String type ;
    private String description ;
    @ManyToOne
    @JsonProperty("machine")
    private Machine machine;
    @ManyToOne
    @JsonProperty("employe")
    private Employe employe;
}
