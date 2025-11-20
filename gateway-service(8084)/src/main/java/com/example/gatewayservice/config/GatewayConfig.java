package com.example.gatewayservice.config;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public DiscoveryClientRouteDefinitionLocator discoveryRoutes(
            ReactiveDiscoveryClient reactiveDiscoveryClient,
            DiscoveryLocatorProperties discoveryLocatorProperties
    ) {
        return new DiscoveryClientRouteDefinitionLocator(
                reactiveDiscoveryClient,
                discoveryLocatorProperties
        );
    }
}
