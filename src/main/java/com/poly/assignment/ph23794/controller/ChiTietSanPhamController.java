package com.poly.assignment.ph23794.controller;

import com.poly.assignment.ph23794.dto.request.ChiTietSanPhamRequest;
import com.poly.assignment.ph23794.dto.request.DongSpRequest;
import com.poly.assignment.ph23794.dto.request.MauSacRequest;
import com.poly.assignment.ph23794.dto.request.NoiSanXuatRequest;
import com.poly.assignment.ph23794.dto.request.SanPhamRequest;
import com.poly.assignment.ph23794.service.ChiTietSanPhamService;
import com.poly.assignment.ph23794.service.DongSpService;
import com.poly.assignment.ph23794.service.MauSacService;
import com.poly.assignment.ph23794.service.NoiSanXuatService;
import com.poly.assignment.ph23794.service.SanPhamService;
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
//import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/chi-tiet-san-pham")
@Controller
public class ChiTietSanPhamController {
    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private DongSpService dongSpService;

    @Autowired
    private NoiSanXuatService noiSanXuatService;


    @GetMapping("/home")
    public String home() {
        return "/viewform/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model,
                          @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {

        model.addAttribute("listSp", chiTietSanPhamService.getAll(pageNo, 4));
        model.addAttribute("listSp1", sanPhamService.getAll1());
        model.addAttribute("listMs", mauSacService.getAll1());
        model.addAttribute("listDsp", dongSpService.getAll1());
        model.addAttribute("listNsx", noiSanXuatService.getAll1());
        model.addAttribute("chiTietSanPham", new ChiTietSanPhamRequest());
//        modelAndView.addObject("view", "/chitietsanpham/chitietsanphams.jsp");
        return "/chitietsanpham/chitietsanphams";
    }

    @GetMapping("/viewadd")
    public String viewadd(Model model) {
        model.addAttribute("chiTietSanPham", new ChiTietSanPhamRequest());
        model.addAttribute("listSp1", sanPhamService.getAll1());
        model.addAttribute("listMs", mauSacService.getAll1());
        model.addAttribute("listDsp", dongSpService.getAll1());
        model.addAttribute("listNsx", noiSanXuatService.getAll1());

        return "/chitietsanpham/add";
    }

    @PostMapping("/add")
    public String add(Model model,
                      @Valid @ModelAttribute("chiTietSanPham") ChiTietSanPhamRequest sp,
                      BindingResult bindingResult,
                      @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            model.addAttribute("listSp1", sanPhamService.getAll1());
            model.addAttribute("listMs", mauSacService.getAll1());
            model.addAttribute("listDsp", dongSpService.getAll1());
            model.addAttribute("listNsx", noiSanXuatService.getAll1());
            return "/chitietsanpham/add";
        }
        chiTietSanPhamService.add(sp);
        model.addAttribute("listSp", chiTietSanPhamService.getAll(pageNo, 4));

        return "/chitietsanpham/chitietsanphams";

    }

    @GetMapping("/viewupdate/{id}")
    public String viewupdate(Model model,
                             @PathVariable("id") String id
                            ) {

        model.addAttribute("sp", chiTietSanPhamService.getOne(id));

        model.addAttribute("listSanPham", sanPhamService.getAll1());
        model.addAttribute("listMs", mauSacService.getAll1());
        model.addAttribute("listDsp", dongSpService.getAll1());
        model.addAttribute("listNsx", noiSanXuatService.getAll1());

        model.addAttribute("chiTietSanPham", new ChiTietSanPhamRequest());



        return "/chitietsanpham/update";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @Valid @ModelAttribute("chiTietSanPham") ChiTietSanPhamRequest sp,
                         BindingResult bindingResult,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "/chitietsanpham/update";
        }
        chiTietSanPhamService.update(sp);
        model.addAttribute("listSp", chiTietSanPhamService.getAll(pageNo, 4));

        return "/chitietsanpham/chitietsanphams";

    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") String id) {
        model.addAttribute("chiTietSanPham", new ChiTietSanPhamRequest());
        model.addAttribute("sp", chiTietSanPhamService.getOne(id));

        return "/chitietsanpham/detail";
    }

    @GetMapping("/remove/{id}")
    public String remove(Model model,
                         @PathVariable("id") String id,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo

    ) {
        model.addAttribute("listSp", chiTietSanPhamService.getAll(pageNo, 4));
        model.addAttribute("chiTietSanPham", new ChiTietSanPhamRequest());
        chiTietSanPhamService.remove(id);
        return "/chitietsanpham/chitietsanphams";

    }
}
