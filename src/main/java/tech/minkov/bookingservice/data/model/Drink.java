package tech.minkov.bookingservice.data.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Drink extends MenuEntry {
  private boolean sugarFree;
  private double alcohol;
}
