package com.example.nexignlottery.repository;

import com.example.nexignlottery.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotteryRepository extends JpaRepository<Participant, Long> {
    List<Participant> findAll();
}
