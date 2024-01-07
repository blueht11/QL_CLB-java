import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SinhVien {
    int maSV;
    int nextID = 1;
    String tenSV;
    LocalDate ngayThamGia;
    ArrayList<KyNang> danhSachKyNang;
    Map<CLB,LocalDate> danhsachCLB = new HashMap<>();
    private static ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();

    public SinhVien() {
        this.maSV = nextID++;
        danhSachSinhVien.add(this);
     }

    public SinhVien(String tenSV, ArrayList<KyNang> danhSachKyNang) {
        this.maSV = nextID++;
        this.tenSV = tenSV;
        this.danhSachKyNang = danhSachKyNang;
        // this.danhsachCLB = danhsachCLB;
        danhSachSinhVien.add(this);
    }

    public int getMaSV() { return maSV; }
    public String getTenSV() { return tenSV; }
    public ArrayList<KyNang> getDanhSachKyNang() { return danhSachKyNang; }
    public Map<CLB,LocalDate> getDanhSachCLB() { return danhsachCLB; }
    public LocalDate getNgaythamgia() { return ngayThamGia;}

    public void setMaSV(int maSV) { this.maSV = maSV; }
    public void setTenSV(String tenSV) { this.tenSV = tenSV; }
    public void setDanhSachKyNang(ArrayList<KyNang> danhSachKyNang) { this.danhSachKyNang = danhSachKyNang; }
    public void setDanhSachCLB(Map<CLB,LocalDate> danhsachCLB) { this.danhsachCLB= danhsachCLB; }
    public void setNgayThamGia(LocalDate ngaythamgia) { this.ngayThamGia = ngaythamgia; }

    public static ArrayList<SinhVien> inputSV() {
        ArrayList<SinhVien> dssv = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        // scanner.nextLine();  
        System.out.print("So luong sinh vien can nhap: ");
        int soluongSV = scanner.nextInt();
        scanner.nextLine();
        for (int a = 1; a<=soluongSV; a++) {
            System.out.println(" - Sinh vien thu " + a);
            SinhVien sv = new SinhVien();
            System.out.print("Nhap ten sinh vien: ");
            sv.tenSV = scanner.nextLine();

            System.out.print("Nhap so luong ky nang: ");
            int numSkills = scanner.nextInt();
            scanner.nextLine();
            ArrayList<KyNang> dsKyNangSV = new ArrayList<>();
            for (int i = 1; i <= numSkills; i++) {
                System.out.println("Nhap thong tin ky nang thu "+ (i) +": ");
                dsKyNangSV.add(KyNang.inputKyNang());
            }
            sv.setDanhSachKyNang(dsKyNangSV);
            dssv.add(sv);
        }
        // scanner.close();
        return dssv;
    }

    public static void outputSV(ArrayList<SinhVien> dssv) {
        if(!dssv.isEmpty()){
            for (SinhVien s : dssv) {
                System.out.println("---Thong tin sinh vien---");
                System.out.println("ID: " + s.maSV);
                System.out.println("Ten: " + s.tenSV);
                System.out.println("Ky nang cua "+ s.tenSV+ " : "+s.danhSachKyNang.size());
                for (KyNang kn : s.danhSachKyNang) {
                    System.out.println(" - "+ kn.kynang + " | trinh do: "+kn.trinhdo);
                }
                if(s.danhsachCLB != null) {
                    System.out.println("CLB da tham gia: "+s.danhsachCLB.size());
                    for (Map.Entry<CLB,LocalDate> c : s.danhsachCLB.entrySet()) {
                        DateTimeFormatter dateF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        String ngayhienthi = c.getValue().format(dateF);
                        System.out.println(" - " + c.getKey().tenCLB + " | Ngay tham gia: " + ngayhienthi);
                    }
                } else {
                    System.out.println("Sinh vien "+ s.tenSV + " chua tham gia CLB nao.");
                }
                System.out.println("-------------------------");
            }
        } else {
            System.out.println("Khong co sinh vien nao!");
        }
        
    }

    public static void outputLimitSV(ArrayList<SinhVien> dssv) {
        if(!dssv.isEmpty()){
            for (SinhVien s : dssv) {
                System.out.print("Ten: " + s.tenSV);
                for (KyNang kn : s.danhSachKyNang) {
                    System.out.print(" ["+ kn.kynang + "|"+kn.trinhdo+"]");
                }
                System.out.print("\n");
            }
        } else {
            System.out.println("Khong co sinh vien nao!");
        }
    }

    public void dangkyCLB(CLB clb) {
        System.out.println("-- SINH VIEN "+this.tenSV);
        boolean result = clb.kiemtraTrinhDo(this);
        Scanner scanner = new Scanner(System.in);
        
        if (result) {
            System.out.print("Sinh vien "+this.tenSV+ " co tham gia vao CLB "+clb.tenCLB+ " hay khong?  [1-Tham gia | !1-Huy]: ");
            int chon = scanner.nextInt();
            
            if (chon == 1) {
                System.out.println("Tham gia thanh cong!");
                this.danhsachCLB.put(clb, LocalDate.now());
            } else {
                System.out.println("Huy thanh cong!");
            }
            scanner.nextLine();
        }
        // scanner.close();
    }

    public static ArrayList<SinhVien> timSinhVien() {
        ArrayList<KyNang.KYNANG> dsKN = new ArrayList<>();
        ArrayList<SinhVien> dsSV = new ArrayList<>();
        System.out.println("Chon ky nang can tim: ");
        System.out.println("---Nhan 0 de thoat---");
        EnumSet<KyNang.KYNANG> danhSachChon = EnumSet.allOf(KyNang.KYNANG.class);
        System.out.println("===== Menu =====");
        hienThiMenu(danhSachChon);
        boolean chon = true;
        
        while (chon) {
            int luaChon = nhapLuaChon();
            if(luaChon <= 12 && luaChon >= 1) {
            KyNang.KYNANG kyNangChon = KyNang.KYNANG.values()[luaChon - 1];
            dsKN.add(kyNangChon);
            System.out.println("Ban da chon: " + dsKN);
            }
            // xuLyLuaChon(danhSachChon, kyNangChon);
            if(luaChon == 0) {
                chon = false;
                System.out.println("Thoat thanh cong!");
            } 
        }
        ArrayList<SinhVien> danhSach = layToanBoSinhVien();
        // System.out.println("Tat ca sinh vien: "+danhSach);
        if (!danhSach.isEmpty()) { 
            for (SinhVien sv : layToanBoSinhVien()) {
                for (KyNang kn : sv.danhSachKyNang) {
                    if(dsKN.contains(kn.kynang)){
                        dsSV.add(sv);
                    }
                }
            }
            System.out.println("Tim thanh cong "+dsSV.size()+" sinh vien thoa yeu cau: ");
        }
        outputLimitSV(dsSV);
        return dsSV;
    }

    private static void hienThiMenu(EnumSet<KyNang.KYNANG> danhSachChon) {
        
        int i = 1;
        for (KyNang.KYNANG kyNang : danhSachChon) {
            System.out.print((i++) + "." + kyNang + " | ");
        }
        System.out.print("\n");
    }

    private static int nhapLuaChon() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap lua chon cua ban: ");
        // scanner.close();
        return scanner.nextInt();
    }

    public static ArrayList<SinhVien> layToanBoSinhVien() {
        return new ArrayList<>(danhSachSinhVien);
    }
}
