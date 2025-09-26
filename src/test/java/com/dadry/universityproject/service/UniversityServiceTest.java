package com.dadry.universityproject.service;

import com.dadry.universityproject.entity.Department;
import com.dadry.universityproject.entity.Lector;
import com.dadry.universityproject.entity.enums.Degree;
import com.dadry.universityproject.repository.DepartmentRepository;
import com.dadry.universityproject.repository.LectorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UniversityServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private LectorRepository lectorRepository;

    @InjectMocks
    private UniversityServiceImpl universityService;

    private Lector assistant;
    private Lector associateProf;
    private Lector professor;
    private Department csDepartment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        assistant = new Lector();
        assistant.setId(1L);
        assistant.setName("Ivan Petrenko");
        assistant.setSalary(1200.0);
        assistant.setDegree(Degree.ASSISTANT);

        associateProf = new Lector();
        associateProf.setId(2L);
        associateProf.setName("Petro Ivanov");
        associateProf.setSalary(2500.0);
        associateProf.setDegree(Degree.ASSOCIATE_PROFESSOR);

        professor = new Lector();
        professor.setId(3L);
        professor.setName("Olena Shevchenko");
        professor.setSalary(4000.0);
        professor.setDegree(Degree.PROFESSOR);

        csDepartment = new Department();
        csDepartment.setId(1L);
        csDepartment.setName("Computer Science");
        csDepartment.setHead(professor);
        csDepartment.setLectors(new HashSet<>(Arrays.asList(assistant, associateProf, professor)));
    }

    @Test
    void testGetHeadOfDepartment() {
        when(departmentRepository.findByName("Computer Science"))
                .thenReturn(Optional.of(csDepartment));

        String result = universityService.getHeadOfDepartment("Computer Science");
        assertEquals("Head of Computer Science department is Olena Shevchenko", result);
    }

    @Test
    void testGetStatistics() {
        when(departmentRepository.findByName("Computer Science"))
                .thenReturn(Optional.of(csDepartment));

        String result = universityService.getStatistics("Computer Science");

        String expected = "assistants - 1\nassociate professors - 1\nprofessors - 1";
        assertEquals(expected, result);
    }

    @Test
    void testGetAverageSalary() {
        when(departmentRepository.findByName("Computer Science"))
                .thenReturn(Optional.of(csDepartment));

        String result = universityService.getAverageSalary("Computer Science");

        String expected = "The average salary of Computer Science is 2566.6666666666665";
        assertEquals(expected, result);
    }

    @Test
    void testGetEmployeeCount() {
        when(departmentRepository.findByName("Computer Science"))
                .thenReturn(Optional.of(csDepartment));

        String result = universityService.getEmployeeCount("Computer Science");
        assertEquals("Employee count: 3", result);
    }

    @Test
    void testGlobalSearch() {
        when(lectorRepository.findByNameContainingIgnoreCase("Ivan"))
                .thenReturn(Arrays.asList(assistant, associateProf));

        String result = universityService.globalSearch("Ivan");
        assertEquals("Ivan Petrenko, Petro Ivanov", result);
    }
}
