# Bài tập Android: Xây dựng một ứng dụng theo yêu cầu dựa theo mô hình MVVM với Nhiều Fragment

Bài tập này là một ứng dụng Android được phát triển bằng Kotlin, trình bày các chức năng khác nhau sử dụng kiến trúc MVVM. Ứng dụng bao gồm nhiều fragment, mỗi fragment giải quyết một yêu cầu cụ thể.

## Mục lục
- [Tính năng](#tính-năng)
- [Kiến trúc](#kiến-trúc)
- [Cài đặt](#cài-đặt)
- [Hướng dẫn sử dụng](#hướng-dẫn-sử-dụng)
- [Thông tin thêm](#thông-tin-thêm)

## Tính năng
1. **Chuỗi ký tự**: Hiển thị số lần xuất hiện của mỗi ký tự trong chuỗi.
2. **Kiểm tra điểm trong tam giác**: Xác định xem một điểm có nằm trong tam giác được tạo từ ba điểm khác hay không.
3. **Đọc và hiển thị dữ liệu từ JSON**: Đọc dữ liệu từ tệp JSON và hiển thị lên màn hình với độ trễ 2 giây.
4. **Tạo tam giác và kiểm tra điểm**: Tạo một tam giác bằng cách chạm vào màn hình và kiểm tra xem một điểm có nằm trong tam giác đã tạo hay không.

## Kiến trúc
Dự án này được xây dựng theo mô hình MVVM (Model-View-ViewModel):
- **Model**: Quản lý dữ liệu và logic nghiệp vụ.
- **View**: Hiển thị dữ liệu và tương tác với người dùng.
- **ViewModel**: Kết nối Model và View, cung cấp dữ liệu cho View và phản hồi các tương tác của người dùng.

## Cài đặt
1. **Clone repository**:
    ```bash
    git clone https://github.com/kouhoang/intern_android_ex1.git
    ```
2. **Mở dự án trong Android Studio**:
    - Mở Android Studio.
    - Chọn "Open an existing Android Studio project".
    - Dẫn đến thư mục chứa dự án đã clone và chọn "Open".

3. **Cài đặt dependencies**:
    - Dự án sử dụng một số thư viện cần thiết được quản lý trong tệp `build.gradle` (Module: app). Khi mở dự án, Android Studio sẽ tự động tải và cài đặt các thư viện này.

## Hướng dẫn sử dụng
### Fragment 1: Chuỗi ký tự
- Nhập chuỗi ký tự vào TextField và nhấn nút ✅.
- Kết quả sẽ hiển thị số lần xuất hiện của mỗi ký tự trong chuỗi.

### Fragment 2: Kiểm tra điểm trong tam giác
- Nhập tọa độ của điểm A và ba điểm tạo thành tam giác.
- Nhấn nút "Lưu" để kiểm tra xem điểm A có nằm trong tam giác hay không.
- Kết quả sẽ hiển thị trên màn hình.

### Fragment 3: Đọc và hiển thị dữ liệu từ JSON
- Khi mở fragment, dữ liệu từ tệp `profile.json` sẽ được đọc và hiển thị sau 2 giây theo một giao diện đã có trước.

### Fragment 4: Tạo tam giác và kiểm tra điểm
- Chạm vào màn hình ba lần để tạo tam giác.
- Chạm lần thứ tư để tạo một điểm và kiểm tra xem điểm đó có nằm trong tam giác đã tạo hay không.
- Kết quả sẽ hiển thị trên màn hình.
- Bấm nút Reset để có thể thao tác lại từ đầu.

## Thông tin thêm
- **Phản hồi**: Nếu có bất kỳ lỗi nào hoặc cần cải tiến, vui lòng tạo một issue trên GitHub.

## Tác giả
- **Tên của bạn** - kouhoang(https://github.com/kouhoang)
