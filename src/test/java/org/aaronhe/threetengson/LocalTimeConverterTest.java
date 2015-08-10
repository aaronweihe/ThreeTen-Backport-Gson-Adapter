package org.aaronhe.threetengson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.LocalTime;

import static org.junit.Assert.assertEquals;

public class LocalTimeConverterTest {

    Gson gson;

    @Before
    public void init() {
        gson = ThreeTenGsonAdapter.registerLocalTime(new GsonBuilder()).create();
    }

    @Test
    public void testSerialization() {
        LocalTime localTime = LocalTime.parse("10:34:00");

        String json = gson.toJson(localTime);

        assertEquals(json, "\"10:34:00\"");
    }

    @Test
    public void testDeserialization() {
        String json = "\"10:35:00\"";

        LocalTime localTime = gson.fromJson(json, LocalTime.class);

        assertEquals(localTime, LocalTime.parse("10:35:00"));
    }
}
