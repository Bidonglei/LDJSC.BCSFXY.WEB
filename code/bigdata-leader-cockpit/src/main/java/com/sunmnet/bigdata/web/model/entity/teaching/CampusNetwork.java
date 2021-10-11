/**
* TAmpusNetwork.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.teaching;

import io.swagger.annotations.ApiModelProperty;

public class CampusNetwork {
    @ApiModelProperty(value="学年")
    private String schoolYear;

    @ApiModelProperty(value="校园网主干带宽(Mbps)")
    private String networkBandwidth;

    @ApiModelProperty(value="校园网出口带宽(Mbps)")
    private String exportBandwidth;

    @ApiModelProperty(value="在线有线联网终端数(个)")
    private String wirdTerminal;

    @ApiModelProperty(value="在线无线联网终端数(个)")
    private String wirelessTeriminal;

    @ApiModelProperty(value="信息点敷设(个)")
    private String informationPoint;

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getNetworkBandwidth() {
        return networkBandwidth;
    }

    public void setNetworkBandwidth(String networkBandwidth) {
        this.networkBandwidth = networkBandwidth;
    }

    public String getExportBandwidth() {
        return exportBandwidth;
    }

    public void setExportBandwidth(String exportBandwidth) {
        this.exportBandwidth = exportBandwidth;
    }

    public String getWirdTerminal() {
        return wirdTerminal;
    }

    public void setWirdTerminal(String wirdTerminal) {
        this.wirdTerminal = wirdTerminal;
    }

    public String getWirelessTeriminal() {
        return wirelessTeriminal;
    }

    public void setWirelessTeriminal(String wirelessTeriminal) {
        this.wirelessTeriminal = wirelessTeriminal;
    }

    public String getInformationPoint() {
        return informationPoint;
    }

    public void setInformationPoint(String informationPoint) {
        this.informationPoint = informationPoint;
    }
}