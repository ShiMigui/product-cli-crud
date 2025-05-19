package entities;

import java.util.ArrayList;

public class ProductRepository {
    private ArrayList<Product> list;

    public ProductRepository(ArrayList<Product> list) {
        this.list = list;
    }

    public ProductRepository() {
        this.list = new ArrayList<Product>();
    }

    public int register(String name, float value) {
        int id = list.size() + 1;
        list.add(new Product(id, name, value));
        return id;
    }

    public String listAll() {
        String text = "";
        for (Product p : list)
            text += "\n" + p.toString();
        return text;
    }

    public void update(int id, String name, Float value) {
        Product p = get(id);
        if (name == null)
            name = p.getName();
        if (value == null)
            value = p.getValue();
        p.setName(name);
        p.setValue(value);
    }

    public void remove(int id) {
        get(id);
        list.remove(id - 1);
    }

    public Product get(int id) {
        Product p = list.get(id - 1);
        if (p == null)
            throw new NullPointerException("Produto[" + id + "] não existe!");
        return p;
    }

    public float totalStock() {
        float total = 0.f;
        for (Product p : list) total += p.getValue();
        return total;
    }
}
