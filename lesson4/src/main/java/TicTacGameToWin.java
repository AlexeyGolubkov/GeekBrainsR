public class TicTacGameToWin {
    private static final int SIZE_MAP = 19;
    private static final char PLAYER_A_FILLING = 'X';
    private static final char PLAYER_B_FILLING = 'O';
    private static final char EMPTY_FILL ='*';
    private static final int LEN_VICTORY_LINE = 5;


    public static void main(String[] args) {
        char filling=PLAYER_A_FILLING;
        int coordinateXofArray=0, coordinateYofArray=0;
        boolean flagStepFinish;
        char [][] array = new char [SIZE_MAP][SIZE_MAP];
        array = printMapGame ();
        int countStep=0;
        boolean flagGameOver=false;
        while ((countStep<SIZE_MAP*SIZE_MAP)&&(!flagGameOver)){
            if (countStep%2==0){
                filling=PLAYER_A_FILLING;
            } else{
                filling=PLAYER_B_FILLING;
            }
            flagStepFinish=true;
            while (flagStepFinish) {
                coordinateXofArray = (int) ( SIZE_MAP * (Math.random()));
                coordinateYofArray = (int) (SIZE_MAP * (Math.random()));
                if ((array[coordinateXofArray][coordinateYofArray]) == EMPTY_FILL) {
                    (array[coordinateXofArray][coordinateYofArray])=filling;
                    flagStepFinish=false;
                }
            }
            flagGameOver = checkWin(array,filling,coordinateXofArray,coordinateYofArray);
            if (flagGameOver) {
                if (countStep%2==0){
                    System.out.println("Player A Win! Position coordinateXofArray="+coordinateXofArray+" coordinateYofArray="+coordinateYofArray);
                }else {
                    System.out.println("Player B Win!Position coordinateXofArray="+coordinateXofArray+" coordinateYofArray="+coordinateYofArray);
                }
            }
            countStep++;
        }
        printFieldGame(array);

        System.out.println("Game Over");
    }


    private static char[][] printMapGame() {
        char [][] array = new char [SIZE_MAP][SIZE_MAP];
        for (int j=0;j<SIZE_MAP;j++){
            for (int i=0;i<SIZE_MAP;i++){
                array[i][j]=EMPTY_FILL;
            }
        }

        printFieldGame (array);
        return array;
    }

    private static void printFieldGame( char[][] array) {

        System.out.print("X--->"+" #");
        int k=0;

        while (k<SIZE_MAP){
            ++k;
            System.out.printf("%7d",k);
        }
        System.out.println();
        for (int j = 0; j< SIZE_MAP; j++) {
            switch (j) {
                case 0:
                    System.out.printf("Y |%4d", j + 1);
                    break;
                case 1:
                    System.out.printf("  |%4d", j + 1);
                    break;
                case 2:
                    System.out.printf("  V%4d", j + 1);
                    break;
                default:
                    System.out.printf("%7d", j + 1);
            }
            for (int i = 0; i < SIZE_MAP; i++) {
                System.out.printf("%7s", array[i][j]);
            }
            System.out.println();
        }
        return;
    }


    private static boolean checkWin(char[][] array, char filling, int x, int y) {
        int CoefficientDiagonalDefineShift=0;
        boolean result=false;

        char[] checkLineLine= new char [SIZE_MAP];
        checkLineLine=array[y];
        result= checkConsensusInLine(checkLineLine,filling,CoefficientDiagonalDefineShift);
        if (result){
            return true;
        }

        char[] checkRowLine = new char [SIZE_MAP];
        for(int i=0;i<SIZE_MAP;i++){
            checkRowLine[i]=array[x][i];
        }
        result= checkConsensusInLine(checkRowLine,filling,CoefficientDiagonalDefineShift);
        if (result){
            return true;
        }

        char[] checkDiagonalLeftLine = new char [SIZE_MAP-CoefficientDiagonalDefineShift];
        CoefficientDiagonalDefineShift=Math.abs(x-y);
        int min=y;
        boolean flagChaingeXminusMinAndYFrom0=true;
        if (x<y){
            min=x;
            flagChaingeXminusMinAndYFrom0=false;
        }

        if (flagChaingeXminusMinAndYFrom0) {
            for (int i=0;i<SIZE_MAP-CoefficientDiagonalDefineShift;i++){
                checkDiagonalLeftLine[i]=array[x-min+i][i];
            }
        } else {
            for (int i=0;i<SIZE_MAP-CoefficientDiagonalDefineShift;i++){
                checkDiagonalLeftLine[i]=array[i][y-min+i];
            }
        }
        result= checkConsensusInLine(checkDiagonalLeftLine,filling,CoefficientDiagonalDefineShift);
        if (result) {
            return true;
        }


        CoefficientDiagonalDefineShift=Math.abs((SIZE_MAP-1-x) -y);
        if ((SIZE_MAP-CoefficientDiagonalDefineShift)<LEN_VICTORY_LINE){
            return false;
        }
        char[] checkDiagonalRightLine = new char [SIZE_MAP-CoefficientDiagonalDefineShift];
        int minForDefineShift=y;
        boolean flagForUpperDiagonal=true;

        if(y>(SIZE_MAP-x-1)){
            minForDefineShift=SIZE_MAP-x-1;
            flagForUpperDiagonal=false;
        }

        for(int i=0;i<SIZE_MAP-CoefficientDiagonalDefineShift;i++){

            if (flagForUpperDiagonal){
                checkDiagonalRightLine[i]=array[x+y-i][i];
            } else {
                checkDiagonalRightLine[i]=array[SIZE_MAP-1-i][y-minForDefineShift];
            }

        }
        result= checkConsensusInLine(checkDiagonalRightLine,filling,CoefficientDiagonalDefineShift);
        if (result) {
            return true;
        }

        return result;
    }


    private static boolean checkConsensusInLine (char[] arrayLine, char filling, int coeffDiag) {
        int k=0;
        int i=0;

        while (i<SIZE_MAP-LEN_VICTORY_LINE-1-coeffDiag) {

            while (k < LEN_VICTORY_LINE) {
                if (arrayLine[i+k] == filling) {
                    k++;
                } else {
                    break;
                }
            }
            if (k >= LEN_VICTORY_LINE) {
                return true;
            }
            if(k==0) {
                i++;
            }else{
                i+=k;
                //i++;
            }
            k=0;
        }
        return false;
    }
}