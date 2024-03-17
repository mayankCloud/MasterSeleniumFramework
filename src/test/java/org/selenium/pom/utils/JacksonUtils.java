package org.selenium.pom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.selenium.pom.objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {
    public static <T>T deSerializeBillingAddress(String filename, Class<T> T) throws IOException {
        InputStream myBillingAddressStream = JacksonUtils.class.getClassLoader().getResourceAsStream(filename);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(myBillingAddressStream,T);
    }
}
