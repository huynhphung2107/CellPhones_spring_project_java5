package com.poly.assignment.ph23794.controller;

import com.poly.assignment.ph23794.dto.request.SanPhamRequest;
import com.poly.assignment.ph23794.entity.SanPham;
import com.poly.assignment.ph23794.service.SanPhamService;
import com.poly.assignment.ph23794.service.ServiceGenarate;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.SizeLimitExceededException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;


@RequestMapping("/san-pham")
@Controller
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/home")
    public String home() {
        return "/viewform/index";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, ModelAndView modelAndView,
                          @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {

        model.addAttribute("listSp", sanPhamService.getAll(pageNo, 4));
        model.addAttribute("sanPham", new SanPhamRequest());
        modelAndView.addObject("view", "/sanpham/mausacs.jsp");
        return "/sanpham/sanphams";
    }

    @GetMapping("/viewadd")
    public String viewadd(Model model) {
        model.addAttribute("sanPham", new SanPhamRequest());


        return "/sanpham/add";
    }

    @PostMapping("/add")
    public String add(Model model,
                      @Valid @ModelAttribute("sanPham") SanPhamRequest sp,
                      BindingResult bindingResult,
                      @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {

        if (bindingResult.hasErrors()) {
            return "/sanpham/add";

        }
        sanPhamService.add(sp);
        model.addAttribute("sanPham", new SanPhamRequest());
        model.addAttribute("listSp", sanPhamService.getAll(pageNo, 4));
        return "/sanpham/sanphams";

    }

    @GetMapping("/viewupdate/{id}")
    public String viewupdate(Model model,
                             @PathVariable("id") String id) {
        model.addAttribute("sanPham", new SanPhamRequest());
        model.addAttribute("sp", sanPhamService.getOne(id));

        return "/sanpham/update";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @Valid @ModelAttribute("sanPham") SanPhamRequest sp,
                         BindingResult bindingResult,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo
    ) {
        if (bindingResult.hasErrors()) {
            return "/sanpham/update";
        }
        sanPhamService.update(sp);
        model.addAttribute("listSp", sanPhamService.getAll(pageNo, 4));

        return "/sanpham/sanphams";

    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") String id) {
        model.addAttribute("sanPham", new SanPhamRequest());
        model.addAttribute("sp", sanPhamService.getOne(id));

        return "/sanpham/detail";
    }

    @GetMapping("/remove/{id}")
    public String remove(Model model,
                         @PathVariable("id") String id,
                         @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo

    ) {
        model.addAttribute("listSp", sanPhamService.getAll(pageNo, 4));
        model.addAttribute("sanPham", new SanPhamRequest());
        sanPhamService.remove(id);
        return "/sanpham/sanphams";

    }

}
