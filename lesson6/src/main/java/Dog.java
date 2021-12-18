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

        public void doSwim() {
        System.out.printf("Собака может проплыть %s m%n",
                getLongOutdistanceSwim());
    }
    @Override
   public void doRun(){
        System.out.printf("Собака может пробежать %s m%n",
                getLongOutdistanceRun());

   }
}
