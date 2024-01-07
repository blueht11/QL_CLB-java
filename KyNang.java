import java.util.EnumSet;
import java.util.Scanner;

public class KyNang {
    public enum KYNANG {
        guitar, piano, trong, nghe, noi, doc, viet, boibuom, boisai, giaocau, dapcau, dichuyenchan
    }

    KYNANG kynang;
    int trinhdo;

    public KyNang() { }

    public KyNang(KYNANG kynang, int trinhdo) {
        this.trinhdo = trinhdo;
        this.kynang = kynang;
    }

    public KYNANG getKyNang() { return kynang; }
    public void setKyNang(KYNANG kynang) { this.kynang = kynang; }
    public int gettrinhdo() { return trinhdo; }
    public void settrinhdo(int trinhdo) { this.trinhdo = trinhdo; }

    public static KyNang inputKyNang() {
        Scanner scanner = new Scanner(System.in);
        KyNang kynangg = new KyNang();
        EnumSet<KYNANG> danhSachChon = EnumSet.allOf(KYNANG.class);
        hienThiMenu(danhSachChon);
        System.out.print("Nhap lua chon cua ban: ");
        int luaChon = scanner.nextInt();
        scanner.nextLine();
        
        switch (luaChon) {
            case 1:
                kynangg.trinhdo = nhapTrinhDo();
                // System.out.println("111");
                kynangg.kynang = KYNANG.guitar;
                // System.out.println("222");
                
                break;
            case 2:
                kynangg.trinhdo = nhapTrinhDo();
                kynangg.kynang = KYNANG.piano;
                break;
            case 3:
                kynangg.trinhdo = nhapTrinhDo();
                kynangg.kynang = KYNANG.trong;
                break;
            case 4:
                kynangg.trinhdo = nhapTrinhDo();
                kynangg.kynang = KYNANG.nghe;
                break;
            case 5:
                kynangg.trinhdo = nhapTrinhDo();
                kynangg.kynang = KYNANG.noi;
                break;
            case 6:
                kynangg.trinhdo = nhapTrinhDo();
                kynangg.kynang = KYNANG.doc;
                break;
            case 7:
                kynangg.trinhdo = nhapTrinhDo();
                kynangg.kynang = KYNANG.viet;
                break;
            case 8:
                kynangg.trinhdo = nhapTrinhDo();
                kynangg.kynang = KYNANG.boibuom;
                break;
            case 9:
                kynangg.trinhdo = nhapTrinhDo();
                kynangg.kynang = KYNANG.boisai;
                break;
            case 10:
                kynangg.trinhdo = nhapTrinhDo();
                kynangg.kynang = KYNANG.giaocau; 
                break;
            case 11:
                kynangg.trinhdo = nhapTrinhDo();
                kynangg.kynang = KYNANG.dapcau;
                break;
            case 12:
                kynangg.trinhdo = nhapTrinhDo();
                kynangg.kynang = KYNANG.dichuyenchan;
                break;
            default:
                System.out.println("Lua chon khong hop le. Vui long chon lai.");
        }
        // scanner.close();
        return kynangg;
    }

    private static void hienThiMenu(EnumSet<KYNANG> danhSachChon) {
        // System.out.println("===== Menu =====");
        int i = 1;
        for (KYNANG kyNang : danhSachChon) {
            System.out.print((i++) + "." + kyNang + " | ");
        }
        System.out.println("\n================");
    }

    private static int nhapTrinhDo(){
        int kq = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap trinh do: ");
        kq = scanner.nextInt();
        // scanner.nextLine();
        while (0 > kq || kq > 10) {
            System.out.print("Trinh do tu 0-10, vui long nhap lai: ");
            kq = scanner.nextInt();
            
        }
        scanner.nextLine();
        // scanner.close();
        return kq;
    }
}
