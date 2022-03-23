import java.util.LinkedList;
import java.util.List;

public class Keller {
    LinkedList<String> keller = new LinkedList<>();
    String result;

    public Keller() {
        keller.push("$");
        printKeller();
    }

    public void push(String string) {
        keller.addLast(string);
        printKeller();
    }

    public void pop() {
        keller.removeLast();
        printKeller();
    }

    public String getLast() {
        return keller.getLast();
    }

    private void printKeller() {
        for (int i = keller.size()-1; i >= 0; i--) {
            System.out.printf("| %2s |\n", keller.get(i));
        }
        System.out.println("------\n");
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
