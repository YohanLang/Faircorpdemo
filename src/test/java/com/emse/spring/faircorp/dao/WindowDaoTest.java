package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowsStatus;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class WindowDaoTest {

    @Autowired
    private WindowDao windowDao;

    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindAWindow() {
        Window window = windowDao.getById(-10L);
        Assertions.assertThat(window.getName()).isEqualTo("Window 1");
        Assertions.assertThat(window.getWindowStatus()).isEqualTo(WindowsStatus.CLOSED);
    }

    @Test
    public void shouldFindRoomOpenWindows() {
        List<Window> result = windowDao.findRoomOpenWindows(-9L);
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("id", "windowStatus")
                .containsExactly(Tuple.tuple(-8L, WindowsStatus.OPEN));
    }

    @Test
    public void shouldNotFindRoomOpenWindows() {
        List<Window> result = windowDao.findRoomOpenWindows(-10L);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void shouldDeleteWindowsRoom() {

        windowDao.deleteByRoom(-10L);
        Set<Window> result = roomDao.findById(-10L).get().getWindow();
        Assertions.assertThat(result).isEmpty();

    }
}