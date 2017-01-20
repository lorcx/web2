package util;

import org.apache.log4j.Logger;

/**
 * 文件下载
 * Created by lx on 2016/2/21.
 */
@SuppressWarnings("unused")
public class downLoadPic {
    private static final long serialVersionUID = 1L;
    private Logger LOG = Logger.getLogger(downLoadPic.class);

    /**
     * 下载图片
     *
     */
    public String downPic(){
//        String userName = request.getParameter("userName");
//        response.addHeader("Content-Disposition","attachment;filename=" + userName + ".bmp");
//        try {
//            BaseUser user = userService.getBaseUserInfoByName(userName);
//            Blob blob = user.getPic();
//            int size = (int)blob.length();
//            byte[] b = blob.getBytes(1,size);
//            OutputStream out = response.getOutputStream();
//            out.write(b);
//            out.flush();
//
//        } catch (ServiceException e) {
//           LOG.error("下载图片失败！",e);
//        } catch (SQLException e) {
//          LOG.error("下载图片失败！", e);
//        } catch (IOException e) {
//            LOG.error("下载图片失败！", e);
//        }
        return null;
    }

}
