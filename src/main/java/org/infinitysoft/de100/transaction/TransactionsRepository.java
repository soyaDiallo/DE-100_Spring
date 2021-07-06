package org.infinitysoft.de100.transaction;

import org.infinitysoft.de100.machine.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findByMachine(Machine machine);
//    @Query(("SELECT SUM(m.montant) FROM Transactions m where type='deposit'"))
//    float getTotalDeposit();
//    @Query(("SELECT SUM(m.montant) FROM Transactions m where type='manuel'"))
//    float getTotalManuel();
//    @Query(("SELECT SUM(m.montant) FROM Transactions m where type='collect'"))
//    float getTotalCollect();
//    @Query(("SELECT SUM(m.montant) FROM Transactions m where type='deposit' and date_transaction=FORMAT (getdate(), 'yyyy/MM/dd '"))
//    float getTotalDepositToday();
//    @Query(("SELECT SUM(m.montant) FROM Transactions m where type='manuel' and date_transaction=FORMAT (getdate(), 'yyyy/MM/dd '"))
//    float getTotalManuelToday();
//    @Query(("SELECT SUM(m.montant) FROM Transactions m where type='collect' and date_transaction=FORMAT (getdate(), 'yyyy/MM/dd '"))
//    float getTotalCollectToday();

}