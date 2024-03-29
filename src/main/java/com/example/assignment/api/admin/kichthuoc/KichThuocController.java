package com.example.assignment.api.admin.kichthuoc;

import com.example.assignment.api.admin.kichthuoc.dto.KichThuocDto;
import com.example.assignment.services.KichThuocService;
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
@RequestMapping(value = "/kich-thuoc")
@RequiredArgsConstructor
public class KichThuocController {

    private final KichThuocService kichThuocService;

    @GetMapping(value = "/test")
    public ResponseEntity<?> test(
            @RequestParam(name = "page", defaultValue = "0") Integer pageParam
    ) {
        Pageable pageable = PageRequest.of(pageParam, 5);
        Page<KichThuocDto> pageData = kichThuocService.getAll(pageable);
        return ResponseEntity.ok(pageData);
    }

    @GetMapping(value = "/index")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageParam
    ) {

        Pageable pageable = PageRequest.of(pageParam, 5);
        Page<KichThuocDto> pageData = kichThuocService.getAll(pageable);
        model.addAttribute("KichThuocPageData", pageData);
        return "admin/kich-thuoc/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("kichThuoc", new KichThuocDto());
        return "admin/kich-thuoc/create";
    }

    @PostMapping(value = "/store")
    public String store(@ModelAttribute(name = "kichThuoc") KichThuocDto dto) {
        this.kichThuocService.create(dto);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {

        model.addAttribute("kichThuoc", this.kichThuocService.getById(id));
        return "admin/kich-thuoc/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @ModelAttribute(name = "kichThuoc") KichThuocDto dto
    ) {
        this.kichThuocService.update(dto, id);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.kichThuocService.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }
}


