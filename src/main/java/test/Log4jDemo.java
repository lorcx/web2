package test;


import org.apache.log4j.Logger;

/**
 *log4j
 *创建人：lixin
 *创建时间：2015-1-27 下午9:38:21
 *类名：
 */
public class Log4jDemo {

	private static final Logger log = Logger.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
		log.error("士大夫");
		log.debug("debug");
		log.fatal("fatal");
		log.info("士大夫");
		log.warn("warn");
		//		String s1 = "1";
//		String s2 = s1;
//		System.out.println(s1 == s2);
//
//		String s3 = "3";
//		String s4 = "3";
//		System.out.println(s3 == s4);
//
//		String s5 = new String("3");
//		String s6 = new String("3");
//		String s7 = s5;
//		System.out.println(s5 == s6);
//		System.out.println("==" + (s5 ==s7));
//		int[] n1 = {1,2,3};
//		Log4jDemo l1 = new Log4jDemo();
//		Log4jDemo l2 = l1;
//		System.out.println(l1 == l2);
//		System.out.println(l1.equals(l2));
	}
}
