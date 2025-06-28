package com.example;
public class MyService{
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String processData() {
        String data = externalApi.fetchData();
        // Process the data
        return "Processed: " + data;
    }
}