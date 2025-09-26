package com.dadry.universityproject.console;

import com.dadry.universityproject.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class ConsoleRunner implements CommandLineRunner {

    private final UniversityService service;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("University console app is running. Type your command:");

        while (true) {
            System.out.println("Type your command:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Bye!");
                break;
            }

            if (input.startsWith("Who is head of department")) {
                String dept = input.replace("Who is head of department ", "");
                System.out.println(service.getHeadOfDepartment(dept));
            } else if (input.startsWith("Show") && input.contains("statistics")) {
                String dept = input.replace("Show ", "").replace(" statistics", "");
                System.out.println(service.getStatistics(dept));
            } else if (input.startsWith("Show the average salary for the department")) {
                String dept = input.replace("Show the average salary for the department ", "");
                System.out.println(service.getAverageSalary(dept));
            } else if (input.startsWith("Show count of employee for")) {
                String dept = input.replace("Show count of employee for ", "");
                System.out.println(service.getEmployeeCount(dept));
            } else if (input.startsWith("Global search by")) {
                String template = input.replace("Global search by ", "");
                System.out.println(service.globalSearch(template));
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}