package org.selenium.pom.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {
    public static <T>T deSerializeJSON(String filename, Class<T> T) throws IOException {
        InputStream inputStream = JacksonUtils.class.getClassLoader().getResourceAsStream(filename);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputStream,T);
    }
}
