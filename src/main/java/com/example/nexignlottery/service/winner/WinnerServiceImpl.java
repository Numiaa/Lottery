package com.example.nexignlottery.service.winner;

import com.example.nexignlottery.model.Winner;
import com.example.nexignlottery.repository.WinnerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WinnerServiceImpl implements WinnerService {

    private final WinnerRepository winnerRepository;
    private static final Logger log = LogManager.getLogger(WinnerServiceImpl.class.getName());

    @Autowired
    public WinnerServiceImpl(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }

    @Override
    public List<Winner> findAll() {
        return winnerRepository.findAll();
    }

    @Override
    public Winner save(Winner winner) {
        winnerRepository.save(winner);
        log.info("Winner name: " + winner.getName() + " saved");
        return winner;
    }
}
