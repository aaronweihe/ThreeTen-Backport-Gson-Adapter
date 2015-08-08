package com.aaronhe.threetengson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.Instant;

import static org.junit.Assert.assertEquals;

public class InstantConverterTest {

    Gson gson;

    @Before
    public void init() {
        gson = ThreeTenGsonAdapter.registerInstant(new GsonBuilder()).create();
    }

    @Test
    public void testSerialization() {
        Instant instant = Instant.parse("2010-08-20T00:01:00Z");

        String json = gson.toJson(instant);

        assertEquals(json, "\"2010-08-20T00:01:00Z\"");
    }

    @Test
    public void testDeserialization() {
        String json = "\"2010-08-20T00:01:00Z\"";

        Instant instant = gson.fromJson(json, Instant.class);

        assertEquals(instant, Instant.parse("2010-08-20T00:01:00Z"));
    }
}
