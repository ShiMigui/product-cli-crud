import java.util.ArrayList;
import java.util.Scanner;

import entities.Product;
import entities.ProductRepository;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ProductRepository repo = new ProductRepository();
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
                String name = getInputName(null);
                float value = getInputValue(null);
                System.out.printf("Produto %d criado!\n", repo.register(name, value));
                sc.nextLine();
                break;
            case 2:
                System.out.println("Lista de produtos\n" + repo.listAll());
                break;
            case 3:
                Product p = repo.get(getInputCode());
                sc.nextLine();
                name = getInputName(p.getName());
                value = getInputValue(p.getValue());
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

    public static String getInputName(String old) {
        boolean hasOldAValue = old != null;
        if (!hasOldAValue) {
            System.out.print("Nome: ");
            return sc.nextLine();
        }
        System.out.print("Nome(" + old + "): ");
        String name = sc.nextLine();
        return (name.trim().isEmpty()) ? old : name;
    }

    public static float getInputValue(Float old) {
        boolean hasOldAValue = old != null;
        if (!hasOldAValue) {
            System.out.print("Valor: R$");
            return sc.nextFloat();
        }
        System.out.printf("Valor(R$%.2f): R$", old);
        String value = sc.nextLine();
        return (value.trim().isEmpty()) ? old : Float.parseFloat(value);
    }

    public static int getInputCode() {
        System.out.print("Código: ");
        return sc.nextInt();
    }
}
