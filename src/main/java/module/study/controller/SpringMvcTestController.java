package module.study.controller;

import com.sun.xml.internal.ws.api.message.stream.InputStreamMessage;
import module.sys.entity.SysUser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * spring mvc 传值学习
 * Created by lx on 2017/4/3.
 */
@Controller
@RequestMapping("springMvcTest")
public class SpringMvcTestController {

    /**
     * ajax请求
     * 参数自动匹配，参数名称必须一样
     * 返回必须要写responseBody
     * @param msg
     * @return
     */
    @RequestMapping("/m1")
    @ResponseBody
    public String m1(String msg) {
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/m2")
    @ResponseBody
    public String m2(@RequestParam("msg") String abc) {
        System.out.println(abc);
        return "success";
    }

    @RequestMapping("/m3/{msg}")
    @ResponseBody
    public String m3(@PathVariable("msg") String abc) {
        System.out.println(abc);
        return "success";
    }

    /**
     * 普通
     * @param request
     * @return
     */
    @RequestMapping("/gotoJsp")
    public String gotoJsp(HttpServletRequest request) {
        List<SysUser> userList = new ArrayList<>();
        SysUser user = new SysUser();
        user.setUserName("李四");
        user.setCreTime(new Date());
        user.setId("99999999");
        user.setPhone("12312312321");
        userList.add(user);
        request.setAttribute("userList", userList);
        return "study/springMvc.jsp";
    }

    /**
     * modelandview
     * @return
     */
    @RequestMapping("/gotoJsp1")
    public ModelAndView gotoJsp1() {
        List<SysUser> userList = new ArrayList<>();
        SysUser user = new SysUser();
        user.setUserName("张三");
        user.setCreTime(new Date());
        user.setId("99999999");
        user.setPhone("12312312321");
        userList.add(user);
        // 创建modelAndView 填充数据
        ModelAndView mav = new ModelAndView();
        // 填充数据 request.setAttribute("","");
        mav.addObject("userList", userList);
        // 视图逻辑名称 reuqest.getRequestDispatcher("url").forward(req, resp);
        mav.setViewName("study/springMvc.jsp");
        return mav;
    }

    /**
     * @TODO
     * forward (有问题)
     * @param request
     * @return
     */
    @RequestMapping("/forward/gotoJsp")
    public String gotoJsp2(HttpServletRequest request) {
        List<SysUser> userList = new ArrayList<>();
        SysUser user = new SysUser();
        user.setUserName("李四");
        user.setCreTime(new Date());
        user.setId("99999999");
        user.setPhone("12312312321");
        userList.add(user);
        request.setAttribute("userList", userList);
        return "forward:study/springMvc.jsp";
    }


    /**
     * @TODO
     * redict (有问题)
     * @param request
     * @return
     */
    @RequestMapping("/redirect/gotoJsp")
    public String gotoJsp3(HttpServletRequest request) {
        List<SysUser> userList = new ArrayList<>();
        SysUser user = new SysUser();
        user.setUserName("李四");
        user.setCreTime(new Date());
        user.setId("99999999");
        user.setPhone("12312312321");
        userList.add(user);
        request.setAttribute("userList", userList);
        return "redirect:/study/springMvc.jsp";
    }

    /**
     *
     *支持ant风格
     * Ant风格资源地址支持3种匹配符：
     *      ?：匹配文件中的一个字符
     *      *：匹配文件中任意字符
     *      **：**匹配多层路径 @RequestMapping
     */
    @RequestMapping(value = "/m3/**/user", method = RequestMethod.GET)
    @ResponseBody
    public String m5() {
        System.out.println("m5");
        return "success";
    }

    @RequestMapping(value = "/m4/?/user", method = RequestMethod.GET)
    @ResponseBody
    public String m3() {
        System.out.println("m5");
        return "success";
    }

    /**
     * POST请求（新增）
     * @return
     */
    @RequestMapping(value = "/m6", method = RequestMethod.POST)
    @ResponseBody
    public String m6(String username , String password) {
        System.out.println("username" + username + "password" + password);

        return "success";
    }
    /**
     * PUT 请求(修改)
     * @return
     */
    @RequestMapping(value = "/m7", method = RequestMethod.PUT)
    @ResponseBody
    public String m7(String username , String password) {
        System.out.println("put : username: " + username + "password" + password);

        return "success";
    }
    /**
     * delete 删除
     * @return
     */
    @RequestMapping(value = "/m8", method = RequestMethod.DELETE)
    @ResponseBody
    public String m8(String username , String password) {
        System.out.println("delete : username: +++++++" + username + "password" + password);

        return "success";
    }

    /**
     * 局部异常处理
     * @return
     */
//    @ExceptionHandler
//    public ModelAndView excetionHandler(Exception ex) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("excetion", ex);
//        System.out.println("出错啦");
//        return mav;
//    }

    @RequestMapping("/error")
    public String error() {
        int i = 5 / 0;
        return "test.jsp";
    }

    /**
     * ajax传值时要设置contentType 为application/json
     * RequestBody 只能接受标准的json字符串
     * @param user
     * @return
     */
    @RequestMapping(value = "/testDateFormat", method = RequestMethod.POST)
    @ResponseBody
    public String testDateFormat(@RequestBody SysUser user) {
        System.out.println(user);
        return "success";
    }


    @RequestMapping(value = "/testDateFormat1", method = RequestMethod.GET)
    @ResponseBody
    public String testDateForma1(SysUser user) {
        System.out.println(user);
        return "success";
    }

    @RequestMapping(value = "/testDateFormat2", method = RequestMethod.POST)
    @ResponseBody
    public String testDateForma2(SysUser user) {
        System.out.println(user);
        return "success";
    }

    /**
     * 传输数组
     * @param str
     * @return
     */
    @RequestMapping(value = "/m8", method = RequestMethod.POST)
    @ResponseBody
    public String m8(String[] id) {
        System.out.println(id);
        return "success";
    }

    /**
     * 传对象
     * @param str
     * @return
     */
    @RequestMapping(value = "/m9", method = RequestMethod.POST)
    @ResponseBody
    public String m9(@RequestParam("id") List<String> str) {
        System.out.println(str);
        return "success";
    }

    @RequestMapping(value = "/m10", method = RequestMethod.POST)
    @ResponseBody
    public String m10(@RequestBody List<String> id) {
        System.out.println(id);
        return "success";
    }


    @RequestMapping("/date")
    public String date(Date date){
        System.out.println(date);
        return "hello";
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }

    @RequestMapping("/m9")
    public String m9 (Map<String, Object> map) {
        SysUser user = new SysUser();
        user.setUserName("cccccccccc");
        map.put("user", user);
        return "study/springMvc.jsp";
    }

    @RequestMapping("/m10")
    public String m10 (ModelMap map) {
        SysUser user = new SysUser();
        user.setUserName("cccccccccc");
        map.put("user", user);
        return "study/springMvc.jsp";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload (MultipartFile file) {
        String fileName = file.getOriginalFilename();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            String filePath = "F:\\" + fileName;
            bis = new BufferedInputStream(file.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(filePath));
            byte[] buffer = new byte[1024];
            while (bis.read(buffer , 0 , buffer.length) != -1) {
                bos.write(buffer, 0, buffer.length);
            }
            System.out.println("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(bos);
            IOUtils.closeQuietly(bis);
        }
        return "study/springMvc.jsp";
    }


}
