public class CauLong extends CLB {
    public CauLong(String tenCLB){
        super(tenCLB);
        this.kynangCAN.add(KyNang.KYNANG.giaocau);
        this.kynangCAN.add(KyNang.KYNANG.dapcau);
        this.kynangCAN.add(KyNang.KYNANG.dichuyenchan);
        this.loaiCLB = getClass().getSimpleName();
    }
}
