package entities;

public class Product {
    private String name;
    private Float value;
    private Integer id;

    public Product(Integer id, String name, Float value) {
        this.name = name;
        this.value = value;
        this.id = id;
    }

    public void setName(String name) {
        name = name.trim();
        if(name.isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio!");
        this.name = name;
    }
    public void setValue(float value) { this.value = value; }
 
    public String getName() { return this.name;}
    public Float getValue() { return this.value;}
    public Integer getId() { return this.id;}

    @Override
    public String toString() {
        return String.format("%d %s %.2f", getId(), getName(), getValue());
    }
}
