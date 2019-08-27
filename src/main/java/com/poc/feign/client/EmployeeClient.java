package com.poc.feign.client;

import com.poc.feign.resource.EmployeeResource;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface  EmployeeClient {
    @RequestLine("GET /{id}")
    EmployeeResource findById(@Param("id") Long id);

    @RequestLine("GET")
    List<EmployeeResource> findAll();
}
