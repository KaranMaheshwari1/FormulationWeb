package com.Formula.Service;

import java.util.List;

import com.Formula.Entity.RawFormulation;
import com.Formula.Entity.RawMaterialRequest;
import com.Formula.Entity.UserRequest;

public interface UserService {

	UserRequest saveUser(UserRequest userRequest);

	RawMaterialRequest saveRawMaterial(RawMaterialRequest ramMaterial);

	List<RawMaterialRequest> getAllRawMaterial();

	RawMaterialRequest rawMaterialFindById(int rm_id);

	UserRequest loginValidation(UserRequest userRequest);

	String findUserRoleByEmail(String email);

	RawFormulation saveRawFormulation(RawFormulation rawFormulation);

	List<RawMaterialRequest> getSelectedRawMaterials(List<Integer> selectedRawMaterialIds);

}
