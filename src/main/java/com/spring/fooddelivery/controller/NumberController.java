package com.spring.fooddelivery.controller;

import com.spring.fooddelivery.model.Number;
import com.spring.fooddelivery.model.User;
import com.spring.fooddelivery.service.NumberService;
import com.spring.fooddelivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
public class NumberController {

    @Autowired
    @Qualifier("NumberService")
    public NumberService numberService;

    @Autowired
    @Qualifier("UserService")
    UserService userService;

    @GetMapping("/calculator")
    public String home(Model model) {
        model.addAttribute("number", new Number());

        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute("number") Number number, BindingResult br,
                            @RequestParam HashMap<String, String> numbers, ModelMap modelMap) {

        if (br.hasErrors()) {
            return "calculator";
        } else {
            String pavadinimas = numbers.get("pavadinimas");
            String pastokodas  = numbers.get("pastokodas");
            String adresas =numbers.get("adresas");
            String maistas  = numbers.get("maistas");

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = authentication.getName();
            User currentUser = userService.findByUsername(currentUserName);

            Number calculation = new Number(pavadinimas, pastokodas, adresas, maistas);
            calculation.setUsers(currentUser);

            numberService.save(calculation);

            modelMap.put("pavadinimas", pavadinimas);
            modelMap.put("pastokodas", pastokodas);
            modelMap.put("adresas", adresas);
            modelMap.put("maistas", maistas);

            return "calculate";
        }
    }

    @GetMapping("/numbers")
    public String getAllNumbers(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName);

        boolean isAdmin = currentUser.getRole() == User.UserRole.ADMIN;

        List<Number> numbers;

        if (isAdmin) {
            numbers = numberService.getAll();
        } else {
            numbers = currentUser.getCalculationsList();
        }

        model.addAttribute("numbers", numbers);

        return "numbers";
    }

    @GetMapping("/view{id}")
    public String getById(@RequestParam("id") int id, Model model) {
        Number number = numberService.getById(id);
        model.addAttribute("number", number);

        return "view";
    }

    @GetMapping("/delete{id}")
    public String delete(@RequestParam("id") int id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName);

        boolean isAdmin = currentUser.getRole() == User.UserRole.ADMIN;
        if (!isAdmin) {
            return "403";
        }

        numberService.delete(id);

        return "redirect:/numbers";
    }

    @GetMapping("/update{id}")
    public String update(@RequestParam("id") int id, Model model) {
        Number number = numberService.getById(id);
        model.addAttribute("number", number);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName);

        boolean isAdmin = currentUser.getRole() == User.UserRole.ADMIN;
        if (!isAdmin) {

            return "403";
        }

        return "update";
    }
}
