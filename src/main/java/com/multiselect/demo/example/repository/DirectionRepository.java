package com.multiselect.demo.example.repository;

import com.multiselect.demo.example.entity.Direction;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends BaseRepository<Direction,Integer> {
}
