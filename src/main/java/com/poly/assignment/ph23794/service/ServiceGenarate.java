package com.poly.assignment.ph23794.service;

import com.poly.assignment.ph23794.entity.SanPham;
import org.springframework.data.domain.Page;

public interface ServiceGenarate<T> {

    Page<SanPham> getAll(Integer pageNo,Integer size);

    void add(T entity);

    void update(T entity);

    void remove(String id);

    T getOne(String id);
}
