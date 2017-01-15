package util.upload;

import common.exception.ServiceException;
import module.base.user.entity.BaseUser;
import module.base.user.service.IBaseUserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

/**
 * 文件上传处理(暂未使用) 有bug
 * Created by dell on 2015/12/10.
 * suffix 下标
 * 文件上传
 */
@SuppressWarnings("all")
public class FileUpload {
    private IBaseUserService userService;
    private static final Logger LOG = Logger.getLogger(FileUpload.class);
    private static final int DEFAULT_SIZE = 1024 * 1024;
    private static final int SIZE_MAX = 100;//默认大小M
    private int thresholdSize = 10;//向磁盘写入的文件的临界值(单位:M)

    /**
     * 文件上传
     */
    public String upload() {
//        String TEMP_DIR = request.getContextPath() + "//tmp";
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        factory.setSizeThreshold(thresholdSize * DEFAULT_SIZE);//设置保存到内存还是临时目录，超过临界值保存到临时目录，否则保存到内存
//        factory.setRepository(new File(TEMP_DIR));//临时目录
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        upload.setHeaderEncoding("UTF-8");
//        upload.setSizeMax(SIZE_MAX * DEFAULT_SIZE);//设置大小
//        try {
//            List<FileItem> list = (List<FileItem>) upload.parseRequest(request);//多组上传
//            if (null != list && list.size() > 0) {
//                for (FileItem item : list) {
//                    if (!item.isFormField()) {
//                        String fileName = item.getName();
//                        //文件后缀
//                        String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
////                String oldName = fileName.replaceAll("." + fileSuffix,"");
//                        Blob file = null;
//                        InputStream in = item.getInputStream();
//                        file = Hibernate.createBlob(in);
//                        BaseUser user = userService.getBaseUserInfoById("admin");//获取用户信息
//                        if(null != user){
//                            user.setPic(file);
//                            userService.saveBaseUser(user);
//                        }else {
//                            LOG.error("文件上传失败");
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            LOG.error("文件上传失败", e.getCause());
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
        return null;
    }


    public void setUserService(IBaseUserService userService) {
        this.userService = userService;
    }
}
