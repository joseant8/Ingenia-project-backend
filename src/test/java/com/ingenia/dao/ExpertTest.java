package com.ingenia.dao;

import com.ingenia.model.Expert;
import com.ingenia.model.State;
import com.ingenia.service.ExpertService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExpertTest {

    @Autowired
    ExpertService service;

    @Test
    @DisplayName("Crear un experto y comprobar que tiene la fecha de creación")
    public void createOneExpertCheckDate() {
        Expert experto1 = new Expert("Mario López Serrano", null, "mañanas", null, null, "123456734", "email@email.com",
                "Valencia", "e", "10.00", "15.00", 70, "12345678A", "Hola", "",
                "e", "", null, null, null, null, State.PENDIENTE);

        Expert expertoCreado1 = service.createExpert(experto1);
        Assertions.assertNotNull(expertoCreado1.getCreated_at());
    }

    @Test
    @DisplayName("Actualizar un experto y comprobar que tiene la fecha de actualización distinta a la de creación")
    public void updateOneExpertCheckDate() {

        Expert expertoDB = service.getExpert(2l);

        expertoDB.setPuntuacion(80);
        Expert expertoActualizado = service.updateExpert(expertoDB.getId(), expertoDB);

        Assertions.assertNotNull(expertoActualizado.getUpdated_at());
        Assertions.assertNotEquals(expertoActualizado.getCreated_at() ,expertoActualizado.getUpdated_at());

    }

    @Test
    @DisplayName("Actualizar un experto cuyo id está en la BD, otro con id que no existe y otro con null")
    public void updateOneExpertCheckId() {

        Expert expertoDB1 = service.getExpert(2l);
        Expert expertoDB2 = service.getExpert(1000l);
        Expert expertoDB3 = service.getExpert(null);

        expertoDB1.setPuntuacion(80);
        Expert expertoActualizado1 = service.updateExpert(expertoDB1.getId(), expertoDB1);

        expertoDB2.setPuntuacion(90);
        Expert expertoActualizado2 = service.updateExpert(1000l, expertoDB2);

        expertoDB3.setPuntuacion(100);
        Expert expertoActualizado3 = service.updateExpert(null, expertoDB3);

        Assertions.assertNotNull(expertoActualizado1.getId());
        Assertions.assertNotEquals(expertoActualizado1.getCreated_at() ,expertoActualizado1.getUpdated_at());

        Assertions.assertNull(expertoActualizado2.getId());
        Assertions.assertNull(expertoActualizado3.getId());

    }


}
