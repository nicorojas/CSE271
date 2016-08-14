// Nico Rojas
// CSE 271, Project 1
// 3.10.16

import java.text.ParseException;
import java.util.GregorianCalendar;

public class Appointment {

	private String description;
    private GregorianCalendar date;

    /**
     * @param description
     * @param year
     * @param month
     * @param day
     * @throws ParseException
     */
    public Appointment(String description, int year, int month, int day) throws ParseException {
        this.description = description;
        
        GregorianCalendar date = new GregorianCalendar();
        date.set(year, month, day);
    }
    
    /**
     * @param year
     * @param month
     * @param day
     * @return
     * @throws ParseException
     */
    public boolean occursOn(int year, int month, int day) throws ParseException {
    	
    	GregorianCalendar checkDate = new GregorianCalendar();
    	checkDate.set(year, month, day);

        return checkDate.equals(this.date);
    }

	/**
	 * @return the date
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Appointment [description=" + description + ", date=" + date + "]";
	}
}