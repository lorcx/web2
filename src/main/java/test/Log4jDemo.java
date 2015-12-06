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
		log.error("error1");
//		log.debug("debug");
//		log.fatal("fatal");
//		log.info("info");
//		log.warn("warn");
	}
}
