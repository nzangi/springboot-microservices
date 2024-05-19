package com.nzangi.employeeservice.model;

public record Employee(Long employeeId, Long departmentId,
                       String employeeName,int employeeAge, String employeePosition) {

}
