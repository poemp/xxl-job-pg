package org.poem.controller.interceptor;

import org.poem.config.JacksonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * web mvc config
 *
 * @author xuxueli 2018-04-02 20:48:20
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private PermissionInterceptor permissionInterceptor;
    @Resource
    private CookieInterceptor cookieInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(permissionInterceptor).addPathPatterns("/**");
        registry.addInterceptor(cookieInterceptor).addPathPatterns("/**");
    }

    @Autowired
    private HttpMessageConverters httpMessageConverters;

    /**
     * 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .maxAge(180)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS");
    }

    /**
     * MappingJackson2HttpMessageConverter 实现了HttpMessageConverter 接口，
     * httpMessageConverters.getConverters() 返回的对象里包含了MappingJackson2HttpMessageConverter
     *
     * @return
     */
    @Bean
    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter(new JacksonMapper());
    }


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.addAll(httpMessageConverters.getConverters());
    }
}