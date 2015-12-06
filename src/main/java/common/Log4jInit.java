package common;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Log4jInit implements ServletContextListener {
	private Logger log = Logger.getLogger(Log4jInit.class);

	public void contextDestroyed(ServletContextEvent sce) {
		log.info("Log4jInit -- contextDestroyed");
	}

	public void contextInitialized(ServletContextEvent sce) {
		//得到servletContext对象的方法
		ServletContext sc = sce.getServletContext();
		//指明文件的相对路径就能够得到文件的绝对路径
		System.out.println(sc.getContextPath());
		String path = sc.getRealPath("config/log4j.properties");
		System.out.println(path);
		//启动服务器的时候加载日志的配置文件
		init(path,sc);
	}
	/**
	 * 加载log4j
	 * @param path
	 * @param sc
	 */
	public void init(String path,ServletContext sc) {
		FileInputStream fis = null;
		Properties props = new Properties();
		try {
			fis = new FileInputStream(path);
			props.load(fis);
			PropertyConfigurator.configure(path);
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}finally{
			try {
				if(fis !=null){
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
