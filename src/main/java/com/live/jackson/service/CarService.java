package com.live.jackson.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.live.jackson.DTO.CarDTO;

public class CarService {

    private ObjectMapper objectMapper = new ObjectMapper();

    public String javaToJson(CarDTO carDTO) throws JsonProcessingException {
        return objectMapper.writeValueAsString(carDTO);
    }

    public CarDTO jsonToJava(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, CarDTO.class);
    }

    public String jsonNode(String json) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(json);
        return jsonNode.get("model").asText();
    }

}
