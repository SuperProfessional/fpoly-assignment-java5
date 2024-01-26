package com.example.assignment.api.admin.nhanvien.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienDto {

    private Integer id;

    @NotBlank(message = "Mã nhân viên không được để trống")
    private String ma;

    @NotBlank(message = "Tên không được để trống")
    private String ten;

    @NotBlank(message = "Tên đăng nhập không được để trống")
    private String tenDangNhap;

    @NotBlank(message = "Mật khẩu không được để trống")
    private String matKhau;

    private Integer trangThai;
}
