import java.util.ArrayList;

public class CTSV {
    public static void main(String[] args) {
        System.out.println("================= CLB =================");
        ArrayList<CLB> clb1 = new ArrayList<>();
        clb1 = CLB.inputCLB();
        CLB.outputCLB(clb1);
        System.out.println("================= SINH VIEN =================");
        ArrayList<SinhVien> sv1 = new ArrayList<>();
        sv1 = SinhVien.inputSV();
        SinhVien.outputSV(sv1);
        System.out.println("================= DANG KY CLB =================");
        for (SinhVien sinhVien : sv1) {
            sinhVien.dangkyCLB(clb1.get(0));
        }
        SinhVien.outputSV(sv1);
        // System.out.println("================= TIM SINH VIEN =================");
        // ArrayList<SinhVien> sv2 = new ArrayList<>();
        // sv2 = SinhVien.timSinhVien();
    }
}
