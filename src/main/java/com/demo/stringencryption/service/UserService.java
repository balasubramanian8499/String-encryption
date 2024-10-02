package com.demo.stringencryption.service;

import com.demo.stringencryption.model.Role;
import com.demo.stringencryption.model.User;
import com.demo.stringencryption.repository.RoleRepository;
import com.demo.stringencryption.repository.UserRepository;
import com.demo.stringencryption.response.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Object saveUser(UserDTO userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setMobileNumber(String.valueOf(userDto.getMobileNumber()));
        Optional<Role> role = roleRepository.findById(userDto.getRoleId());
        role.ifPresent(user::setRole);
        user.setIsActive(userDto.getIsActive());
        user.setDeletedFlag(userDto.getDeletedFlag());
        return userRepository.save(user);
    }

    public List<UserDTO> getAllUsers(){

        List<UserDTO> userDTOList = new LinkedList<>();
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserName(user.getUserName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            userDTO.setMobileNumber(Integer.valueOf(user.getMobileNumber()));
            userDTO.setRoleId(user.getRole().getId());
            userDTO.setIsActive(user.getIsActive());
            userDTO.setDeletedFlag(user.getDeletedFlag());
            userDTOList.add(userDTO);
        });
        return userDTOList;
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

}
