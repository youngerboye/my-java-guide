package main.java.com.young.guide.base.controller;

import com.young.guide.base.config.CartInterceptor;
import com.young.guide.base.vo.UserInfoVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: young
 * @date: 2021/3/10
 */
@Controller
public class CarController {

    @GetMapping("/cart.html")
    public String getCarts(){
        UserInfoVo userInfoVo = CartInterceptor.threadLocal.get();
        System.out.println(userInfoVo);
        return "cartList";//静态页面
    }
}
