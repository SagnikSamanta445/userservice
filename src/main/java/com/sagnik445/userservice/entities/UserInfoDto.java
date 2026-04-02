package com.sagnik445.userservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoDto
{
    //@JsonProperty("user_id")
    @NonNull
    private String userId;

    //@JsonProperty("user_name")
    @NonNull
    private String userName;

    //@JsonProperty("phone_number")
    @NonNull
    private String phoneNumber;

    //@JsonProperty("email")
    @NonNull
    private String email;

    //@JsonProperty("profile_pic")
    private String profilePic;

    public UserInfo transformToUserInfo(){
        return UserInfo.builder()
                .userId(userId)
                .userName(userName)
                .email(email)
                .phoneNumber(phoneNumber)
                .profilePic(profilePic)
                .build();
    }
}
