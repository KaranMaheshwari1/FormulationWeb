package com.Formula.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Formula.Entity.RawFormulation;

public interface RawFormulaRepo extends JpaRepository<RawFormulation, Integer> {
}