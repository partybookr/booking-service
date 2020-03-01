package tech.minkov.bookingservice.data.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.minkov.bookingservice.data.model.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, UUID> {

}
