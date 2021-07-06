package org.infinitysoft.de100.deplacement;

import org.infinitysoft.de100.machine.Machine;
import org.infinitysoft.de100.site.Site;
import org.infinitysoft.de100.site.SiteRepository;
import org.infinitysoft.de100.transaction.Transactions;
import org.infinitysoft.de100.transaction.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class DeplacementController {


    private DeplacemenetRepository deplacemenetRepository;
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    TransactionsRepository transactionsRepository;
    public DeplacementController(DeplacemenetRepository deplacemenetRepository) {
        this.deplacemenetRepository = deplacemenetRepository;
    }


    @GetMapping("/machinesSite/{id}")
    List<Machine> machinesSite(@PathVariable Long id)
    {
        Optional<Site> site= siteRepository.findById(id);
        List<Deplacement> deplacements =  deplacemenetRepository.findBySite(site);
        List<Machine> machines = new ArrayList<>();
        deplacements.forEach(d->{
            machines.add(d.getMachine());
        });
         return  machines;
    }

    @GetMapping("/msite/{id}")
    List<Machine> msite(@PathVariable Long id)
    {
        List<Machine> machines = new ArrayList<>();
        for(Deplacement deplacement : deplacemenetRepository.findAll())
        {
            if(deplacement.getSite().getId() == id)
                machines.add(deplacement.getMachine());
        }
        return  machines;

    }

}

