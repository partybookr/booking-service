package tech.minkov.bookingservice.data.seed;

import java.time.Instant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.minkov.bookingservice.data.model.Party;
import tech.minkov.bookingservice.data.model.PartyDetails;
import tech.minkov.bookingservice.data.model.PartyType;
import tech.minkov.bookingservice.data.repository.PartyDetailsRepository;
import tech.minkov.bookingservice.data.repository.PartyRepository;

@Component
public class DataSeeder implements CommandLineRunner {

  private PartyRepository partyRepository;
  private PartyDetailsRepository partyDetailsRepository;

  public DataSeeder(PartyRepository partyRepository,
    PartyDetailsRepository partyDetailsRepository) {
    this.partyRepository = partyRepository;
    this.partyDetailsRepository = partyDetailsRepository;
  }

  @Override
  public void run(String... args) {
    if (partyRepository.count() == 0) {
      var party = new Party();
      party.setType(PartyType.NEON);
      var start = Instant.parse("2020-03-05T13:00:00Z");
      party.setStartTime(start);
      party.setEndTime(start.plusSeconds(7200L));
      var details = new PartyDetails();
      partyDetailsRepository.save(details);
      party.setDetails(details);
      partyRepository.save(party);
    }
  }
}
