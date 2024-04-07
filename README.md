# Hotel-management-project
Hotel management project (Demo sơ sài)

Phần 1: Đối tượng
I.Khách hàng 
1.Thuộc tính 
a.MaKhach
b.TenKhach
c.Tuoi
d.SoDT
e.CCCD
f.DiaChi
g.TaiKhoan(Số dư tài khoản)
2.Phương thức
a.Constructor
b.Setter, getter
c.Thêm
d.Sửa
e.Xóa

II.Phòng
1.Thuộc tính
a.MaPhong
b.LoaiPhong
c.GiaPhong
d.TrangThai
2.Phương thức
a.Constructor
b.Setter, getter
c.Thêm
d.Sửa
e.Xóa

III.Danh sách phòng
1.Thuộc tính
Phòng
2.Phương thức
a.InDanhSachPhongConTrong
b.InDanhSachPhong
c.TimKiemPhongTheoMaPhong
d.TimKiemPhongTheoGiaPhong...etc
e.SapXepPhongTangDanTheoMaPhong(Giảm dần)
f.SapXepPhongTangDanTheoGiaPhong(Giảm dần)...etc

IV.Danh sách khách hàng
1.Thuộc tính
Khách Hàng
2.Phương thức
a.InDanhSachKhachHang
b.TimKiemKhachHangTheoMaKhach
c.TimKiemKhachHangTheoTen...etc
d.SapXepKhachHangTangDanTheoMaKhach(Giảm dần)
e.SapXepKhachHangTangDanTheoTenKhach(Giảm dần)...etc

V.Đặt Phòng
1.Thuộc tính
a.MaDatPhong
b.MaKhach
c.MaPhong
d.NgayDatPhongNgayTra
e.SoTienCanThanhToan
f.Trạng thái (Đã duyệt hay chưa duyệt)
2. Phương Thức
a.Constructor
b.Setter, getter
c.ThemPhieuDatPhong
d.SuaPhieuDatPhong
e.XoaPhieuDatPhong

VI.Danh sách phiếu đặt phòng
1.Thuộc tính
Phiếu Đặt Phòng
2.Phương thức
a.Constructor
b.Setter, Getter
c.InDanhSachPhieuDatPhong(Còn hạn, hết hạn, theo ngày, từ ngày đến 	ngày)
d.TimKiemPhieuDatPhongTheoMaDatPhong
e.TimKiemPhieuDatPhongTheoTenKhachHang
f.TimKiemPhieuDatPhongTheoNgay...etc
g.SapXepPhieuDatPhongTangDan or GiamDan (theo ngày đặt phòng, 	ngày đến hạn, mã đặt phòng, mã khách hàng, tên khách hàng)

Phần 2: Phân quyền Admin, User

1.Admin
a.Login, Sign up
b.(Viết 1 số hàm bắt điều kiện Tên đăng nhập, Mật khẩu luôn nha)
c.Thêm, sửa, xóa, in danh sách, tìm kiếm, sắp xếp khách hàng...
d.Thêm, sửa, xóa, in danh sách, tìm kiếm, sắp xếp phòng...
e.Thêm, sửa, xóa, in danh sách, tìm kiếm, sắp xếp phiếu đặt phòng...
f.Duyệt đơn Đặt phòng của khách hàng (Khi khách hàng thực hiện đặt phòng sẽ tạo ra Phiếu đặt phòng (Trạng thái chưa duyệt: false) chức năng này đơn giản là thay đổi trạng thái của thuộc tính Trạng thái sang True (Đã duyệt) và thực hiện trừ đi số tiền trong tài khoản của Khách hàng)
g....10 tỉ chức năng khác

2.User
a.Login, Sign up
b.Kiểm tra thông tin cá nhân
c.Hiển thị phòng còn trống
d.Đặt phòng
e.Nạp tiền
f.Đặt 1 vài dịch vụ gì đó...(Mấy ông não to hoặc hay đi khách sạn có thể thêm vào)

Note: Nếu có ý tưởng nào hay hoặc có gì ko đúng ý mấy huynh thì các huynh đài cứ sửa vào file (Nhớ note lại phía dưới này luôn nha...)

Note 0: Đại ca Tín hãy cứu lấy bọn em...




