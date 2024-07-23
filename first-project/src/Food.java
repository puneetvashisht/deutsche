public class Food implements PricedItem<Integer> {
    private String name;
    private String description;
    private int price;

    // constructor
    public Food(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Food(){
        
    }
    @Override
    public double getPrice() {
        return this.price;
    }
    @Override
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
    
}
