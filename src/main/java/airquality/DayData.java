package airquality;

import com.scmoure.csvreader.annotations.CSVColumn;

public class DayData {

    @CSVColumn(column = 0)
    private Float value;
    
    @CSVColumn(column = 1)
    private String control;

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
