
public class Main {
    public static final int COUNT_DOG=100,COUNT_CAT=100;


    public static void main(String[] args) {
        Dog[] dog = new Dog[COUNT_DOG];
        Cat [] cat = new Cat[COUNT_CAT];

        for (int i = 0; i < COUNT_DOG; i++) {


            dog[i]=new Dog("Собака"+i,5+i/100,"color"+i,2000+((int)(i/10)));

            System.out.println(dog[i].getName()+" "+dog[i].doRun(100+i*5));
            System.out.println(dog[i].doSwim(50+i*2));
            if(i%2==0) {
                cat[i/2] = new Cat("Cat"+i/2, 1.5 + 1 / 200, "color" + i, 2000 + ((int) (i / 10)));
                System.out.println(cat[i/2].doRun(100+i*3));
                System.out.println(cat[i/2].doSwim(i*2));
            }
        }
        System.out.println("Собак во дворе: "+Dog.getNumberDogs());
        System.out.println("Котов в классе: "+Cat.getNumberCats());
        System.out.println("Всего животных создано этой программой: "+Animals.getNumberAnimals());
    }

}
