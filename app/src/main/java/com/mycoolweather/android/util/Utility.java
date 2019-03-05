package com.mycoolweather.android.util;

import android.text.TextUtils;

import com.google.gson.JsonArray;
import com.mycoolweather.android.db.City;
import com.mycoolweather.android.db.County;
import com.mycoolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Utility {

    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray list=new JSONArray(response);
                for (int i=0;i<list.length();i++){
                    JSONObject obj=list.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(obj.getString("name"));
                    province.setProvinceCode(obj.getInt("id"));
                    province.save();
                }
                return true;

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }


    public static boolean handleCityResponse(String response,int proviceId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray list=new JSONArray(response);
                for (int i=0;i<list.length();i++){
                    JSONObject obj=list.getJSONObject(i);
                    City city=new City();
                   city.setCityCode(obj.getInt("id"));
                    city.setCityName(obj.getString("name"));
                    city.setProvinceId(proviceId);
                    city.save();
                }
                return true;

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public static boolean handleCountryResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray list=new JSONArray(response);
                for (int i=0;i<list.length();i++){
                    JSONObject obj=list.getJSONObject(i);
                    County county=new County();
                    county.setCountryName(obj.getString("name"));
                    county.setWeatherId(obj.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
