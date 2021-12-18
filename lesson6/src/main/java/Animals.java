public abstract class Animals {
    private String name;
    protected double weight;
    private String colorOfAnimal;
    private int ageOfBirth ;
    protected int longOutdistanceRun;
    protected int longOutdistanceSwim;
    private static int numberAnimals=0;


    public Animals(
            String name, double weight,
            String color, int ageOfBirth,int longOutdistanceRun,int longOutdistanceSwim ) {


        this.name = name;
        this.weight = weight;
        this.colorOfAnimal = colorOfAnimal;
        this.ageOfBirth = ageOfBirth;
        this.longOutdistanceRun=longOutdistanceRun;
        this.longOutdistanceSwim=longOutdistanceSwim;
        numberAnimals++;
    }

    public static int getNumberAnimals() {
        return numberAnimals;
    }

    public Animals(
            String name, double weight,
            String color, int ageOfBirth) {


        this.name = name;
        this.weight = weight;
        this.colorOfAnimal = colorOfAnimal;
        this.ageOfBirth = ageOfBirth;
        this.longOutdistanceRun=0;
        this.longOutdistanceSwim=0;
        numberAnimals++;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColorOfAnimal() {
        return colorOfAnimal;
    }

    public void setColorOfAnimal(String colorOfAnimal) {
        this.colorOfAnimal = colorOfAnimal;
    }

    public int getAgeOfBirth() {
        return ageOfBirth;
    }

    public void setAgeOfBirth(int ageOfBirth) {
        this.ageOfBirth = ageOfBirth;
    }

    public int getLongOutdistanceRun() {
        return longOutdistanceRun;
    }

    public int getLongOutdistanceSwim() {
        return longOutdistanceSwim;
    }

    public String doSwim (int longTask){
        String result="";
        if (longTask==0){
            result+="Ноль метров преодолеть не проблема, хотя ";
        }
        if (getLongOutdistanceSwim()<=0){
           result="животное не умеет плавать";
        } else {
            result = "животное может пробежать" + getLongOutdistanceRun() + " метров";
        }
        return result;
    }
    public String doRun (int longTask) {
        String result="";
        if (getLongOutdistanceSwim() <= 0) {
            result = "Животное не умеет бегать";
        } else{
            result = "Животное может проплыть" + getLongOutdistanceSwim() + " метров";
    }
        return result;
    }
}
