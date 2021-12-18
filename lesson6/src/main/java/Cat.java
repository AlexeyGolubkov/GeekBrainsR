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
    public String doRun(int longTask) {
        String result="Кот "+ getName() +" не может пробежать "+longTask+" метров";
        if (longTask<=getLongOutdistanceRun()){
            result = "Кот "+ getName() +" пробегает " +longTask+" метров";
        }
        return result;

    }
    @Override
    public String doSwim(int longTask) {
        String result =
                "Кошка " + getName() + ", как и все кошки, не умеет плавать и не может проплыть " + longTask +
                        " метров";
        if (longTask==0) {
            result =
                    "Кошка " + getName() + ", как и все кошки, не умеет плавать, но 0 метров она проплыть может";
        }

        return result;
    }
}