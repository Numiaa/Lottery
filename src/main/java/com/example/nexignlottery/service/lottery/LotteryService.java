package com.example.nexignlottery.service.lottery;


import com.example.nexignlottery.exception.NotEnoughParticipantsException;
import com.example.nexignlottery.model.Participant;
import com.example.nexignlottery.model.Winner;

import java.util.List;

public interface LotteryService {

    void save(Participant participant);
    List<Participant> findAll();
    Winner lotteryStart() throws NotEnoughParticipantsException;
}
