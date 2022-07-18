package com.angelalmuenda.dangerpredict;

import com.android.volley.VolleyError;

import org.json.JSONObject;

interface ApiEventListener {

    void onApiSocialIndicatorEvent(JSONObject response);
    void onApiPredictEvent(JSONObject response);
    void onApiErrorEvent(VolleyError error);

}
