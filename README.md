# Clinic management - Spring MVC

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally
```
Download Apache Tomcat
Import clinicmanagementdb.sql file
In clinic-springmvc/src/main/resources/databases.properties -> modify port + username + password
```

## Techs
- Spring MVC
- Hibernate
- Spring security
- Mysql
- Bootstrap 5

## Overview

### 1. Mô tả chung
Website quản lý phòng mạch được xây dựng với Spring MVC + JSP View

### 2. Database schema

<img src="https://res.cloudinary.com/tamdev/image/upload/v1666166777/clinic/images/erd-springmvc_t5icwq.png">

### 3. Chức năng
- Đăng nhập (có các vai trò admin, bác sĩ, y tá, bệnh nhân) và đăng ký người dùng (bệnh
nhân) (phải có avatar upload lên cloudinary).
- Admin có quyền quản lý tất cả thông tin như quản lý (thêm/xoá/cập nhật/tra cứu) bác
sĩ, y tá phòng mạch, sắp lịch trực cho từng đối tượng, quản lý thuốc (thêm/xoá/sửa/tìm
kiếm). Một super admin có quyền thiết lập quyền admin chom một user khác.
- Bệnh nhân đăng ký/huỷ lịch khám, lịch đăng ký của bệnh nhân sẽ được y tá xác nhận,
khi lịch xác nhận thì bệnh nhân nhận email lịch hẹn. Quy định trong ngày phòng khám
chỉ tiếp nhận tối đa 40 lịch khám.
- Bác sĩ ra toa thuốc cho bệnh nhân (chỉ bác sĩ được thực hiện nhiệm vụ này), trong quá
trình ra toa, bác sĩ được phép tìm kiếm thuốc cần để thêm vào toa. Khi ra toa, bác sĩ
chỉ định triệu chứng bệnh, kết luận và danh mục thuốc uống. Trong quá trình kê toá,
bác sĩ được phép xem lịch sử khám và bệnh của bệnh nhân (linh hoạt lọc theo khoảng
thời gian).in
- Thống kê báo cáo số lượng bệnh nhân đến khám, doanh thu và tần suất sử dụng các
thuốc được kê toa linh hoạt theo tháng, quý, năm (kết hợp vẽ biều đồ bằng
chartjs/googlejs) (chỉ admin được thực hiện chức năng này).
- Bác sĩ tư vấn trực tuyến cho bệnh nhân.
- Thanh toán tiền khám (tiền khám + chi phí ra toa của bác sĩ, và y tá là người thực hiện
chức năng này). Bệnh nhân có thể thanh toán tiền khám trực tiếp hoặc thông quá ví
điện tử momo.


