package org.aaronhe.threetengson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.threeten.bp.OffsetTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.lang.reflect.Type;

public final class OffsetTimeConverter implements JsonSerializer<OffsetTime>, JsonDeserializer<OffsetTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_TIME;

    public JsonElement serialize(OffsetTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(FORMATTER.format(src));
    }

    @Override
    public OffsetTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
          throws JsonParseException {
        return FORMATTER.parse(json.getAsString(), OffsetTime.FROM);
    }
}
