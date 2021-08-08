package exam;

public class Product {
	private int maHang;
	private String tenSanPham;
	private float gia;
	private float chietKhau;
	public Product() {
		
	}
	public Product(int maHang,String tenSanPham,float gia, float chietKhau) {
		this.maHang = maHang;
		this.tenSanPham = tenSanPham;
		this.gia = gia;
		this.chietKhau = chietKhau;
	}
	public int getMaHang() {
		return maHang;
	}
	public void setMaHang(int maHang) {
		this.maHang = maHang;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}	
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public float getChietKhau() {
		return chietKhau;
	}
	public void setChietKhau(float chietKhau) {
		this.chietKhau = chietKhau;
	}
	public float chietKhau() {
		return chietKhau/100;
	}
	public String print() {
		return "{" +
				"mã = "+maHang +
				",tên sản phẩm = '"+tenSanPham+"'"+
				",giá = "+gia +
				",chiết khấu = "+chietKhau +
				"}";
					
	}
	public float getRealPrice() {
		return gia*chietKhau();
	}

}

