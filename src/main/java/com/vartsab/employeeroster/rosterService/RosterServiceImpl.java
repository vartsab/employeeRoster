package com.vartsab.employeeroster.rosterService;

import com.vartsab.employeeroster.Employee;
import com.vartsab.employeeroster.exceptions.exceptions.BadRequest;
import com.vartsab.employeeroster.exceptions.exceptions.InternalSrvErr;
import com.vartsab.employeeroster.exceptions.exceptions.NotFound;
import org.springframework.stereotype.Service;

@Service
public class RosterServiceImpl implements RosterService {

    private final int maxRosterLen = 3;
    private int rosterLength = 0;
    private Employee[] employeeRoster = new Employee[maxRosterLen];

    public String findEmployee ( String firstName, String lastName ) {
        Employee employee2 = new Employee(firstName, lastName);
        for (int i = 0; i < rosterLength; i++)
            if (employeeRoster[i].equals(employee2))
                return employeeRoster[i].toString();
        System.out.println("Error 404");
        throw new NotFound();
    }

    public String addEmployee ( String firstName, String lastName ) {
        try {
            findEmployee(firstName, lastName);
        } catch (RuntimeException e) {
            if ( rosterLength >= maxRosterLen ) {
                System.out.println("Error 500");
                throw new InternalSrvErr();
            }
            Employee newEmployee = new Employee(firstName, lastName);
            employeeRoster[rosterLength++] = newEmployee;
            return newEmployee.toString();
        }
        System.out.println("Error 400");
        throw new BadRequest();
    }

    public String removeEmployee ( String firstName, String lastName ) {
        Employee employee2 = new Employee(firstName, lastName);
        for (int i = 0; i < rosterLength; i++)
            if (employeeRoster[i].equals(employee2)) {
                while (i < (rosterLength-1)) {
                    employeeRoster[i] = employeeRoster[i + 1];
                    i++;
                }
                employeeRoster[--rosterLength] = null;
                return employee2.toString();
            }
        return employee2 + " not found!";
    }

}
