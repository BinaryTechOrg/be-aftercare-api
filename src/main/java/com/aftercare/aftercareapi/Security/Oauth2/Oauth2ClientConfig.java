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
        ClientRegistration clientRegistration = ClientRegistration.withRegistrationId("okta")
                .clientId(properties.getClientId())
                .clientSecret(properties.getClientSecret())
                .issuerUri(properties.getIssuerUri())
                .authorizationUri(properties.getIssuerUri() + "/v1/authorize")
                .tokenUri(properties.getIssuerUri() + "/v1/token")
                .userInfoUri(properties.getIssuerUri() + "/v1/userinfo")
                .jwkSetUri(properties.getIssuerUri() + "/v1/keys")
                .scope("openid", "profile", "email")
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .clientName("Okta")
                .build();

        return new InMemoryClientRegistrationRepository(clientRegistration);
    }
}
