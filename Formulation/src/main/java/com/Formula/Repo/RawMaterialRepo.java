package com.Formula.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Formula.Entity.RawMaterialRequest;

public interface RawMaterialRepo extends JpaRepository<RawMaterialRequest, Integer> {

}
