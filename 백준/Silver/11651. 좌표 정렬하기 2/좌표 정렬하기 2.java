import java.io.*;
import java.util.*;

public class Main {
    static class Position implements Comparable<Position> {
        public int x;
        public int y;
        
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Position other) {
            if (this.y != other.y) {
                return this.y - other.y;
            } else {
                return this.x - other.x;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Position[] positions = new Position[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            positions[i] = new Position(x, y);
        }
        
        Arrays.sort(positions);
        
        for (Position pos : positions) {
            System.out.println(pos.x + " " + pos.y);
        }
    }
}