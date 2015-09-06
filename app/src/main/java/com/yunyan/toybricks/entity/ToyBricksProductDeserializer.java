package com.yunyan.toybricks.entity;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by George on 2015/9/6.
 */
public class ToyBricksProductDeserializer implements JsonDeserializer<ToyBricksProduct>{
    @Override
    public ToyBricksProduct deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ToyBricksProduct product=new ToyBricksProduct();
        Log.e(ToyBricksProductDeserializer.class.getSimpleName(),json.toString());
        JsonObject object=json.getAsJsonObject();
        product.setId(object.get("id").getAsInt());
        product.setQr_name(object.get("qr_name").getAsString());
        product.setVersion_model(object.get("version_model").getAsString());
        product.setUrl_zip(object.get("url_zip").getAsString());
        product.setUrl_icon(object.get("url_icon").getAsString());
        product.setContent(object.get("content").getAsString());
        return product;
    }
}
