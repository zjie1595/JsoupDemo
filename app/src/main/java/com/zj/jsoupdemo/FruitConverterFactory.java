package com.zj.jsoupdemo;

import androidx.annotation.NonNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import me.ghui.fruit.Fruit;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class FruitConverterFactory extends Converter.Factory {

    private final Fruit mPicker;

    public static FruitConverterFactory create(Fruit fruit) {
        return new FruitConverterFactory(fruit);
    }

    public static FruitConverterFactory create() {
        return new FruitConverterFactory(new Fruit());
    }

    private FruitConverterFactory(Fruit fruit) {
        mPicker = fruit;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(
            @NonNull Type type, @NonNull Annotation[] annotations, @NonNull Retrofit retrofit) {
        return new FruitResponseBodyConverter<>(mPicker, type);
    }

}
