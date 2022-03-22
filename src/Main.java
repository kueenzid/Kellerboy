import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run(getTerm());
    }

    public static List<String> getTerm() {
        System.out.println("Gib den Term ein in UPN: ");
        Scanner sc = new Scanner(System.in);
        String term = sc.nextLine();
        while (!term.matches("[0-9\\*\\+ ]+")) {
            System.out.println("Wrong: ONLY 1-9, * and + are accepted!");
            term = sc.nextLine();
        }
        term = term.replaceAll(" ", "");
        List<String> input = new ArrayList<>();
        input.addAll(Arrays.asList(term.split("")));
        return input;
    }

    public static void run(List<String> input) {
        Keller keller = new Keller();
        Automat automat = new Automat();
        try {
            automat.q0(input, keller);
        } catch (Exception exception) {
            System.out.println("Term Ungültig!");
            run(getTerm());
        }
    }
}