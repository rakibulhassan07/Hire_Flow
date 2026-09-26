package com.example.hireflow.security.oauth2;

import com.example.hireflow.entity.User;
import com.example.hireflow.entity.type.AccountStatus;
import com.example.hireflow.entity.type.AuthProvider;
import com.example.hireflow.entity.type.RoleType;
import com.example.hireflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest)
            throws OAuth2AuthenticationException {

        OAuth2User oauth2User = super.loadUser(userRequest);

        return processOAuth2User(userRequest, oauth2User);
    }

    private OAuth2User processOAuth2User(
            OAuth2UserRequest userRequest,
            OAuth2User oauth2User
    ) {

        String registrationId =
                userRequest.getClientRegistration().getRegistrationId();

        String email = oauth2User.getAttribute("email");

        String firstName =
                oauth2User.getAttribute("given_name");

        String lastName =
                oauth2User.getAttribute("family_name");

        String picture =
                oauth2User.getAttribute("picture");

        AuthProvider provider =
                AuthProvider.valueOf(registrationId.toUpperCase());

        // User lookup/create logic will go here

        return oauth2User;
    }
}