package com.poly.assignment.ph23794.controller;

import com.poly.assignment.ph23794.dto.request.NoiSanXuatRequest;
import com.poly.assignment.ph23794.service.NoiSanXuatService;
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

@RequestMapping("/noi-san-xuat")
@Controller
public class NoiSanXuatController {
    @Autowired
    private NoiSanXuatService NoiSanXuatService;

    @GetMapping("/home")
    public String home() {
        return "/viewform/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, ModelAndView modelAndView,
                          @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {

        model.addAttribute("listSp", NoiSanXuatService.getAll(pageNo, 4));
        model.addAttribute("noiSanXuat", new NoiSanXuatRequest());
        modelAndView.addObject("view", "/noisanxuat/noisanxuats.jsp");
        return "/noisanxuat/noisanxuats";
    }

    @GetMapping("/viewadd")
    public String viewadd(Model model) {
        model.addAttribute("noiSanXuat", new NoiSanXuatRequest());


        return "/noisanxuat/add";
    }

    @PostMapping("/add")
    public String add(Model model,
                      @Valid @ModelAttribute("noiSanXuat") NoiSanXuatRequest sp,
                      BindingResult bindingResult,
                      @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            return "/noisanxuat/add";
        }
        NoiSanXuatService.add(sp);
        model.addAttribute("listSp", NoiSanXuatService.getAll(pageNo, 4));

        return "/noisanxuat/noisanxuats";

    }

    @GetMapping("/viewupdate/{id}")
    public String viewupdate(Model model,
                             @PathVariable("id") String id) {
        model.addAttribute("noiSanXuat", new NoiSanXuatRequest());
        model.addAttribute("sp", NoiSanXuatService.getOne(id));

        return "/noisanxuat/update";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @Valid @ModelAttribute("noiSanXuat") NoiSanXuatRequest sp,
                         BindingResult bindingResult,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            return "/noisanxuat/update";
        }
        NoiSanXuatService.update(sp);
        model.addAttribute("listSp", NoiSanXuatService.getAll(pageNo, 4));

        return "/noisanxuat/noisanxuats";

    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") String id) {
        model.addAttribute("noiSanXuat", new NoiSanXuatRequest());
        model.addAttribute("sp", NoiSanXuatService.getOne(id));

        return "/noisanxuat/detail";
    }

    @GetMapping("/remove/{id}")
    public String remove(Model model,
                         @PathVariable("id") String id,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo

    ) {
        model.addAttribute("listSp", NoiSanXuatService.getAll(pageNo, 4));
        model.addAttribute("noiSanXuat", new NoiSanXuatRequest());
        NoiSanXuatService.remove(id);
        return "/noisanxuat/noisanxuats";

    }
}
