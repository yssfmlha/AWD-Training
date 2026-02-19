package tn.esprit.spring.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){

		return builder.routes()
				.route("candidat", r->r.path("/candidats/**")
						.uri("lb://Candidat"))

				.route("job", r->r.path("/jobs/**")
						.uri("lb://job"))
				.route("candidature", r->r.path("/candidatures/**")
						.uri("lb://candidature"))
				.route("journal", r->r.path("/journals/**")
						.uri("lb://journal"))
				.build();
	}
}