public class RotationPointInRotatedSortedArray{

    public static void main(String[] args) {
        //Rotation Point
        int[] rotatedArray = {15, 18, 2, 3, 6, 12};
        int rotationIndex = findRotationPoint(rotatedArray);
        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Rotation point value: " + rotatedArray[rotationIndex]);
    }

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1; // rotation point is in the right half
            } else {
                right = mid; // rotation point is in the left half including mid
            }
        }

        return left; // left ==  right at rotation point
    }
}
