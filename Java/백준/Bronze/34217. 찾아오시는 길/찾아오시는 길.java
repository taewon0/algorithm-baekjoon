import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int h2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        if (h1 + h2 < y1 + y2) {
            System.out.println("Hanyang Univ.");
        } else if (h1 + h2 > y1 + y2) {
            System.out.println("Yongdap");
        } else {
            System.out.println("Either");
        }
    }
}