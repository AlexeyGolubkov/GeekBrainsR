import java.util.ArrayList;

public class Main {
    public final static int HEIGHTBOX = 10;
    public final static int WIDTHBOX = 20;
    public final static int LONGBOX = 20;
    public final static int NUMBERSOFBOX = 30;
    public final static int NUMBERSOFFRUIT = 30;
    public final static double DELTA_OF_UNCERTAINTY = 0.5;

    public static void main(String[] args) throws MyArraySizeException {

        GenericForExercise1Box[] arrayForTaskLesson3part1 = new GenericForExercise1Box[4];
        arrayForTaskLesson3part1[0] = new GenericForExercise1Box("df1");
        arrayForTaskLesson3part1[1] = new GenericForExercise1Box('%');
        arrayForTaskLesson3part1[2] = new GenericForExercise1Box(4);
        arrayForTaskLesson3part1[3] = new GenericForExercise1Box("");
        System.out.println("Исходный массив:");
        for (GenericForExercise1Box genericForExercise1Box : arrayForTaskLesson3part1) {
            System.out.println(genericForExercise1Box.toString());
        }
        try {
            arrayForTaskLesson3part1 = changing(arrayForTaskLesson3part1, 1, 3);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Переделанный массив:");
            for (GenericForExercise1Box genericForExercise1Box : arrayForTaskLesson3part1) {
                System.out.println(genericForExercise1Box.toString());
            }
            System.out.println("Ящиков:" + GenericForExercise1Box.getNumber() + " . Их оставили на складе");

        }
        BoxForFruits[] boxForFruits = new BoxForFruits[NUMBERSOFBOX];
        ArrayList<BoxForFruits> arrayBoxesForFruits = new ArrayList<>();

        Apple[] oneApple = new Apple[NUMBERSOFFRUIT];
        ArrayList<Apple> arrayApple = new ArrayList<>();

        Orange[] oneOrange = new Orange[NUMBERSOFFRUIT];
        ArrayList<Orange> arrayOrange = new ArrayList<>();


        for (int i = 0; i < NUMBERSOFFRUIT; i++) {
            oneOrange[i] = new Orange();
            arrayOrange.add(oneOrange[i]);
            System.out.println(oneOrange[i]);
            oneApple[i] = new Apple();
            arrayApple.add(oneApple[i]);
            System.out.println(oneApple[i]);

        }
        System.out.println("one[0]: " + oneApple[0]);
        System.out.println(arrayApple.toString());
        System.out.println("one[0]: " + oneOrange[0]);
        System.out.println(arrayOrange.toString());
        for (int j = 0; j < NUMBERSOFBOX; j++) {
            boxForFruits[j] = new BoxForFruits();
            arrayBoxesForFruits.add(boxForFruits[j]);
        }
        System.out.println(arrayBoxesForFruits.toString());

        int j = NUMBERSOFBOX;
        while ((!arrayApple.isEmpty()) && (j > 0)) {

            try {
                //BoxForFruits oneBox = arrayBoxesForFruits.remove(arrayBoxesForFruits.size() - 1);
                // For other variant between existed boxForFruits[k]. The choice is made by the further statement and the condition of the task.
                j--;

                while (boxForFruits[j].isNotFulling() && (!arrayApple.isEmpty())) {
                    if (arrayApple.size() <= 1) {
                        //oneBox = arrayBoxesForFruits.remove(arrayBoxesForFruits.size() - 1);

                        break;
                    } //reserve checking
                    Apple one = arrayApple.get(arrayApple.size() - 1);
                    arrayApple.remove(arrayApple.size() - 1);
                    //oneBox.addFruit(one);
                    boxForFruits[j].addFruit(one);

                }
                j--;
                while (boxForFruits[j].isNotFulling() && (!arrayOrange.isEmpty())) {
                    if (arrayOrange.size() <= 1) {
                        //oneBox = arrayBoxesForFruits.remove(arrayBoxesForFruits.size() - 1);

                        break;
                    } //reserve checking
                    Orange one = arrayOrange.get(arrayOrange.size() - 1);
                    arrayOrange.remove(arrayOrange.size() - 1);
                    //oneBox.addFruit(one);
                    boxForFruits[j].addFruit(one);
                }

            } catch (IndexOutOfBoundsException e) {
                System.err.println("Box is finished!");
            }
        }
        boolean flagEqualOfFruitInBox = compare(boxForFruits[15], boxForFruits[10]);
        System.out.println("compare(boxForFruits[15],boxForFruits[10]) = " + flagEqualOfFruitInBox);
        System.out.println(arrayApple.toString());
        System.out.println(arrayOrange.toString());
        boxForFruits = boxFruitReloadToOther(boxForFruits, 15);
    }

