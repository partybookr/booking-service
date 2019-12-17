package tech.minkov.bookingservice.data.model;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Meal extends MenuEntry {

    private boolean vegan;
    private boolean allergens;
}
