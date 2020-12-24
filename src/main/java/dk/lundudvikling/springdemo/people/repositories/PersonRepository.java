package dk.lundudvikling.springdemo.people.repositories;

import dk.lundudvikling.springdemo.people.models.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person, Long> {

}
