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
// This class is used to create an array of up to 100 Employees. It will also
// be used to sort, delete, remove duplicates, and list all Employees.

public class EmployeeManager {

    Employee[] employee;
    final int employeeMax = 100;
    int currentEmployees;

// Method Name      : EmployeeManager
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : EmployeeManager constructor.
    public EmployeeManager () {
        
        employee = new Employee[employeeMax];
        currentEmployees = 0;
    }

// Method Name      : addEmployee
// Parameters       : type:int, fn:String, m:char, ln:String, g:char,
// en:int, ft:boolean, amount:double
// Return value(s)  : None
// Partners         : N/A
// Description      : This method adds Employees to the array.
    public void addEmployee (int type, String fn, char m, String ln, char g, int en, boolean ft, double amount) {

        if (currentEmployees < employeeMax) {
            if (type == 1) {
                employee[currentEmployees] = new HourlyEmployee(fn, ln, m, g, en, ft, amount);
            }
            else if (type == 2) {
                employee[currentEmployees] = new SalaryEmployee(fn, ln, m, g, en, ft, amount);
            }
            else if (type == 3) {
                employee[currentEmployees] = new CommissionEmployee(fn, ln, m, g, en, ft, amount);
            }
            currentEmployees += 1;
        }
        else {
            System.out.println ("Maximum number of employees reached. Please delete an employee before adding another.");
        }
    }

// Method Name      : removeEmployee
// Parameters       : index:int
// Return value(s)  : None
// Partners         : N/A
// Description      : Method removes Employees from the array.
    public void removeEmployee (int index) {
        
        for (int x = index; x < currentEmployees; x++) {
            if (x != employeeMax) {
                employee[x] = employee[x + 1];
            }
        }
        employee[employee.length - 1] = null;
        currentEmployees--;
    }

// Method Name      : listAll
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Method lists all current Employees.
    public void listAll () {

        if (currentEmployees > 0) {
            for (int x = 0; x < currentEmployees; x++) {
                System.out.printf ("%s\n", employee[x].toString());
            }
        }
        else {
            System.out.println ("No Employees.");
        }
    }

// Method Name      : listHourly
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Method lists Hourly Employees only. Outputs none if none.
    public void listHourly () {

        int count = 0;
        for (int x = 0; x < currentEmployees; x++) {
            if (employee[x] instanceof HourlyEmployee) {
                System.out.printf ("%s\n", employee[x].toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println ("No Hourly Employees.\n");
        }
    }

// Method Name      : listSalary
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Method lists Salary Employees only. Outputs none if none.
    public void listSalary () {

        int count = 0;
        for (int x = 0; x < currentEmployees; x++) {
            if (employee[x] instanceof SalaryEmployee) {
                System.out.printf ("%s\n", employee[x].toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println ("No Salary Employees.\n");
        }
    }

// Method Name      : listCommission
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Method lists Commission Employees only. Outputs none if none.
    public void listCommission () {

        int count = 0;
        for (int x = 0; x < currentEmployees; x++) {
            if (employee[x] instanceof CommissionEmployee) {
                System.out.printf ("%s\n", employee[x].toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println ("No Commission Employees.\n");
        }
    }

// Method Name      : resetWeek
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Resets week for all Employees.
    public void resetWeek () {

        for (int x = 0; x < currentEmployees; x++) {
            employee[x].resetWeek();
        }
    }

// Method Name      : calculatePayout
// Parameters       : None
// Return value(s)  : double
// Partners         : N/A
// Description      : Method returns total weekly payout for all Employees.
    public double calculatePayout () {
        
        double payout = 0.0;
        for (int x = 0; x < currentEmployees; x++) {
            System.out.printf ("%sPayout Amount: %.2f\n\n", employee[x].toString(), employee[x].calculateWeeklyPay());
            payout += employee[x].calculateWeeklyPay();
        }
        return payout;
    }

// Method Name      : removeRedundancies
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Removes any duplicate employees, keeps Employee that appeared earlier.
    public void removeRedundancies () {

        if (currentEmployees > 1) {
            for (int x = 0; x < currentEmployees - 2; x++) {
                if (employee[x].equals(employee[currentEmployees - 1])) {
                    System.out.printf ("Duplicate employee ID found: %d. Employee %s, %s has not been added.\n", employee[currentEmployees - 1].getEmployeeNumber(), employee[currentEmployees - 1].getLastName(), employee[currentEmployees - 1].getFirstName());
                    employee[currentEmployees - 1] = null;
                    currentEmployees--;
                }
            }
        }
    }

// Method Name      : getIndex
// Parameters       : empNum:int
// Return value(s)  : int
// Partners         : N/A
// Description      : Given an Employee Number, returns index of that Employee.
// Returns -1 if Employee doesn't exist.
    public int getIndex (int empNum) {

        int index = -1;
        boolean t;
        for (int x = 0; x < currentEmployees; x++) {
            if ((employee[x].getEmployeeNumber()) == empNum) {
                index = x;
            }
        }
        return index;
    }

// Method Name      : sortNumber
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Sorts Employees by Employee Number.
    public void sortNumber () {

        Employee temp = employee[0];
        for (int x = 1; x < currentEmployees; x++) {
            for (int y = 0; y < currentEmployees - x; y++) {
                if ((employee[y].getEmployeeNumber()) > (employee[y + 1].getEmployeeNumber())) {
                    temp = employee[y + 1];
                    employee[y + 1] = employee[y];
                    employee[y] = temp;
                }
            }
        }
    }

// Method Name      : sortName
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Sorts Employees by name. Primarily by last name, then first name.
// Ignore middle initial.
    public void sortName () {

        Employee temp = employee[0];
        for (int x = 1; x < currentEmployees; x++) {
            for (int y = 0; y < currentEmployees - x; y++) {
                if((employee[y].getLastName()).compareToIgnoreCase((
                    employee[y + 1].getLastName())) > 0) {
                    temp = employee[y];
                    employee[y] = employee[y + 1];
                    employee[y + 1] = temp;
                }
                else if ((employee[y].getLastName()).compareToIgnoreCase((
                    employee[y + 1].getLastName())) == 0) {
                    if ((employee[y].getFirstName()).compareToIgnoreCase((
                        employee[y + 1].getFirstName())) > 0) {
                        temp = employee[y];
                        employee[y] = employee[y + 1];
                        employee[y + 1] = temp;
                    }
                }
            }
        }
    }

// Method Name      : annualRaises
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Applies annual raise to all current Employees.
    public void annualRaises () {

        for (int x = 0; x < currentEmployees; x++) {
            employee[x].annualRaise();
        }
    }

// Method Name      : holidayBonuses
// Parameters       : None
// Return value(s)  : double
// Partners         : N/A
// Description      : Outputs and returns the total holiday bonus of all Employees.
    public double holidayBonuses () {

        double bonuses = 0.0;
        for (int x = 0; x < currentEmployees; x++) {
            bonuses += employee[x].holidayBonus();
        }
        System.out.printf ("Holiday bonuses: %.2f\n", bonuses);
        return bonuses;
    }

// Method Name      : increaseHours
// Parameters       : index:int, amount:double
// Return value(s)  : None
// Partners         : N/A
// Description      : Increase hours worked of the Employee at given index.
    public void increaseHours (int index, double amount) {
   
        int x = index;
        double hours = amount;
        if (employee[x] instanceof HourlyEmployee) {
            ((HourlyEmployee) employee[x]).increaseHours(hours);
        }
    }

// Method Name      : increaseSales
// Parameters       : index:int, amount:double
// Return value(s)  : None
// Partners         : N/A
// Description      : Increase sales of Employee at given index.
    public void increaseSales (int index, double amount) {

        int x = index;
        double hours = amount;
        if (employee[x] instanceof CommissionEmployee) {
            ((CommissionEmployee) employee[x]).increaseSales(hours);
        }
    }
}
