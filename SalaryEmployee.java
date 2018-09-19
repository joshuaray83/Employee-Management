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
// This class is a subclass of Employee and denotes a Salary Employee.

public class SalaryEmployee extends Employee {

    private double salary;

// Method Name      : SalaryEmployee
// Parameters       : fn:String, ln:String, m:char, g:char, empNum:int, ft:boolean
// salary:double
// Return value(s)  : None
// Partners         : N/A
// Description      : This is SalaryEmployee's constructor
    public SalaryEmployee (String fn, String ln, char m, char g, int empNum, boolean ft, double salary) {

        super(fn, ln, m, g, empNum, ft);
        this.salary = salary;
    }

// Method Name      : toString
// Parameters       : None
// Return value(s)  : String
// Partners         : N/A
// Description      : Override toString. Returns String of SalaryEmployee.
    @Override
    public String toString () {

        return String.format ("%sSalary: %.2f\n", super.toString(), salary);
    }

// Method Name      : calculateWeeklyPay
// Parameters       : None
// Return value(s)  : double
// Partners         : N/A
// Description      : Return amount earned in week by dividing salary by 52.
    public double calculateWeeklyPay () {
        double weeklyPay = salary / 52.00;
        weeklyPay = Math.floor(100.0 * weeklyPay) / 100.0;
        return weeklyPay;
    }

// Method Name      : annualRaise
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Salary is increased by 6%.
    public void annualRaise () {

        salary = salary * 1.06;
        salary = Math.floor(100.0 * salary) / 100.0;
    }

// Method Name      : holidayBonus
// Parameters       : None
// Return value(s)  : double
// Partners         : N/A
// Description      : Return 3% of salary.
    public double holidayBonus () {

        double bonus = salary * 0.03;
        bonus = Math.floor(100.0 * bonus) / 100.0;
        return bonus;
    }

// Method Name      : resetWeek
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : No change
    public void resetWeek () {

    }
}
