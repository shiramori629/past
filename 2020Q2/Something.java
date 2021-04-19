
public class Something {

	private static final int VALUE1 = 36;
	private static final int VALUE2 = 15;

	private static int method1(int n1, int n2) {
		if (n1 >= n2) {
			while (n1 >= n2) {
				n1 -= n2;
			}

			return n1;
		} else {
			while (n2 >= n1) {
				n2 -= n1;
			}

			return n2;
		}
	}

	private static int method2(int n1, int n2) {
		while (n1 != n2) {
			if (n1 > n2)
				n1 -= n2;
			else
				n2 -= n1;
		}
		return n2;
	}

	private static int method3(int n1, int n2) {
		return n1 * n2 / method2(n1, n2);
	}

	public static int someMethod(int n1, int n2, int n3, int n4) {
		int sum = 0;
		if (method2(n1, n2) == VALUE1) {
			if (method3(n1, n3) == method3(n2, n4)) {
				sum += n1 + n4;
			}
			sum += n1 + n2;
		}

		if (method1(n3, n4) == VALUE2) {
			sum += n3 + n4;
		}

		return sum;
	}
	
public static void main(String[] args) {
    int m1 = method2(72, 36);
    int m2 = method1(31, 16);
    int m3 = method3(72, 31);
    int m4 = method3(36, 16);
    int s1 = someMethod(1, 1, 1, 2);
    System.out.println(s1);
    // 228 36 36 30 45 ttt
    // 72 36 36 1 5 tff
    // 0 1 1 1 2 fff


    for (int n1 = 1; n1 < 100; n1++) {
      for (int n2 = 1; n2 < 100; n2++) {
        for (int n3 = 1; n3 < 100; n3++) {
          for (int n4 = 1; n4 < 100; n4++) {
            if (!(method2(n1, n2) == VALUE1) && !(method3(n1, n3) == method3(n2, n4))
                && !(method1(n3, n4) == VALUE2)) {
              System.out.println(n1);
              System.out.println(n2);
              System.out.println(n3);
              System.out.println(n4);
              return;
            }


          }
        }
      }

    }
    //
    // System.out.println(m1);
    // System.out.println(m2);
    // System.out.println(m3);
    // System.out.println(m4);


  }
}
