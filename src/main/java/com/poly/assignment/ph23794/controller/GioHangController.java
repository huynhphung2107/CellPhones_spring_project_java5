package com.poly.assignment.ph23794.controller;

import com.poly.assignment.ph23794.entity.GioHang;
import com.poly.assignment.ph23794.entity.KhachHang;
import com.poly.assignment.ph23794.entity.NhanVien;
import com.poly.assignment.ph23794.service.GioHangService;
import com.poly.assignment.ph23794.service.KhachHangService;
import com.poly.assignment.ph23794.service.NhanVienService;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/gio-hang/")
public class GioHangController {
    List<GioHang> listGioHang = new ArrayList<>();
    List<KhachHang> listKhachHang = new ArrayList<>();
    List<NhanVien> listNhanVien = new ArrayList<>();
    @Autowired
    private GioHangService gioHangService;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("hien-thi")
    public String viewGioHang(Model model){
        listGioHang = gioHangService.getAllGH();
        model.addAttribute("listGioHang", listGioHang);
        return "viewGioHang/gio-hang";
    }
    @GetMapping("view-add")
    public String viewAddGioHang(Model model){
        listKhachHang = khachHangService.getAll1();
        listNhanVien = nhanVienService.getAll1();
        model.addAttribute("addGioHang", new GioHang());
        model.addAttribute("listKhachHang", listKhachHang);
        model.addAttribute("listNhanVien", listNhanVien);
        return "viewGioHang/view-add";
    }
    @PostMapping("add")
    public String addGioHang(@ModelAttribute("addGioHang") GioHang newGioHang){
        gioHangService.addGioHang(newGioHang);
        return "redirect:/gio-hang/hien-thi";
    }
    @GetMapping("delete/{idGioHang}")
    public String huyGioHang(@PathVariable("idGioHang") UUID idGioHang){
        gioHangService.deleteGioHang(idGioHang);
        return "redirect:/gio-hang/hien-thi";
    }
    @PostMapping("search")
    public String searchTen(Model model,
                            @RequestParam("maGioHang") String maGioHang) {
        if (maGioHang.isEmpty()) {
            model.addAttribute("listGioHang", listGioHang);
        } else {
            List<GioHang> searchGioHang = gioHangService.searchMaGioHang(maGioHang);
            model.addAttribute("listGioHang", searchGioHang);
        }
        return "viewGioHang/gio-hang";
    }
}
