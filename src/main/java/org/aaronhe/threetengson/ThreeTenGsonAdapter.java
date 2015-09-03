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

    private static final Type INSTANT_TYPE_TOKEN = new TypeToken<Instant>() {}.getType();

    private static final Type LOCAL_DATE_TYPE = new TypeToken<LocalDate>() {}.getType();

    private static final Type LOCAL_DATE_TIME_TYPE = new TypeToken<LocalDateTime>() {}.getType();

    private static final Type LOCAL_TIME_TYPE = new TypeToken<LocalTime>(){}.getType();

    private static final Type OFFSET_DATE_TIME_TYPE = new TypeToken<OffsetDateTime>() {}.getType();

    private static final Type OFFSET_TIME_TYPE = new TypeToken<OffsetTime>() {}.getType();

    private static final Type ZONED_DATE_TIME_TYPE = new TypeToken<ZonedDateTime>() {}.getType();


    public static GsonBuilder registerInstant(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(INSTANT_TYPE_TOKEN, new InstantConverter());
    }

    public static GsonBuilder registerLocalDate(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(LOCAL_DATE_TYPE, new LocalDateConverter());
    }

    public static GsonBuilder registerLocalDateTime(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(LOCAL_DATE_TIME_TYPE, new LocalDateTimeConverter());
    }

    public static GsonBuilder registerLocalTime(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(LOCAL_TIME_TYPE, new LocalTimeConverter());
    }

    public static GsonBuilder registerOffsetDateTime(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(OFFSET_DATE_TIME_TYPE, new OffsetDateTimeConverter());
    }

    public static GsonBuilder registerOffsetTime(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(OFFSET_TIME_TYPE, new OffsetTimeConverter());
    }

    public static GsonBuilder registerZonedDateTime(GsonBuilder gsonBuilder) {
        return gsonBuilder.registerTypeAdapter(ZONED_DATE_TIME_TYPE, new ZonedDateTimeConverter());
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
