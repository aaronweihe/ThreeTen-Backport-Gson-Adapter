package org.aaronhe.threetengson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.LocalDate;

import static org.junit.Assert.assertEquals;

public class LocalDateConverterTest {

    Gson gson;

    @Before
    public void init() {
        gson = ThreeTenGsonAdapter.registerLocalDate(new GsonBuilder()).create();
    }

    @Test
    public void testSerialization() {
        LocalDate localDate = LocalDate.parse("2010-08-20");

        String json = gson.toJson(localDate);

        assertEquals(json, "\"2010-08-20\"");
    }

    @Test
    public void testDeserialization() {
        String json = "\"2010-08-20\"";

        LocalDate localDate = gson.fromJson(json, LocalDate.class);

        assertEquals(localDate, LocalDate.parse("2010-08-20"));
    }
}
