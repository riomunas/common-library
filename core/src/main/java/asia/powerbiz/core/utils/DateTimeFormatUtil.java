package asia.powerbiz.core.utils;

import java.time.Instant;
import java.time.temporal.ChronoField;

public class DateTimeFormatUtil {
    public static Instant getInstantNow(){
        Instant instant = Instant.now();
        long epochMili = instant.toEpochMilli();
        if (instant.get(ChronoField.MILLI_OF_SECOND) == 0) epochMili  = epochMili-1;
        return Instant.ofEpochMilli(epochMili);
    }

}
