package tech.minkov.bookingservice.data.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tech.minkov.bookingservice.data.model.Drink;

@RepositoryRestResource
public interface DrinkRepository extends JpaRepository<Drink, UUID> {

}
