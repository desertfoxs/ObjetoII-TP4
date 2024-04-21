package ejercicio2.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatterDayTime {

    private static final String FORMAT = "MM/dd";

    public String toString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(FORMAT));
    }

}
