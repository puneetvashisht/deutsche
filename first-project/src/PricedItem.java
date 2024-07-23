// create interface PricedItem upper bounded by Number
interface PricedItem<T extends Number> {
    double getPrice();
    void setPrice(T price);
}

