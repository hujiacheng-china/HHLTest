package gov.xiangan.publicsanitation.activity.supervise;

/**
 * Created by HuJiaCheng on 2017/6/1.
 */

public class SuperviseQueryBean {
    private String dw;//单位
    private String zy;//专业
    private String lb;//类别

    public String getDw() {
        return dw;
    }

    public SuperviseQueryBean setDw(String dw) {
        this.dw = dw;
        return this;
    }

    public String getZy() {
        return zy;
    }

    public SuperviseQueryBean setZy(String zy) {
        this.zy = zy;
        return this;
    }

    public String getLb() {
        return lb;
    }

    public SuperviseQueryBean setLb(String lb) {
        this.lb = lb;
        return this;
    }

    public SuperviseQueryBean(String dw, String zy, String lb) {
        this.dw = dw;
        this.zy = zy;
        this.lb = lb;
    }

    public SuperviseQueryBean() {
    }

    @Override
    public String toString() {
        return "SuperviseQueryBean{" +
                "dw='" + dw + '\'' +
                ", zy='" + zy + '\'' +
                ", lb='" + lb + '\'' +
                '}';
    }
}
