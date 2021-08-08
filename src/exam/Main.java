package exam;

import java.util.*;
public class Main {
	ArrayList<Product>danhsach = new ArrayList<>();
	//nhập dữ liệu sản phẩm
	public void nhapSanPham() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập số lượng sản phẩm là: ");
			int n = input.nextInt();
			for(int i=0;i<n;i++) {
				int maHang;
				String fullName;
				float gia, chietKhau;
				System.out.println("Mã sản phẩm: ");
				maHang = input.nextInt();
				input.nextLine();
				System.out.println("Tên sản phẩm: ");
				fullName = input.nextLine();
				System.out.println("Giá: ");
				gia = input.nextFloat();
				System.out.println("Chiết khấu: ");
				chietKhau = input.nextFloat();
				Product product = new Product(maHang,fullName,gia,chietKhau);
				danhsach.add(product);
			}
	}
	//in dữ liệu sản phẩm
	public void inSanPham() {
		System.out.println("Danh sách sản phẩm là:");
		for(int i=0;i<danhsach.size();i++) {
			System.out.println(danhsach.get(i).print());
		}
	}
	//lấy giá cuối cùng
	public int findById(int id) {
		for(int i=0;i<danhsach.size();i++) {
			if(danhsach.get(i).getMaHang()==id) {
				System.out.println("Sản phẩm cần tìm: "+danhsach.get(i).getTenSanPham());
				System.out.println("Giá cuối cùng (có tính cả chiết khấu) là: "+danhsach.get(i).getRealPrice());
				return i;
			}
		}
		return -1;
	}
	//sắp xếp
	public void sort() {
		Collections.sort(danhsach,new Comparator<>() {

			@Override
			public int compare(Product price1, Product price2) {
				if(price1.getRealPrice()>price2.getRealPrice()) {
					return 1;
				}else {
					if(price1.getRealPrice()==price2.getRealPrice()) {
						return 0;
					}
				}
				return -1;
			}
			
		});
		System.out.println("Thông tin sản phẩm tăng dần là: ");
		for(int i=0;i<danhsach.size();i++) {
			System.out.println("Tên sản phẩm "+ danhsach.get(i).getTenSanPham() + " giá "+ danhsach.get(i).getRealPrice());
		}
	}
	
	//menu
	public void menu() {
		 int choice;
		Scanner sc = new Scanner(System.in);
		for(;;) {
		System.out.println("=====MENU====");
		System.out.println("1. Nhập sản phẩm ");
        System.out.println("2. Danh sách sản phẩm ");
        System.out.println("3. Tìm");
        System.out.println("4. Sắp xếp ");
		do {
        	System.out.println("Please choice");
        	choice = sc.nextInt();
        }while((choice < 1)||(choice > 4));
        	switch(choice){
            	case 1: 
            		nhapSanPham();
            		break;
            	case 2: 
            		inSanPham();
            		break;
            	case 3:
            		System.out.println("Nhập mã sản phẩm: ");
            		int id = sc.nextInt();
            		int find = findById(id);
            		if(find<0) {
            			System.out.println("Không tìm thấy sản phẩm nào!!");
            		}
            		menu();
            	case 4:
            		sort();
            		break;
            	default:
            		System.out.println("Không có chức năng này!!");
            		break;
        	}
        
		}
	}
	public static void main(String[] args) {
		Main pro = new Main();
		pro.menu();
		
	}

}