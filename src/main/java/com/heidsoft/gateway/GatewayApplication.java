package com.heidsoft.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.gateway.mvc.ProxyExchange;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

//	@GetMapping("/test")
//	public ResponseEntity<?> proxy(ProxyExchange<byte[]> proxy) throws Exception {
//		return proxy.uri("http://account.baozun.com/images/uac/user_bg.png").get();
//	}

	@Component
	public class HomeRouter {
		@Bean
		public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
			return builder.routes()
					.route(r -> r.path("/")
							.filters(f -> f.addRequestHeader("HelloKey", "WorldValue"))
							.uri("https://www.baidu.com/"))
					.build();
		}
	}

}
