import java.util.Scanner;

public class HiringSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
        Applicant a = new Applicant(new String[]{"Meta"}, "Justin Chong", 4.23, "Harvard", new String[]{"Business Management"});
        Applicant b = new Applicant(new String[]{"Meta, Google, Youtube"}, "Gilbert Chong", 4.43, "MIT", new String[]{"Java", "Python", "Swift"});
        System.out.println(a);
        System.out.println(b);

    }
}