package com.xqd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 刘攀
 *
 */
@Configuration
public class Swagger2 {

	@Bean
	public Docket createRestApi() {
		List<ResponseMessage> responseMessageList = new ArrayList<ResponseMessage>();
		responseMessageList.add(new ResponseMessageBuilder().code(200).message("请求接口成功，业务正确").build());
		responseMessageList.add(new ResponseMessageBuilder().code(412).message("请求接口成功，业务失败，前端返回预先定义的统一错误信息").build());
		responseMessageList.add(new ResponseMessageBuilder().code(413).message("没有登录，接口不能处理").build());
		responseMessageList.add(new ResponseMessageBuilder().code(414).message("请求接口成功，业务失败，前端返回后端返回的msg信息").build());
		responseMessageList.add(new ResponseMessageBuilder().code(500).message("不明错误，前端返回预先定义的统一错误信息").build());
		return new Docket(DocumentationType.SWAGGER_2).globalResponseMessage(RequestMethod.GET, responseMessageList)
				.globalResponseMessage(RequestMethod.POST, responseMessageList)
				.globalResponseMessage(RequestMethod.PUT, responseMessageList)
				.globalResponseMessage(RequestMethod.DELETE, responseMessageList).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.xqd")).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("api文档")
				.description("统一返回JSON类 {</br>"+
							 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;attribute : 返回附加内容 ,</br>"+
							 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;data : 返回数据 ,</br>"+
							 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;msg : 返回消息 ,</br>"+
							 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;statusCode : 返回结果 ,</br>"+
							 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;uccess : 兼容APP返回数据</br>"+
							 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}</br>"+"data里面具体数据会在相应接口具体表示")
				.version("1.0").build();
		
	}
}
