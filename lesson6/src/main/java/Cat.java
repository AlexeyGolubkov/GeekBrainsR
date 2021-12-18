public class Cat extends Animals {
    private static int numberCats=0;

    public Cat(String name, double weight, String color, int ageOfBirth) {
        super(name, weight, color, ageOfBirth);

        this.longOutdistanceRun = 200;

        numberCats++;
    }

    public static int getNumberCats() {
        return numberCats;
    }

    @Override
    public void doRun() {
        System.out.printf("Кот может пробежать %s m%n",
                getLongOutdistanceRun());

    }
}