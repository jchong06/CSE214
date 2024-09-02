import java.util.Scanner;

public class HiringSystem {
    public static void main(String[] args) throws FullTableException, ApplicantNotFoundException {
        Scanner input = new Scanner(System.in);
        HiringTable h = new HiringTable();
        String[] options = {"A", "R", "G", "P", "RS", "S", "D", "CB", "RB", "Q"};
        String menu = "(A) Add Applicant\n" +
                "(R) Remove Applicant\n" +
                "(G) Get Applicant\n" +
                "(P) Print List\n" +
                "(RS) Refine Search\n" +
                "(S) Size\n" +
                "(D) Backup\n" +
                "(CB) Compare Backup\n" +
                "(RB) Revert Backup\n" +
                "(Q) Quit";
        System.out.println(menu);
        System.out.print("Please enter a command: ");
        String option = input.next().toUpperCase();
        input.nextLine();
//        Applicant b = new Applicant(new String[]{"Google", "Meta"}, "Justin Chong", 3.4, "Harvard", new String[]{"Code", "Talk", "Eat"});
//        h.addApplicant(b);
//        Applicant c = new Applicant(new String[]{"Google", "Yahoo"}, "Ryan Chong", 3.7, "MIT", new String[]{"Code", "Talk", "Sleep"});
//        h.addApplicant(c);
//        Applicant d = new Applicant(new String[]{"Google", "Meta"}, "Jose Chong", 3.4, "Harvard", new String[]{"Core", "Talk"});
//        h.addApplicant(d);
        while (!option.equals("Q")) {
            if (option.equals("A")) {
                System.out.print("Enter Applicant Name: ");
                String name = input.nextLine();
                System.out.print("Enter Applicant GPA: ");
                double gpa = input.nextDouble();
                input.nextLine();
                System.out.print("Enter Applicant College: ");
                String college = input.nextLine();
                int num1 = 0;
                String[] tempCompanies = new String[3];
                while (num1 < 3) {
                    System.out.print("Enter up to " + (3 - num1) + " Companies: ");
                    String comp = input.nextLine();
                    if (comp.trim().isEmpty()) {
                        break;
                    }
                    tempCompanies[num1] = comp;
                    num1++;
                }
                int num2 = 0;
                String[] tempSkills = new String[3];
                while (num2 < 3) {
                    System.out.print("Enter up to " + (3 - num2) + " Skills: ");
                    String skill = input.nextLine();
                    if (skill.isEmpty()) {
                        break;
                    }
                    tempSkills[num2] = skill;
                    num2++;
                }
                String[] companies = new String[0];
                if (num1 > 0) {
                    companies = new String[num1];
                    System.arraycopy(tempCompanies, 0, companies, 0, num1);
                }
                String[] skills = new String[0];
                if (num2 > 0) {
                    skills = new String[num2];
                    System.arraycopy(tempSkills, 0, skills, 0, num2);
                }
                Applicant a = new Applicant(companies, name, gpa, college, skills);
                h.addApplicant(a);
                System.out.println("Applicant " + name + " has been successfully added to the hiring system");
            }
            else if (option.equals("R")){
                System.out.print("Enter applicant name: ");
                String remove = input.nextLine();
                h.removeApplicant(remove);
                System.out.println("Applicant " + remove + " has been successfully removed from the hiring system");
            }
            else if (option.equals("G")){
                System.out.print("Enter Applicant Name: ");
                String name = input.nextLine();
                Applicant a = h.getApplicant(name);
                System.out.println("Applicant Name: " + name + "\nApplicant Applying From: " + a.getCompanyName()[0] + "\nApplicant GPA: " + a.getApplicantGPA() + "\nApplicant College: " + a.getApplicantCollege() + "\nApplicant Skills: " + String.join(", ", a.getApplicantSkills()));
            }
            else if (option.equals("P")) {
                HiringTable.print(h.applicants);
            }
            else if (option.equals("RS")){
                System.out.print("Enter a company to filter for: ");
                String company = input.nextLine();
                if (company.trim().isEmpty()) {
                    company = null;
                }
                System.out.print("Enter a skill to filter for: ");
                String skill = input.nextLine();
                if (skill.trim().isEmpty()) {
                    skill = null;
                }
                System.out.print("Enter a college to filter for: ");
                String college = input.nextLine();
                if (college.trim().isEmpty()) {
                    college= null;
                }
                System.out.print("Enter the minimum GPA to filter for: ");
                double GPA;
                String gpaInput = input.nextLine();
                if (gpaInput.trim().isEmpty()) {
                    GPA = 0;
                }
                else {
                    GPA = Double.parseDouble(gpaInput);
                }
                HiringTable.refineSearch(h, company, skill, college, GPA);
            }
            else if (option.equals("S")){
                System.out.println("There are " + h.size() + " applicants in the hiring system.");
            }
            System.out.println(menu);
            System.out.print("Please enter a command: ");
            option = input.next().toUpperCase();
        }
        System.out.println("Quitting program...");
    }
}
