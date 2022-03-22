import java.util.List;

public class Automat {
    public void q0(List<String> input, Keller keller) throws Exception {
        if (input.get(0).matches("\\d") && keller.getLast().equals("$")) {
            keller.push(input.get(0));
            input.remove(0);
            keller.toString();
            q0(input, keller);
        } else if (input.get(0).matches("\\d") && keller.getLast().matches("\\d+")) {
            keller.push(input.get(0));
            input.remove(0);
            keller.toString();
            q0(input, keller);
        } else if (!input.get(0).matches("\\d") && keller.getLast().matches("\\d+")) {
            String a = keller.getLast();
            keller.pop();
            String b = keller.getLast();
            keller.pop();
            keller.push(operate(a, b, input.get(0)));
            input.remove(0);
            keller.toString();
            q1(input, keller);
        } else {
            throw new Exception();
        }
    }

    public void q1(List<String> input, Keller keller) throws Exception {
        if (input.size() == 0 && keller.getLast().matches("\\d+")) {
            System.out.println("Resulat: " + keller.getLast());
            keller.pop();
            q2(input, keller);
        } else if (!input.get(0).matches("\\d") && keller.getLast().matches("\\d+")) {
            String a = keller.getLast();
            keller.pop();
            String b = keller.getLast();
            keller.pop();
            keller.push(operate(a, b, input.get(0)));
            input.remove(0);
            q1(input, keller);
        } else if (input.get(0).matches("\\d") && keller.getLast().matches("\\d+")) {
            keller.push(input.get(0));
            input.remove(0);
            q0(input, keller);
        } else {
            throw new Exception();
        }
    }

    public void q2(List<String> input, Keller keller) throws Exception {
        if (input.size() == 0 && keller.getLast().equals("$")) {
            keller.pop();
            keller.push("$");
            q3(input, keller);
        } else {
            throw new Exception();
        }
    }

    public void q3(List<String> input, Keller keller) {
        Main.run(Main.getTerm());
    }

    public String operate(String a, String b, String operand) throws Exception {
        switch (operand) {
            case "+":
                return String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
            case "*":
                return String.valueOf(Integer.parseInt(a) * Integer.parseInt(b));
        }
        throw new Exception();
    }
}
