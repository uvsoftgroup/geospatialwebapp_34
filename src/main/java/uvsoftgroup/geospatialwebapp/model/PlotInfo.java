package uvsoftgroup.geospatialwebapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class PlotInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="seq_plot", strategy="uvsoftgroup.geospatialwebapp.utility.PlotInfoIdGenerator")
	@GeneratedValue(generator="seq_plot")
	Long plId;
	Long plAddressId,userRefNrId;
	String plCode, plName, plType, plNumber, plMonzaNumber, plCSNumber, plMSNumber, plRemark;
	Double plTotalArea, plTotalBuildingCoverArea, plNumberOfBuilding, plHeightFromMSL, plCenterLongitude,
			plCenterLatitude;
	byte[] plLayoutPicture, utilityLocationMap;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pl_id_id")
	List<GeometryGisInfo> geometryGisInfos=new ArrayList<GeometryGisInfo>();
	
	
	public PlotInfo() {
		super();

	}

	public List<GeometryGisInfo> getGeometryGisInfos() {
		return geometryGisInfos;
	}

	public void setGeometryGisInfos(List<GeometryGisInfo> geometryGisInfos) {
		this.geometryGisInfos = geometryGisInfos;
	}


	public Long getUserRefNrId() {
		return userRefNrId;
	}



	public void setUserRefNrId(Long userRefNrId) {
		this.userRefNrId = userRefNrId;
	}



	public Long getPlId() {
		return plId;
	}

	public void setPlId(Long plId) {
		this.plId = plId;
	}

	public Long getPlAddressId() {
		return plAddressId;
	}

	public void setPlAddressId(Long plAddressId) {
		this.plAddressId = plAddressId;
	}

	public String getPlCode() {
		return plCode;
	}

	public void setPlCode(String plCode) {
		this.plCode = plCode;
	}

	public String getPlName() {
		return plName;
	}

	public void setPlName(String plName) {
		this.plName = plName;
	}

	public String getPlType() {
		return plType;
	}

	public void setPlType(String plType) {
		this.plType = plType;
	}

	public String getPlNumber() {
		return plNumber;
	}

	public void setPlNumber(String plNumber) {
		this.plNumber = plNumber;
	}

	public String getPlMonzaNumber() {
		return plMonzaNumber;
	}

	public void setPlMonzaNumber(String plMonzaNumber) {
		this.plMonzaNumber = plMonzaNumber;
	}

	public String getPlCSNumber() {
		return plCSNumber;
	}

	public void setPlCSNumber(String plCSNumber) {
		this.plCSNumber = plCSNumber;
	}

	public String getPlMSNumber() {
		return plMSNumber;
	}

	public void setPlMSNumber(String plMSNumber) {
		this.plMSNumber = plMSNumber;
	}

	public String getPlRemark() {
		return plRemark;
	}

	public void setPlRemark(String plRemark) {
		this.plRemark = plRemark;
	}

	public Double getPlTotalArea() {
		return plTotalArea;
	}

	public void setPlTotalArea(Double plTotalArea) {
		this.plTotalArea = plTotalArea;
	}

	public Double getPlTotalBuildingCoverArea() {
		return plTotalBuildingCoverArea;
	}

	public void setPlTotalBuildingCoverArea(Double plTotalBuildingCoverArea) {
		this.plTotalBuildingCoverArea = plTotalBuildingCoverArea;
	}

	public Double getPlNumberOfBuilding() {
		return plNumberOfBuilding;
	}

	public void setPlNumberOfBuilding(Double plNumberOfBuilding) {
		this.plNumberOfBuilding = plNumberOfBuilding;
	}

	public Double getPlHeightFromMSL() {
		return plHeightFromMSL;
	}

	public void setPlHeightFromMSL(Double plHeightFromMSL) {
		this.plHeightFromMSL = plHeightFromMSL;
	}

	public Double getPlCenterLongitude() {
		return plCenterLongitude;
	}

	public void setPlCenterLongitude(Double plCenterLongitude) {
		this.plCenterLongitude = plCenterLongitude;
	}

	public Double getPlCenterLatitude() {
		return plCenterLatitude;
	}

	public void setPlCenterLatitude(Double plCenterLatitude) {
		this.plCenterLatitude = plCenterLatitude;
	}

	public byte[] getPlLayoutPicture() {
		return plLayoutPicture;
	}

	public void setPlLayoutPicture(byte[] plLayoutPicture) {
		this.plLayoutPicture = plLayoutPicture;
	}

	public byte[] getUtilityLocationMap() {
		return utilityLocationMap;
	}

	public void setUtilityLocationMap(byte[] utilityLocationMap) {
		this.utilityLocationMap = utilityLocationMap;
	}



	@Override
	public String toString() {
		return "PlotInfo [plId=" + plId + ", plAddressId=" + plAddressId + ", userRefNrId=" + userRefNrId + ", plCode="
				+ plCode + ", plName=" + plName + ", plType=" + plType + ", plNumber=" + plNumber + ", plMonzaNumber="
				+ plMonzaNumber + ", plCSNumber=" + plCSNumber + ", plMSNumber=" + plMSNumber + ", plRemark=" + plRemark
				+ ", plTotalArea=" + plTotalArea + ", plTotalBuildingCoverArea=" + plTotalBuildingCoverArea
				+ ", plNumberOfBuilding=" + plNumberOfBuilding + ", plHeightFromMSL=" + plHeightFromMSL
				+ ", plCenterLongitude=" + plCenterLongitude + ", plCenterLatitude=" + plCenterLatitude
				+ ", plLayoutPicture=" + Arrays.toString(plLayoutPicture) + ", utilityLocationMap="
				+ Arrays.toString(utilityLocationMap) + ", geometryGisInfos=" + geometryGisInfos + "]";
	}

	

}
