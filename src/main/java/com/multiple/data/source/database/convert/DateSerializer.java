package com.multiple.data.source.database.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.multiple.data.source.database.helper.RedisHelper;
import org.apache.commons.lang3.time.FastDateFormat;

import java.io.IOException;
import java.util.Date;

public class DateSerializer extends JsonSerializer<Date>{
	private static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance(RedisHelper.DATE_FORMAT);

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeString(DATE_FORMAT.format(date));
    }
}