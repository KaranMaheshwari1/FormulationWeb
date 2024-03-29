package com.Formula.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Formula.Entity.RawFormulation;
import com.Formula.Entity.RawMaterialRequest;
import com.Formula.Entity.UserRequest;
import com.Formula.Repo.RawFormulaRepo;
import com.Formula.Repo.RawMaterialRepo;
import com.Formula.Repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RawMaterialRepo rawMaterialRepo;
	
	@Autowired
	private RawFormulaRepo rawFormulaRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserRequest saveUser(UserRequest userRequest) {

		String password = bCryptPasswordEncoder.encode("12345"); // it is manually do this for forget password
		userRequest.setPassword(password);
		userRequest.setRole("user");
		UserRequest newUser = userRepo.save(userRequest);
		return newUser;
	}

	@Override
	public RawMaterialRequest saveRawMaterial(RawMaterialRequest ramMaterial) {
		RawMaterialRequest saveRawMaterial = rawMaterialRepo.save(ramMaterial);
		return saveRawMaterial;
	}

	@Override
	public List<RawMaterialRequest> getAllRawMaterial() {
		List<RawMaterialRequest> rawList = rawMaterialRepo.findAll();
		return rawList;
	}

	@Override
	public RawMaterialRequest rawMaterialFindById(int rm_id) {
		Optional<RawMaterialRequest> optionalRawMaterial = rawMaterialRepo.findById(rm_id);

		if (optionalRawMaterial.isPresent()) {
			RawMaterialRequest rawMaterial = optionalRawMaterial.get();
			RawMaterialRequest materialRequest = new RawMaterialRequest();
			rawMaterial.setRmName(materialRequest.getRmName());
			rawMaterial.setRmNumber(materialRequest.getRmNumber());
			return rawMaterialRepo.save(rawMaterial);
		} else {
			return null;
		}
	}

	@Override
	public UserRequest loginValidation(UserRequest userRequest) {
		UserRequest user = userRepo.findByUserId(userRequest.getUserId());
		if (user != null) {
			if (user.getEmail().equals(userRequest.getEmail())
					&& user.getPassword().equals(userRequest.getPassword())) {
				return user;
			}
		}
		return null;
	}

	@Override
	public String findUserRoleByEmail(String email) {
		UserRequest user = userRepo.findByEmail(email);
		if (user != null) {
			String role = user.getRole();
			return role;
		} else {
			return null;
		}
	}

	 public RawFormulation saveRawFormulation(RawFormulation rawFormulation) {
	        return rawFormulaRepo.save(rawFormulation);
	    }

	 @Override
	    public List<RawMaterialRequest> getSelectedRawMaterials(List<Integer> selectedRawMaterialIds) {
	        // Use Spring Data JPA's findByIdIn method to fetch selected raw materials
	      //  return rawFormulaRepo.findByIdIn(selectedRawMaterialIds);
		 return null;
	    }
}
