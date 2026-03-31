public class PrototypeObject implements Cloneable {
    private String model;

    public PrototypeObject(String model) {
        this.model = model;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "PrototypeObject[model=" + model + "]";
    }
}
