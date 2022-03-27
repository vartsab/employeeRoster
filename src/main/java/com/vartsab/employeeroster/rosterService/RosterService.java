package com.vartsab.employeeroster.rosterService;

public interface RosterService {

    String findEmployee ( String firstName, String lastName );

    String addEmployee ( String firstName, String lastName );

    String removeEmployee ( String firstName, String lastName );

}
