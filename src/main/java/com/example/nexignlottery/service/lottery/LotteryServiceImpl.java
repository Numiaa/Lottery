package com.example.nexignlottery.service.lottery;

import com.example.nexignlottery.exception.NotEnoughParticipantsException;
import com.example.nexignlottery.model.Participant;
import com.example.nexignlottery.model.Winner;
import com.example.nexignlottery.repository.LotteryRepository;
import com.example.nexignlottery.service.winner.WinnerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LotteryServiceImpl implements LotteryService {

    private static final Logger logger = LogManager.getLogger(LotteryServiceImpl.class.getName());
    private final WinnerService winnerService;
    private final LotteryRepository lotteryRepository;

    @Autowired
    public LotteryServiceImpl(LotteryRepository lotteryRepository,
                              WinnerService winnerService) {
        this.lotteryRepository = lotteryRepository;
        this.winnerService = winnerService;
    }

    @Override
    public void save(Participant participant) {
        lotteryRepository.save(participant);
        logger.info("Participant with name: " + participant.getName() + ", age: " + participant.getAge() +
                ", city: " + participant.getCity() + " registered in lottery system");
    }

    @Override
    public List<Participant> findAll() {
        return lotteryRepository.findAll();
    }

    @Override
    public Winner lotteryStart() throws NotEnoughParticipantsException {
        List<Participant> list = findAll();
        if (list.size() < 2) {
            throw new NotEnoughParticipantsException("To start the lottery, you need at least 2 participants");
        }
        Random random = new Random();
        final int MAX = 1000;
        final int MIN = 1;
        int prizePool = random.nextInt(MAX - MIN) + MIN;
        int winnerPrize = random.nextInt(list.size() - MIN) + MIN;

        Participant participant = list.get(winnerPrize);
        Winner winner = new Winner();
        winner.setName(participant.getName());
        winner.setAge(participant.getAge());
        winner.setCity(participant.getCity());
        winner.setPrize(prizePool);
        winnerService.save(winner);
        clearDataBaseAfterLottery();
        return winner;
    }

    private void clearDataBaseAfterLottery() {
        lotteryRepository.deleteAll();
    }
}
