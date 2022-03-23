import java.util.LinkedList;

public class Keller {
    LinkedList<String> keller = new LinkedList<>();

    public Keller() {
        keller.push("$");
    }

    public void push(String string) {
        keller.addLast(string);
        printKeller();
    }

    public void pop() {
        keller.removeLast();
    }

    public String getLast() {
        return keller.getLast();
    }

}
