public class HorribleSteve {
	public static void main (String [] args) {
		int i = 0;
		/*for (int j = 0; i < 500; ++i, ++j) {

			if (!Flik.isSameNumber(i, j)) {
          break; // break exits the for loop!
			}
		}*/
		int j = 0;
		while (i<500){

			if (!Flik.isSameNumber(i,j)){
				break;
			}
			i += 1;
			j += 1;
		}
		System.out.println("i is " + i);
	}
} 