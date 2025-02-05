import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Boj11917 {
	public static void main(String[]args) {
		TreeSet<Integer> st = new TreeSet<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]A = new int[n+1];
		for(int i=1; i<=n; i++) {
			int x =  sc.nextInt();
			A[i] = x;
			st.add(x);
		}
		int m = sc.nextInt();
		if(m <= n) System.out.print(A[m]);
		else {
			int nxt = st.size();
			if(st.contains(nxt)) System.out.print(nxt);
			else {
				if(st.higher(nxt) == null) System.out.print(m-n + nxt-1);
				else {
					int fin = st.higher(nxt);
					m-=n;
					if(fin-nxt+1 >= m) System.out.print(nxt-1+m);
					else System.out.print(fin);
				}
			}
		}
	}
}
