package algoritmiekEnDatastructurenWeek1;

class recursion {
	public static void main(String[] args) {
		long start, end;
		int aantalkeer = 10000;

		start = System.currentTimeMillis();
		System.out.println("\nOptie 1:");
		System.out.println(noverk1(6, 3));
		System.out.println(noverk1(10, 5));
		System.out.println(noverk1(15, 8));
		for (int i = 0; i < aantalkeer; i++) {
			noverk1(6, 3);
			noverk1(10, 5);
			noverk1(15, 8);
		}
		end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));

		start = System.currentTimeMillis();
		System.out.println("\nOptie 2:");
		System.out.println(noverk2(6, 3));
		System.out.println(noverk2(10, 5));
		System.out.println(noverk2(15, 8));
		for (int i = 0; i < aantalkeer; i++) {
			noverk2(6, 3);
			noverk2(10, 5);
			noverk2(15, 8);
		}
		end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));

		start = System.currentTimeMillis();
		System.out.println("\nOptie 3:");
		System.out.println(noverk3(6, 3));
		System.out.println(noverk3(10, 5));
		System.out.println(noverk3(15, 8));
		for (int i = 0; i < aantalkeer; i++) {
			noverk3(6, 3);
			noverk3(10, 5);
			noverk3(15, 8);
		}
		end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));

		start = System.currentTimeMillis();
		System.out.println("\nOptie 4:");
		System.out.println(noverk4(6, 3));
		System.out.println(noverk4(10, 5));
		System.out.println(noverk4(15, 8));
		for (int i = 0; i < aantalkeer; i++) {
			noverk4(6, 3);
			noverk4(10, 5);
			noverk4(15, 8);
		}
		end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));
	}

	public static long noverk1(long n, long k) {
		if (k > n || k < 0) {
			return 0;
		}

		if (n == k || k == 0) {
			return 1;
		}

		return (fac(n)) / (fac(k) * fac(n - k));
	}

	public static long fac(long n) {
		if (n == 1)
			return 1;
		else
			return fac(n - 1) * n;
	}

	public static int noverk2(int n, int k) {
		if (k > n || k < 0) {
			return 0;
		}

		if (n == k || k == 0) {
			return 1;
		}

		Double r = 1.0;

		for (Double i = 1.0; i <= k; i++) {
			r = r * ((n + 1 - i) / (i));
		}

		Long L = Math.round(r);
		int i = Integer.valueOf(L.intValue());

		return i;
	}

	public static int noverk3(int n, int k) {
		if (k > n || k < 0) {
			return 0;
		}

		if (n == k || k == 0) {
			return 1;
		}

		return noverk3(n - 1, k - 1) * n / k;
	}

	public static int noverk4(int n, int k) {
		if (k > n || k < 0) {
			return 0;
		}

		if (n == k || k == 0) {
			return 1;
		}

		return noverk4(n - 1, k) + noverk4(n - 1, k - 1);
	}
}
