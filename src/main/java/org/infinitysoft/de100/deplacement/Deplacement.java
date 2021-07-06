package org.infinitysoft.de100.deplacement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.infinitysoft.de100.machine.Machine;
import org.infinitysoft.de100.site.Site;

import javax.persistence.*;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Deplacement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    @JsonIgnore
    private Site site;
    @ManyToOne
    @JsonBackReference
    private Machine machine;
    private Date date_deplacement;
}
