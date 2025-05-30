# Hệ Thống Quản Lý Bida

## Giới thiệu

Đây là phần mềm quản lý bida được phát triển bằng Java Swing, hỗ trợ các nghiệp vụ cơ bản như quản lý bàn, gậy, khách hàng, nhân viên, hóa đơn, dịch vụ, đặt trước, v.v. Phần mềm giúp các cơ sở kinh doanh bida quản lý hiệu quả hoạt động kinh doanh, tiết kiệm thời gian và giảm thiểu sai sót.

## Tính năng chính

- Quản lý bàn bida: thêm, sửa, xóa, cập nhật trạng thái bàn.
- Quản lý gậy, dịch vụ: thêm mới, chỉnh sửa, xóa, cập nhật thông tin.
- Quản lý khách hàng: lưu trữ thông tin, lịch sử sử dụng dịch vụ.
- Quản lý nhân viên: thêm mới, chỉnh sửa, phân quyền tài khoản.
- Quản lý hóa đơn: tạo hóa đơn, thanh toán, lưu trữ lịch sử giao dịch.
- Đặt trước bàn: hỗ trợ khách hàng đặt bàn trước, quản lý trạng thái đặt bàn.
- Báo cáo doanh thu, thống kê sử dụng dịch vụ.
- Đăng nhập, phân quyền tài khoản (quản lý, nhân viên).
- Giao diện trực quan, dễ sử dụng.

## Cấu trúc thư mục

```
src/
├── dao/        # Lớp truy xuất dữ liệu
├── model/      # Định nghĩa các đối tượng dữ liệu
├── view/       # Giao diện người dùng (Java Swing)
├── control/    # Xử lý logic nghiệp vụ
└── utils/      # Các tiện ích dùng chung
```

## Yêu cầu hệ thống

- Java JDK 8 trở lên
- Hệ quản trị cơ sở dữ liệu MySQL (hoặc SQL Server tùy cấu hình)
- IDE: NetBeans, IntelliJ IDEA, hoặc Visual Studio Code

## Hướng dẫn cài đặt

1. **Clone project về máy:**
   ```
   git clone https://github.com/DuyNguyen279/PTTKHT.git
   ```
2. **Cấu hình cơ sở dữ liệu:**
   - Tạo database theo file script trong thư mục `database/`.
   - Cập nhật thông tin kết nối DB trong file cấu hình (ví dụ: `DBConnection.java`).

3. **Build và chạy chương trình:**
   - Mở project bằng IDE.
   - Build project.
   - Chạy file `Main.java` để khởi động ứng dụng.

## Tài khoản mẫu
- **Quản lý:**  
  Tài khoản: `admin`  
  Mật khẩu: `admin`

- **Nhân viên:**  
  Tài khoản: `nhanvien1`  
  Mật khẩu: `123`

## Đóng góp

Mọi đóng góp, phản hồi hoặc báo lỗi xin gửi về ntduy279@gmail.com hoặc tạo issue trên GitHub.

## Hướng phát triển

- Phát triển phiên bản web/mobile.
- Tích hợp thanh toán điện tử.
- Nâng cấp báo cáo, thống kê.
- Tăng cường bảo mật, phân quyền chi tiết.
- Hỗ trợ đa ngôn ngữ.

---

**Bản quyền © 2025 ntduy**
