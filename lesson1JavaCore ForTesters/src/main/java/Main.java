public class Main {

    public static void main(String[] args) {
        Course c = new Course(500,5); // Создаем полосу препятствий
        Team team = new Team(); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }

}
