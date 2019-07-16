package com.xz.demo.config.general;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class JacksonConfig {

    public static class Deserializer extends JsonDeserializer<String> {
        @Override
        public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            if (p.hasToken(JsonToken.VALUE_STRING)) {
                String text = p.getText();
                if("".equals(text)){
                    return null;
                }
                return text;
            }
            JsonToken t = p.getCurrentToken();
            if (t == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object ob = p.getEmbeddedObject();
                if (ob == null) {
                    return null;
                }
                if (ob instanceof byte[]) {
                    return ctxt.getBase64Variant().encode((byte[]) ob, false);
                }
                // otherwise, try conversion using toString()...
                return ob.toString();
            }
            // allow coercions for other scalar types
            // 17-Jan-2018, tatu: Related to [databind#1853] avoid FIELD_NAME by ensuring it's
            //   "real" scalar
            if (t.isScalarValue()) {
                String text = p.getValueAsString();
                if (text != null) {
                    return text;
                }
            }
            return (String) ctxt.handleUnexpectedToken(Object.class, p);
        }
    }
}
