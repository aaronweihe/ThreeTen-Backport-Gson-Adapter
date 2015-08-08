package com.aaronhe.threetengson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.OffsetDateTime;

import static org.junit.Assert.*;

public class OffsetDateTimeConverterTest {

    Gson gson;

    @Before
    public void init() {
        gson = ThreeTenGsonAdapter.registerOffsetDateTime(new GsonBuilder()).create();
    }

    @Test
    public void testSerialization() {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse("2010-08-20T10:37:50+08:00");

        String json = gson.toJson(offsetDateTime);

        assertEquals(json, "\"2010-08-20T10:37:50+08:00\"");
    }

    @Test
    public void testDeserialization() {
        String json = "\"2010-08-20T10:37:50+08:00\"";

        OffsetDateTime offsetDateTime = gson.fromJson(json, OffsetDateTime.class);

        assertEquals(offsetDateTime, OffsetDateTime.parse("2010-08-20T10:37:50+08:00"));
    }
}
