package shop;
import java.lang.*;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "This is TutorialsPoint";
        // returns canonical representation for the string object
        String str2 = str1.intern();
        String str3 = str1;

        // prints the string str2
        System.out.println(str2);

        // check if str1 and str2 are equal or not
        System.out.println("Is str1 equal to str2 ? = " + (str1.equals(str2)));
        System.out.println("Is str1 equal to str3 ? = " + (str1.equals(str3)));
        String a = "Hello world";
        String b = new String("Hello world");
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }
}
