package seminars.first.hw;

public class Product {
    private int cost; // Стоимость продукта
    private String title; // Название

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // @Override
    public int compareTo(Product product) {return this.getCost().compareTo(product.getCost());}
}