package Activities;

public class Generics {
    public static void main(String[] args) {
        System.out.println(echo2 ("Hello"));
        System.out.println(echo2 (5));
        System.out.println(echo2 (true));
    }
    public static <T> T echo2(T input){
        return input;
    }
}
