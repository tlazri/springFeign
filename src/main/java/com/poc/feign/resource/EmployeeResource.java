package com.poc.feign.resource;

import com.poc.feign.model.Employee;

public class EmployeeResource {
    private Employee employee;

    public EmployeeResource() {
    }

    public EmployeeResource(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeResource{" +
                "employee=" + employee +
                '}';
    }
}
