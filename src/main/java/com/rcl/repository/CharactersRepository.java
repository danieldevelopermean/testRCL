package com.rcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcl.entity.CharactersEntity;

@Repository
public interface CharactersRepository extends JpaRepository<CharactersEntity, Long> {

}
