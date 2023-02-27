import java.util.ArrayList;

public class Main {


    static void testMethod(int t){
        t++;
        t++;
        System.out.println(t);
    }


    public static void main(String[] args) {


        int x = 0 ;

        testMethod(x);
        System.out.println(x);

    }
}