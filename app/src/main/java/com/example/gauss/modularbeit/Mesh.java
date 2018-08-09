package com.example.gauss.modularbeit;

import java.util.Date;

public class Mesh {
    private String meshId;
    private Date productionStart;
    private Date productionEnd;

    public Mesh(String meshId, Date productionStart, Date productionEnd) {
        this.meshId = meshId;
        this.productionStart = productionStart;
        this.productionEnd = productionEnd;
    }

    public String getMeshId() {
        return meshId;
    }

    public Date getProductionStart() {
        return productionStart;
    }

    public Date getProductionEnd() {
        return productionEnd;
    }

    public void setMeshId(String meshId) {
        this.meshId = meshId;
    }

    public void setProductionStart(Date productionStart) {
        this.productionStart = productionStart;
    }

    public void setProductionEnd(Date productionEnd) {
        this.productionEnd = productionEnd;
    }


}
