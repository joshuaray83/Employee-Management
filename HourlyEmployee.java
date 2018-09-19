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
// This method is a subclass of Employee that denotes an Hourly Employee

public class HourlyEmployee extends Employee {

    private double wage;
    private double hoursWorked;

// Method Name      : HourlyEmployee
// Parameters       : fn:String, ln:String, m:char, g:char, empNum:int, ft:boolean,
// wage:double
// Return value(s)  : None
// Partners         : N/A
// Description      : HourlyEmployee constructor.
    public HourlyEmployee (String fn, String ln, char m, char g, int empNum, boolean ft, double wage) {

        super(fn, ln, m, g, empNum, ft);
        this.wage = wage;
    }

// Method Name      : increaseHours
// Parameters       : hours:double
// Return value(s)  : None
// Partners         : N/A
// Description      : Method should give ability to increase hours worked. Requesting
// to increase by a negative should give no change and report an error to user.
    public void increaseHours (double hours) {

        if (hours < 0) {
            System.out.println ("Error: cannot add negative hours worked.");
            hoursWorked += 0;
        }
        else {
            hoursWorked += hours;
        }
    }

// Method Name      : toString
// Parameters       : None
// Return value(s)  : String
// Partners         : N/A
// Description      : Override toString. Returns String in HourlyEmployee format.
    @Override
    public String toString () {

        return String.format ("%sWage: %.2f\nHours Worked: %.2f\n", super.toString(), wage, hoursWorked);
    }

// Method Name      : calculateWeeklyPay
// Parameters       : None
// Return value(s)  : double
// Partners         : N/A
// Description      : Return amount earned in week using wage and hoursWorked.
// Any hours worked over 40 gives double pay.
    public double calculateWeeklyPay () {

        double weeklyPay = 0;
        if (hoursWorked <= 40) {
            weeklyPay = wage * hoursWorked;
        }
        else if (hoursWorked > 40) {
            double overtime = hoursWorked - 40;
            weeklyPay = (wage * 40) + (wage * 2 * overtime);
        }
        weeklyPay = Math.floor(100.0 * weeklyPay) / 100.0;
        return weeklyPay;
    }

// Method Name      : annualRaise
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Wage is increased by 5%.
    public void annualRaise () {

        wage = wage * 1.05;
        wage = Math.floor(100.0 * wage) / 100.0;
    }

// Method Name      : holidayBonus
// Parameters       : None
// Return value(s)  : double
// Partners         : N/A
// Description      : Return amount of 40 hours worked (40*wage).
    public double holidayBonus () {

        return wage * 40;
    }

// Method Name      : resetWeek
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Resets hours worked to 0.
    public void resetWeek () {

        hoursWorked = 0;
    }
}
