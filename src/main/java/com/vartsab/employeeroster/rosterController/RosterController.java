package com.vartsab.employeeroster.rosterController;

import com.vartsab.employeeroster.exceptions.exceptions.NotFound;
import com.vartsab.employeeroster.rosterService.RosterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class RosterController {

    private final RosterService rosterService;

    public RosterController(RosterService rosterService) {
        this.rosterService = rosterService;
    }

    @GetMapping("/add")
    String addEmpl(String firstName, String lastName) {
        return rosterService.addEmployee(firstName,lastName);
    }

    @GetMapping("/remove")
    String  rmvEmpl(String firstName, String lastName) {
        return rosterService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    String fndEmpl(String firstName, String lastName) {
        return rosterService.findEmployee(firstName, lastName);
    }

}
