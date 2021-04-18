package shop.models.flowers;

public abstract class FlowerAbstract implements Flower {

    private final int height;
    private final int basePrice;
    private final String color;

    public FlowerAbstract(int height, String color, int basePrice) {

        this.height = height;
        this.color = color;
        this.basePrice = basePrice;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getPrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return String.format("%s with color %s", getName(), color);
    }
}
