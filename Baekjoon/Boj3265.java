import java.io.*;
import java.util.StringTokenizer;
	
public class Boj3265 {
	public static void main(String[]args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[]B = new int[n+1];
		int[]A = new int[n+1];
		int[]E = new int[n+1];
		
		st = new StringTokenizer(bf.readLine()," ");
		for(int i=1; i<=n; i++) B[i] = Integer.parseInt(st.nextToken());
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(bf.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a] = b;
			E[b] = 1;
		}
		
		solve(n,A,B,E);
		if(B[n] == 0) bw.write("-1");
		else {
			for(int i=1; i<=n; i++) bw.write(A[i]+" ");
		}
		bw.flush();
		bw.close();
		bf.close();
	}
	public static void solve(int n,int[]A,int[]B,int[]E) {
		if(B[n] == 0) return;
		int p = 0;
		for(int i=1; i<=n; i++) {
			if(B[i] == 1) {
				int l = p+1,r = i;
				for(int j=l; j<=r; j++) {
					if(A[j] == 0) continue;
					if(A[j] < l || A[j] > r) {
						B[n] = 0;
						return;
					}
				}	
				p = i+1;
			}
		}
		p = 0;
		for(int i=1; i<=n; i++) {
			if(B[i] == 1) {
				int l = p+1,r = i;	
				int x = r;
				for(int j=l; j<=r; j++) {
					if(A[j] > 0) continue;
					while(E[x] > 0) x--;
					E[x] = 1;
					A[j] = x;
				}
				int mx = 0;
				for(int j=l; j<r; j++) {
					mx = Math.max(mx, A[j]);
					if(mx == j) {
						B[n] = 0;
						return;
					}
				}
				p = i;
			}
		}
	}
}