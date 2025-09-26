package com.dadry.universityproject.service;

public interface UniversityService {
    String getHeadOfDepartment(String departmentName);
    String getStatistics(String departmentName);
    String getAverageSalary(String departmentName);
    String getEmployeeCount(String departmentName);
    String globalSearch(String template);
}

