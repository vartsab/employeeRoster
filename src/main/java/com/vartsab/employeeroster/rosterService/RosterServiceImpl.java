package com.vartsab.employeeroster.rosterService;

import com.vartsab.employeeroster.Employee;
import com.vartsab.employeeroster.exceptions.exceptions.BadRequest;
import com.vartsab.employeeroster.exceptions.exceptions.InternalSrvErr;
import com.vartsab.employeeroster.exceptions.exceptions.NotFound;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class RosterServiceImpl implements RosterService {

    private final int maxRosterLen = 3;
    private int rosterLength = 0;
    private final Employee[] employeeRoster = new Employee[maxRosterLen];

    private int searchEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < rosterLength; i++) {
            if (employeeRoster[i].equals(employee))
                return i;
        }
        return -1;
    }

    private String addItem(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        employeeRoster[rosterLength++] = newEmployee;
        return newEmployee.toString();
    }

    private void removeItem(int i) {
        while (i < (--rosterLength)) {
            employeeRoster[i] = employeeRoster[i + 1];
            i++;
        }
        employeeRoster[rosterLength] = null;
    }

    public String findEmployee ( String firstName, String lastName ) {
        int i = searchEmployee(firstName, lastName);
        if ( i == -1) {
            System.out.println("Error 404. Not found.");
            throw new NotFound();
        } else
            return employeeRoster[i].toString();
    }

    public String addEmployee ( String firstName, String lastName ) {
        try {
            findEmployee(firstName, lastName);
        } catch (NotFound e) {
            if ( rosterLength >= maxRosterLen ) {
                System.out.println("Error 500. Roster is full.");
                throw new InternalSrvErr();
            }
            return addItem(firstName, lastName);
        }
        System.out.println("Error 400. Already exists.");
        throw new BadRequest();
    }

    public String removeEmployee ( String firstName, String lastName ) {
        Employee employee = new Employee(firstName, lastName);
        int i = searchEmployee(firstName, lastName);
        removeItem(i);
        return employee.toString();
    }

}