    private static BoxForFruits[] boxFruitReloadToOther(BoxForFruits boxForFruit[], int numberOfBox) throws MyArraySizeException {
        if (numberOfBox > boxForFruit.length) {
            System.out.println("Нет такого ящика");
            return boxForFruit;
        }

        if (boxForFruit[numberOfBox].getFruit().equals("empty")) {
            System.out.println("ящик номер " + numberOfBox + " пустой");
            return boxForFruit;}
        for (int i = 0; i < boxForFruit.length; i++) {
            if (!boxForFruit[numberOfBox].isNotFulling() || i==numberOfBox){break;}
            if (boxForFruit[numberOfBox].getFruit().equals("empty"))  {       // it is not sporting, but the gist is get

                boxForFruit=changing(boxForFruit,i, numberOfBox);
                System.out.println("ящик был пустой \"... И ящички поменяем\"(c) ");
                return boxForFruit;
            }
            while(!boxForFruit[numberOfBox].getArrayFruitInBox().isEmpty() || !(boxForFruit[i].isNotFulling())) {
                if (boxForFruit[numberOfBox].getArrayFruitInBox().get(0) instanceof Orange) {

                    Orange one = (Orange) boxForFruit[i].getArrayFruitInBox().remove(boxForFruit[i].getArrayFruitInBox().size() - 1);
                    boxForFruit[numberOfBox].setArrayFruitInBox(boxForFruit[numberOfBox].getArrayFruitInBox());
                    boxForFruit[i].addFruit(one);
                }
                if (boxForFruit[i].getArrayFruitInBox().get(0) instanceof Apple) {

                    Apple one = (Apple) boxForFruit[numberOfBox].getArrayFruitInBox().remove(boxForFruit[numberOfBox].getArrayFruitInBox().size() - 1);
                    boxForFruit[i].setArrayFruitInBox(boxForFruit[i].getArrayFruitInBox());
                    boxForFruit[i].addFruit(one);
                }
            }


        }

        return boxForFruit;
    }

    private static BoxForFruits[] changing(BoxForFruits[] array, int index1, int index2) throws MyArraySizeException {
        if (index1 >= array.length || index2 >= array.length || index1 < 0 || index2 < 0) {
            generationException();
            System.out.println("Изменение не возможны массив меньше, чем индексы для перестановки");
        }
        BoxForFruits accumulator;
        accumulator = array[index1];
        array[index1] = array[index2];
        array[index2] = accumulator;
        return array;
    }

    private static GenericForExercise1Box[] changing (GenericForExercise1Box[]array,int index1, int index2) throws
            MyArraySizeException {
        if (index1 >= array.length || index2 >= array.length || index1 < 0 || index2 < 0) {
            generationException();
            System.out.println("Изменение не возможны массив меньше, чем индексы для перестановки");
        }
        GenericForExercise1Box accumulator;
        accumulator = array[index1];
        array[index1] = array[index2];
        array[index2] = accumulator;
        return array;
    }

    public static boolean compare (BoxForFruits Box1, BoxForFruits Box2 ){
        return Math.abs((Box1.getResultWeight()) - (Box2.getResultWeight())) < DELTA_OF_UNCERTAINTY;
    }

    private static void generationException () throws MyArraySizeException {
        throw new MyArraySizeException("Error size Array or Indexes of changing");

    }
}