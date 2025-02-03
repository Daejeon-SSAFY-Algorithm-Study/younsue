import java.io.*;
import java.util.StringTokenizer;
public class Boj30411 {
	public static void main(String[]args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long w = n;
		if((w/2)*(w-w/2) < k) bw.write("NO");
		else {
			bw.write("YES\n");
			for(int i=1; i<=n/2; i++) {
				for(int j=n/2+1; j<=n; j++) {
					if(k == 0) break;
					k--;
					bw.write(i + " " + j + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}