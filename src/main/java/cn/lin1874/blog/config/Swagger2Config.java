package cn.lin1874.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置类
 * @author lin1874
 * @date 2021/7/21 - 9:27
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    //api接口扫描包路径
    private static final String SWAGGER_SCAN_BASE_PACKAGE = "cn.lin1874.blog.controller";
    //版本
    private static final String VERSION = "1.0.0";

    @Value("${swagger2.enable}")
    private boolean swagger2Enable;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swagger2Enable)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Lin1874个人博客API")//文档标题
                .description("")//文档描述
                .contact(
                        new Contact(
                                "Lin1874",
                                "http://lin1874.cn",
                                "103013999@qq.com")
                )
                .version(VERSION) //文档版本
                .termsOfServiceUrl("http://lin1874.cn")
                .build();
    }

}
