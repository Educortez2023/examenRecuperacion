package ec.com.electrica;

import java.io.Serializable;

public class Consumption implements Serializable {
    private String month;
    private double value;
    private String status;

    public Consumption(String month, double value, String status) {
        this.month = month;
        this.value = value;
        this.status = status;
    }

    public String getMonth() {
        return month;
    }

    public double getValue() {
        return value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
