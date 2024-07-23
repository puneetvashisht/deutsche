public class Customer {
    String name;
    int money;

    //create constructor with name, and initial money
    public Customer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
}
