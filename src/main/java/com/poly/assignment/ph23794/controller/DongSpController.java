package com.poly.assignment.ph23794.controller;

import com.poly.assignment.ph23794.dto.request.DongSpRequest;
import com.poly.assignment.ph23794.service.DongSpService;
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

@RequestMapping("/dongsp")
@Controller
public class DongSpController {
    @Autowired
    private DongSpService DongSpService;

    @GetMapping("/home")
    public String home() {
        return "/viewform/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, ModelAndView modelAndView,
                          @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {

        model.addAttribute("listSp", DongSpService.getAll(pageNo, 4));
        model.addAttribute("dongSp", new DongSpRequest());
        modelAndView.addObject("view", "/dongsp/dongsps.jsp");
        return "/dongsp/dongsps";
    }

    @GetMapping("/viewadd")
    public String viewadd(Model model) {
        model.addAttribute("dongSp", new DongSpRequest());


        return "/dongsp/add";
    }

    @PostMapping("/add")
    public String add(Model model,
                      @Valid @ModelAttribute("dongSp") DongSpRequest sp,
                      BindingResult bindingResult,
                      @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            return "/dongsp/add";
        }
        DongSpService.add(sp);
        model.addAttribute("listSp", DongSpService.getAll(pageNo, 4));

        return "/dongsp/dongsps";

    }

    @GetMapping("/viewupdate/{id}")
    public String viewupdate(Model model,
                             @PathVariable("id") String id) {
        model.addAttribute("dongSp", new DongSpRequest());
        model.addAttribute("sp", DongSpService.getOne(id));

        return "/dongsp/update";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @Valid @ModelAttribute("dongSp") DongSpRequest sp,
                         BindingResult bindingResult,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            return "/dongsp/update";
        }
        DongSpService.update(sp);
        model.addAttribute("listSp", DongSpService.getAll(pageNo, 4));

        return "/dongsp/dongsps";

    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") String id) {
        model.addAttribute("dongSp", new DongSpRequest());
        model.addAttribute("sp", DongSpService.getOne(id));

        return "/dongsp/detail";
    }

    @GetMapping("/remove/{id}")
    public String remove(Model model,
                         @PathVariable("id") String id,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo

    ) {
        model.addAttribute("listSp", DongSpService.getAll(pageNo, 4));
        model.addAttribute("dongSp", new DongSpRequest());
        DongSpService.remove(id);
        return "/dongsp/dongsps";

    }
}
