package br.com.xuitter.xuitter_api;

import br.com.xuitter.xuitter_api.entities.User;
import br.com.xuitter.xuitter_api.entities.Xuit;
import br.com.xuitter.xuitter_api.repositories.UserRepository;
import br.com.xuitter.xuitter_api.repositories.XuitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FeedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private XuitRepository xuitRepository;

    @BeforeEach
    void setUp() {
        xuitRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("should return a feed with xuits")
    void x1() throws Exception {
        User alexandre = userRepository.save(new User(1L, "alexandre"));

        List.of(
            new Xuit("A vida é bela.", Xuit.XuitType.ORIGINAL, null, alexandre),
            new Xuit("Aproveita cada instante.", Xuit.XuitType.ORIGINAL, null, alexandre)
        ).forEach(xuit -> xuitRepository.save(xuit));

        mockMvc.perform(get("/feed"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                // first xuit
                .andExpect(jsonPath("$[0].id").isNotEmpty())
                .andExpect(jsonPath("$[0].content").value("A vida é bela."))
                .andExpect(jsonPath("$[0].type").value(Xuit.XuitType.ORIGINAL.name()))
                .andExpect(jsonPath("$[0].authorUsername").value(alexandre.getUsername()))
                // second xuit
                .andExpect(jsonPath("$[1].id").isNotEmpty())
                .andExpect(jsonPath("$[1].content").value("Aproveita cada instante."))
                .andExpect(jsonPath("$[1].type").value(Xuit.XuitType.ORIGINAL.name()))
                .andExpect(jsonPath("$[1].authorUsername").value(alexandre.getUsername()));
    }

}
