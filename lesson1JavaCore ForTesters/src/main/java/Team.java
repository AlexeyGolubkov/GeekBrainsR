
public class Team {
    private String name;
    private int numbersMembers;
    private boolean finish;
    private static int numbersTeams = 0;
    private int[] timeOfMembers;    //
    private int[] timeForEverMember;    //

    public String getName() {
        return name;
    }

    public int getNumbersMembers() {
        return numbersMembers;
    }

    public boolean getFinish() {
        return finish;
    }

    public static int getNumbersTeams() {
        return numbersTeams;
    }

    public Team(String name, int numbersMembers) {
        this.name = name;
        this.numbersMembers = numbersMembers;
        this.timeForEverMember=initArrayWitchZero(numbersMembers);
/*
        int[]  timeOfMembers = new int[numbersMembers]   ;
        for (int i=0;i<numbersMembers;i++) {
          timeOfMembers[i] = 0;
        }
*/
        //this.timeForEverMember =timeOfMembers;
        finish=false;
        numbersTeams++;
    }

    private int[] initArrayWitchZero(int numbersMembers) {
        int[]  timeOfMembers = new int[numbersMembers]   ;
        for (int i=0;i<numbersMembers;i++) {
            timeOfMembers[i] = 0;
        }
        return timeOfMembers;
    }

    public Team() {
        this.numbersMembers = 2;
        this.timeForEverMember=initArrayWitchZero(numbersMembers);
        this.name = "NameTeam"+numbersTeams;
         numbersTeams++;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public int[] getTimeForEverMember() {
        return timeForEverMember;
    }

    public void setTimeForEverMembers (int[] timeForEverMember) {
        this.timeForEverMember = timeForEverMember;
    }

    public void showResults(){
     System.out.printf("Команда %s%n", getName());
     if (!finish){
          System.out.println("не участвовала в соревнованиях");
         return;
     }
     int i=1 ;
     for (int one: getTimeForEverMember())  {
       System.out.println("Результат участника "+i+": "+ one+" времени");
       i++;
     }
    }

}