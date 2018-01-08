package com.testgreetgo.eSchool.controller;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class eSchoolControllerTest {
  private eSchollController controller;
  private MockMvc mockMvc;

  @BeforeMethod
  public void setUp() {
    controller = new eSchollController();
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void studentsAdd_ShouldRenderFormPage() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.post("/students/add"))
        .andExpect(MockMvcResultMatchers.view().name("form"));

  }





}
