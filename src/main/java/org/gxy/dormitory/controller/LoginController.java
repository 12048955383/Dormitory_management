package org.gxy.dormitory.controller;

import com.google.code.kaptcha.Producer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.gxy.dormitory.entity.TSRole;
import org.gxy.dormitory.util.Menu;
import org.gxy.dormitory.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * 登录控制层
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:40:53
 */
@Controller
@RequestMapping("/loginController")
public class LoginController {
    /**
     * 服务对象
     */
    @Autowired
    private Producer producer;

    /**
     * @return 返回主页面
     */
    @RequestMapping(params = "doLogin")
    public String doLogin() {
        return "/system/main";
    }

    /**
     * @return 访问主页
     */
    @RequestMapping(params = "home")
    public String home() {
        return "/system/home";
    }

    /**
     * 用户名密码认证
     *
     * @param username 账号
     * @param password 密码
     * @param captcha  验证码
     * @param re       状态对象
     * @param session
     * @return json数据
     */
    @ResponseBody
    @RequestMapping(params = "doCheck", method = RequestMethod.POST)
    public Result Login(String username, String password, String captcha, Result re, HttpSession session) {
        //获取session中验证码
        String kaptcha = (String) session.getAttribute("kaptcha");
        //验证码进行比对
        if (!kaptcha.equalsIgnoreCase(captcha)) {
            re.setSuccess(false);
            re.setMsg("验证码错误");
            return re;
        }
        //得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        //认证数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //shiro默认支持"记住我"，只要有一次设置则自动运作
        token.setRememberMe(true);
        try {
            subject.login(token);
            re.setMsg("登录成功");
            PrincipalCollection principals = subject.getPrincipals();
            TSRole tsRole = (TSRole) principals.getPrimaryPrincipal();
            session.setAttribute("userid",tsRole.getId());
            session.setAttribute("username", username);
            return re;
        } catch (AuthenticationException e) {
            //返回false 写入报错信息
            re.setSuccess(false);
            re.setMsg("账号或密码错误");
            return re;
        }
    }

    /**
     * 获取树形菜单
     *
     * @return 树形菜单
     */
    @ResponseBody
    @RequestMapping(params = "getTreeMenu")
    public List<Menu> getTreeMenu() {
        Subject subject = SecurityUtils.getSubject();
        TSRole tsRoles = (TSRole) subject.getPrincipal();
        List<Menu> menuList = tsRoles.getMenuList();
        return menuList;
    }

    /**
     * 验证码
     *
     * @param session  session域
     * @param response response域
     * @throws IOException
     */
    @RequestMapping("/captchaCode")
    public void Check(HttpSession session, HttpServletResponse response) throws IOException {
        //获取验证码字符
        String kaptcha = producer.createText();
        //保留验证码，存储在session
        session.setAttribute("kaptcha", kaptcha);
        //把字符加干扰线装进图片
        BufferedImage image = producer.createImage(kaptcha);
        try {
            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}