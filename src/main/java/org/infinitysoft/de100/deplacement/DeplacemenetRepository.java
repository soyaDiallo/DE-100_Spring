package org.infinitysoft.de100.deplacement;

import org.infinitysoft.de100.site.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
@CrossOrigin("*")
public interface DeplacemenetRepository extends JpaRepository<Deplacement,Long> {
    List<Deplacement> findBySite(Optional<Site> site);
}
