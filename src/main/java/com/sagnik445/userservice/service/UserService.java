package com.sagnik445.userservice.service;

import com.sagnik445.userservice.entities.UserInfo;
import com.sagnik445.userservice.entities.UserInfoDto;
import com.sagnik445.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Service
public class UserService
{

    @Autowired
    private UserRepository userRepository;

    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto){
        UnaryOperator<UserInfo> updatingUser = user -> {
            return userRepository.save(userInfoDto.transformToUserInfo());
        };

        Supplier<UserInfo> createUser = () -> {
            return userRepository.save(userInfoDto.transformToUserInfo());
        };

        UserInfo userInfo = userRepository.findByUserId(userInfoDto.getUserId())
                .map(updatingUser)
                .orElseGet(createUser);
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getUserName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }

    public UserInfoDto getUserById(String userId) throws Exception {
        Optional<UserInfo> userInfoOpt = userRepository.findByUserId(userId);

        if(userInfoOpt.isEmpty()){
            throw new Exception("User not found");
        }

        UserInfo userInfo = userInfoOpt.get();

        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getUserName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }
}
