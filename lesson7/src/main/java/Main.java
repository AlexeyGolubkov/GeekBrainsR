// by AlexeyGolubkov
import java.io.*;
import java.util.Arrays;

public class Main {
    // -   внимание для изменения максимального размера количества котов необходимо убедиться, что файл inputFileCats не существует!
    private static final int CAT_MAX = 53;
    //
    private static final int PLATE_MAX = 15;
    private static int appetite;
    private static int maxAppetitCat;
    private static int food;

    private static final String inputFileCats = "src/main/resources/config.cat";


    public static void main(String[] args) throws IOException {
        Cat[] cat = new Cat[CAT_MAX];
        Plate[] plate = new Plate [PLATE_MAX];

        if (serialArrayCheck(cat,plate)) {
            cat = (Cat[]) (deserialize(cat));
        }
        for (int i = 0; i < PLATE_MAX; i++) {
            food = 25+(int) (30 * (Math.random()));
            plate[i] = new Plate (food);
        }


        System.out.println("Изначально еды="+Plate.getTotalFood());
//        System.out.println(Arrays.toString(cat));
        System.out.println(Arrays.toString(plate));

        int numNoHungryCatAfterEating =0;
        int attemtTryEating=0;
        maxAppetitCat=cat[0].getAppetite();
        for (int i=1;i<CAT_MAX;i++) {
           if (cat[i].getAppetite()>maxAppetitCat) {
               maxAppetitCat=cat[i].getAppetite();
           }
        }
//--------------------------------------------main body
        while (minAppetiteCat(cat)<maxFoodInPlate(plate)) {
            if (numNoHungryCatAfterEating>=CAT_MAX){
                break;
            }
            for (Plate plateOne : plate) {

                for (int i = 0; i < CAT_MAX; i++) {
                    if (!cat[i].getFillCat()) { attemtTryEating++;
                        if (cat[i].eat(plateOne)) {
                            numNoHungryCatAfterEating++;

                        }
                    }
                }
            }
//            System.out.println("Min="+minAppetiteCat(cat)+"MaxFood="+maxFoodInPlate(plate)+"CatAte"+numNoHungryCatAfterEating);

        }
//---------------------------------------------main body
        int n=0;
        for (Cat catOne: cat) {
            if (!catOne.getFillCat()){
                n++;
                System.out.printf("Кот по имени %s остался голодным%n",catOne.getName());

            }
        }
        System.out.println("Осталось голодными всего="+n+ " попыток поесть "+attemtTryEating+", накормлено котов всего:"+numNoHungryCatAfterEating);
        System.out.println("Осталось еды="+Plate.getTotalFood());
        System.out.println(Arrays.toString(cat));
        System.out.println(Arrays.toString(plate));
    }

    private static int maxFoodInPlate(Plate[] plate) {
        int maximum=plate[0].getFood();
        for(int i=1;i<PLATE_MAX;i++) {
            if(plate[i].getFood()>maximum){
                maximum=plate[i].getFood();
            }
        }
        return maximum;
    }

    private static int minAppetiteCat(Cat[] cat) {
        int minimum=maxAppetitCat;
        int minimumAppetitCat=cat[0].getAppetite();
        for(int i=1;i<CAT_MAX;i++) {
            if (!cat[i].getFillCat()) {
                if (cat[i].getAppetite() < minimumAppetitCat) {
                    minimum = cat[i].getAppetite();
                }
            }
        }
        return minimum;
    }


    private static boolean serialArrayCheck (Cat[] cat, Plate[] plate) throws IOException {

        File inputCats = new File(inputFileCats);

        if (!inputCats.exists()) {

            for (int i = 0; i < CAT_MAX; i++) {
                appetite = 7+(int) (13 * (Math.random()));
                cat[i] = new Cat("NameofCat" + i, appetite);

            }
// ------------------ serialization for future tasks (and convenience of checking random chang in Cat) -----------------------------------------
            FileOutputStream fileOut=new FileOutputStream(inputFileCats);
            ObjectOutputStream out=new ObjectOutputStream(fileOut);
            out.writeObject(cat);
            fileOut.close();
            out.close();
            return false;
        }
        return true;
    }

    private static Object deserialize(Cat[] cat) throws FileNotFoundException {
        Object returnResult = null;
        try {

            FileInputStream fileIn = new FileInputStream(inputFileCats);
            ObjectInputStream in= new ObjectInputStream(fileIn);

            returnResult = in.readObject();

            fileIn.close();
            in.close();
        } catch (FileNotFoundException e){
            System.out.println("File "+inputFileCats+" not found or not possible to change ");
            System.exit(1);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Input error");

            System.exit(2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(3);
        }

        return returnResult;
    }
}


