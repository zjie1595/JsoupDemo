package com.zj.jsoupdemo;

import java.io.IOException;
import java.lang.reflect.Type;

import me.ghui.fruit.Fruit;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class FruitResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Fruit mPicker;
    private final Type mType;

    FruitResponseBodyConverter(Fruit fruit, Type type) {
        mPicker = fruit;
        mType = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            String response = value.string();
            T data = mPicker.fromHtml(response, mType);
            if (data instanceof IBaseWrapper) {
                ((IBaseWrapper) data).setResponse(response);
            }
            return data;
        } finally {
            value.close();
        }
    }
}
