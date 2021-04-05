package shop.shops;

import shop.models.bouquet.FlowersBouquet;
import shop.models.flowers.ChamomileFlower;
import shop.models.flowers.RoseFlower;
import java.util.LinkedList;

public class CommandLineShop {

    public static void main(String[] args) throws Exception{
        FlowersBouquet f = new FlowersBouquet(new LinkedList<>());
        f.addFlower(new RoseFlower(2, "red", 2));
        f.addFlower(new ChamomileFlower(2, "black", 3));
        String s = f.constructBouquet();
        System.out.println(s);
        ReadWriteFile reads = new ReadWriteFile();
        reads.storesBouquet(f);
    }
}
