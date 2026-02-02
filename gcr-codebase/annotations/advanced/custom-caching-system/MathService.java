class MathService {

    @CacheResult
    public long factorial(int n) {
        System.out.println("Computing factorial of " + n);
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
