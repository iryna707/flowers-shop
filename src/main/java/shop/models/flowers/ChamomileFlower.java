package shop.models.flowers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChamomileFlower extends FlowerAbstract {

    private final String name;

    public ChamomileFlower(@JsonProperty("height")int height,
                           @JsonProperty("color")String color,
                           @JsonProperty("name")String name,
                           @JsonProperty("price")int price) {
        super(height, color, price);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
