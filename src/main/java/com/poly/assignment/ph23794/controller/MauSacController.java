package com.poly.assignment.ph23794.controller;

import com.poly.assignment.ph23794.dto.request.MauSacRequest;
import com.poly.assignment.ph23794.service.MauSacService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/mau-sac")
@Controller
public class MauSacController {
    @Autowired
    private MauSacService MauSacService;

    @GetMapping("/home")
    public String home() {
        return "/viewform/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, ModelAndView modelAndView,
                          @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {

        model.addAttribute("listSp", MauSacService.getAll(pageNo, 4));
        model.addAttribute("mauSac", new MauSacRequest());
        modelAndView.addObject("view", "/mausac/mausacs.jsp");
        return "/mausac/mausacs";
    }

    @GetMapping("/viewadd")
    public String viewadd(Model model) {
        model.addAttribute("mauSac", new MauSacRequest());


        return "/mausac/add";
    }

    @PostMapping("/add")
    public String add(Model model,
                      @Valid @ModelAttribute("mauSac") MauSacRequest sp,
                      BindingResult bindingResult,
                      @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            return "/mausac/add";
        }
        MauSacService.add(sp);
        model.addAttribute("listSp", MauSacService.getAll(pageNo, 4));

        return "/mausac/mausacs";

    }

    @GetMapping("/viewupdate/{id}")
    public String viewupdate(Model model,
                             @PathVariable("id") String id) {
        model.addAttribute("mauSac", new MauSacRequest());
        model.addAttribute("sp", MauSacService.getOne(id));

        return "/mausac/update";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @Valid @ModelAttribute("mauSac") MauSacRequest sp,
                         BindingResult bindingResult,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            return "/mausac/update";
        }
        MauSacService.update(sp);
        model.addAttribute("listSp", MauSacService.getAll(pageNo, 4));

        return "/mausac/mausacs";

    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") String id) {
        model.addAttribute("mauSac", new MauSacRequest());
        model.addAttribute("sp", MauSacService.getOne(id));

        return "/mausac/detail";
    }

    @GetMapping("/remove/{id}")
    public String remove(Model model,
                         @PathVariable("id") String id,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo

    ) {
        model.addAttribute("listSp", MauSacService.getAll(pageNo, 4));
        model.addAttribute("mauSac", new MauSacRequest());
        MauSacService.remove(id);
        return "/mausac/mausacs";

    }
}
