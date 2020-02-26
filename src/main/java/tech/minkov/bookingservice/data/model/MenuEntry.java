package tech.minkov.bookingservice.data.model;

import java.math.BigDecimal;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import tech.minkov.bookingservice.data.serializers.MoneySerializer;

@MappedSuperclass
@Getter
@Setter
public abstract class MenuEntry extends AuditableEntity {
  private String title;

  @JsonSerialize(using = MoneySerializer.class)
  private BigDecimal price;

  private int quantity;
}
