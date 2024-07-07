package lk.ijse.gdse.service.custom.impl;

import lk.ijse.gdse.dao.custom.impl.UserDAOImpl;
import lk.ijse.gdse.dto.UserDTO;
import lk.ijse.gdse.entity.User;

public class UserServiceImpl {
    UserDAOImpl userDAO = new UserDAOImpl();

    public boolean save(UserDTO userDTO) throws Exception {

        return userDAO.save(new User(
                userDTO.getFullName(),
                userDTO.getUserName(),
                userDTO.getEmail(),
                userDTO.getPassword()
        ));
    }

    public UserDTO search(String username) throws Exception {

        User user = userDAO.search(username);

        return new UserDTO(user.getFullName(),user.getUserName(),user.getEmail(),user.getPassword());

    }

}
