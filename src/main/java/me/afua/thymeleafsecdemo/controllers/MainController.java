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
        model.addAttribute("pagenumber","4");
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

    @GetMapping("/deposite")
    public String showDepositePage(Model model){
        model.addAttribute("bank", new Bank());
        model.addAttribute("pagenumber","Bank");
        return "deposite";
    }

    @PostMapping("/deposite")
    public String showDepositePage(
            @Valid @ModelAttribute("bank") Bank bank,
            BindingResult result, Model model){

        model.addAttribute("bank", bank);

        if (result.hasErrors()) {
            return "deposite";
        } else {
            bankRepository.save(bank);
            model.addAttribute("message", "User Account Successfully Created");
        }
        return "transactionhistory";
    }

    @GetMapping("/transactionhistory")
    public String showTransactionhistoryPage(Model model){
        model.addAttribute("bank", new Bank());
        model.addAttribute("pagenumber","Bank");
        return "transactionhistory";
    }
//
    @PostMapping("/transactionhistory")
    public String showTransactionhistoryPage(
            @Valid @ModelAttribute("bank") Bank bank,
            BindingResult result, Model model){

        model.addAttribute("bank", bank);

        if (result.hasErrors()) {
            return "index";
        } else {
            bankRepository.save(bank);
            model.addAttribute("message", "User Account Successfully Created");
        }
        return "transactionhistory";
    }
//
//




    @GetMapping("/withdrawal")
    public String showWithdrawalPage(Model model){
        model.addAttribute("bank", new Bank());
        model.addAttribute("pagenumber","Bank");
        return "withdrawal";
    }

    @PostMapping("/withdrawal")
    public String showWithdrawalPage(
            @Valid @ModelAttribute("user") UserData user,
            BindingResult result, Model model){

        model.addAttribute("user", user);

        if (result.hasErrors()) {
            return "index";
        } else {
            userService.saveUserData(user);
            model.addAttribute("message", "User Account Successfully Created");
        }
        return "index";
    }



    @RequestMapping("/pagetwo")
    public String showPageTwo(Model model)
    {
        model.addAttribute("title","Second Page");
        model.addAttribute("pagenumber","2");
        return "withdrawl";
    }

    @RequestMapping("/pagethree")
    public String showPageThree(Model model)
    {
        model.addAttribute("title","Third Page");
        model.addAttribute("pagenumber","3");
        return "pagethree";
    }




}
