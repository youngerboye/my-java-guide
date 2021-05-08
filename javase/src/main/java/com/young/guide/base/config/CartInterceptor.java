package main.java.com.young.guide.base.config;

import com.young.guide.base.vo.MemberRespVo;
import com.young.guide.base.vo.UserInfoVo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: young
 * @date: 2021/3/10
 */
@Component
public class CartInterceptor implements HandlerInterceptor {

    public static ThreadLocal<UserInfoVo> threadLocal = new ThreadLocal<>();

    /**
     * 目标方法执行之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserInfoVo userInfoVo = new UserInfoVo();
        HttpSession session = request.getSession();

        MemberRespVo memberRespVo = (MemberRespVo) session.getAttribute(
                "username");
        if (memberRespVo != null) {
            //用户登录,设置用户userId
            userInfoVo.setUserId(memberRespVo.getId());
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (cookieName.equals("user-key")) {
                    //设置临时用户的key
                    userInfoVo.setUserKey(cookieName);
                }
            }
        }
        //目标方法执行之前,将用户信息存放到threadLocal
        threadLocal.set(userInfoVo);
        return true;
    }

    /**
     * 业务执行之后
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserInfoVo userInfoVo = threadLocal.get();
        //这里的userKey就是上面preHandle中设置在threadLocal中的用户信息
        Cookie cookie = new Cookie("user-key", userInfoVo.getUserKey());
        cookie.setMaxAge(60 * 60 * 24 * 30);
        cookie.setDomain("gulimall.com");//作用域
        //添加到cookie
        response.addCookie(cookie);
    }
}
