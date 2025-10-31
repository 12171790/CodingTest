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
        public int compareTo(Student other) {
                if (this.kor != other.kor) {
                    return other.kor - this.kor;
                } else if (this.eng != other.eng) {
                    return this.eng - other.eng;
                } else if (this.math != other.math) {
                    return other.math - this.math;
                } else {
                    return this.name.compareTo(other.name);
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
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            
            Student temp = new Student(name, kor, eng, math);
            students[i] = temp;
        }
        
        Arrays.sort(students);
        
        for (int i = 0; i < n; i++) {
            System.out.println(students[i].name);
        }
    }
}