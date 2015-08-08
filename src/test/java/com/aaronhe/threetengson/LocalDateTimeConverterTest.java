package com.aaronhe.threetengson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.LocalDateTime;

import static org.junit.Assert.*;

public class LocalDateTimeConverterTest {

    Gson gson;

    @Before
    public void init() {
        gson = ThreeTenGsonAdapter.registerLocalDateTime(new GsonBuilder()).create();
    }

    @Test
    public void testSerialization() {
        LocalDateTime localDateTime = LocalDateTime.parse("2010-08-20T12:00:00");

        String json = gson.toJson(localDateTime);
        
        assertEquals(json, "\"2010-08-20T12:00:00\"");
    }

    @Test
    public void testDeserialization() {
        String json = "\"2010-08-20T12:00:00\"";

        LocalDateTime localDateTime = gson.fromJson(json, LocalDateTime.class);

        assertEquals(localDateTime, LocalDateTime.parse("2010-08-20T12:00:00"));
    }

}
