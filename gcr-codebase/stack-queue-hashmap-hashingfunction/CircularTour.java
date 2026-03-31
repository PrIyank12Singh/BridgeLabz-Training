import java.util.*;

class CircularTour {

    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int p, int d) {
            petrol = p;
            distance = d;
        }
    }

    public static int findStart(PetrolPump[] pumps) {

        Deque<Integer> queue = new ArrayDeque<>();

        int surplus = 0;
        int start = 0;

        for (int i = 0; i < pumps.length; i++) {

            surplus += pumps[i].petrol - pumps[i].distance;
            queue.offer(i);

            //If surplus then negative 
            if (surplus < 0) {
                queue.clear();
                surplus = 0;
                start = i + 1;
            }
        }

        return queue.isEmpty() ? -1 : start;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Taking Input
        int n = sc.nextInt();

        PetrolPump[] pumps = new PetrolPump[n];

        for (int i = 0; i < n; i++) {
            int petrol = sc.nextInt();
            int distance = sc.nextInt();
            pumps[i] = new PetrolPump(petrol, distance);
        }

        int startIndex = findStart(pumps);

        if (startIndex == -1) {
            System.out.println("No possible tour");
        } else {
            System.out.println(startIndex);
        }

        sc.close();
    }
}
