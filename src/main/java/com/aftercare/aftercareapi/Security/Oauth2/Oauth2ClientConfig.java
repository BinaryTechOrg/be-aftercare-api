package com.aftercare.aftercareapi.Security.Oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

@Configuration
public class Oauth2ClientConfig {

    private final Oauth2ClientProperties properties;

    public Oauth2ClientConfig(Oauth2ClientProperties properties) {
        this.properties = properties;
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration clientRegistration = ClientRegistration.withRegistrationId("auth0")
                .clientId(properties.getClientId())
                .clientSecret(properties.getClientSecret())
                .issuerUri(properties.getIssuerUri())
                .authorizationUri(properties.getIssuerUri() + "/authorize")
                .tokenUri(properties.getIssuerUri() + "/oauth/token")
                .userInfoUri(properties.getIssuerUri() + "/userinfo")
                .jwkSetUri(properties.getIssuerUri() + "/.well-known/jwks.json")
                .scope("openid", "profile", "email")
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .clientName("Auth0")
                .build();

        return new InMemoryClientRegistrationRepository(clientRegistration);
    }
}
