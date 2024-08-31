import java.util.Arrays;
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
        input.nextLine();  // Consume the leftover newline character after the option input
        Applicant b = new Applicant(new String[]{"Google", "Meta"}, "Justin Chong", 3.4, "Harvard", new String[]{"Code", "Talk"});
        h.addApplicant(b);
        Applicant c = new Applicant(new String[]{"Google", "Meta"}, "Ryan Chong", 3.4, "Harvard", new String[]{"Code", "Talk"});
        h.addApplicant(c);
        Applicant d = new Applicant(new String[]{"Google", "Meta"}, "Jose Chong", 3.4, "Harvard", new String[]{"Code", "Talk"});
        h.addApplicant(d);
        while (!option.equals("Q")) {
            if (option.equals("A")) {
                System.out.print("Enter Applicant Name: ");
                String name = input.nextLine();
                System.out.print("Enter Applicant GPA: ");
                double gpa = input.nextDouble();
                input.nextLine();  // Consume the leftover newline character after the GPA input

                System.out.print("Enter Applicant College: ");
                String college = input.nextLine();

                int num = 0;
                String[] companies = new String[3];
                while (num < 3) {
                    System.out.print("Enter up to " + (3 - num) + " Companies: ");
                    String comp = input.nextLine();
                    if (comp.isEmpty()) {
                        break;
                    }
                    companies[num] = comp;
                    num++;
                }

                num = 0;
                String[] skills = new String[3];
                while (num < 3) {
                    System.out.print("Enter up to " + (3 - num) + " Skills: ");
                    String skill = input.nextLine();
                    if (skill.isEmpty()) {
                        break;
                    }
                    skills[num] = skill;
                    num++;
                }

                Applicant a = new Applicant(companies, name, gpa, college, skills);
                h.addApplicant(a);
                System.out.println("\nApplicant " + name + " has been successfully added to the hiring system.\n");
            }
            else if (option.equals("R")){
                System.out.print("Enter applicant name: ");
                String remove = input.nextLine();
                h.removeApplicant(remove);
                System.out.println("\nApplicant " + remove + " has been successfully removed from the hiring system.\n");
            }
            else if (option.equals("P")) {
                System.out.println("\nCompany                         Name          GPA       College         Skills");
                System.out.println("--------------------------------------------------------------------------------------------------");
                for (int i = 0; i < h.size(); i++) {
                    System.out.println(h.applicants[i]);
                }
                System.out.println("\n");
            }
            System.out.println(menu);
            System.out.print("Please enter a command: ");
            option = input.next().toUpperCase();
            input.nextLine();  // Consume the leftover newline character after the option input
        }


    }
}
