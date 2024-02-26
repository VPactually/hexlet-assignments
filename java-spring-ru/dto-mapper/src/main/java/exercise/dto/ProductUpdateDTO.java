package exercise.dto;

import lombok.Getter;
import lombok.Setter;


public class ProductUpdateDTO {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
