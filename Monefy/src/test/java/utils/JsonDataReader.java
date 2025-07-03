package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonDataReader {

    public static <T> T readJson(String filePath, Class<T> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(filePath), clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath + ", Error: " + e.getMessage());
        }
    }
}
