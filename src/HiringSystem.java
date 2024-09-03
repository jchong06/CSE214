import java.util.Scanner;
/**
 * Name: Justin Chong
 * Student ID: 116143020
 * Recitation Number: R03
 * TA: Veronica Oreshko
 */

/**
 * The class Hiring System provides a console-based interface for managing a hiring table.
 * It allows the user to add, remove, get, print, and refine searches for applicants, as well as
 * manage backups of the hiring table. The program runs in a while loop, displaying a menu and executing
 * commands based on user input until the user chooses to quit.
 *
 * @throws FullTableException if the hiring table is full and cannot add more applicants.
 * @throws ApplicantNotFoundException if an operation targets an applicant that does not exist.
 */
public class HiringSystem {

    /**
     * The main method serves as the entry point of the application.
     * It initializes the hiring table, displays a menu, and processes user commands
     * in a loop until the user chooses to quit the program.
     *
     * @param args command-line arguments (not used).
     * @throws FullTableException if the hiring table is full and cannot add more applicants.
     * @throws ApplicantNotFoundException if an operation targets an applicant that does not exist.
     */
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
                "(B) Backup\n" +
                "(CB) Compare Backup\n" +
                "(RB) Revert Backup\n" +
                "(Q) Quit";
        System.out.println(menu);
        System.out.print("Please enter a command: ");
        String option = input.next().toUpperCase();
        input.nextLine();
        Applicant e = new Applicant(new String[]{"Facebook"}, "Mark Zuck", "3.99", "Harvard", new String[] {"Business Management"});
        Applicant b = new Applicant(new String[]{"Apple", "Google","Two Sigma"}, "Steve Jobs", "3.98", "De Anza College", new String[] {"Ruby On Rails", "Java"});
        Applicant c = new Applicant(new String[]{"Airbnb", "Facebook"}, "Henry White", "2.5", "NYIT", new String[] {"JavaScript"});
        Applicant d = new Applicant(new String[]{"Quora", "Google", "Twitter"}, "Bob Chen", "3.6", "Stony Brook", new String[] {"Java", "C++", "C"});
        h.addApplicant(e);
        h.addApplicant(b);
        h.addApplicant(c);
        h.addApplicant(d);
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
                    String comp = input.nextLine().trim();
                    if (comp.isEmpty()) {
                        break;
                    }
                    tempCompanies[num1] = comp;
                    num1++;
                }
                int num2 = 0;
                String[] tempSkills = new String[3];
                while (num2 < 3) {
                    System.out.print("Enter up to " + (3 - num2) + " Skills: ");
                    String skill = input.nextLine().trim();
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
                Applicant a = new Applicant(companies, name, String.format("%.2f", gpa), college, skills);
                h.addApplicant(a);
                System.out.println("\nApplicant " + name + " has been successfully added to the hiring system\n");
            }
            else if (option.equals("R")) {
                System.out.print("Enter applicant name: ");
                String remove = input.nextLine();
                h.removeApplicant(remove);
                System.out.println("\nApplicant " + remove + " has been successfully removed from the hiring system\n");
            }
            else if (option.equals("G")) {
                System.out.print("Enter Applicant Name: ");
                String name = input.nextLine();
                Applicant a = h.getApplicant(name);
                System.out.println("\nApplicant Name: " + name + "\nApplicant Applying From: " + a.getCompanyName()[0] + "\nApplicant GPA: " + a.getApplicantGPA() + "\nApplicant College: " + a.getApplicantCollege() + "\nApplicant Skills: " + String.join(", ", a.getApplicantSkills()) + "\n");
            }
            else if (option.equals("P")) {
                HiringTable.print(h.getApplicants());
            }
            else if (option.equals("RS")) {
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
                String gpaInput = input.nextLine();
                if (gpaInput.trim().isEmpty()) {
                    gpaInput = null;
                }
                HiringTable.refineSearch(h, company, skill, college, gpaInput);
            }
            else if (option.equals("S")) {
                System.out.println("There are " + h.size() + " applicants in the hiring system.");
            }
            else if (option.equals("B")){
                Object backup = h.clone();
                System.out.println("\nSuccessfully created backup.\n");
            }
            else if (option.equals("CB")){
                boolean comparison = h.compareBackup();
                if (comparison){
                    System.out.println("Current list is the same as the backup copy.");
                }
                else{
                    System.out.println("Current list is not the same as the backup copy.");
                }
            }
            else if (option.equals("RB")){
                h.revertBackup();
                System.out.println("Successfully reverted to the backup copy.");
            }
            System.out.println(menu);
            System.out.print("Please enter a command: ");
            option = input.nextLine().toUpperCase();
        }
        System.out.println("Quitting program...");
    }
}
