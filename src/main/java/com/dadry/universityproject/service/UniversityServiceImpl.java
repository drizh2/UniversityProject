package com.dadry.universityproject.service;

import com.dadry.universityproject.entity.Lector;
import com.dadry.universityproject.entity.enums.Degree;
import com.dadry.universityproject.repository.DepartmentRepository;
import com.dadry.universityproject.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    @Override
    public String getHeadOfDepartment(String departmentName) {
        return departmentRepository.findByName(departmentName)
                .map(d -> "Head of " + departmentName + " department is " + d.getHead().getName())
                .orElse("Department not found");
    }

    @Override
    public String getStatistics(String departmentName) {
        return departmentRepository.findByName(departmentName)
                .map(d -> {
                    long assistants = d.getLectors().stream().filter(l -> l.getDegree() == Degree.ASSISTANT).count();
                    long assoc = d.getLectors().stream().filter(l -> l.getDegree() == Degree.ASSOCIATE_PROFESSOR).count();
                    long prof = d.getLectors().stream().filter(l -> l.getDegree() == Degree.PROFESSOR).count();
                    return "assistants - " + assistants + "\nassociate professors - " + assoc + "\nprofessors - " + prof;
                }).orElse("Department not found");
    }

    @Override
    public String getAverageSalary(String departmentName) {
        return departmentRepository.findByName(departmentName)
                .map(d -> {
                    double avg = d.getLectors().stream().mapToDouble(Lector::getSalary).average().orElse(0);
                    return "The average salary of " + departmentName + " is " + avg;
                }).orElse("Department not found");
    }

    @Override
    public String getEmployeeCount(String departmentName) {
        return departmentRepository.findByName(departmentName)
                .map(d -> "Employee count: " + d.getLectors().size())
                .orElse("Department not found");
    }

    @Override
    public String globalSearch(String template) {
        List<Lector> results = lectorRepository.findByNameContainingIgnoreCase(template);
        if (results.isEmpty()) return "No matches found";
        return results.stream().map(Lector::getName).collect(Collectors.joining(", "));
    }
}
