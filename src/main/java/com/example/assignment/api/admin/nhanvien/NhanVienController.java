package com.example.assignment.api.admin.nhanvien;

import com.example.assignment.api.admin.nhanvien.dto.NhanVienDto;
import com.example.assignment.services.NhanVienService;
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
@RequestMapping(value = "/nhan-vien")
@RequiredArgsConstructor
public class NhanVienController {

    private final NhanVienService nhanVienService;

    @GetMapping(value = "/test")
    public ResponseEntity<?> test(
            @RequestParam(name = "page", defaultValue = "0") Integer pageParam
    ) {
        Pageable pageable = PageRequest.of(pageParam, 5);
        Page<NhanVienDto> pageData = this.nhanVienService.getAll(pageable);
        return ResponseEntity.ok(pageData);
    }

    @GetMapping(value = "/index")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageParam
    ) {

        Pageable pageable = PageRequest.of(pageParam, 5);
        Page<NhanVienDto> pageData = this.nhanVienService.getAll(pageable);
        model.addAttribute("nhanVienPageData", pageData);
        return "admin/nhan-vien/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("nhanVien", new NhanVienDto());
        return "admin/nhan-vien/create";
    }

    @PostMapping(value = "/store")
    public String store(@ModelAttribute(name = "nhanVien") NhanVienDto dto) {
        this.nhanVienService.create(dto);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {

        model.addAttribute("nhanVien", this.nhanVienService.getById(id));
        return "admin/nhan-vien/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @ModelAttribute(name = "nhanVien") NhanVienDto dto
    ) {
        this.nhanVienService.update(dto, id);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.nhanVienService.deleteById(id);
        return "redirect:/nhan-vien/index";
    }
}


