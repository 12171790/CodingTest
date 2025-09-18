import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String[] tails = new String[str.length()];

    for (int i = 0; i < str.length(); i++) {
      tails[i] = str.substring(i);
    }
    Arrays.sort(tails);
    
    for (String temp : tails) {
        System.out.println(temp);
    }
  }
}