package com.example.assignment.api.admin.sanphamchitiet;

import java.util.Optional;

import com.example.assignment.api.admin.kichthuoc.dto.KichThuocDto;
import com.example.assignment.api.admin.mausac.dto.MauSacDto;
import com.example.assignment.api.admin.sanphamchitiet.dto.SanPhamChiTietDto;
import com.example.assignment.api.admin.sanphamchitiet.dto.SanPhamChiTietViewIndex;
import com.example.assignment.services.KichThuocService;
import com.example.assignment.services.MauSacService;
import com.example.assignment.services.SanPhamChiTietService;
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
@RequestMapping(value = "/san-pham-chi-tiet")
@RequiredArgsConstructor
public class SanPhamChiTietController {

    private Integer SAN_PHAM_ID = null;

    private Integer PAGE_NUMBER = 0;

    private final SanPhamChiTietService sanPhamChiTietService;

    private final SanPhamService sanPhamService;

    private final MauSacService mauSacService;

    private final KichThuocService kichThuocService;


    @GetMapping(value = "/test")
    public ResponseEntity<?> test(
            @RequestParam(name = "page", defaultValue = "0") Integer pageParam
    ) {
        Pageable pageable = PageRequest.of(pageParam, 5);
        Page<SanPhamChiTietDto> pageData = this.sanPhamChiTietService.getAll(pageable);
        return ResponseEntity.ok(pageData);
    }

    @GetMapping(value = "/index")
    public String index(
            Model model,
            @RequestParam(name = "sanPhamId") Optional<Integer> idOptional,
            @RequestParam(name = "page", defaultValue = "0") Optional<Integer> pageParam
    ) {

        idOptional.or(
                () -> this.SAN_PHAM_ID.describeConstable()
        ).ifPresent(
                integer -> this.SAN_PHAM_ID = integer
        );

        pageParam.or(
                () -> this.PAGE_NUMBER.describeConstable()
        ).ifPresent(
                integer -> this.PAGE_NUMBER = integer
        );

        Page<SanPhamChiTietViewIndex> pageData = this.sanPhamChiTietService.getAllByIdSanPham(
                this.SAN_PHAM_ID,
                PageRequest.of(this.PAGE_NUMBER, 5)
        )
                .map(
                        dto -> SanPhamChiTietViewIndex.builder()
                                .id(dto.getId())
                                .mauSac(
                                        this.mauSacService.findById(dto.getIdMauSac())
                                                .orElse(new MauSacDto())
                                ).kichThuoc(
                                        this.kichThuocService.findById(dto.getIdKichThuoc())
                                                .orElse(new KichThuocDto())
                                )
                                .maSPCT(dto.getMaSPCT())
                                .soLuong(dto.getSoLuong())
                                .donGia(dto.getDonGia())
                                .trangThai(dto.getTrangThai())
                                .build()
                );
        model.addAttribute("sanPhamChiTietPageData", pageData);

        model.addAttribute("sanPham", this.sanPhamService.getById(this.SAN_PHAM_ID));
        return "admin/san-pham-chi-tiet/index";
    }

    @GetMapping(value = "/create")
    public String create(
            Model model,
            @RequestParam(name = "sanPhamId") Optional<Integer> idOptional
    ) {
        idOptional.or(
                () -> this.SAN_PHAM_ID.describeConstable()
        ).ifPresent(
                integer -> this.SAN_PHAM_ID = integer
        );
        model.addAttribute("sanPham", this.sanPhamService.getById(this.SAN_PHAM_ID));
        model.addAttribute("sanPhamChiTiet", SanPhamChiTietDto.builder().idSanPham(this.SAN_PHAM_ID).build());

        return "admin/san-pham-chi-tiet/create";
    }

    @PostMapping(value = "/store")
    public String store(@ModelAttribute(name = "sanPhamChiTiet") SanPhamChiTietDto dto) {
        this.sanPhamChiTietService.create(dto);
        return "redirect:/san-pham-chi-tiet/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id,
            @RequestParam(name = "sanPhamId") Optional<Integer> idOptional
    ) {
        idOptional.or(
                () -> this.SAN_PHAM_ID.describeConstable()
        ).ifPresent(
                integer -> this.SAN_PHAM_ID = integer
        );
        model.addAttribute("sanPham", this.sanPhamService.getById(this.SAN_PHAM_ID));
        model.addAttribute("sanPhamChiTiet", this.sanPhamChiTietService.getById(id));
        return "admin/san-pham-chi-tiet/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @ModelAttribute(name = "sanPhamChiTiet") SanPhamChiTietDto dto
    ) {
        this.sanPhamChiTietService.update(dto, id);
        return "redirect:/san-pham-chi-tiet/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.sanPhamChiTietService.deleteById(id);
        return "redirect:/san-pham-chi-tiet/index";
    }
}
