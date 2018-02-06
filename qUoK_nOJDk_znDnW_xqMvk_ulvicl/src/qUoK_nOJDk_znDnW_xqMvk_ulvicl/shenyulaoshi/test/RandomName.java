package qUoK_nOJDk_znDnW_xqMvk_ulvicl.shenyulaoshi.test;

import java.util.Random;
/** 作为github项目名使用 */
public class RandomName {
	private static Random random = new Random();
	public static void main(String[] args) {
		String rn = randomName(4)+"_"+randomName(5)+"_"+randomName(5)+"_"+randomName(5)+"_"+randomName(6);
		ToString.println(rn.length());
		ToString.println(rn);
//		of2d8-l1i2n4-j-od7djwlkeqp-la [length 29]
	}

	private static String randomName(int num) {		
		String name = "";
		for (int i = 0; i < num; i++) {
			name+=(char)((random.nextInt(2)==1?65:97) + random.nextInt(26));
		}
		return name;
	}

}
