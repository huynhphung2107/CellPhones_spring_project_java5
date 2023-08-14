package com.poly.assignment.ph23794.controller;


import com.poly.assignment.ph23794.entity.ChiTietSanPham;
import com.poly.assignment.ph23794.entity.GioHang;
import com.poly.assignment.ph23794.entity.GioHangChiTiet;
import com.poly.assignment.ph23794.service.ChiTietSanPhamService;
import com.poly.assignment.ph23794.service.GioHangChiTietService;
import com.poly.assignment.ph23794.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/gio-hang-chi-tiet/")
public class GioHangChiTietController {
    List<GioHangChiTiet> listGioHangChiTiet = new ArrayList<>();
    List<GioHang> listGioHang = new ArrayList<>();
    List<ChiTietSanPham> listChiTietSanPham = new ArrayList<>();
    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private ChiTietSanPhamService chiTietSPService;

    @Autowired
    private GioHangService gioHangService;

    @GetMapping("hien-thi/{idGioHangChiTiet}")
    public String viewGioHangChiTietById(Model model,
                                         @PathVariable("idGioHangChiTiet") UUID idGioHangChiTiet) {
        listGioHangChiTiet = gioHangChiTietService.getAllGioHangById(idGioHangChiTiet);
        model.addAttribute("listGioHangChiTietById", listGioHangChiTiet);
        return "viewGioHang/chi-tiet-gio-hang";
    }

    @GetMapping("view-add-san-pham")
    public String viewAddSanPham(Model model) {
        listGioHang = gioHangService.getAllGH();
        listChiTietSanPham = chiTietSPService.getAll1();
        model.addAttribute("listGioHang", listGioHang);
        model.addAttribute("listGioHangChiTietById", listGioHangChiTiet);
        model.addAttribute("listSanPhamAddToCart", listChiTietSanPham);
        return "viewGioHang/view-add-san-pham";
    }

    @GetMapping("addtocart/{idCTSP}")
    public String addSanPhamVaoGioHang(@PathVariable("idGioHang") UUID idGioHang,
                                       @PathVariable("idCTSP") UUID idCTSP,
                                       @PathVariable("giaBan") Double giaBan) {
        gioHangChiTietService.addToCart(idGioHang, idCTSP, 1, giaBan);
        return "redirect:/gio-hang-chi-tiet/hien-thi/{idGioHang}";
    }
}
