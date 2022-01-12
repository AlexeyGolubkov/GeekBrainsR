import java.io.Serializable;

public class Cat implements Serializable {
    private String name;
    private int appetite;
    boolean fillCat;

    // геттеры/сеттеры

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fillCat=false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean getFillCat() {
        return fillCat;
    }

    public void setFillCat(boolean fillCat) {
        this.fillCat = fillCat;
    }

    public boolean eat(Plate p) {
        boolean memory=fillCat;
        boolean checkCatEating=(p.decreaseFood(appetite, fillCat));
           if (checkCatEating){
               setFillCat(true);
        }
        return checkCatEating;
    }

   @Override
    public String toString () {

return String.format("Cat %s has appetit %s and fill=%s",getName(),getAppetite(),getFillCat());
    }
}
