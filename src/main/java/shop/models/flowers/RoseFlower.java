package shop.models.flowers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//@JacksonXmlRootElement(localName = "customer")
public class RoseFlower extends FlowerAbstract {

    private final String name;

    public RoseFlower(@JsonProperty("height")int height,
                      @JsonProperty("color")String color,
                      @JsonProperty("name")String name,
                      @JsonProperty("price")int price) {
        super(height, color, price);
        this.name = name;
    }

    @Override
    public int getPrice() {
        return super.getPrice() * getHeight();
    }

    @Override
    public String getName() {
        return name;
    }
}
