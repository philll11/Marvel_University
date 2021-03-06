//=================================================================================
/**
 * A class representing a Professor
 */
public final class Prof extends SalaryEmp {
	private int mDaysLeave; ///< Number of unpaid leave days.
	private final int mTax = 28; 	///< Percent deductions from salary.
	/**
	  * Default Constructor
	  * Initializes an Prof object and sets data members
	  */
	public Prof() { 
		super("NO_PR", "NO_PR", "PR00-0000-000", 0.0);
		this.mDaysLeave = 0;
	}
	/**
	  * Constructor
	  * Initializes an Prof object and sets data members
	  * @param[in] _mFName 		Employee first name
	  * @param[in] _mGName		Employee second name
	  * @param[in] _mIRD			Employee IRD number
	  * @param[in] _mAPay		SalaryEmp annual pay 
	  * @param[in] _mDaysLeave	Prof unpaid leave days
	  */
	public Prof(String _mFName, String _mGName, String _mIRD, double _mAPay, int _mDaysLeave) {
		super(_mFName, _mGName, _mIRD, _mAPay);
		this.mDaysLeave = _mDaysLeave;
	}	
	/**
	  * Returns mDaysLeave 
	  * @return mDaysLeave
	  */
	public int getMDaysLeave() { return mDaysLeave; };
	/**
	  * Mutates mDaysLeave
	  * @param[in] _mDaysLeave Assigns mDaysLeave with the value _mDaysLeave
	  */
	public void setMDaysLeave(int _mDaysLeave) { mDaysLeave = _mDaysLeave; }
	/**
	  * Converts Employee data members to strings and sets a format for display
	  * @return formatted and concatenated string
	  */
	@Override
	public String toString(){
		return super.toString() + String.format("$%-20s", getNetMonthlyPay());
	}
	/**
	  * Calculates the monthly net wages for the Prof object less leave days
	  * and tax deducted
	  * @return total monthly net wages
	  */
	@Override
	public double getNetMonthlyPay() {
		double totalMonthlyLeaveDeductions = (super.getMAPay() / 365.0) * this.getMDaysLeave();	
		double monthlySalaryLessLeave = (super.getMAPay() / 12) - totalMonthlyLeaveDeductions;
		return (double)(Math.round((monthlySalaryLessLeave - (monthlySalaryLessLeave * (mTax / 100.0))) * 100d) / 100d);
	}
	
}