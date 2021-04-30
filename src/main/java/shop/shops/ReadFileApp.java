package shop.shops;

import shop.filesIO.ReadFileJson;
import shop.models.bouquet.FlowersBouquet;
import shop.models.flowers.Flower;

import java.util.List;

public class ReadFileApp {

    public static void main(String[] args) throws Exception {
        ReadFileJson fileReader = new ReadFileJson();
        List<Flower> flowers = fileReader.getFlowers();
        FlowersBouquet flowersBouquet = new FlowersBouquet(flowers);
        System.out.println(flowersBouquet.constructBouquet());

    }
}
