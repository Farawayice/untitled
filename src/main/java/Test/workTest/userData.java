package Test.workTest;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @author liulihua
 * @date 2022/10/20 17:21
 */
public class userData {
    private List<String> polIds;

    private String view;

    private String exclude;

    private String name;

    private String typeName;

    private Integer flag;

    private Timestamp startTime;

    private Timestamp endTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        userData userData = (userData) o;
        return Objects.equals(polIds, userData.polIds) && Objects.equals(view, userData.view) && Objects.equals(exclude, userData.exclude) && Objects.equals(name, userData.name) && Objects.equals(typeName, userData.typeName) && Objects.equals(flag, userData.flag) && Objects.equals(startTime, userData.startTime) && Objects.equals(endTime, userData.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(polIds, view, exclude, name, typeName, flag, startTime, endTime);
    }

    public List<String> getPolIds() {
        return polIds;
    }

    public void setPolIds(List<String> polIds) {
        this.polIds = polIds;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getExclude() {
        return exclude;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "userData{" +
                "polIds=" + polIds +
                ", view='" + view + '\'' +
                ", exclude='" + exclude + '\'' +
                ", name='" + name + '\'' +
                ", typeName='" + typeName + '\'' +
                ", flag=" + flag +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public userData() {
    }

    public userData(List<String> polIds, String view, String exclude, String name, String typeName, Integer flag, Timestamp startTime, Timestamp endTime) {
        this.polIds = polIds;
        this.view = view;
        this.exclude = exclude;
        this.name = name;
        this.typeName = typeName;
        this.flag = flag;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
