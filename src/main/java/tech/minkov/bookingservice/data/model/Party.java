package tech.minkov.bookingservice.data.model;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Party extends AuditableEntity {

  @OneToOne
  private PartyDetails details;
  private PartyType type;
  private Instant startTime;
  private Instant endTime;
}
