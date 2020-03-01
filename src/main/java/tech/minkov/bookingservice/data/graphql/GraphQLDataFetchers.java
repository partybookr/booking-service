package tech.minkov.bookingservice.data.graphql;

import graphql.schema.DataFetcher;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;
import tech.minkov.bookingservice.data.model.Party;
import tech.minkov.bookingservice.data.model.PartyDetails;
import tech.minkov.bookingservice.data.repository.PartyRepository;

@Component
public class GraphQLDataFetchers {

  private final PartyRepository partyRepository;

  public GraphQLDataFetchers(PartyRepository partyRepository) {
    this.partyRepository = partyRepository;
  }

  public DataFetcher<Party> getPartyByIdDataFetcher() {
    return dataFetchingEnvironment -> {
      String partyId = dataFetchingEnvironment.getArgument("id");
      Optional<Party> party = partyRepository.findById(UUID.fromString(partyId));
      return party.orElse(null);
    };
  }

  public DataFetcher<PartyDetails> getPartyDetailsDataFetcher() {
    return dataFetchingEnvironment -> {
      Party party = dataFetchingEnvironment.getSource();
      return party.getDetails();
    };
  }

  public DataFetcher<List<Party>> getPartiesDataFetcher() {
    return dataFetchingEnvironment -> partyRepository.findAll();
  }
}
