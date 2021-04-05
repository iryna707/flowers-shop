package shop.models.flowers;

public class ChamomileFlower extends FlowerAbstract {

    private final static String NAME = "Chamomile";

    public ChamomileFlower(int height, String color, int basePrice) {
        super(height, color, basePrice);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
