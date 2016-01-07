package servlet.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

/**
 *
 * Created by dell on 2016/1/7.
 */
@SuppressWarnings("all")
public class UploadFileServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(UploadFileServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String TEMP_DIR = request.getContextPath() + "//tmp" ;
        int DEFAULT_SIZE = 1024 * 1024;
        int SIZE_MAX = 100;//默认大小M
        int thresholdSize = 10;//向磁盘写入的文件的临界值(单位:M)

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(thresholdSize * DEFAULT_SIZE);//设置保存到内存还是临时目录，超过临界值保存到临时目录，否则保存到内存
        factory.setRepository(new File(TEMP_DIR));//临时目录
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        upload.setSizeMax(SIZE_MAX * DEFAULT_SIZE);//设置大小
        try {
            List<FileItem> list =(List<FileItem>) upload.parseRequest(request);//多组上传
            if(null != list && list.size() > 0 ){
                for(FileItem item : list){
                    if(!item.isFormField()){
                        String fileName = item.getName();
                        //文件后缀
                        String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
//                String oldName = fileName.replaceAll("." + fileSuffix,"");
                        Blob file = null;
                        InputStream in = item.getInputStream();
                        file = Hibernate.createBlob(in);
//                        BaseUser user = userService.getBaseUserInfoById("admin");//获取用户信息
//                        user.setPic(file);
//                        userService.saveBaseUser(user);

                    }
                }
            }
        } catch (Exception e) {
            LOG.error("文件上传失败", e.getCause());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void init() throws ServletException{


    }

    @Override
    public void destroy() {

    }
}
