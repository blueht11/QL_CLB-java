public class BoiLoi extends CLB{
    public BoiLoi(String tenCLB){
        super(tenCLB);
        this.kynangCAN.add(KyNang.KYNANG.boibuom);
        this.kynangCAN.add(KyNang.KYNANG.boisai);
        this.loaiCLB = getClass().getSimpleName();
    }
}
