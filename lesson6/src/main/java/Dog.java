public class Dog extends Animals {

    private int longOutdistanceSwim;

    private static int numberDogs=0;

    public Dog(String name, double weight, String color, int ageOfBirth)
           {
        super(name, weight, color, ageOfBirth);

          this.longOutdistanceRun= 500;
          this.longOutdistanceSwim= 10;
        numberDogs++;
    }

    public static int getNumberDogs() {
        return numberDogs;
    }

    public int getLongOutdistanceSwim() {
        return longOutdistanceSwim;
    }

    @Override
        public String doSwim(int longTask) {
        String result="Собака "+getName()+" не может проплыть "+longTask+" метров";
        if (longTask<=getLongOutdistanceRun()){
            result = "Собака "+getName()+" может проплыть " +longTask+" метров";
        }
        return result;
    }

    @Override
    public String doRun(int longTask) {
        String result="Собака "+getName()+" не может пробежать "+longTask+" метров";
        if (longTask<=getLongOutdistanceRun()){
            result = "Собака "+getName()+" пробегает " +longTask+" метров";
        }
        return result;

   }
}
