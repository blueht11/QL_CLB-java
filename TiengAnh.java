public class TiengAnh extends CLB{
    public TiengAnh(String tenCLB){
        super(tenCLB);
        this.kynangCAN.add(KyNang.KYNANG.nghe);
        this.kynangCAN.add(KyNang.KYNANG.noi);
        this.kynangCAN.add(KyNang.KYNANG.doc);
        this.kynangCAN.add(KyNang.KYNANG.viet);
        this.loaiCLB = getClass().getSimpleName();
    }
}
