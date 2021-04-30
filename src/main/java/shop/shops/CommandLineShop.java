package shop.shops;

import shop.filesIO.WriteFileJson;
import shop.models.bouquet.FlowersBouquet;
import shop.models.flowers.ChamomileFlower;
import shop.models.flowers.RoseFlower;

public class CommandLineShop {

    public static void main(String[] args) throws Exception{
        FlowersBouquet f = new FlowersBouquet();
        f.addFlower(new RoseFlower(2, "red", "Rose", 2));
        f.addFlower(new ChamomileFlower(2, "black", "Chamomile", 3));
        String s = f.constructBouquet();
        System.out.println(s);
        WriteFileJson reads = new WriteFileJson();
        reads.storeFlowers(f.getFlowers());
    }
}
