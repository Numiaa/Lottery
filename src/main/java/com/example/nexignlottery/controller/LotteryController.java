package com.example.nexignlottery.controller;

import com.example.nexignlottery.exception.NotEnoughParticipantsException;
import com.example.nexignlottery.model.Participant;
import com.example.nexignlottery.model.Winner;
import com.example.nexignlottery.service.lottery.LotteryService;
import com.example.nexignlottery.service.winner.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "lottery")
public class LotteryController {

    private final LotteryService lotteryService;
    private final WinnerService winnerService;

    @Autowired
    public LotteryController(LotteryService lotteryService,
                             WinnerService winnerService) {
        this.lotteryService = lotteryService;
        this.winnerService = winnerService;
    }

    @PostMapping(path = "participant")
    public void addParticipant(@RequestBody @Valid Participant participant) {
        lotteryService.save(participant);
    }

    @GetMapping(path = "participant")
    public List<Participant> getAllParticipants() {
        return lotteryService.findAll();
    }

    @GetMapping(path = "start")
    public Winner startLottery() throws NotEnoughParticipantsException {
        Winner winner = lotteryService.lotteryStart();
        winnerService.save(winner);
        return winner;
    }

    @GetMapping(path = "winners")
    public List<Winner> getAllWinner() {
        return winnerService.findAll();
    }
}
