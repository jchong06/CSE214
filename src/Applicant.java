import java.util.Arrays;
/**
 * Name: Justin Chong
 * Student ID: 116143020
 * Recitation Number: R03
 * TA: Veronica Oreshko
 */

/**
 * The Applicant class represents an individual applying for a position.
 * It contains information about the applicant's name, GPA, college, companies they have worked for,
 * and their skills. This class provides getters and setters for each field, as well as methods to clone
 * the object, check for equality, and convert the applicant's information to a formatted string.
 */
public class Applicant {
    /**
     * An array of company names where the applicant has worked.
     */
    private String[] companyName;

    /**
     * The name of the applicant.
     */
    private String applicantName;

    /**
     * The GPA of the applicant, represented as a string.
     */
    private String applicantGPA;

    /**
     * The name of the college the applicant attended.
     */
    private String applicantCollege;

    /**
     * An array of skills the applicant possesses.
     */
    private String[] applicantSkills;

    /**
     * Constructs an Applicant object with default values.
     */
    public Applicant() {
    }

    /**
     * Constructs an Applicant object with the specified details.
     *
     * @param companyName      the list of companies where the applicant has worked.
     * @param applicantName    the name of the applicant.
     * @param applicantGPA     the GPA of the applicant.
     * @param applicantCollege the college the applicant attended.
     * @param applicantSkills  the list of skills the applicant possesses.
     */
    public Applicant(String[] companyName, String applicantName, String applicantGPA, String applicantCollege, String[] applicantSkills) {
        this.companyName = companyName;
        this.applicantName = applicantName;
        this.applicantGPA = applicantGPA;
        this.applicantCollege = applicantCollege;
        this.applicantSkills = applicantSkills;
    }

    /**
     * Returns the list of companies where the applicant has worked.
     *
     * @return an array of company names.
     */
    public String[] getCompanyName() {
        return companyName;
    }

    /**
     * Sets the list of companies where the applicant has worked.
     *
     * @param companyName an array of company names.
     */
    public void setCompanyName(String[] companyName) {
        this.companyName = companyName;
    }

    /**
     * Returns the name of the applicant.
     *
     * @return the applicant's name.
     */
    public String getApplicantName() {
        return applicantName;
    }

    /**
     * Sets the name of the applicant.
     *
     * @param applicantName the name of the applicant.
     */
    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    /**
     * Returns the GPA of the applicant.
     *
     * @return the applicant's GPA as a string.
     */
    public String getApplicantGPA() {
        return applicantGPA;
    }

    /**
     * Sets the GPA of the applicant.
     *
     * @param applicantGPA the GPA of the applicant as a string.
     */
    public void setApplicantGPA(String applicantGPA) {
        this.applicantGPA = applicantGPA;
    }

    /**
     * Returns the college attended by the applicant.
     *
     * @return the name of the college.
     */
    public String getApplicantCollege() {
        return applicantCollege;
    }

    /**
     * Sets the college attended by the applicant.
     *
     * @param applicantCollege the name of the college.
     */
    public void setApplicantCollege(String applicantCollege) {
        this.applicantCollege = applicantCollege;
    }

    /**
     * Returns the list of skills the applicant possesses.
     *
     * @return an array of skills.
     */
    public String[] getApplicantSkills() {
        return applicantSkills;
    }

    /**
     * Sets the list of skills the applicant possesses.
     *
     * @param applicantSkills an array of skills.
     */
    public void setApplicantSkills(String[] applicantSkills) {
        this.applicantSkills = applicantSkills;
    }

    public Object clone() {
        Applicant a = new Applicant();
        a.setApplicantName(getApplicantName());
        a.setApplicantGPA(getApplicantGPA());
        a.setApplicantCollege(getApplicantCollege());
        a.setApplicantSkills(getApplicantSkills());
        a.setCompanyName(getCompanyName());
        return (Object) a;
    }

    /**
     * Compares this Applicant object to another object for equality.
     *
     * @param obj the object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Applicant){
            Applicant a = (Applicant) obj;
            return this.applicantName.equals(a.applicantName) && this.applicantCollege.equals(a.applicantCollege) && this.applicantGPA.equals(a.applicantGPA) && this.applicantSkills.equals(a.applicantSkills) && this.companyName.equals(a.companyName);
        }
        return false;
    }

    /**
     * Returns a formatted string representing the applicant's information, including
     * the companies, name, GPA, college, and skills.
     *
     * @return a string representing the applicant's information.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 98; i++) {
            if (i == 0) {
                result.append(String.join(", ", companyName));
                i += String.join(", ", companyName).length();
            } else if (i == 33) {
                result.append(applicantName);
                i += applicantName.length();
            } else if (i == 48) {
                result.append(applicantGPA);
                i += applicantGPA.length();
            } else if (i == 59) {
                result.append(applicantCollege);
                i += applicantCollege.length();
            } else if (i == 78) {
                result.append(String.join(", ", applicantSkills));
                i += String.join(", ", applicantSkills).length();
            } else {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
