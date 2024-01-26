package com.example.assignment.api.admin.khachhang;

import com.example.assignment.api.admin.khachhang.dto.KhachHangDto;
import com.example.assignment.services.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/khach-hang")
@RequiredArgsConstructor
public class KhachHangController {

    private final KhachHangService khachHangService;

    @GetMapping(value = "/test")
    public ResponseEntity<?> test(
            @RequestParam(name = "page", defaultValue = "0") Integer pageParam
    ) {
        Pageable pageable = PageRequest.of(pageParam, 5);
        Page<KhachHangDto> pageData = this.khachHangService.getAll(pageable);
        return ResponseEntity.ok(pageData);
    }

    @GetMapping(value = "/index")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageParam
    ) {

        Pageable pageable = PageRequest.of(pageParam, 5);
        Page<KhachHangDto> pageData = this.khachHangService.getAll(pageable);
        model.addAttribute("khachHangPageData", pageData);
        return "admin/khach-hang/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("khachHang", new KhachHangDto());
        return "admin/khach-hang/create";
    }

    @PostMapping(value = "/store")
    public String store(@ModelAttribute(name = "khachHang") KhachHangDto dto) {
        this.khachHangService.create(dto);
        return "redirect:/khach-hang/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {

        model.addAttribute("khachHang", this.khachHangService.getById(id));
        return "admin/khach-hang/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @ModelAttribute(name = "khachHang") KhachHangDto dto
    ) {
        this.khachHangService.update(dto, id);
        return "redirect:/khach-hang/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.khachHangService.deleteById(id);
        return "redirect:/khach-hang/index";
    }
}


