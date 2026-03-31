public class SmartLightSystem {

    public static void main(String[] args) {

        // Motion trigger
        LightBehavior motionTrigger = () ->
                System.out.println("Lights ON at 70% brightness");

        // Time trigger (night mode)
        LightBehavior nightMode = () ->
                System.out.println("Dim warm lights activated");

        // Voice command trigger
        LightBehavior voiceCommand = () ->
                System.out.println("Party mode lights activated");

        motionTrigger.activate();
        nightMode.activate();
        voiceCommand.activate();
    }
}
