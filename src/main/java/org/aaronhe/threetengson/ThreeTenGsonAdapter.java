package org.aaronhe.threetengson;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.OffsetTime;
import org.threeten.bp.ZonedDateTime;

import java.lang.reflect.Type;

/**
 * {@code ThreeTenGsonAdapter} contains static methods for registering ThreeTen BP type on GsonBuilder.
 */
public class ThreeTenGsonAdapter {

    private ThreeTenGsonAdapter() {
    }


    public static GsonBuilder registerInstant(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(Instant.class, new InstantConverter());
    }

    public static GsonBuilder registerLocalDate(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateConverter());
    }

    public static GsonBuilder registerLocalDateTime(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeConverter());
    }

    public static GsonBuilder registerLocalTime(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(LocalTime.class, new LocalTimeConverter());
    }

    public static GsonBuilder registerOffsetDateTime(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeConverter());
    }

    public static GsonBuilder registerOffsetTime(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(OffsetTime.class, new OffsetTimeConverter());
    }

    public static GsonBuilder registerZonedDateTime(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeConverter());
    }

    /**
     * A convenient method to register all supported ThreeTen BP types.
     * @param gsonBuilder a GsonBuilder to be registered.
     * @return a GsonBuilder knows how to de/serialize all supported ThreeTen BP types.
     */
    public static GsonBuilder registerAll(GsonBuilder gsonBuilder) {
        registerInstant(gsonBuilder);
        registerLocalDate(gsonBuilder);
        registerLocalDateTime(gsonBuilder);
        registerLocalTime(gsonBuilder);
        registerLocalDate(gsonBuilder);
        registerOffsetDateTime(gsonBuilder);
        registerOffsetTime(gsonBuilder);
        registerZonedDateTime(gsonBuilder);

        return gsonBuilder;
    }

}
