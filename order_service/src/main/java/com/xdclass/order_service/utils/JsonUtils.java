package com.xdclass.order_service.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Json工具类
 */
public class JsonUtils {


    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * JSON字符串转JsonNode对象的方法
     */
    public static JsonNode str2JsonNode(String str) {
        try {
            return objectMapper.readTree(str);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
