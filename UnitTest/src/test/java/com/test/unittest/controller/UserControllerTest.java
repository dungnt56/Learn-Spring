package com.test.unittest.controller;

import com.test.unittest.entity.User;
import com.test.unittest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testCreateUser_Success() throws Exception {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        when(userService.createUser(user)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\", \"email\":\"john.doe@example.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
    }

    @Test
    void testCreateUser_EmailAlreadyExists() throws Exception {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        when(userService.createUser(user)).thenThrow(new IllegalArgumentException("Email already exists"));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\", \"email\":\"john.doe@example.com\"}"))
                .andExpect(status().isBadRequest());
    }
}

