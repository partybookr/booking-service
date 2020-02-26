package tech.minkov.bookingservice.data.serializers;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MoneySerializer extends JsonSerializer<BigDecimal> {
  @Override
  public void serialize(BigDecimal value, JsonGenerator generator, SerializerProvider provider)
    throws IOException {
    generator.writeString(value.setScale(2, RoundingMode.HALF_UP).toString());
  }
}
