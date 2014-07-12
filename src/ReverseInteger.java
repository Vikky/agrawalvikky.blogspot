/**
 * @author Vikky.Agrawal Reverse digits of an integer. Example1: x = 123, return
 *         321 Example2: x = -123, return -321
 */
public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseInteger obj = new ReverseInteger();
		System.out.println(obj.reverse(-1000));
	}

	public int reverse(int x) {

		if (x == 0) {
			return x;
		}

		int val = Math.abs(x);
		int retVal = 0;

		while (val > 0) {
			retVal = retVal * 10 + (val % 10);
			val = val / 10;
		}

		// Checking whether there should be leading zero's?
		//Print number with leading zero's
		int zeroval = Math.abs(x);
		int zeros = 0;
		if (zeroval % 10 == 0) {
			while (zeroval > 0) {
				if (zeroval % 10 == 0) {
					zeros++;
					zeroval /= 10;
				} else {
					break;
				}
			}
			System.out.print("Number with zero's : ");
			if (x < 0) {
				System.out.print("-");
			}

			while (zeros-- > 0) {
				System.out.print("0");
			}
			System.out.println(retVal);
		}

		if (x < 0) {
			retVal = -retVal;
		}

		return retVal;
	}

}
