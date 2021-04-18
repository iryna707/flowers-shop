package shop.models.flowers;

public class RoseFlower extends FlowerAbstract {

    private final static String NAME = "Rose";

    public RoseFlower(int height, String color, int basePrice) {
        super(height, color, basePrice);
    }

    @Override
    public int getPrice() {
        return getPrice() * getHeight();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
