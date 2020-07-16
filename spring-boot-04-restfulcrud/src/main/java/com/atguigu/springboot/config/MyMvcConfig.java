package com.atguigu.springboot.config;

import com.atguigu.springboot.component.LoginHandlerInterceptor;
import com.atguigu.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc   不要接管SpringMVC
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送 /atguigu 请求来到 success
        registry.addViewController("/atguigu").setViewName("success");

    }

    /**
     * 所有的WebMvcConfigurerAdapter组件都会一起起作用
    用了@Bean下面的优先级比较高，只要url和上面的一样的情况下，下面的会优先生效,加了@Bean就会被spring添加到容器
    识别的都是thymeleaf模板引擎下面的html,不会识别public等资源问价下的，而上面没有加@Bean的就会是默认，
     比如访问"/"的话跳转的就是默认的public里面的index.html,注意要先关闭下面的的@Bean,以防容器中还存在"/"指定
     的login.html.没有添加@Bean
    这里没有声明"/"的话是默认就是找资源问价下的index,除了"/"。其他的html必须要在thymeleaf里面有才会生效，在其他目录
     访问不到,只要没有添加@Bean"/"默认的都是资源文件夹下的index
     */
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                //发送的url请求如果是/index.html就访问login.html界面，这里省略了html.
                registry.addViewController("/index.html").setViewName("login");


                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
//               // 静态资源；  *.css , *.js
//               // SpringBoot已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html", "/", "/user/login");
//            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {

        return new MyLocaleResolver();
    }

}
