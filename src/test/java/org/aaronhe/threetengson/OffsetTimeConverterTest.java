package org.aaronhe.threetengson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.OffsetTime;

import static org.junit.Assert.*;

public class OffsetTimeConverterTest {

    Gson gson;

    @Before
    public void init() {
        gson = ThreeTenGsonAdapter.registerOffsetTime(new GsonBuilder()).create();
    }

    @Test
    public void testSerialization() {
        OffsetTime offsetTime = OffsetTime.parse("10:41:26+08:00");

        String json = gson.toJson(offsetTime);

        assertEquals(json, "\"10:41:26+08:00\"");
    }

    @Test
    public void testDeserialization() {
        String json = "\"10:41:26+08:00\"";

        OffsetTime offsetTime = gson.fromJson(json, OffsetTime.class);

        assertEquals(offsetTime, OffsetTime.parse("10:41:26+08:00"));
    }
}
