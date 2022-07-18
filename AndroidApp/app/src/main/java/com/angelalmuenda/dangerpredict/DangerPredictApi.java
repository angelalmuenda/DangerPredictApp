package com.angelalmuenda.dangerpredict;

import android.util.ArrayMap;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class DangerPredictApi {

    private static String baseURL = "https://dangerpredict.appspot.com/";

    private ApiEventListener mApiListener;

    public void registerApiEventListener(ApiEventListener mApiListener)
    {
        this.mApiListener = mApiListener;
    }

    void getSocialIndicators(ArrayMap<String,String> data) {
        RequestQueue requstQueue = Volley.newRequestQueue((Context) mApiListener);
        String url = baseURL.concat("api/social_indicators");

        JsonObjectRequest jsonobj = new JsonObjectRequest(
                Request.Method.POST,
                url,
                new JSONObject(data),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        mApiListener.onApiSocialIndicatorEvent(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mApiListener.onApiErrorEvent(error);
                    }
                }
        );

        requstQueue.add(jsonobj);
    }

    void getPredictions(ArrayMap<String,String> data) {
        RequestQueue requstQueue = Volley.newRequestQueue((Context) mApiListener);
        String url = baseURL.concat("api/predict");

        JsonObjectRequest jsonobj = new JsonObjectRequest(
                Request.Method.POST,
                url,
                new JSONObject(data),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        mApiListener.onApiPredictEvent(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mApiListener.onApiErrorEvent(error);
                    }
                }
        );

        requstQueue.add(jsonobj);
    }

}
