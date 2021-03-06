package app.model.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class PriorityConverter implements AttributeConverter<Priority, String> {

    @Override
    public String convertToDatabaseColumn(Priority priority) {
        if (priority == null) {
            return null;
        }
        return priority.name();
    }

    @Override
    public Priority convertToEntityAttribute(String name) {
        if (name == null) {
            return null;
        }
        return Stream.of(Priority.values())
            .filter(p -> p.name().equals(name))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
