package org.infinitysoft.de100.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface ClientRepository extends JpaRepository<Client,Long> {
    @RestResource
    public Client findByNom(@Param("nom") String nom);
}
