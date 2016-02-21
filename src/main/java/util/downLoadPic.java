package util;

import common.action.BaseAction;
import common.exception.ServiceException;
import module.base.user.entity.BaseUser;
import module.base.user.service.IBaseUserService;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * 文件下载
 * Created by lx on 2016/2/21.
 */
@SuppressWarnings("unused")
public class downLoadPic extends BaseAction {
    private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(downLoadPic.class);
    private IBaseUserService userService;

    /**
     * 下载图片
     *
     */
    public String downPic(){
        String userName = request.getParameter("userName");
        response.addHeader("Content-Disposition","attachment;filename=" + userName + ".bmp");
        try {
            BaseUser user = userService.getBaseUserInfoByName(userName);
            Blob blob = user.getPic();
            int size = (int)blob.length();
            byte[] b = blob.getBytes(1,size);
            OutputStream out = response.getOutputStream();
            out.write(b);
            out.flush();

        } catch (ServiceException e) {
           LOG.error("下载图片失败！",e);
        } catch (SQLException e) {
          LOG.error("下载图片失败！", e);
        } catch (IOException e) {
            LOG.error("下载图片失败！", e);
        }
        return null;
    }

    public void setUserService(IBaseUserService userService) {
        this.userService = userService;
    }
}
