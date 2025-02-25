package com.nowcoder.community.Controller;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
//    @Autowired
//    private AlphaService alphaService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public String home(){
        return "hello Spring boot";
    }
//    @RequestMapping("/data")
//    @ResponseBody
//    public String getData(){
//        return alphaService.fing();
//    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+":"+value);
        }
        System.out.println(request.getParameter("code"));

        response.setContentType("text/html;charset = utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<h1>你好</h1>");
        printWriter.close();
    }

    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@RequestParam(name = "current",required = false,defaultValue = "1") int current,
                              @RequestParam(name = "limit",required = false,defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";

    }

    @RequestMapping("/students/{id}")
    @ResponseBody
    public String getStudent(@PathVariable int id){
        System.out.println(id);
        return "第123个学生";
    }
    @RequestMapping("/user/{id}")
    @ResponseBody
    public String selectById(@PathVariable int id){
        User user = userMapper.selectById(101);
        System.out.println(user);
        return "Test";
    }


}
