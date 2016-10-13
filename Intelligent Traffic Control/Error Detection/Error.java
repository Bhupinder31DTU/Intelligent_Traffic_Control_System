import java.util.Random;
public class Error {
	public static void main(String ...args) {
		Random r = new Random(1234);
		for(int i=0;i<10;i++) {
			System.out.println(r.nextInt());
		}
	}
}