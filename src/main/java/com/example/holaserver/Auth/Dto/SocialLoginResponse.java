package com.example.holaserver.Auth.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SocialLoginResponse {
    private String name;
    private String email;
    private String imgPath;

    private String oauthType;
    private String oauthIdentity;
    private String jwt;
    private String refreshToken;


    @Builder
    public SocialLoginResponse(KakaoUserInfoDto user, String oauthIdentity, String token){
        this.oauthType = "KAKAO";
        this.oauthIdentity = oauthIdentity;
        this.jwt = token;
    }

    @Builder
    public SocialLoginResponse(String oauthIdentity, String token){
        this.oauthType = "APPLE";
        this.oauthIdentity = oauthIdentity;
        this.jwt = token;
    }

    @Builder
    public SocialLoginResponse(NaverUserInfoDto user, String oauthIdentity, String token){
        this.name = user.getResponse().getName();
        this.email = user.getResponse().getEmail();
        this.oauthType = "NAVER";
        this.oauthIdentity = oauthIdentity;
        this.jwt = token;
    }
}
