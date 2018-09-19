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
// This class is a subclass of Employee that denotes a Commission Employee.

public class CommissionEmployee extends Employee {

        private double sales;
        private double rate;


// Method Name      : CommissionEmployee
// Parameters       : fn:String, ln:String, m:char, g:char, empNum:int,
// ft:boolean, rate:double
// Return value(s)  : None
// Partners         : N/A
// Description      : CommissionEmployee constructor.
    public CommissionEmployee (String fn, String ln, char m, char g, int empNum, boolean ft, double rate) {

        super (fn, ln, m, g, empNum, ft);
        this.rate = rate;
    }

// Method Name      : increaseSales
// Parameters       : sales:double
// Return value(s)  : None
// Partners         : N/A
// Description      : Increases sales. Requesting to increase by a negative
// value should give no change and report an error.
    public void increaseSales (double sales) {

        if (sales < 0) {
            System.out.println ("Error: cannot enter negative value for sales.");
            this.sales += 0;
        }
        else {
            this.sales += sales;
        }
    }

// Method Name      : toString
// Parameters       : None
// Return value(s)  : String
// Partners         : N/A
// Description      : Overrides toString. Returns string of CommissionEmployee.
    public String toString () {

        return String.format ("%sRate: %.2f\nSales: %.2f\n", super.toString(), rate, sales);
    }

// Method Name      : calculateWeeklyPay
// Parameters       : None
// Return value(s)  : double
// Partners         : N/A
// Description      : Return rate percentage of sales.
    public double calculateWeeklyPay () {

        double weeklyPay = rate * sales / 100;
        weeklyPay = Math.floor(100.0 * weeklyPay) / 100.0;
        return weeklyPay;
                                                            }

// Method Name      : annualRaise
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Rate percentage increase by .2% (ie. 2.5 to 2.7).
    public void annualRaise () {

        rate += 0.2;
    }

// Method Name      : holidayBonus
// Parameters       : None
// Return value(s)  : double
// Partners         : N/A
// Description      : No bonus
    public double holidayBonus () {

        double bonus = 0;
        return bonus;
    }

// Method Name      : resetWeek
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Resets sales to 0.0.
    public void resetWeek () {

        sales = 0;
    }
}
