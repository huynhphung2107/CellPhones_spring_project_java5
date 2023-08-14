package com.poly.assignment.ph23794.controller;

import com.poly.assignment.ph23794.dto.request.CuaHangRequest;
import com.poly.assignment.ph23794.service.CuaHangService;
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

@RequestMapping("/cua-hang")
@Controller
public class CuaHangController {
    @Autowired
    private CuaHangService CuaHangService;

    @GetMapping("/home")
    public String home() {
        return "/viewform/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, ModelAndView modelAndView,
                          @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {

        model.addAttribute("listSp", CuaHangService.getAll(pageNo, 4));
        model.addAttribute("cuaHang", new CuaHangRequest());
        modelAndView.addObject("view", "/cuahang/cuahangs.jsp");
        return "/cuahang/cuahangs";
    }

    @GetMapping("/viewadd")
    public String viewadd(Model model) {
        model.addAttribute("cuaHang", new CuaHangRequest());


        return "/cuahang/add";
    }

    @PostMapping("/add")
    public String add(Model model,
                      @Valid @ModelAttribute("cuaHang") CuaHangRequest sp,
                      BindingResult bindingResult,
                      @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            return "/cuahang/add";
        }
        CuaHangService.add(sp);
        model.addAttribute("listSp", CuaHangService.getAll(pageNo, 4));

        return "/cuahang/cuahangs";

    }

    @GetMapping("/viewupdate/{id}")
    public String viewupdate(Model model,
                             @PathVariable("id") String id) {
        model.addAttribute("cuaHang", new CuaHangRequest());
        model.addAttribute("sp", CuaHangService.getOne(id));

        return "/cuahang/update";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @Valid @ModelAttribute("cuaHang") CuaHangRequest sp,
                         BindingResult bindingResult,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            return "/cuahang/update";
        }
        CuaHangService.update(sp);
        model.addAttribute("listSp", CuaHangService.getAll(pageNo, 4));

        return "/cuahang/cuahangs";

    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") String id) {
        model.addAttribute("cuaHang", new CuaHangRequest());
        model.addAttribute("sp", CuaHangService.getOne(id));

        return "/cuahang/detail";
    }

    @GetMapping("/remove/{id}")
    public String remove(Model model,
                         @PathVariable("id") String id,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo

    ) {
        model.addAttribute("listSp", CuaHangService.getAll(pageNo, 4));
        model.addAttribute("cuaHang", new CuaHangRequest());
        CuaHangService.remove(id);
        return "/cuahang/cuahangs";

    }
}
