package shop;

public class Generic<T> {

    public static void main(String[] args) {
        Generic<Integer> integerGeneric = new Generic<Integer>(1);
//        String a = integerGeneric.get();
        Generic<String> str = new Generic<String>("");
    }

    T val;

    public Generic(T val) {
        this.val = val;
    }

    public T get() {
        return val;
    }

}
