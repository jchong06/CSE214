import java.util.Arrays;
import java.util.Objects;
/**
 * Name: Justin Chong
 * Student ID: 116143020
 * Recitation Number: R03
 * TA: Veronica Oreshko
 */

/**
 * The Hiring Table class represents a collection of Applicant objects.
 * It allows adding, removing, searching, refining search results, and printing the list
 * of applicants. The table can store a maximum of 50 applicants, and each applicant can have
 * up to 3 skills and 3 companies associated with them.
 *
 */
public class HiringTable {

    /**
     * An array of Applicant objects representing the applicants in the hiring table.
     */
    private Applicant[] applicants;
    private int size;
    private HiringTable backup;

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
     * Constructs a new Hiring Table with an array to hold up to 50 applicants.
     */
    public HiringTable() {
        applicants = new Applicant[MAX_APPLICANTS];
        size = 0;
    }

    public Applicant[] getApplicants() {
        return applicants;
    }

    /**
     * Returns the number of applicants currently stored in the table.
     *
     * @return the number of applicants in the table.
     */
    public int size() {
        return size;
    }

    public void setSize(int s){
        size = s;
    }

    /**
     * Adds a new applicant to the hiring table.
     *
     * @param newApplicant the Applicant object to be added.
     * @throws FullTableException if the table is full and no more applicants can be added.
     */
    public void addApplicant(Applicant newApplicant) throws FullTableException {
        if (size() < MAX_APPLICANTS) {
            applicants[size()] = newApplicant;
            size++;
        }
        else{
            throw new FullTableException("Hiring table is full. Cannot add more applicants.");
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
        for (int i = 0; i < size(); i++) {
            if (check) {
                applicants[i - 1] = applicants[i];
                applicants[i] = null;
            }
            if (applicants[i] == a) {
                check = true;
                applicants[i] = null;
            }
        }
        size--;
    }

    /**
     * Retrieves an applicant from the hiring table by their name.
     *
     * @param name the name of the applicant to retrieve.
     * @return the Applicant object with the given name.
     * @throws ApplicantNotFoundException if no applicant with the given name is found.
     */
    public Applicant getApplicant(String name) throws ApplicantNotFoundException {
        if (size() > 0){
            for (int i = 0; i < size(); i++) {
                if (Objects.equals(applicants[i].getApplicantName(), name)) {
                    return applicants[i];
                }
            }
        }
        throw new ApplicantNotFoundException("Applicant with the given name was not found.");
    }

    /**
     * Filters the list of applicants based on the specified company, skill, college, and GPA.
     * Prints the filtered list of applicants.
     *
     * @param table the Hiring Table object containing the list of applicants.
     * @param company the company to filter by, or null to skip this filter.
     * @param skill the skill to filter by, or null to skip this filter.
     * @param college the college to filter by, or null to skip this filter.
     * @param GPA the minimum GPA to filter by, or null to skip this filter.
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
     * Creates a clone of the current HiringTable and stores it as a backup.
     * The backup contains the current list of applicants and the current size of the HiringTable.
     *
     * @return the backup HiringTable object.
     */
    public Object clone() {
        backup = new HiringTable();
        for (int i = 0; i < size(); i++) {
            backup.applicants[i] = applicants[i];
        }
        backup.setSize(size());
        return (Object) backup;
    }

    /**
     * Compares the current HiringTable with the backup table to determine if they are identical.
     * Checks if the number of applicants and the applicants themselves are the same in both the current and backup tables.
     *
     * @return true if the current HiringTable is identical to the backup, false otherwise.
     */
    public boolean compareBackup() {
        if (backup.size() != size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (applicants[i] == null) {
                return false;
            }
            if (!(applicants[i].equals(backup.applicants[i]))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Reverts the current HiringTable to the state stored in the backup.
     * Restores the list of applicants and the size of the table from the backup.
     * If the backup is smaller than the current table, extra entries are removed.
     */
    public void revertBackup() {
        int s = Math.max(backup.size, size());
        for (int i = 0; i < s; i++) {
            if (i < backup.size) {
                applicants[i] = backup.applicants[i];
            } else {
                applicants[i] = null;
            }
        }
        setSize(backup.size);
    }

    /**
     * Prints the list of applicants in a formatted manner.
     *
     * @param a an array of Applicant objects to print.
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
