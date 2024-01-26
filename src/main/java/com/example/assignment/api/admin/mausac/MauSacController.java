package com.example.assignment.api.admin.mausac;

import com.example.assignment.api.admin.mausac.dto.MauSacDto;
import com.example.assignment.services.MauSacService;
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
@RequestMapping(value = "/mau-sac")
@RequiredArgsConstructor
public class MauSacController {

    private final MauSacService mauSacService;

    @GetMapping(value = "/test")
    public ResponseEntity<?> test(
            @RequestParam(name = "page", defaultValue = "0") Integer pageParam
    ) {
        Pageable pageable = PageRequest.of(pageParam, 5);
        Page<MauSacDto> pageData = mauSacService.getAll(pageable);
        return ResponseEntity.ok(pageData);
    }

    @GetMapping(value = "/index")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") Integer pageParam
    ) {

        Pageable pageable = PageRequest.of(pageParam, 5);
        Page<MauSacDto> pageData = mauSacService.getAll(pageable);
        model.addAttribute("mauSacPageData", pageData);
        return "admin/mau-sac/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("mauSac", new MauSacDto());
        return "admin/mau-sac/create";
    }

    @PostMapping(value = "/store")
    public String store(@ModelAttribute(name = "mauSac") MauSacDto dto) {
        this.mauSacService.create(dto);
        return "redirect:/mau-sac/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {

        model.addAttribute("mauSac", this.mauSacService.getById(id));
        return "admin/mau-sac/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @ModelAttribute(name = "mauSac") MauSacDto dto
    ) {
        this.mauSacService.update(dto, id);
        return "redirect:/mau-sac/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.mauSacService.deleteById(id);
        return "redirect:/mau-sac/index";
    }
}


