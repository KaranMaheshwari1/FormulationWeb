package com.Formula.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Formula.Entity.RawFormulation;
import com.Formula.Entity.RawMaterialRequest;
import com.Formula.Entity.UserRequest;
import com.Formula.Repo.RawMaterialRepo;
import com.Formula.Service.UserService;
import com.Formula.constant.UrlConstant;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RawMaterialRepo rawMaterialRepo;

	@GetMapping(value = UrlConstant.RECIPE_PAGE_URL)
	public String home(Model model) {
		List<RawMaterialRequest> rawList = userService.getAllRawMaterial();
		model.addAttribute("allraw", rawList);
		return "recipe";
	}

	@GetMapping(value = UrlConstant.REGISTER_PAGE_URL)
	public String addUser(HttpSession session) {
		// session.removeAttribute("msg");
		return "register";
	}

	@GetMapping(value = UrlConstant.LOGIN_PAGE_URL)
	public String showLoginForm(Model model) {
		return "log_In";
	}

	@PostMapping("/register")
	public String saveUser(@ModelAttribute UserRequest userRequest, HttpSession session) {
		UserRequest user = userService.saveUser(userRequest);

		if (user != null) {
			session.setAttribute("msg", "Register Successfully");
		} else {
			session.setAttribute("msg", "Something went wrong");
		}

		return "redirect:/register"; // to redirect to register not on the same page
	}

	@PostMapping("/add/rawMaterial")
	public String AddRawMaterial(@ModelAttribute RawMaterialRequest ramMaterial, HttpSession session) {
		RawMaterialRequest user = userService.saveRawMaterial(ramMaterial);

		if (user != null) {
			session.setAttribute("msg", "Added Successfully");
		} else {
			session.setAttribute("msg", "Something went wrong");
		}

		return "redirect:/get/all/rawMaterial";
	}

	@GetMapping("/get/all/rawMaterial")
	public String getAllRawMaterial(Model model) {

		List<RawMaterialRequest> rawList = userService.getAllRawMaterial();
		model.addAttribute("allraw", rawList);

		return "raw";
	}

	@GetMapping("/rawMaterial/byId/{rmId}")
	public String getMaterialById(@PathVariable(value = "rmId") int rmId, Model model) {
		Optional<RawMaterialRequest> rawMaterial = rawMaterialRepo.findById(rmId);
		RawMaterialRequest raw = rawMaterial.get();
		model.addAttribute("material", raw);
		return "updateRm";
	}

	@PostMapping("/update/rawMaterial")
	public String updateRawMaterial(@ModelAttribute RawMaterialRequest ramMaterial, HttpSession session) {
		RawMaterialRequest user = userService.saveRawMaterial(ramMaterial);

		if (user != null) {
			session.setAttribute("msg", "Update Successfully");
		} else {
			session.setAttribute("msg", "Something went wrong");
		}

		return "redirect:/get/all/rawMaterial";
	}

	@GetMapping("/delete/rawMaterial{rmId}")
	public String deleteRawMaterial(@PathVariable(value = "rmId") int rmId, HttpSession session) {
		rawMaterialRepo.deleteById(rmId);
		session.setAttribute("msg", "Delete Succesfully");
		return "redirect:/get/all/rawMaterial";

	}
//
//	@PostMapping("/saveformula")
//	public String addRawMaterialWithFormula(@ModelAttribute RawFormulation rawFormulation, HttpSession session) {
//	    List<RawMaterialRequest> selectedRawMaterials = rawFormulation.getRawMaterialRequests();
//	    String recipeNumber = rawFormulation.getFormulaName();
//	    String recipeName = rawFormulation.getFormulaName();
//
//	    if (selectedRawMaterials != null && !selectedRawMaterials.isEmpty()) {
//	        System.out.println("Selected Raw Material IDs: " + selectedRawMaterials);
//	    }
//
//	    System.out.println("Recipe Number: " + recipeNumber);
//	    System.out.println("Recipe Name: " + recipeName);
//
//	    // Save the recipe details and selected raw material IDs in the database (assuming you have a service method for this)
//
//	    return "redirect:/get/all/rawMaterial";
//	}


//	@PostMapping("/authenticate")
//	public String authenticate(HttpServletRequest request, HttpSession session) {
//		String email = request.getParameter("email"); // Assuming the parameter name is 'email'
//		String role = userService.findUserRoleByEmail(email);
//		session.setAttribute("userRole", role);
//		if ("admin".equals(role)) {
//			return "navbar"; // Redirect to admin page
//		} else {
//			return "redirect:/get/all/rawMaterial"; // Redirect to user page
//		}
//	}

//	@PostMapping("/loginRequest/{userId}")
//	public String rawMaterial(UserRequest userRequest,@PathVariable(value = "userId") int userId, Model m, HttpSession session) {
//	    UserRequest user = userService.loginValidation(userRequest);
//	    if (user != null) {
//	        return "recipe";
//	    } else {
//	        session.setAttribute("msg", "Invalid credentials. Please try again.");
//	        return "redirect:/signin";
//	    }
}
