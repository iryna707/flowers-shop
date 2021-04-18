package shop.models.bouquet;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import shop.models.flowers.ChamomileFlower;
import shop.models.flowers.Flower;
import shop.models.flowers.RoseFlower;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FlowersBouquet {

    private final List<Flower> flowers;

    public FlowersBouquet(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public String constructBouquet() {
        return flowers.stream().map(Flower::toString).collect(Collectors.joining(", "));
        // return flowers.stream().map(flower -> flower.toString()).collect(Collectors.joining(", "));
    }

    public int getPrice() {
        return flowers.stream().mapToInt(Flower::getPrice).sum();
    }

}
