import java.util.Scanner;

public class InputHandler {
    Scanner sc;

    public InputHandler(Scanner sc) {
        this.sc = sc;
    }

    public String questString(String text) {
        System.out.print(text);
        return sc.nextLine().trim();
    }

    public Float questFloat(String text) {
        while (true) {
            try {
                System.out.print(text);
                return Float.parseFloat(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Formato inválido!");
            }
        }
    }

    public Integer questInteger(String text) {
        while (true) {
            try {
                System.out.print(text);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Formato inválido!");
            }
        }
    }

    public String questStringDefault(String text, String old) {
        String value = questString(text + "(" + old + ") ");
        return value.isEmpty() ? old : value;
    }

    public Float questFloatDefault(String text, Float old) {
        while (true) {
            try {
                String value = questStringDefault(text, old.toString());
                return value.isEmpty() ? old : Float.parseFloat(value);
            } catch (NumberFormatException e) {
                System.err.println("Formato inválido!");
            }
        }
    }

    public Integer questIntegerDefault(String text, Integer old) {
        while (true) {
            try {
                String value = questStringDefault(text, old.toString());
                return value.isEmpty() ? old : Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.err.println("Formato inválido!");
            }
        }
    }
}
