import java.util.ArrayList;
import java.util.Scanner;

import entities.Product;
import entities.ProductRepository;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(1, "vassoura", 1.00f));
        list.add(new Product(2, "vela", 1.00f));
        list.add(new Product(3, "mesa", 1.00f));
        list.add(new Product(4, "tapete", 1.00f));
        list.add(new Product(5, "pano", 1.00f));
        list.add(new Product(6, "cadeira", 1.00f));
        ProductRepository repo = new ProductRepository(list);
        boolean run = true;
        while (run) {
            try {
                run = menu(repo);
                System.out.println("Aperte enter...");
                sc.nextLine();
            } catch (NullPointerException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("Um erro desconhecido ocorreu!");
                System.err.println(e);
            } finally {
                System.out.println();
            }
        }
        sc.close();
    }

    public static boolean menu(ProductRepository repo) throws Exception {
        System.out.print(
                "1) Cadastrar\n2) Listar produtos\n3) Atualizar dados\n4) Remover produto\n5) Buscar produto\n6) Total\n7) Sair\n\tOpção: ");

        int opt = sc.nextInt();
        sc.nextLine();
        switch (opt) {
            case 1:
                String name = getInputName();
                float value = getInputValue();
                System.out.printf("Produto %d criado!\n", repo.register(name, value));
                sc.nextLine();
                break;
            case 2:
                System.out.println("Lista de produtos\n" + repo.listAll());
                break;
            case 3:
                Product p = repo.get(getInputCode());
                sc.nextLine();
                name = getInputNameOrDefault(p.getName());
                value = getInputValueOrDefault(p.getValue());
                p.setName(name);
                p.setValue(value);
                break;
            case 4:
                int code = getInputCode();
                repo.remove(code);
                System.out.println("Produto[" + code + "] deletado!");
                sc.nextLine();
                break;
            case 5:
                System.out.println(repo.get(getInputCode()));
                sc.nextLine();
                break;
            case 6:
                System.out.printf("Total: R$%.2f%n", repo.totalStock());
                break;
            case 7:
                return false;
            default:
                throw new Exception("Opção inválida!");
        }
        return true;
    }

    public static String getInputName() {
        System.out.print("Nome: ");
        return sc.nextLine();
    }

    public static float getInputValue() {
        System.out.print("Valor: R$");
        return sc.nextFloat();
    }

    public static int getInputCode() {
        System.out.print("Código: ");
        return sc.nextInt();
    }

    public static String getInputNameOrDefault(String name) {
        System.out.printf("Nome(%s): ", name);
        String novo = sc.nextLine();
        return novo.trim().isEmpty() ? name : novo;
    }

    public static float getInputValueOrDefault(float value) {
        System.out.printf("Valor(R$%.2f): R$", value);
        String novo = sc.nextLine();
        return novo.trim().isEmpty() ? value : Float.parseFloat(novo);
    }
}
