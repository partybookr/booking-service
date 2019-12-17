package tech.minkov.bookingservice.data.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.math.BigDecimal;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.minkov.bookingservice.data.serializers.MoneySerializer;

@MappedSuperclass
@Getter
@Setter
@ToString
public abstract class MenuEntry extends BaseEntity {

    private String title;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal price;
    private int quantity;
}
