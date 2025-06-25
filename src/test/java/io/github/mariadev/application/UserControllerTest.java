package io.github.mariadev.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mariadev.application.controller.UserController;
import io.github.mariadev.application.dto.user.UserRequest;
import io.github.mariadev.core.domain.User;
import io.github.mariadev.usecase.user.CreateUserUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    private MockMvc mockMvc;

    private CreateUserUseCase createUserUseCase;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        createUserUseCase = mock(CreateUserUseCase.class);
        UserController userController = new UserController(createUserUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void shouldReturn201WhenUserCreated() throws Exception {
        var request = new UserRequest("Maria", "maria@email.com");
        var user = new User(1L, "Maria", "maria@email.com", null);

        when(createUserUseCase.execute(anyString(), anyString())).thenReturn(user);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Maria"))
                .andExpect(jsonPath("$.email").value("maria@email.com"));
    }
}
