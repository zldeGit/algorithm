package lu.zhang;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class EncryptUtil {

	/**
	 * 加密统一方法
	 * @param strSrc
	 * @param algorithm
	 * @return
	 */
	public static String encrypt(String strSrc, String algorithm) {
		MessageDigest md = null;
		String strDes = null;
		byte[] bt = strSrc.getBytes();
		try {
			md = MessageDigest.getInstance(algorithm);
			md.update(bt);
			strDes = bytes2Hex(md.digest()); //to HexString
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Invalid algorithm.");
			return null;
		}
		return strDes;
	}

	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}
	
	/**
	 * MD5加密
	 * @param strSrc
	 * @return
	 */
	public static String MD5(String strSrc) {
		return encrypt(strSrc, "MD5").toUpperCase();
	}
	
	/**
	 * MD5盐值加密
	 * @param pwd
	 * @param salt
	 * @return
	 */
	public static String MD5(String pwd, String salt) {
		return MD5(pwd + salt);
	}
	
	/**
	 * SHA1加密
	 * @param strSrc
	 * @return
	 */
	public static String SHA1(String strSrc) {
		return encrypt(strSrc, "SHA-1").toUpperCase();
	}

	/**
	 * SHA256加密
	 * @param strSrc
	 * @return
     */
	public static String SHA256(String strSrc) {return encrypt(strSrc, "SHA-256").toUpperCase(); }
	
	/**
	 * SHA1盐值加密
	 * @param pwd
	 * @param salt
	 * @return
	 */
	public static String SHA1(String pwd, String salt) {
		return SHA1(pwd + salt);
	}

	/**
	 * SHA256盐值加密
	 * @param pwd
	 * @param salt
     * @return
     */
	public static String SHA256(String pwd, String salt) {
		return SHA256(pwd + salt);
	}

	public static String generateApiKey() {
		String uuid = UUID.randomUUID().toString().replace("-","");
		return MD5(uuid, String.valueOf(System.currentTimeMillis())).toLowerCase();
	}

	public static void main(String[] args) {
		String s = EncryptUtil.SHA256("zkwgrl");
		System.out.println(s.toUpperCase());
	}
}
