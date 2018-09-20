package com.example.gauss.modularbeit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * The Mesh is a mesh produced on the machine. The attributes describe the production time and the type of mesh produced
 */
public class Mesh {
    private String meshId;
    private Date productionStart;
    private Long productionTimeInS;

    public Mesh(String meshId, Date productionStart, Long productionTimeInS) {
        this.meshId = meshId;
        this.productionStart = productionStart;
        this.productionTimeInS = productionTimeInS;
    }

    public String getMeshId() {
        return meshId;
    }

    public Date getProductionStart() {
        return productionStart;
    }

    public Long getProductionTimeInS() {
        return productionTimeInS;
    }

    public void setMeshId(String meshId) {
        this.meshId = meshId;
    }

    public void setProductionStart(Date productionStart) {
        this.productionStart = productionStart;
    }

    public void setProductionTimeInS(Long productionTimeInS) {
        this.productionTimeInS = productionTimeInS;
    }

    /**
     * Converts the productionStart Date to String
     * @return
     */
    public String getProductionStartasString(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(productionStart);
    }

    @Override
    public String toString() {
        return "GitterId: " + getMeshId() +
                " Startzeit: " + getProductionStartasString() +
                " Produktionsdauer [s]: " + getProductionTimeInS().toString();
    }
}
