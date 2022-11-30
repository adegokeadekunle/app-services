package com.example.appservice.app;

public enum AppServicesEnum {
    LOGIN_SERVICE("https://www.blacklist.com"),
    REPORT_SERVICE("http://localhost:8000/api/v1/reports/get-all");



    private final String service;
    AppServicesEnum(String service){
        this.service = service;
    }

    public String getService() {
        return service;
    }
}


//    CLIENT_AUDIT("https://www.blacklist.com"),
//    LOGIN_SERVICE("https://www.blacklist.com"),
//    SETTING_SERVICE("https://www.blacklist.com"),
//    DEVICE_MANAGER("https://www.blacklist.com"),
//    USER_SERVICE("https://www.blacklist.com"),
//    NOTIFICATION_SERVICE("https://www.blacklist.com"),
//    REPORT_SERVICE("https://www.blacklist.com"),
//    TAGGING_SERVICE("https://www.blacklist.com");