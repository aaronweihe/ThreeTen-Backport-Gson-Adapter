package org.aaronhe.threetengson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.ZonedDateTime;

import static org.junit.Assert.*;

public class ZonedDateTimeConverterTest {

    Gson gson;

    @Before
    public void init() {
        gson = ThreeTenGsonAdapter.registerZonedDateTime(new GsonBuilder()).create();
    }

    @Test
    public void testSerialization() {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2010-08-20T10:43:46+08:00[Asia/Shanghai]");

        String json = gson.toJson(zonedDateTime);

        assertEquals(json, "\"2010-08-20T10:43:46+08:00[Asia/Shanghai]\"");
    }

    @Test
    public void testDeserialization() {
        String json = "\"2010-08-20T10:43:46+08:00[Asia/Shanghai]\"";

        ZonedDateTime zonedDateTime = gson.fromJson(json, ZonedDateTime.class);

        assertEquals(zonedDateTime, ZonedDateTime.parse("2010-08-20T10:43:46+08:00[Asia/Shanghai]"));
    }
}
