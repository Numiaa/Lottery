package com.example.nexignlottery.service.winner;

import com.example.nexignlottery.model.Winner;

import java.util.List;

public interface WinnerService {
    List<Winner> findAll();
    Winner save(Winner winner);
}
