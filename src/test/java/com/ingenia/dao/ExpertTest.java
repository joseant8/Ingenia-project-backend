package com.ingenia.dao;

import com.ingenia.model.Expert;
import com.ingenia.model.State;
import com.ingenia.payload.request.ExpertEditRequest;
import com.ingenia.service.ExpertService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ExpertTest {

    @Autowired
    ExpertService service;

    @Test
    @DisplayName("Crear un experto y comprobar que tiene la fecha de creación")
    public void createOneExpertCheckDate() {
        Expert experto1 = new Expert("Mario López Serrano", null, "mañanas", null, "direccion", null, "123456734", "email@email.com",
                "Valencia", "e", "10.00", "15.00", 70, "12345678A", "Hola", "",
                "e", "", null, null, null, null, State.PENDIENTE);

        Expert expertoCreado1 = service.createExpert(experto1);
        Assertions.assertNotNull(expertoCreado1.getCreated_at());
    }

    @Test
    @DisplayName("Actualizar un experto y comprobar que tiene la fecha de actualización distinta a la de creación")
    public void updateOneExpertCheckDate() {

        Expert expertoDB = service.getExpert(2l);
        ExpertEditRequest peticion = new ExpertEditRequest();
        peticion.setNombre("Editado");

        expertoDB.setPuntuacion(80);
        Expert expertoActualizado = service.updateExpert(expertoDB.getId(), peticion);

        Assertions.assertNotNull(expertoActualizado.getUpdated_at());
        Assertions.assertNotEquals(expertoActualizado.getCreated_at() ,expertoActualizado.getUpdated_at());

    }

    @Test
    @DisplayName("Expertos filtrados por nombre")
    public void ExpertsFilterByName() {
        List<Expert> expertos = service.filterByNameContains("Ant");
        for (Expert e: expertos) {
            System.out.println(e.getNombre());
        }
    }

    @Test
    @DisplayName("Expertos filtrados por estado")
    public void ExpertsFilterByState() {
        List<Expert> expertos = service.filterByState("pendiente");
        for (Expert e: expertos) {
            System.out.println(e.getEstado());
        }
    }


}
