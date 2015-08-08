package com.aaronhe.threetengson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.*;

import static org.junit.Assert.assertEquals;

public class AdapterTest {

    Gson gson;

    @Before
    public void init() {
        gson = ThreeTenGsonAdapter.registerAll(new GsonBuilder()).create();
    }

    @Test
    public void testSerialization() {
        Data d = new Data();
        d.localDate = LocalDate.parse("2010-08-20");
        d.localTime = LocalTime.parse("10:53:18");
        d.localDateTime = LocalDateTime.of(d.localDate, d.localTime);
        d.offsetDateTime = OffsetDateTime.of(d.localDateTime, ZoneOffset.ofHours(8));
        d.instant = d.offsetDateTime.toInstant();
        d.offsetTime = OffsetTime.of(d.localTime, ZoneOffset.ofHours(8));
        d.zonedDateTime = ZonedDateTime.of(d.localDateTime, ZoneId.of("Asia/Shanghai"));

        String json = gson.toJson(d);

        // Convert serialized json string to a temporary JsonObject for easier assertion.
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class).getAsJsonObject();
        assertEquals(jsonObject.get("localDate").getAsString(), "2010-08-20");
        assertEquals(jsonObject.get("localTime").getAsString(), "10:53:18");
        assertEquals(jsonObject.get("localDateTime").getAsString(), "2010-08-20T10:53:18");
        assertEquals(jsonObject.get("offsetDateTime").getAsString(), "2010-08-20T10:53:18+08:00");
        assertEquals(jsonObject.get("instant").getAsString(), "2010-08-20T02:53:18Z");
        assertEquals(jsonObject.get("offsetTime").getAsString(), "10:53:18+08:00");
        assertEquals(jsonObject.get("zonedDateTime").getAsString(), "2010-08-20T10:53:18+08:00[Asia/Shanghai]");
    }

    @Test
    public void testDeserialization() {
        String json = "{" +
                "    \"localDate\": \"2010-08-20\",\n" +
                "    \"localTime\": \"10:53:18\",\n" +
                "    \"localDateTime\": \"2010-08-20T10:53:18\",\n" +
                "    \"offsetDateTime\": \"2010-08-20T10:53:18+08:00\",\n" +
                "    \"instant\": \"2010-08-20T02:53:18Z\",\n" +
                "    \"offsetTime\": \"10:53:18+08:00\",\n" +
                "    \"zonedDateTime\": \"2010-08-20T10:53:18+08:00[Asia/Shanghai]\"\n" +
                "}";
        Data d = gson.fromJson(json, Data.class);

        assertEquals(d.localDate, LocalDate.parse("2010-08-20"));
        assertEquals(d.localTime, LocalTime.parse("10:53:18"));
        assertEquals(d.localDateTime, LocalDateTime.parse("2010-08-20T10:53:18"));
        assertEquals(d.offsetDateTime, OffsetDateTime.parse("2010-08-20T10:53:18+08:00"));
        assertEquals(d.instant, Instant.parse("2010-08-20T02:53:18Z"));
        assertEquals(d.offsetTime, OffsetTime.parse("10:53:18+08:00"));
        assertEquals(d.zonedDateTime, ZonedDateTime.parse("2010-08-20T10:53:18+08:00[Asia/Shanghai]"));
    }

    private static class Data {
        Instant instant;
        LocalDate localDate;
        LocalDateTime localDateTime;
        LocalTime localTime;
        OffsetDateTime offsetDateTime;
        OffsetTime offsetTime;
        ZonedDateTime zonedDateTime;
    }
}
