import java.util.Scanner;

public class String2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter a string: ");
    String newString = scanner.nextLine();
    System.out.println(convertxy(newString));
  }

  private static String convertxy(String n) {
    if (n.length() == 0) {
      return "";
    }
    if (n.charAt(0) == 'x') {
      return "" + convertxy(n.substring(1, n.length()));
    } else {
      return n.charAt(0) + convertxy(n.substring(1, n.length()));
    }
  }
}
// Given a string, compute recursively a new string where all the 'x' chars have been removed.
