import java.io.*;
import java.util.*;

public class Main {
    static class Member implements Comparable<Member> {
        public String name;
        public int age;
        public int joinOrder;
    
        public Member(String name, int age, int joinOrder) {
            this.name = name;
            this.age = age;
            this.joinOrder = joinOrder;
        }
    
        @Override
        public int compareTo(Member other) {
            if (this.age != other.age) {
                return this.age - other.age;
            } else {
                return this.joinOrder - other.joinOrder;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Member[] members = new Member[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int joinOrder = i + 1;
            
            members[i] = new Member(name, age, joinOrder);
        }
        
        Arrays.sort(members);
        
        for (Member m : members) {
            System.out.println(m.age + " " + m.name);
        }
    }
}