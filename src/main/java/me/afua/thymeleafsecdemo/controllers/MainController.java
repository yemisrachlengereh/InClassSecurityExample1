package me.afua.thymeleafsecdemo.controllers;

import me.afua.thymeleafsecdemo.entities.Bank;
import me.afua.thymeleafsecdemo.entities.UserData;
import me.afua.thymeleafsecdemo.entities.UserService;
import me.afua.thymeleafsecdemo.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private BankRepository bankRepository;

    @RequestMapping("/")
    public String showMainPage(Principal p) {
            //Principal allows you to store to name you except user to have store object parameters in repository

        return "index";
    }

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    @RequestMapping("/pageone")
    public String showPageOne(Model model)
    {
        model.addAttribute("title","First Page");
        model.addAttribute("pagenumber","1");
        return "deposite";
    }

    //this is for user data object

    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("userdata", new UserData ());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistrationPage(
            @Valid @ModelAttribute("userdata") UserData user,
            BindingResult result,
            Model model){

        model.addAttribute("userdata", user);

        if (result.hasErrors()) {
            return "registration";
        } else {
            userService.saveUserData(user);
            model.addAttribute("message", "User Account Successfully Created");
        }
        return "index";
    }

    //this is for bank object

    @GetMapping("/deposit")
    public String showDepositePage(Model model){
        model.addAttribute("bank", new Bank());
//        model.addAttribute("pagenumber","Bank");
        return "deposit";
    }

    @PostMapping("/deposit")
    public String depositeForm(@Valid Bank bank,BindingResult result){
        if(result.hasErrors()) {
            return "deposit";
        }
            bankRepository.save(bank);

        return "redirect:/history";
    }

    @RequestMapping("/history")
    public String listRecords(Model model){
                model.addAttribute("records" , bankRepository.findAll());
                return "transactionhistory";

    }

//    @GetMapping("/withdrawal")
//    public String showWithdrawalPage(Model model){
//        model.addAttribute("bank", new Bank());
//
//        return "withdrawal";
//    }
//
//    @PostMapping("/deposit")
//    public String withdrawalForm(@Valid Bank bank,BindingResult result){
//        if(result.hasErrors()) {
//            return "withdrawal";
//        }
//        bankRepository.save(bank);
//
//        return "redirect:/history";
//    }


}
