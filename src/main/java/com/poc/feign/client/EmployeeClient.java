package com.poc.feign.client;

import com.poc.feign.model.Employee;
import com.poc.feign.resource.EmployeeResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface  EmployeeClient {
    @RequestLine("GET /{id}")
    EmployeeResource findById(@Param("id") Long id);

    @RequestLine("GET /name/{name}")
    EmployeeResource findByName(@Param("name") String name);

    @RequestLine("GET")
    List<EmployeeResource> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(Employee employee);
}
