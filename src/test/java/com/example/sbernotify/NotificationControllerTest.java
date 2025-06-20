package com.example.sbernotify;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.sbernotify.controller.NotificationController;
import ru.sbernotify.service.NotificationProducer;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest(NotificationController.class)
class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Getter
    @Setter
    @MockBean
    private NotificationProducer notificationProducer;

    @Test
    void sendNotification_shouldReturnOk() throws Exception {
        String json = """
            {
              "type": "EMAIL",
              "recipient": "test@example.com",
              "subject": "Test",
              "message": "Hello from test"
            }
        """;

        mockMvc.perform(post("/api/notifications")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

}
