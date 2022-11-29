public class Task1 {
  public static int factorial(int n) throws IllegalArgumentException {
    if (n < 0) throw new IllegalArgumentException();
    return (n == 0) ? 1 
      : n * factorial(n - 1);
  }

  public static void main(String[] args) {
    System.out.println(factorial(6));
  }
}