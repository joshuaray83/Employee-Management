// Name         : Josh Heyer
// Class        : CSCI 1620-301
// Program #    : 0
// Due Date     : 7/5/2016
//
// Honor Pledge : On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// Name         : Josh Heyer
// NUID         : 59530380
// Email        : jheyer@unomaha.edu
// Partners     : None
//
// This is a base class which other employee type inherit from.

import java.util.Scanner;
public abstract class Employee {

    private String firstName;
    private String lastName;
    private char middleInitial;
    private boolean fulltime;
    private char gender;
    private int employeeNum;

// Method Name      : Employee
// Parameters       : fn:String, ln:String, m:char, g:char, empNum:int, ft:boolean
// Return value(s)  : None
// Partners         : N/A
// Description      : Employee constructor
    public Employee (String fn, String ln, char m, char g, int empNum, boolean ft) {
        
        firstName = fn;
        lastName = ln;
        middleInitial = m;
        gender = g;
        employeeNum = empNum;
        fulltime = ft;
        setGender(g);
    }

// Method Name      : getEmployeeNumber
// Parameters       : None
// Return value(s)  : int
// Partners         : N/A
// Description      : Method takes employee num from user and returns it.
    public int getEmployeeNumber () {

        return employeeNum;
    }

// Method Name      : setEmployeeNumber
// Parameters       : empNum:int
// Return value(s)  : None
// Partners         : N/A
// Description      : Method checks employee number to ensure it is between 10000 and
// 99999. Should ask for another if input is invalid.
    public void setEmployeeNumber (int empNum) {

        Scanner input = new Scanner (System.in);
        while (empNum < 10000 || empNum > 99999) {
            System.out.println ("Employee Number invalid, please re-enter:");
            empNum = input.nextInt();
        }
        employeeNum = empNum;
    }

// Method Name      : getFirstName
// Parameters       : None
// Return value(s)  : String
// Partners         : N/A
// Description      : Returns employee's first name.
    public String getFirstName () {

        return firstName;
    }

// Method Name      : getLastName
// Parameters       : None
// Return value(s)  : String
// Partners         : N/A
// Description      : Returns employee's last name.
    public String getLastName () {

        return lastName;
    }

// Method Name      : setFirstName
// Parameters       : fn:String
// Return value(s)  : None
// Partners         : N/A
// Description      : Sets employee's first name.
    public void setFirstName (String fn) {

        firstName = fn;
    }

// Method Name      : setLastName
// Parameters       : ln:String
// Return value(s)  : None
// Partners         : N/A
// Description      : Sets employee's last name.
    public void getFirstName (String ln) {

        lastName = ln;
    }

// Method Name      : setMiddleI
// Parameters       : m:char
// Return value(s)  : None
// Partners         : N/A
// Description      : Sets employee's middle initial.
    public void setMiddleI (char m) {

        middleInitial = m;
    }

// Method Name      : setGender
// Parameters       : g:char
// Return value(s)  : None
// Partners         : N/A
// Description      : Sets employee's gender. If F/f or M/m are not entered,
// defaults to F.
    public void setGender (char g) {

        if (g == 'M' || g == 'm') {
            gender = 'M';
        }
        else {
            gender = 'F';
        }
    }

// Method Name      : equals
// Parameters       : e2:Object
// Return value(s)  : boolean
// Partners         : N/A
// Description      : Overrides class Object equals method. Returns true if
// employeeNum of the two instances are equal, false otherwise.
    @Override
    public boolean equals (Object e2) {

        if (this.employeeNum == ((Employee)e2).employeeNum) {
            System.out.println ("");
            return true;
        }
        else {
            return false;
        }
    }

// Method Name      : toString
// Parameters       : None
// Return value(s)  : String
// Partners         : N/A
// Description      : Overrides class Object toString method. Returns string of
// employee's information.
    @Override
    public String toString () {

        if (fulltime == true) {
            return employeeNum+"\n" +lastName+ ", " +firstName+ " "
            +middleInitial+ ".\nGender: " +gender+ "\nStatus: Full Time\n";
        }
        else {
            return employeeNum+"\n" +lastName+ ", " +firstName+ " "
            +middleInitial+ ".\nGender: " +gender+ "\nStatus: Part Time\n";
        }
    }
// Method Name      : calculateWeeklyPay
// Parameters       : None
// Return value(s)  : double
// Partners         : N/A
// Description      : Abstract method to be called by subclass.
// Calculates pay for the week.
    public abstract double calculateWeeklyPay();

// Method Name      : annualRaise
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Abstract method to be called by subclass.
// Gives employee a raise.
    public abstract void annualRaise();

// Method Name      : holidayBonus
// Parameters       : None
// Return value(s)  : double
// Partners         : N/A
// Description      : Abstract method to be called by subclass.
// Calculates bonus for Employee.
    public abstract double holidayBonus();

// Method Name      : resetWeek
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Abstract method to be called by subclass.
// Resets weekly values for Employee.
    public abstract void resetWeek();
}

