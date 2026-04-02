package com.sagnik445.userservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties
@Table(name = "users")
public class UserInfo {

    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Long id;

    @Id
    @JsonProperty("user_id")
    @NonNull
    private String userId;

    @JsonProperty("user_name")
    @NonNull
    private String userName;

    @JsonProperty("phone_number")
    @NonNull
    private String phoneNumber;

    @JsonProperty("email")
    @NonNull
    private String email;

    @JsonProperty("profile_pic")
    private String profilePic;

}
