import java.util.Arrays;

public class Applicant {
    String[] companyName;
    String applicantName;
    double applicantGPA;
    String applicantCollege;
    String[] applicantSkills;

    public Applicant(String[] companyName, String applicantName, double applicantGPA, String applicantCollege, String[] applicantSkills) {
        this.companyName = companyName;
        this.applicantName = applicantName;
        this.applicantGPA = applicantGPA;
        this.applicantCollege = applicantCollege;
        this.applicantSkills = applicantSkills;
    }

    public String[] getCompanyName(){
        return companyName;
    }

    public void setCompanyName(String[] companyName) {
        this.companyName = companyName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public double getApplicantGPA() {
        return applicantGPA;
    }

    public void setApplicantGPA(double applicantGPA) {
        this.applicantGPA = applicantGPA;
    }

    public String getApplicantCollege() {
        return applicantCollege;
    }

    public void setApplicantCollege(String applicantCollege) {
        this.applicantCollege = applicantCollege;
    }

    public String[] getApplicantSkills() {
        return applicantSkills;
    }

    public void setApplicantSkills(String[] applicantSkills) {
        this.applicantSkills = applicantSkills;
    }

    public Object clone(String[] companyName, String applicantName, double applicantGPA, String applicantCollege, String[] applicantSkills) {
        return new Applicant(companyName, applicantName, applicantGPA, applicantCollege, applicantSkills);
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "companyName=" + Arrays.toString(companyName) +
                ", applicantName='" + applicantName + '\'' +
                ", applicantGPA=" + applicantGPA +
                ", applicantCollege='" + applicantCollege + '\'' +
                ", applicantSkills=" + Arrays.toString(applicantSkills) +
                '}';
    }
}
