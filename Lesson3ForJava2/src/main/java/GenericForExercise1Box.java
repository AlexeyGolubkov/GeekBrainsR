public class GenericForExercise1Box<T> {
    private T obj;
    private static int number=0;

    public static int getNumber() {
        return number;
    }

    public GenericForExercise1Box(T оbj) {
        this.obj = оbj;
        number++;
    }

    public T getObj() {
        return obj;
    }

    public  String showType() {
        return (obj.getClass().getName());
    }
    @Override
    public String toString () {
        String str=showType();

        str=str+":"+ getObj()+":"+str;

        return str;
    }
}