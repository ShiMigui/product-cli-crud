import java.util.ArrayList;
import java.util.Scanner;

import entities.Product;
import entities.ProductRepository;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(1, "vassoura", 1.00f));
        list.add(new Product(2, "vassoura", 1.00f));
        list.add(new Product(3, "vassoura", 1.00f));
        list.add(new Product(4, "vassoura", 1.00f));
        list.add(new Product(5, "vassoura", 1.00f));
        list.add(new Product(6, "vassoura", 1.00f));
        ProductRepository repo = new ProductRepository(list);
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            try {
                run = menu(sc, repo);
            } catch (NullPointerException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("Um erro desconhecido ocorreu!");
                System.err.println(e);
            }
            finally {
                System.out.println();
            }
        }
        sc.close();
    }

    public static boolean menu(Scanner sc, ProductRepository repo) throws Exception{
        System.out.print("1) Cadastrar\n2) Listar produtos\n3) Atualizar dados\n4) Remover produto\n5) Buscar produto\n6) Total\n7) Sair\n\tOpção: ");

        int opt = sc.nextInt();
        sc.nextLine();
        String name;
        float value;
        switch (opt) {
            case 1:
                System.out.print("Nome: ");
                name = sc.nextLine();
                System.out.print("Valor: R$");
                value = sc.nextFloat();
                System.out.printf("Produto %d criado!\n", repo.register(name, value));
                break;
            case 2:
                System.out.println("Lista de produtos\n"+repo.listAll());
                break;
            case 7:
                return false;
            default:
                throw new Exception("Opção inválida!");
        }
        return true;
    }
}
