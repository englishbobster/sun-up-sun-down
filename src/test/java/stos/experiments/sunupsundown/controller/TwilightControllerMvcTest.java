package stos.experiments.sunupsundown.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TwilightController.class)
public class TwilightControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_a_message_using_mvc() throws Exception {
        mockMvc.perform(get("/sunupdown/day"))
                .andDo(print()).andExpect(status().isOk())
                //This works because MockMvc doesnt wait for the async process to finish
                //and therefore we get an empty string, not expected "long day"
                .andExpect(content().string(""));
    }

    @Test
    public void should_return_a_message_using_mvc_async_dispatch() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/sunupdown/day"))
                .andReturn();

        //but if we wait we get the expected answer
        mockMvc.perform(asyncDispatch(mvcResult)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("long day"));
    }

}
