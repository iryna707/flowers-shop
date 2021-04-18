package shop.shops;

import shop.exceptions.InvalidFlowerHeightException;
import shop.exceptions.InvalidFlowerPriceException;
import shop.exceptions.InvalidFlowerTypeException;
import shop.jdbc.ReadDataBase;
import shop.models.bouquet.FlowersBouquet;
import shop.models.flowers.Flower;

import java.util.List;

public class DataBaseApplication {

    public static void main(String[] args) {
        ReadDataBase readBase = new ReadDataBase();
        List<Flower> listFlowers = null;
        try {
            listFlowers = readBase.getAllFlowers();
        } catch (InvalidFlowerHeightException e) {
            e.printStackTrace();
        } catch (InvalidFlowerPriceException e) {
            e.printStackTrace();
        } catch (InvalidFlowerTypeException e) {
            e.printStackTrace();
        }

        FlowersBouquet flowersBouquet = new FlowersBouquet(listFlowers);
        System.out.println(flowersBouquet);

    }


}
