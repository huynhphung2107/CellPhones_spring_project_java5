package com.poly.assignment.ph23794.controller;

import com.poly.assignment.ph23794.dto.request.ChucVuRequest;
import com.poly.assignment.ph23794.service.ChucVuService;
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

@RequestMapping("/chuc-vu")
@Controller
public class ChucVuController {
    @Autowired
    private ChucVuService ChucVuService;

    @GetMapping("/home")
    public String home() {
        return "/viewform/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, ModelAndView modelAndView,
                          @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {

        model.addAttribute("listSp", ChucVuService.getAll(pageNo, 4));
        model.addAttribute("chucVu", new ChucVuRequest());
        modelAndView.addObject("view", "/chucvu/chucvus.jsp");
        return "/chucvu/chucvus";
    }

    @GetMapping("/viewadd")
    public String viewadd(Model model) {
        model.addAttribute("chucVu", new ChucVuRequest());


        return "/chucvu/add";
    }

    @PostMapping("/add")
    public String add(Model model,
                      @Valid @ModelAttribute("chucVu") ChucVuRequest sp,
                      BindingResult bindingResult,
                      @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            return "/chucvu/add";
        }
        ChucVuService.add(sp);
        model.addAttribute("listSp", ChucVuService.getAll(pageNo, 4));

        return "/chucvu/chucvus";

    }

    @GetMapping("/viewupdate/{id}")
    public String viewupdate(Model model,
                             @PathVariable("id") String id) {
        model.addAttribute("chucVu", new ChucVuRequest());
        model.addAttribute("sp", ChucVuService.getOne(id));

        return "/chucvu/update";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @Valid @ModelAttribute("chucVu") ChucVuRequest sp,
                         BindingResult bindingResult,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            return "/chucvu/update";
        }
        ChucVuService.update(sp);
        model.addAttribute("listSp", ChucVuService.getAll(pageNo, 4));

        return "/chucvu/chucvus";

    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") String id) {
        model.addAttribute("chucVu", new ChucVuRequest());
        model.addAttribute("sp", ChucVuService.getOne(id));

        return "/chucvu/detail";
    }

    @GetMapping("/remove/{id}")
    public String remove(Model model,
                         @PathVariable("id") String id,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo

    ) {
        model.addAttribute("listSp", ChucVuService.getAll(pageNo, 4));
        model.addAttribute("chucVu", new ChucVuRequest());
        ChucVuService.remove(id);
        return "/chucvu/chucvus";

    }
}
