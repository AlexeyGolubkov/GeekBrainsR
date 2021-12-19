
public class Plate {
    private static int totalFood;
    private int food;


    public static int getTotalFood() {
        return totalFood;
    }
    public int getFood() {
        return food;
    }

    public void setFood (int food) {
        this.food = food;totalFood+=getFood();
    }
// Task 6 ----------
    public void setFoodAdd (int food) {
        this.food = getFood()+food;
        totalFood+=getFood();
    }
// -----------------
    public Plate(int food) {
        this.food = food;totalFood+=getFood();
    }

    public boolean decreaseFood(int amount, boolean filling) {
        //filling=false;
        if (food>=amount){
            food -= amount;
            totalFood-=amount;
            filling=true;
        }
        return filling;
    }
    @Override
    public String toString () {

        return String.format("Еды=%s",getFood());
    }
}