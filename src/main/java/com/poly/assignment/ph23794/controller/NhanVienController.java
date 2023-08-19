package com.poly.assignment.ph23794.controller;

import com.poly.assignment.ph23794.dto.request.NhanVienRequest;
import com.poly.assignment.ph23794.entity.NhanVien;
import com.poly.assignment.ph23794.service.NhanVienService;
import com.poly.assignment.ph23794.service.ChucVuService;
import com.poly.assignment.ph23794.service.CuaHangService;
import com.poly.assignment.ph23794.service.DongSpService;
import com.poly.assignment.ph23794.service.MauSacService;
import com.poly.assignment.ph23794.service.NhanVienService;
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
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/nhan-vien")
@Controller
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private ChucVuService chucVuService;


    @GetMapping("/home")
    public String home() {
        return "/viewform/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, ModelAndView modelAndView,
                          @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {

        model.addAttribute("listSp", nhanVienService.getAll(pageNo, 4));
        model.addAttribute("listCh", cuaHangService.getAll1());
        model.addAttribute("listCv", chucVuService.getAll1());
        model.addAttribute("nhanVien", new NhanVienRequest());
        modelAndView.addObject("view", "/nhanvien/nhanvienss.jsp");
        return "/nhanvien/nhanvienss";
    }

    @GetMapping("/viewadd")
    public String viewadd(Model model) {
        model.addAttribute("nhanVien", new NhanVienRequest());
        model.addAttribute("listCh", cuaHangService.getAll1());
        model.addAttribute("listCv", chucVuService.getAll1());
        model.addAttribute("listNv", nhanVienService.getAll1());

        return "/nhanvien/add";
    }

    @PostMapping("/add")
    public String add(Model model,
                      @Valid @ModelAttribute("nhanVien") NhanVienRequest nv,
                      BindingResult bindingResult,
                      @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            model.addAttribute("listCh", cuaHangService.getAll1());
            model.addAttribute("listCv", chucVuService.getAll1());
            System.out.println(bindingResult);
            return "/nhanvien/add";
        }
       nhanVienService.add(nv);
        model.addAttribute("listCh", cuaHangService.getAll1());
        model.addAttribute("listCv", chucVuService.getAll1());
        model.addAttribute("listNv", nhanVienService.getAll1());
        model.addAttribute("listSp", nhanVienService.getAll(pageNo, 4));


        return "/nhanvien/nhanvienss";

    }

    @GetMapping("/viewupdate/{id}")
    public String viewupdate(Model model,
                             @PathVariable("id") String id) {
        model.addAttribute("nhanVien", new NhanVienRequest());
        model.addAttribute("sp", nhanVienService.getOne(id));
        model.addAttribute("listCh", cuaHangService.getAll1());
        model.addAttribute("listCv", chucVuService.getAll1());


        return "/nhanvien/update";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @Valid @ModelAttribute("nhanVien") NhanVienRequest sp,
                         BindingResult bindingResult,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listCh", cuaHangService.getAll1());
            model.addAttribute("listCv", chucVuService.getAll1());
            return "/nhanvien/update";
        }
        nhanVienService.update(sp);
        model.addAttribute("listSp", nhanVienService.getAll(pageNo, 4));

        return "/nhanvien/nhanvienss";

    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") String id) {
        model.addAttribute("nhanVien", new NhanVienRequest());
        model.addAttribute("sp", nhanVienService.getOne(id));

        return "/nhanvien/detail";
    }

    @GetMapping("/remove/{id}")
    public String remove(Model model,
                         @PathVariable("id") String id,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo

    ) {
        model.addAttribute("listSp", nhanVienService.getAll(pageNo, 4));
        model.addAttribute("nhanVien", new NhanVienRequest());
        nhanVienService.remove(id);
        return "/nhanvien/nhanvienss";

    }
}
