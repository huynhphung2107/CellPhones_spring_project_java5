package com.poly.assignment.ph23794.controller;

import com.poly.assignment.ph23794.dto.request.KhachHangRequest;
import com.poly.assignment.ph23794.service.KhachHangService;
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

@RequestMapping("/khach-hang")
@Controller
public class KhachHangController {
    @Autowired
    private KhachHangService KhachHangService;

    @GetMapping("/home")
    public String home() {
        return "/viewform/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, ModelAndView modelAndView,
                          @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {

        model.addAttribute("listSp", KhachHangService.getAll(pageNo, 4));
        model.addAttribute("khachHang", new KhachHangRequest());
        modelAndView.addObject("view", "/khachhang/mausacs.jsp");
        return "/khachhang/khachhangs";
    }

    @GetMapping("/viewadd")
    public String viewadd(Model model) {
        model.addAttribute("khachHang", new KhachHangRequest());


        return "/khachhang/add";
    }

    @PostMapping("/add")
    public String add(Model model,
                      @Valid @ModelAttribute("khachHang") KhachHangRequest sp,
                      BindingResult bindingResult,
                      @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            return "/khachhang/add";
        }
        KhachHangService.add(sp);
        model.addAttribute("listSp", KhachHangService.getAll(pageNo, 4));

        return "/khachhang/khachhangs";

    }

    @GetMapping("/viewupdate/{id}")
    public String viewupdate(Model model,
                             @PathVariable("id") String id) {
        model.addAttribute("khachHang", new KhachHangRequest());
        model.addAttribute("sp", KhachHangService.getOne(id));

        return "/khachhang/update";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @Valid @ModelAttribute("khachHang") KhachHangRequest sp,
                         BindingResult bindingResult,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            return "/khachhang/update";
        }
        KhachHangService.update(sp);
        model.addAttribute("listSp", KhachHangService.getAll(pageNo, 4));

        return "/khachhang/khachhangs";

    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") String id) {
        model.addAttribute("khachHang", new KhachHangRequest());
        model.addAttribute("sp", KhachHangService.getOne(id));

        return "/khachhang/detail";
    }

    @GetMapping("/remove/{id}")
    public String remove(Model model,
                         @PathVariable("id") String id,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo

    ) {
        model.addAttribute("listSp", KhachHangService.getAll(pageNo, 4));
        model.addAttribute("khachHang", new KhachHangRequest());
        KhachHangService.remove(id);
        return "/khachhang/khachhangs";

    }
}
