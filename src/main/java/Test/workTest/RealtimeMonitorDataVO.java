package Test.workTest;



/**
 * @description:
 * @author: xuxianwei
 * @time: 2020/11/13 0:37
 */
public class RealtimeMonitorDataVO  {

    private String id;

    private String monitoringFactorName="";

    private String code;

    private String dataTime;

    private String value="";

    private String flag="";

    private String reducedValue;

    private String unit;

    private String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMonitoringFactorName() {
        return monitoringFactorName;
    }

    public void setMonitoringFactorName(String monitoringFactorName) {
        this.monitoringFactorName = monitoringFactorName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getReducedValue() {
        return reducedValue;
    }

    public void setReducedValue(String reducedValue) {
        this.reducedValue = reducedValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
