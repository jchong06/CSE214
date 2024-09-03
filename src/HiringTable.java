import java.util.Arrays;
import java.util.Objects;
/**
 * Name: Justin Chong
 * Student ID: 116143020
 * Recitation Number: R03
 * TA: Veronica Oreshko
 */

/**
 * The Hiring Table class represents a collection of {@code Applicant} objects.
 * It allows adding, removing, searching, refining search results, and printing the list
 * of applicants. The table can store a maximum of 50 applicants, and each applicant can have
 * up to 3 skills and 3 companies associated with them.
 *
 */
public class HiringTable {

    /**
     * An array of {@code Applicant} objects representing the applicants in the hiring table.
     */
    Applicant[] applicants;

    /**
     * The maximum number of skills an applicant can have.
     */
    static final int MAX_SKILLS = 3;

    /**
     * The maximum number of companies an applicant can have worked for.
     */
    static final int MAX_COMPANIES = 3;

    /**
     * The maximum number of applicants the hiring table can store.
     */
    static final int MAX_APPLICANTS = 50;

    /**
     * Constructs a new {@code HiringTable} with an array to hold up to 50 applicants.
     */
    public HiringTable() {
        applicants = new Applicant[MAX_APPLICANTS];
    }

    /**
     * Returns the number of applicants currently stored in the table.
     *
     * @return the number of applicants in the table.
     */
    public int size() {
        for (int i = 0; i < applicants.length; i++) {
            if (applicants[i] == null) {
                return i;
            }
        }
        return applicants.length;
    }

    /**
     * Adds a new applicant to the hiring table.
     *
     * @param newApplicant the {@code Applicant} object to be added.
     * @throws FullTableException if the table is full and no more applicants can be added.
     */
    public void addApplicant(Applicant newApplicant) throws FullTableException {
        if (size() < MAX_APPLICANTS) {
            applicants[size()] = newApplicant;
        }
        else{
            throw new FullTableException("There is no more room in the Hiring Table for new Applicants");
        }
    }

    /**
     * Removes an applicant from the hiring table by their name.
     *
     * @param name the name of the applicant to be removed.
     * @throws ApplicantNotFoundException if no applicant with the given name is found.
     */
    public void removeApplicant(String name) throws ApplicantNotFoundException {
        Applicant a = getApplicant(name);
        boolean check = false;
        int runs = size();
        for (int i = 0; i < runs; i++) {
            if (check) {
                applicants[i - 1] = applicants[i];
                applicants[i] = null;
            }
            if (applicants[i] == a) {
                check = true;
                applicants[i] = null;
            }
        }
    }

    /**
     * Retrieves an applicant from the hiring table by their name.
     *
     * @param name the name of the applicant to retrieve.
     * @return the {@code Applicant} object with the given name.
     * @throws ApplicantNotFoundException if no applicant with the given name is found.
     */
    public Applicant getApplicant(String name) throws ApplicantNotFoundException {
        if (size() > 0){
            for (Applicant a : applicants) {
                if (Objects.equals(a.getApplicantName(), name)) {
                    return a;
                }
            }
        }
        throw new ApplicantNotFoundException("Applicant with the given name was not found");
    }

    /**
     * Filters the list of applicants based on the specified company, skill, college, and GPA.
     * Prints the filtered list of applicants.
     *
     * @param table the {@code HiringTable} object containing the list of applicants.
     * @param company the company to filter by, or {@code null} to skip this filter.
     * @param skill the skill to filter by, or {@code null} to skip this filter.
     * @param college the college to filter by, or {@code null} to skip this filter.
     * @param GPA the minimum GPA to filter by, or {@code null} to skip this filter.
     */
    public static void refineSearch(HiringTable table, String company, String skill, String college, String GPA) {
        Applicant[] result = new Applicant[MAX_APPLICANTS];
        Applicant[] filter = new Applicant[MAX_APPLICANTS];
        int index = 0;
        for (int i = 0; i < filter.length; i++) {
            if (table.applicants[i] == null) {
                break;
            }
            filter[i] = table.applicants[i];
        }
        if (company != null) {
            for (int i = 0; i < table.size(); i++) {
                if (!Arrays.asList(filter[i].getCompanyName()).contains(company)) {
                    filter[i] = null;
                }
            }
        }
        if (skill != null) {
            for (int i = 0; i < filter.length; i++) {
                if ((filter[i] != null) && (!(Arrays.asList(table.applicants[i].getApplicantSkills()).contains(skill)))) {
                    filter[i] = null;
                }
            }
        }
        if (college != null) {
            for (int i = 0; i < filter.length; i++) {
                if ((filter[i] != null) && (!Objects.equals(filter[i].getApplicantCollege(), college))) {
                    filter[i] = null;
                }
            }
        }
        if (GPA != null) {
            for (int i = 0; i < filter.length; i++) {
                if ((filter[i] != null) && (Double.parseDouble(filter[i].getApplicantGPA()) < Double.parseDouble(GPA))) {
                    filter[i] = null;
                }
            }
        }
        for (Applicant applicant : filter) {
            if (applicant != null) {
                result[index] = applicant;
                index++;
            }
        }
        print(result);
    }

    /**
     * Clones the current {@code HiringTable} object. This method creates a shallow copy of the table.
     *
     * @return a clone of the current {@code HiringTable} object.
     * @throws CloneNotSupportedException if cloning is not supported.
     */
    public Object clone() throws CloneNotSupportedException {
        Object a = super.clone();
        return a;
    }

    /**
     * Prints the list of applicants in a formatted manner.
     *
     * @param a an array of {@code Applicant} objects to print.
     */
    public static void print(Applicant[] a) {
        System.out.println("\nCompany                         Name          GPA       College           Skills");
        System.out.println("--------------------------------------------------------------------------------------------------");
        int idx = 0;
        while (a[idx] != null) {
            System.out.println(a[idx]);
            idx++;
        }
        System.out.println("\n");
    }
}
