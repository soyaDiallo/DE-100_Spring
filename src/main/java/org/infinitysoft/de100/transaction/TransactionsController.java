package org.infinitysoft.de100.transaction;

import org.hibernate.type.TrueFalseType;
import org.infinitysoft.de100.deplacement.Deplacement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class TransactionsController
{
    private TransactionsRepository transactionsRepository;
    public TransactionsController(TransactionsRepository transactionsRepository)
    {
        this.transactionsRepository=transactionsRepository;
    }



//    @GetMapping("/totalDeposit")
//    public float getTotalDeposit()
//    {
//        return transactionsRepository.getTotalDeposit();
//    }
//    @GetMapping("/totalManuel")
//    public float getTotalManuel()
//    {
//        return transactionsRepository.getTotalManuel();
//    }
//
//    @GetMapping("/totalCollect")
//    public float getTotalCollect()
//    {
//        return transactionsRepository.getTotalCollect();
//    }

//    @GetMapping("/totalDepositToday")
//    public float getTotalDepositToday()
//    {
//        return transactionsRepository.getTotalDepositToday();
//    }
//
//    @GetMapping("/totalManuelToday")
//    public float getTotalManuelToday()
//    {
//        return transactionsRepository.getTotalManuelToday();
//    }
//
    @GetMapping("/stat/{filterBy}/{value}/{type}/{site}/{nbrMount}")
    public float stat(@PathVariable String filterBy, @PathVariable int value, @PathVariable String type, @PathVariable Long site,@PathVariable String nbrMount )
    {
        double total=0;
        Predicate<Transactions> transactionsStream = null;
        if(filterBy.equals("day")) {
            transactionsStream = tr -> tr.getDate_transaction().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().equals(LocalDate.now());
        }
        else if(filterBy.equals("month")){
            transactionsStream = tr -> tr.getDate_transaction().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonth().equals(Month.of(value));
        }
        else
            transactionsStream = tr -> tr.getDate_transaction().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear() == value;


        // todo: améliorer la requette
        List<Transactions> transactions = transactionsRepository.findAll();
        transactions = transactions.stream()
                .filter(transactionsStream)
                .filter(tr-> tr.getType().equals(type))
                .collect(Collectors.toList());

        List<Transactions> transactions_filter = new ArrayList<>();
        for(Transactions trs : transactions){
            for(Deplacement deplacement : trs.getMachine().getDeplacements())
                if(deplacement.getSite().getId() == site)
                    transactions_filter.add(trs);
        }
        if(nbrMount.equals("montant"))
        {
             total = transactions_filter.stream().mapToDouble(tr-> tr.getMontant()).sum();
        }else if (nbrMount.equals("nbr")){
             total = transactions_filter.stream().mapToDouble(tr-> tr.getMontant()).count();
        }


        return (float) total;


        //return transactionsRepository.getTotalCollectToday();
    }


}
