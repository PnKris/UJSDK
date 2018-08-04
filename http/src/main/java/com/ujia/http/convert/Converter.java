package com.ujia.http.convert;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Converter {
    public <T> T convertModel(String result) {
        Gson gson = new Gson();
        Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return (T) gson.fromJson(result, cls);
    }

    public <T> List<T> convertList(String result) {
        try {
            Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            Gson gson = new Gson();
            List<T> lst = new ArrayList<>();
            JsonArray array = new JsonParser().parse(result).getAsJsonArray();
            for (final JsonElement element : array) {
                lst.add(gson.fromJson(element, cls));
            }
            return lst;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
