package com.example.nexignlottery;

import com.example.nexignlottery.model.Participant;
import com.example.nexignlottery.repository.LotteryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class LotteryRepositoryTest {

    @Autowired
    LotteryRepository lotteryRepository;

    Participant FIRST = new Participant(1L, "Maks", 21, "Saint-Petersburg");
    @Test
    void testSaveParticipant() {
        lotteryRepository.save(FIRST);
        assertNotNull(FIRST.getId());
    }
}
