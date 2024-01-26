package com.example.assignment.api.admin.sanpham;

import com.example.assignment.api.admin.sanpham.dto.SanPhamDto;
import com.example.assignment.services.SanPhamService;
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
@RequestMapping(value = "/san-pham")
@RequiredArgsConstructor
public class SanPhamController {

    private final SanPhamService sanPhamService;

    @GetMapping(value = "/test")
    public ResponseEntity<?> test(
            @RequestParam(name = "page", defaultValue = "0") Integer pageParam
    ) {
        Pageable pageable = PageRequest.of(pageParam, 5);
        Page<SanPhamDto> pageData = this.sanPhamService.getAll(pageable);
        return ResponseEntity.ok(pageData);
    }

    @GetMapping(value = "/index")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageParam
    ) {

        Pageable pageable = PageRequest.of(pageParam, 5);
        Page<SanPhamDto> pageData = this.sanPhamService.getAll(pageable);
        model.addAttribute("sanPhamPageData", pageData);
        return "admin/san-pham/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("sanPham", new SanPhamDto());
        return "admin/san-pham/create";
    }

    @PostMapping(value = "/store")
    public String store(@ModelAttribute(name = "sanPham") SanPhamDto dto) {
        this.sanPhamService.create(dto);
        return "redirect:/san-pham/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {

        model.addAttribute("sanPham", this.sanPhamService.getById(id));
        return "admin/san-pham/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @ModelAttribute(name = "sanPham") SanPhamDto dto
    ) {
        this.sanPhamService.update(dto, id);
        return "redirect:/san-pham/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.sanPhamService.deleteById(id);
        return "redirect:/san-pham/index";
    }
}


