package com.example.WebProg.controller;

import com.example.WebProg.model.Clan;
import com.example.WebProg.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ClanController {

    @Autowired
    private ClanService clanService;

    @GetMapping("/login")
    public String login_mapping(Model model){
        Clan clan = new Clan();
        model.addAttribute("clan",clan);
        return "index.html";
    }

    @GetMapping("/login-check")
    public String login_check(@ModelAttribute Clan clan){
        if(this.clanService.daLiPostoji(clan.getkorisnickoIme(), clan.getLozinka()))
            return "redirect:/clan";
        return "redirect:/login";
    }
}
