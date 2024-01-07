public class AmNhac extends CLB{

    public AmNhac() { }

    public AmNhac(String tenCLB){
        super(tenCLB);
        this.kynangCAN.add(KyNang.KYNANG.guitar);
        this.kynangCAN.add(KyNang.KYNANG.piano);
        this.kynangCAN.add(KyNang.KYNANG.trong);
        this.loaiCLB = getClass().getSimpleName();
    }
}
