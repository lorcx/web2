package util.upload;

import module.sys.entity.BaseUser;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *文件上传
 * Created by dell on 2016/1/7.
 */
public class UploadFileServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(UploadFileServlet.class);
//    private HibernateTemplate template;
//    private Session session;

    /**
     * servelt文件上传
     * @param :request
     * @param :response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temp_dir = "/WEB-INF/tmp";
        int DEFAULT_SIZE = 1024 * 1024;
        int SIZE_MAX = 100;//默认大小M
        int thresholdSize = 10;//向磁盘写入的文件的临界值(单位:M)

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(thresholdSize * DEFAULT_SIZE);//设置保存到内存还是临时目录，超过临界值保存到临时目录，否则保存到内存
        factory.setRepository(new File(getServletContext().getRealPath(temp_dir)));//临时目录
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        upload.setSizeMax(SIZE_MAX * DEFAULT_SIZE);//设置大小
        try {
            List<FileItem> list =(List<FileItem>) upload.parseRequest(request);//多组上传
            if(null != list && list.size() > 0 ){
                for(FileItem item : list){
                    if(!item.isFormField()){
//                        String fileName = item.getName();
                        //文件后缀
//                        String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
//                String oldName = fileName.replaceAll("." + fileSuffix,"");
                        InputStream in = item.getInputStream();
//                        Blob file  = Hibernate.createBlob(in);
                        BaseUser user = getBaseUserInfoByName("admin");//获取用户信息
                        if(null != user){
//                            user.setPic(file);
                            saveOrUpdateBaseUser(user);
                            response.getWriter().print(1);
                        }else{
                            response.getWriter().print(0);
                            LOG.error(" servelt文件上传-失败");
                        }
                    }
                }
            }
        } catch (Exception e) {
            response.getWriter().print(0);
            e.printStackTrace();
            LOG.error("文件上传失败", e);
        }
    }

    /**
     * 查询用户信息
     * @param:name
     * @return
     */
    public BaseUser getBaseUserInfoByName(String name){
        StringBuilder sql = new StringBuilder();
        sql.append("from BaseUser where userName = '").append(name).append("'");
//        return (BaseUser) template.find(sql.toString()).get(0);
        return null;
    }

    /**
     * 保存用户信息
     * @param:user
     * @return
     */
    public void saveOrUpdateBaseUser(BaseUser user){
        try {
//            if(StringUtils.isEmpty(user.getId())) {
//                template.save(user);
//            }else {
//                template.update(user);
//            }
        }catch (Exception e){
            LOG.error("保存用户信息失败");
        }
    }

//    public void setSession(HibernateTemplate template){
//        template.execute(new HibernateCallback() {
//            @Override
//            public Object doInHibernate(Session session) throws HibernateException, SQLException {
//                return null;
//            }
//        });
//
////        session = template.getSessionFactory().getCurrentSession();
////        if(null == session){
////            session = template.getSessionFactory().openSession();
////        }
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

//    public void init() throws ServletException{
//        //在servlet中使用spring的bean
//        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
//        template = (HibernateTemplate) ac.getBean("hibernateTemplate");
////        setSession(template);
//    }

    public void destroy() {

    }

//    public void setTemplate(HibernateTemplate template) {
//        this.template = template;
//    }

}
