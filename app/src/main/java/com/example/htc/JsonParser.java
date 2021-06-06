package com.example.htc;

import com.google.gson.Gson;

public class JsonParser {

    private static Gson gson = new Gson();
    private static CompanyView companyView;

    public static CompanyView getCompanyView(String json) {
        companyView = gson.fromJson(json, CompanyView.class);
        return companyView;
    }
}
