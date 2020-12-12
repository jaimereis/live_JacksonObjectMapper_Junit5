package com.live.jackson.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.live.jackson.DTO.CarDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Test
    public void givenObjectJavaReturnJson() throws JsonProcessingException {
        var carDto = CarDTO.builder()
                .id(UUID.randomUUID().toString())
                .color("red")
                .model("pegeout 207")
                .build();

        String json = carService.javaToJson(carDto);
        assertThat(json, containsString("207"));
        System.out.println(json);
    }

    @Test
    public void givenJsonReturnObjectJava() throws JsonProcessingException {
        String json = "{\"id\":\"38231c8b-5c18-45d3-8492-b67cadcc6ada\",\"model\":\"pegeout 207\",\"color\":\"red\"}";
        var carDTO = carService.jsonToJava(json);
        assertThat(carDTO.getColor(), equalTo("red"));
        System.out.println(carDTO);
    }

    @Test
    public void givenJsonVerifyModel() throws JsonProcessingException {
        String json = "{\"id\":\"38231c8b-5c18-45d3-8492-b67cadcc6ada\",\"model\":\"pegeout 207\",\"color\":\"red\"}";
        var carDTO = carService.jsonNode(json);
        assertThat(carDTO, equalTo("pegeout 207"));
        System.out.println(carDTO);
    }

}