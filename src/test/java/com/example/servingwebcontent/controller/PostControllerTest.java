package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.config.SecurityConfig;
import com.example.servingwebcontent.entity.Post;
import com.example.servingwebcontent.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PostController.class)
@Import(SecurityConfig.class)
class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    public void givenPost_whenGetPost_thenReturnJson() throws Exception {
        Post post = new Post();
        post.setUserId("123");
        post.setContent("testContent");
        String postId = post.getPostId();

        when(postService.findPostById(post.getPostId())).thenReturn(post);
        MvcResult result = this.mockMvc.perform(get("/api/post/"+postId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(post.getUserId()))
                .andReturn();

    }

}