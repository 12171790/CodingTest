import java.util.*;
import java.io.*;

public class Main {
  static class Student implements Comparable<Student> {
    public String name;
    public int kor;
    public int eng;
    public int math;

    public Student(String name, int kor, int eng, int math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
    }

    @Override
    public int compareTo(Student other) {
      if (this.kor != other.kor) {
        return other.kor - this.kor;
      } else {
        if (this.eng != other.eng) {
          return this.eng - other.eng;
        } else {
          if (this.math != other.math) {
            return other.math - this.math;
          } else {
            return this.name.compareTo(other.name);
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Student[] students = new Student[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      int[] scores = new int[3];

      for (int j = 0; j < 3; j++) {
        scores[j] = Integer.parseInt(st.nextToken());
      }

      students[i] = new Student(name, scores[0], scores[1], scores[2]);
    }

    Arrays.sort(students);

    for (Student st : students) {
      System.out.println(st.name);
    }
  }
}