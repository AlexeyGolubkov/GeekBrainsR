public abstract class Animals {
    private String name;
    protected double weight;
    private String colorOfAnimal;
    private int ageOfBirth ;
    protected int longOutdistanceRun;



    public Animals(
            String name, double weight,
            String color, int ageOfBirth,int longOutdistanceRun ) {


        this.name = name;
        this.weight = weight;
        this.colorOfAnimal = colorOfAnimal;
        this.ageOfBirth = ageOfBirth;
        this.longOutdistanceRun=longOutdistanceRun;

    }
    public Animals(
            String name, double weight,
            String color, int ageOfBirth) {


        this.name = name;
        this.weight = weight;
        this.colorOfAnimal = colorOfAnimal;
        this.ageOfBirth = ageOfBirth;
        this.longOutdistanceRun=7;

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
 /*   public String doRun() {
        return String.format("Может пробежать %d km",longOutDistanceRun);
    }
*/
    public abstract void doRun ();
}
