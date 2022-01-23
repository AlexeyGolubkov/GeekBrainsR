import java.util.*;

public class BoxForFruits <T> {
    private List<T> arrayFruitInBox;
    private String fruit;
    private boolean fulling;
    private int number = 0;
    private int heightBox;
    private int widthBox;
    private int longBox;
    private int idBox;
    private double resultWeight = 0;
    private double resultV = 0;

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public BoxForFruits() {
        this.arrayFruitInBox = new ArrayList<>();
        this.fulling = true; // true = is not full
        this.fruit = "empty";
        this.heightBox = Main.HEIGHTBOX;
        this.widthBox = Main.WIDTHBOX;
        this.longBox = Main.LONGBOX;
        number++;
        this.idBox = number;
    }


    public void setArrayFruitInBox(List<T> arrayFruitInBox) {
        this.arrayFruitInBox = arrayFruitInBox;
    }

    public List<T> getArrayFruitInBox() {
        return arrayFruitInBox;
    }

    public boolean isNotFulling() {
        return fulling;
    }

    public double getResultWeight() {
        return resultWeight;
    }
    public double getResultV() {
        return resultV;
    }


    public String getFruit() {
        return fruit;
    }

    public void addFruit(Fruit one) {
        boolean flagAction=false;
        System.out.println("getArrayFruitInBox()" + getArrayFruitInBox());
        //other varian was to ose getFruit
        if (!getArrayFruitInBox().isEmpty()) {

            if ((getArrayFruitInBox().get(0)) instanceof Orange) {

                List<Orange> arrayFruits = new ArrayList(getArrayFruitInBox());
                arrayFruits.add((Orange) one);
                setArrayFruitInBox((List<T>) arrayFruits);
                flagAction=true;

            }
            if ((getArrayFruitInBox().get(0)) instanceof Apple) {
                List<Apple> arrayFruits = new ArrayList(getArrayFruitInBox());
                arrayFruits.add((Apple) one);
                setArrayFruitInBox((List<T>) arrayFruits);
                flagAction=true;
            }
        } else {
            if (one instanceof Orange) {
                List<Orange> arrayFruits = new ArrayList();
                arrayFruits.add((Orange) one);
                setArrayFruitInBox((List<T>) arrayFruits);
                flagAction=true;
                setFruit("Orange");
            }
            if (one instanceof Apple) {
                List<Apple> arrayFruits = new ArrayList();
                arrayFruits.add((Apple) one);
                setArrayFruitInBox((List<T>) arrayFruits);
                flagAction=true;
                setFruit("Apple");
            }

        }

        if (flagAction){
            resultWeight += one.getWeight();
            resultV += one.getRadiusSize() * one.getRadiusSize() * one.getRadiusSize() * (4 / 3) * (104348 / 33215);
            // The approximate checking of max weight and volume
            if ((resultWeight >= ( heightBox * widthBox * longBox/30)) || (resultV >= ( heightBox * widthBox * longBox*2/3))) {
                fulling = false;

            }
        }
        else {
            System.out.println("Attention! There is not correct the Fruit Class");
            //Call of Duty Manager
        }
    }


    @Override
    public String toString () {
        String str="\"";

        String strFromFruit=""+getArrayFruitInBox();

        str=str + strFromFruit+"<-\n";//+isFulling()+str+getFruit()+str+getIdBox()+str;//+str+getLongBox()+str+getWidthBox()+str+getHeightBox();

        return str;
    }

}