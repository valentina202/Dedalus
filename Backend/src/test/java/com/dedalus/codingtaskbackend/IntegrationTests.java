package com.dedalus.codingtaskbackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class IntegrationTests {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void postNewText_shouldBeAnalyzed_then200() throws Exception {

    TextDto textDto = new TextDto(true, "What a beautiful day");

    String mapper = objectMapper.writeValueAsString(textDto);

    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/analyse")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper)).andDo(print()).andReturn();

    MockHttpServletResponse response = mvcResult.getResponse();

    TextDto result = objectMapper.readValue(response.getContentAsString(), TextDto.class);

    assertAll(
            () -> assertEquals(HttpStatus.OK.value(), response.getStatus()),
            () -> assertEquals("Letter 'A' appears 4 times\nLetter 'E' appears 1 times\nLetter 'I' appears 1 times\nLetter 'O' appears 0 times\nLetter 'U' appears 2 times\n",result.text())
    );
  }
}
