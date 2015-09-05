package javaweb3.utils;

import java.security.MessageDigest;

public class StringUtils {
	public static boolean isEmpty(String input) {
		if (input == null)
			return false;
		return input.isEmpty();
	}

	public static String sha256(String base) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(base.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void main(String[] args) {
		// String s = null;

		// System.out.println(s.isEmpty());
	}

}
