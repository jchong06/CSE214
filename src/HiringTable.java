import java.util.Arrays;
import java.util.Objects;

public class HiringTable {
    Applicant[] applicants;
    static final int MAX_SKILLS = 3;
    static final int MAX_COMPANIES = 3;
    static final int MAX_APPLICANTS = 50;

    public HiringTable(){
        applicants = new Applicant[MAX_APPLICANTS];
    }

    public int size(){
        for (int i = 0; i < applicants.length; i++){
            if (applicants[i] == null){
                return i;
            }
        }
        return applicants.length;
    }

    public void addApplicant(Applicant newApplicant) throws FullTableException{
        if (size() < MAX_APPLICANTS){
           applicants[size()] = newApplicant;
        }
    }

    public void removeApplicant(String name) throws ApplicantNotFoundException {

        Applicant a = getApplicant(name);
        boolean check = false;
        int runs = size();
        for (int i = 0; i < runs; i++){
            if (check) {
                applicants[i - 1] = applicants[i];
                applicants[i] = null;
            }
            if (applicants[i] == a){
                check = true;
                applicants[i] = null;
            }
        }
    }

    public Applicant getApplicant(String name) throws ApplicantNotFoundException{
        for (Applicant a : applicants){
            if (Objects.equals(a.getApplicantName(), name)) {
                return a;
            }
        }
        throw new ApplicantNotFoundException();
    }

    public static void refineSearch(HiringTable table, String company, String skill, String college, double GPA){
        Applicant[] result = new Applicant[MAX_APPLICANTS];
        int index = 0;
        for (int i = 0; i < table.applicants.length; i++){
            if (Arrays.asList(table.applicants[i].getCompanyName()).contains(company)){
                if (Arrays.asList(table.applicants[i].getApplicantSkills()).contains(skill)){
                    if (Objects.equals(table.applicants[i].getApplicantCollege(), college)){
                        if (table.applicants[i].getApplicantGPA() >= GPA){
                            result[index] = table.applicants[i];
                            index++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < index; i++){
            System.out.println(result[i]);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        Object a = super.clone();
        return a;
    }

    public void print(Applicant[] a){
        System.out.println("\nCompany                         Name          GPA       College         Skills");
        System.out.println("--------------------------------------------------------------------------------------------------");
        int idx = 0;
        while (a[idx] != null){
            System.out.println(a[idx]);
            idx++;
        }
        System.out.println("\n");
    }

}
