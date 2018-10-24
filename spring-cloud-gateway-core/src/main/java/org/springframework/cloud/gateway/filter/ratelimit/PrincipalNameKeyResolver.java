package org.springframework.cloud.gateway.filter.ratelimit;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.security.Principal;
// 默认限流key解析器
public class PrincipalNameKeyResolver implements KeyResolver {

	public static final String BEAN_NAME = "principalNameKeyResolver";

	@Override
	public Mono<String> resolve(ServerWebExchange exchange) {
		return exchange.getPrincipal().map(Principal::getName).switchIfEmpty(Mono.empty());
	}
}
