import java.util.Arrays;
import java.util.Random;

class HomeTask3 {
    public static void main(String[] args) {
        //1)
        byte[] arrayForTask0 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        //System.out.println(Arrays.toString (arrayForTask1));
        invert(arrayForTask0);
        //System.out.println(Arrays.toString (arrayForTask1));
        //2)
        final int NUM_FOR2 = 100;
        int[] arrayForTask2 = new int[NUM_FOR2];
        for (int i = 0; i < NUM_FOR2; i++) {
            arrayForTask2[i] = i + 1;
        }
        //System.out.println(Arrays.toString (arrayForTask2));
        //3)
        int[] arrayForTask3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        //exact fulfilling of the customer task but necessary to clarify about saving of result
        for (int num : arrayForTask3) {
            if (num < 6) {
                num = num * 2;
                //System.out.printf("%5d", num);
            } else {
                num=num;
                 //System.out.printf("%5d", num);
            }
        }
        //
        //4)
        final int NUM_FOR4=11;
        int[][] arrayForTask4 = new int[NUM_FOR4][NUM_FOR4];
        arrayForTask4=diagonalFill (arrayForTask4);
        /*
        //for checking Task4
        for (int i=0;i<arrayForTask4[0].length;i++){
            System.out.println(Arrays.toString(arrayForTask4[i]));
        }
        */
        //5)to clarify about type of ArrayForTask5
        int len;String initialValue;
        len=10;
        initialValue="2021";
        String[] arrayForTask5 = new String[len];
        arrayForTask5 = arrayInitial(len,initialValue);
        // for checking Task5
        // System.out.println(Arrays.toString(arrayForTask5));
        //6)
        final int NUM_FOR6=10;
        double [] arrayForTask6 = new double[NUM_FOR6]   ;
        // result will here
        double[] minAndMaxOfArray={0,0};
        // generation numerics from -1 to +1
        for(int i=0;i<NUM_FOR6;i++) {
            arrayForTask6[i] = -1+2*Math.random();
        }
        minAndMaxOfArray=minAndMaxOperation(arrayForTask6);
        //for checking Task6
        // System.out.println(Arrays.toString(arrayForTask6));
        // System.out.println(Arrays.toString(minAndMaxOfArray));
        //7)
        final int NUM_FOR7=8;
        int[] arrayForTask7 = new int[NUM_FOR7];
/*
        // here you can created special array for task 7
        arrayForTask7[0] = 2;
        arrayForTask7[1] = 2;
        arrayForTask7[2] = 0;
        arrayForTask7[3] = 0;
        arrayForTask7[4] = 2;
        arrayForTask7[5] = 2;
        arrayForTask7[6] = 8;
        arrayForTask7[7] = 0;*/

///* try to run the program several times and the desired sequence will be created:
        System.out.println();
        for (int i=0;i<NUM_FOR7;i++){
            if (i%2==1) {
                arrayForTask7[i] = (int) (i*Math.random());
            } else{
                arrayForTask7[i] = (int) (-i+ NUM_FOR7*Math.random());
            }

            System.out.printf("%5d",arrayForTask7 [i]);
        }
//*/
        boolean b7=intraSpecificArrayPlace(arrayForTask7);
        //8) используем в качестве массива массив, созданный в Task7 только в вещественных переменных
        //final int KF_FOR_SHIFT = 1000000000;
        int numSteps=4;
        //numSteps=(int)(KF_FOR_SHIFT*(-1+Math.random()));
        int [] arrayForTask8 = new int [NUM_FOR7];
        arrayForTask8= arrayForTask7;
        arrayForTask8=ciclicShiftNumSteps (numSteps,arrayForTask8);
        System.out.println();
        System.out.println(Arrays.toString(arrayForTask8));
    }

    private static int[] ciclicShiftNumSteps(int numSteps, int[] array) {
        int len = array.length;
        int numCicle=len/numSteps;
        int k1 = 0;
        int flagF = 1;
        if (numSteps < 0) {
            flagF = -1;
        }
        numSteps = Math.abs(numSteps % len);
        int forRec,forRecNew ;
        for (int i = 0; i < numSteps; i++) {
            forRec=array[i];
            for (int k = 1; k <= numCicle; k ++) {

                if ((i + k*numSteps) / len < 1) {
                    forRecNew = array[i + k*numSteps] ;
                    array[i + k*numSteps] = forRec;

                } else {
                    k1 = (i + k*numSteps) % len;
                    forRecNew=array[k1];
                    array[k1]= forRec;
                }
                forRec=forRecNew;
            }
        }
        return array;
    }


    private static boolean intraSpecificArrayPlace(int[] array) {
        int len=array.length;
        switch (len) {
            case 1:
                System.out.println("Массив из одного числа");
                return false;
        }


        // control points for amounts became less by one
        int[] sumHead=new int[len-1];
        int[] sumTail=new int[len-1];
        boolean result=false;
        sumHead[0]=array[0];
        sumTail[len-2] = array[len-1];
        for (int k=1;k<len-1;k++)  {
            sumHead [k]=sumHead [k-1]+array[k];
            for(int i=k;i<len;i++) {
                sumTail[k-1]=sumTail[k-1] +array[i];
            }
        }
        // сравнение массивов сумм начал и концов последовательности
        for (int i=0;i<=len-2;i++) {
            if (sumHead[i]==sumTail[i])  {
                result = true;
                /*
                //checking Task7
                System.out.println("i="+i);
                System.out.println(Arrays.toString(sumHead));
                System.out.println(Arrays.toString(sumTail));
                */
            }
        }
        return result;
    }

    private static double[] minAndMaxOperation(double[] array) {
        double [] minAndMax = {array[0],array[0]};
        for(int i=1;i<array.length;i++){
            if (array[i]<minAndMax[0]){
                minAndMax[0]=array[i];
            }
            if (array[i]>minAndMax[1]){
                minAndMax[1]=array[i];
            }
        }
        return minAndMax;
    }

    private static String[] arrayInitial(int len, String initialValue) {
        String[] array = new String[len];
        for(int i=0;i<len;i++){
            array[i]=initialValue;
        }
        return array;
    }

    private static int[][] diagonalFill(int[][] arraySquare) {
        //side of square
        int k=arraySquare[0].length;
        for (int i=0; i< k;i++) {
            arraySquare[i][i] = 1;
            arraySquare[i][k - i-1] = 1;
        }
        return arraySquare;
    }

    private static byte[] invert ( byte[] array0_1){
        for (int i = 0; i < array0_1.length; i++) {
            switch (array0_1[i]) {
                case 0x00:
                    array0_1[i] = 0x01;
                    break;
                default:
                    array0_1[i] = 0x00;
            }

        }
        return array0_1;
    }
}

