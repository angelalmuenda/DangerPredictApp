package com.angelalmuenda.dangerpredict;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AssetPropertyReader {

    public static String getPolylinePropertyValue(String key,Context context)
            throws IOException {
        Properties properties = new Properties();;
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("polyline.properties");
        properties.load(inputStream);
        return properties.getProperty(key);
    }

    public static Properties getPolylineProperty(Context context) throws IOException {
        Properties properties = new Properties();;
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("polyline.properties");
        properties.load(inputStream);
        return properties;
    }

    public static String getCityBarangayPropertyValue(String key,Context context)
            throws IOException {
        Properties properties = new Properties();;
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("city_barangay.properties");
        properties.load(inputStream);
        return properties.getProperty(key);
    }

}
