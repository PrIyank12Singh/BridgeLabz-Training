public class CloneApp {

    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeObject original = new PrototypeObject("Model-X");
        PrototypeObject clone = (PrototypeObject) original.clone();

        System.out.println("Original: " + original);
        System.out.println("Clone:    " + clone);
    }
}
