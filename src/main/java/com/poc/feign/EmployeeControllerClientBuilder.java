package com.poc.feign;

import com.poc.feign.client.EmployeeClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;

public class EmployeeControllerClientBuilder {

    private EmployeeClient employeeClient = createClient(EmployeeClient.class, "http://localhost:8080/api/employees");

    private static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(type, uri);
    }

    public EmployeeClient getEmployeeClient() {
        return employeeClient;
    }
}
