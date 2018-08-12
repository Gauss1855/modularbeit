package com.example.gauss.modularbeit;

import java.util.Date;

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
}
