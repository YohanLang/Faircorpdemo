package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RoomDaoTest {

    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindARoom() {
        Room room = roomDao.getById(-10L);
        Assertions.assertThat(room.getName()).isEqualTo("Room1");
    }

    @Test
    public void shouldFindByName(){
        List<Room> result = roomDao.findByName("Room1");
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("id")
                .containsExactly(-10L);
    }
}