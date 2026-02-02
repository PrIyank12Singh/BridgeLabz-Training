class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature is executed");
    }

    public void newFeature() {
        System.out.println("New feature is executed");
    }
}

public class DeprecatedDemo {

    public static void main(String[] args) {

        LegacyAPI api = new LegacyAPI();

        api.oldFeature();   //Deprecated method
        api.newFeature();   // Recommended method
    }
}
