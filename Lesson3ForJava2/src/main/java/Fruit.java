abstract public class Fruit {
    protected static double weight;
    protected static double radiusSize;
    protected static String color;

    protected Fruit(double weight, double radiusSize, String color) {
        this.weight=weight;
        this.radiusSize=radiusSize;
        this.color=color;
    }

   protected  Fruit() {
        color="color";
    }


    protected double getWeight() {
        return weight;
    }

    protected double getRadiusSize() {
        return radiusSize;
    }
    @Override
    public String toString() {
        String str = "\"";

        str = str + color + str + radiusSize + str + weight + str;

        return str;
    }
    }

