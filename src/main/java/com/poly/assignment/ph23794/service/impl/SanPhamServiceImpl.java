package com.poly.assignment.ph23794.service.impl;

import com.poly.assignment.ph23794.dto.request.SanPhamRequest;
import com.poly.assignment.ph23794.entity.SanPham;
import com.poly.assignment.ph23794.repository.SanPhamRepository;
import com.poly.assignment.ph23794.service.SanPhamService;
import com.poly.assignment.ph23794.service.ServiceGenarate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamRepository sanPhamService;

    @Override
    public List<SanPham> getAll1() {
        return sanPhamRepository.findAll();
    }

    @Override
    public Page<SanPham> getAll(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public void add(SanPhamRequest request) {
        SanPham sp = SanPham.builder()
                .ma(request.getMa())
                .ten(request.getTen())
                .build();
        sanPhamRepository.save(sp);

    }

    @Override
    public void update(SanPhamRequest request) {
        SanPham sp = sanPhamService.getOne(request.getId());
        sp.setMa(request.getMa());
        sp.setTen(request.getTen());

        sanPhamRepository.save(sp);


    }

    @Override
    public void remove(String id) {
        sanPhamRepository.deleteById(id);

    }

    @Override
    public SanPham getOne(String id) {
        return sanPhamRepository.findById(id).get();
    }

    @Override
    public File saveFile(MultipartFile file, String path) {
        if (!file.isEmpty()) {
            try {
                Path directoryPath = Paths.get(path);
                if (!Files.exists(directoryPath)) {
                    Files.createDirectories(directoryPath);
                }
                String fileName = file.getOriginalFilename();
                String filePath = path + File.separator + fileName;
                File savedFile = new File(filePath);
                Files.copy(file.getInputStream(), savedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                return savedFile;
            } catch (IOException e) {
                throw new RuntimeException("Error saving file");
            }
        }
        return null;
    }

}
