import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CLB {
    protected int maCLB;
    public static int nextID = 1;
    protected String tenCLB;
    protected String loaiCLB;
    protected ArrayList<SinhVien> dsSinhVien;
    protected ArrayList<KyNang.KYNANG> kynangCAN;

    public CLB() { }

    public CLB(String tenCLB) {
        this.maCLB = nextID++;
        this.tenCLB = tenCLB;
        this.loaiCLB = new String();
        this.dsSinhVien = new ArrayList<>();
        this.kynangCAN = new ArrayList<>();
    }

    public String getloaiCLB() { return this.loaiCLB; }
    public void setloaiCLB(String loaiCLB) { this.loaiCLB = loaiCLB; }

    public static ArrayList<CLB> inputCLB() { 
        ArrayList<CLB> dsclb = new ArrayList<CLB>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong CLB muon tao: ");
        int soluongCLB = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= soluongCLB; i++) {
            CLB clb = new CLB();
            System.out.println("Nhap thong tin CLB thu "+i+" :");
            System.out.print("Nhap ten CLB: ");
            clb.tenCLB = scanner.nextLine();
            boolean check = false;
            System.out.print("Chon loai CLB [1-Am Nhac | 2-Tieng Anh | 3-Boi Loi | 4-Cau Long: ");
            while(!check) {
                int luaChon = scanner.nextInt();
                switch (luaChon) {
                    case 1:
                        clb.setloaiCLB("AmNhac");
                        AmNhac a = new AmNhac(clb.tenCLB);
                        dsclb.add(a);
                        check = true;
                        break;
                    case 2:
                        clb.setloaiCLB("TiengAnh");
                        TiengAnh b = new TiengAnh(clb.tenCLB);
                        dsclb.add(b);
                        check = true;
                        break;
                    case 3:
                        clb.setloaiCLB("BoiLoi");
                        BoiLoi c = new BoiLoi(clb.tenCLB);
                        dsclb.add(c);
                        check = true;
                        break;
                    case 4:
                        clb.setloaiCLB("CauLong");
                        CauLong d = new CauLong(clb.tenCLB);
                        dsclb.add(d);
                        check = true;
                        break;
                    default:
                        System.out.print("Chon tu 1-4!: ");
                }
            }
            // dsclb.add(clb);
            scanner.nextLine();
        }
        return dsclb;
    }

    public static void outputCLB(ArrayList<CLB> b){
        for (CLB c : b) {
            System.out.println("---Thong tin CLB---");
            System.out.println("ID: " + c.maCLB);
            System.out.println("Ten: " + c.tenCLB);
            
            if(c.kynangCAN != null) {
                System.out.println("Ky nang can co: "+c.kynangCAN.size());
                for (KyNang.KYNANG kn : c.kynangCAN) {
                    System.out.print(" - " + kn);
                }
            } else {
                System.out.println("Chua cap nhat ky nang can co!");
            }
            if(c.dsSinhVien != null) {
                System.out.println("\nDanh sach sinh vien: "+ c.dsSinhVien.size()+ " sinh vien");
                for (SinhVien sv : c.dsSinhVien) {
                    System.out.println(" - " + sv.tenSV);
                }
            } else {
                System.out.println("Khong co sinh vien trong CLB");
            }
            System.out.println("-----------------------");
        }
    }

    public boolean kiemtraTrinhDo(SinhVien sv) {
        boolean result = false;
        ArrayList<KyNang> dsKN = sv.getDanhSachKyNang();
        for(KyNang kn : dsKN) {
            if (this.kynangCAN.contains(kn.getKyNang())){
                if (kn.gettrinhdo() > 5) {
                    System.out.println("Ky nang "+kn.getKyNang()+" cua SV "+sv.tenSV+" du trinh do de tham gia CLB "+tenCLB);
                    result = true;
                } else {
                    System.out.println("Ky nang "+kn.getKyNang()+" cua SV "+sv.tenSV+" KHONG du trinh do de tham gia CLB "+tenCLB);
                }
            }
        }
        if(result == false) System.out.println("SV khong co ky nang nao de tham gia CLB "+tenCLB+" nay!");
        return result;
    }

    public void themSV(SinhVien sv) {
        boolean result = kiemtraTrinhDo(sv);
        if(result) {
            this.dsSinhVien.add(sv);
            sv.setNgayThamGia(LocalDate.now());
            System.out.println("Them SV thanh cong!");
        } 
        else {
            System.out.println("Them SV khong thanh cong!");
        } 
    }
}