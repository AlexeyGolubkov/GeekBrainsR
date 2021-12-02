//by AlexeyGolubkov
public class Main {
    public static void main(String[] args) {
        //1)
        int[] numerics12 = {444, 555};

        boolean bf;
        bf = checkSumArray12(numerics12);
        //2)
        int n=7;
        bf = compareWith0(n);
        //3)
        int k=-7;
        boolean bk = compareWith0(n);
        //4)
        String str="Any information";
        final int N_TIMES=7;
        if (compareWith0(N_TIMES)) { // В задании этого не было, но ситуация возможна
            System.out.println("Ошибка. Число строк должно быть положительным!");
        } else {
            printStringNumTimes(str, N_TIMES);
        }

        //5))
        int year= 2100;
        boolean what = defineSpecialYear (year);
/*        if (what) {
            System.out.println("високосный год -"+year);
        }else{
            System.out.println("обычный год -"+year);*/
    }




    private static boolean checkSumArray12 (int[] numerics) {
        boolean result;
        int sum = 0;
        for (int i = 0; i < numerics.length; i++) {
            sum += numerics[i];
        }
        if (sum < 10 || sum > 20) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }
    // совместили 2 и 3 задание в одном методе
    private static boolean compareWith0 (int n) {
        if (n>=0){
            System.out.println("Число положительное");
            return false;
        }else{
            System.out.println("Число отрицательное");
            return true;
        }

    }
    private static void printStringNumTimes (String str, int n) {
        for(int i=0;i<n; i++){
            System.out.println(str);
        }
    }
    private static boolean defineSpecialYear (int n) {
        if ((n%400==0)) {
            return true;
        }else if (n%4==0&&(!(n%100==0))) {
            return true;
        } else {
            return false;
        }
    }
}


