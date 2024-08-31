import java.util.Arrays;

public class Applicant {
    String[] companyName;
    String applicantName;
    double applicantGPA;
    String applicantCollege;
    String[] applicantSkills;

    public Applicant(){

    }

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

    public Object clone() throws CloneNotSupportedException {
        Object a = super.clone();
        return a;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 98; i++){
            if (i == 0){
                result.append(String.join(", ", companyName));
                i += String.join(", ", companyName).length();
            }
            else if (i == 33){
                result.append(applicantName);
                i += applicantName.length();
            }
            else if (i == 48){
                result.append(applicantGPA);
                i += Double.toString(applicantGPA).length();
            }
            else if (i == 59){
                result.append(applicantCollege);
                i += applicantCollege.length();
            }
            else if (i == 76) {
                result.append(String.join(", ", applicantSkills));
                i += String.join(", ", applicantSkills).length();
            }
            else{
                result.append(" ");
            }
        }
        return result.toString();
    }
}
