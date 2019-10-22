package uvsoftgroup.geospatialwebapp.model;

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
public class BuildingInfo {
	@Id
	@GenericGenerator(name="seq_building", strategy="uvsoftgroup.geospatialwebapp.utility.BuildingInfoIdGenerator")
	@GeneratedValue(generator="seq_building")
	Long buId;
	Long buAddressId,buPlId,userRefNrId;
	String buCode,buName,buUseType,buRemark;
	Double buNumberOfFloor,buTotalHeight,buNumberOfFloorUnit,buTotalGroundArea,buTotalFloorArea;
	Double buSetBackFront,buSetBackBack,buSetBackRight,buSetBackLeft,buCenterLongitude,buCenterLatitude;
	byte [] buLayoutPicture;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="bu_id_id")
	List<GeometryGisInfo> geometryGisInfos=new ArrayList<GeometryGisInfo>();
	
	public BuildingInfo() {
		super();
		
	}
	
	
	public Long getUserRefNrId() {
		return userRefNrId;
	}


	public void setUserRefNrId(Long userRefNrId) {
		this.userRefNrId = userRefNrId;
	}


	public List<GeometryGisInfo> getGeometryGisInfos() {
		return geometryGisInfos;
	}


	public void setGeometryGisInfos(List<GeometryGisInfo> geometryGisInfos) {
		this.geometryGisInfos = geometryGisInfos;
	}


	public Long getBuId() {
		return buId;
	}
	public void setBuId(Long buId) {
		this.buId = buId;
	}
	public Long getBuAddressId() {
		return buAddressId;
	}
	public void setBuAddressId(Long buAddressId) {
		this.buAddressId = buAddressId;
	}
	public Long getBuPlId() {
		return buPlId;
	}
	public void setBuPlId(Long buPlId) {
		this.buPlId = buPlId;
	}
	public String getBuCode() {
		return buCode;
	}
	public void setBuCode(String buCode) {
		this.buCode = buCode;
	}
	public String getBuName() {
		return buName;
	}
	public void setBuName(String buName) {
		this.buName = buName;
	}
	public String getBuUseType() {
		return buUseType;
	}
	public void setBuUseType(String buUseType) {
		this.buUseType = buUseType;
	}
	public String getBuRemark() {
		return buRemark;
	}
	public void setBuRemark(String buRemark) {
		this.buRemark = buRemark;
	}
	public Double getBuNumberOfFloor() {
		return buNumberOfFloor;
	}
	public void setBuNumberOfFloor(Double buNumberOfFloor) {
		this.buNumberOfFloor = buNumberOfFloor;
	}
	public Double getBuTotalHeight() {
		return buTotalHeight;
	}
	public void setBuTotalHeight(Double buTotalHeight) {
		this.buTotalHeight = buTotalHeight;
	}
	public Double getBuNumberOfFloorUnit() {
		return buNumberOfFloorUnit;
	}
	public void setBuNumberOfFloorUnit(Double buNumberOfFloorUnit) {
		this.buNumberOfFloorUnit = buNumberOfFloorUnit;
	}
	public Double getBuTotalGroundArea() {
		return buTotalGroundArea;
	}
	public void setBuTotalGroundArea(Double buTotalGroundArea) {
		this.buTotalGroundArea = buTotalGroundArea;
	}
	public Double getBuTotalFloorArea() {
		return buTotalFloorArea;
	}
	public void setBuTotalFloorArea(Double buTotalFloorArea) {
		this.buTotalFloorArea = buTotalFloorArea;
	}
	public Double getBuSetBackFront() {
		return buSetBackFront;
	}
	public void setBuSetBackFront(Double buSetBackFront) {
		this.buSetBackFront = buSetBackFront;
	}
	public Double getBuSetBackBack() {
		return buSetBackBack;
	}
	public void setBuSetBackBack(Double buSetBackBack) {
		this.buSetBackBack = buSetBackBack;
	}
	public Double getBuSetBackRight() {
		return buSetBackRight;
	}
	public void setBuSetBackRight(Double buSetBackRight) {
		this.buSetBackRight = buSetBackRight;
	}
	public Double getBuSetBackLeft() {
		return buSetBackLeft;
	}
	public void setBuSetBackLeft(Double buSetBackLeft) {
		this.buSetBackLeft = buSetBackLeft;
	}
	public Double getBuCenterLongitude() {
		return buCenterLongitude;
	}
	public void setBuCenterLongitude(Double buCenterLongitude) {
		this.buCenterLongitude = buCenterLongitude;
	}
	public Double getBuCenterLatitude() {
		return buCenterLatitude;
	}
	public void setBuCenterLatitude(Double buCenterLatitude) {
		this.buCenterLatitude = buCenterLatitude;
	}
	public byte[] getBuLayoutPicture() {
		return buLayoutPicture;
	}
	public void setBuLayoutPicture(byte[] buLayoutPicture) {
		this.buLayoutPicture = buLayoutPicture;
	}


	@Override
	public String toString() {
		return "BuildingInfo [buId=" + buId + ", buAddressId=" + buAddressId + ", buPlId=" + buPlId + ", userRefNrId="
				+ userRefNrId + ", buCode=" + buCode + ", buName=" + buName + ", buUseType=" + buUseType + ", buRemark="
				+ buRemark + ", buNumberOfFloor=" + buNumberOfFloor + ", buTotalHeight=" + buTotalHeight
				+ ", buNumberOfFloorUnit=" + buNumberOfFloorUnit + ", buTotalGroundArea=" + buTotalGroundArea
				+ ", buTotalFloorArea=" + buTotalFloorArea + ", buSetBackFront=" + buSetBackFront + ", buSetBackBack="
				+ buSetBackBack + ", buSetBackRight=" + buSetBackRight + ", buSetBackLeft=" + buSetBackLeft
				+ ", buCenterLongitude=" + buCenterLongitude + ", buCenterLatitude=" + buCenterLatitude
				+ ", buLayoutPicture=" + Arrays.toString(buLayoutPicture) + ", geometryGisInfos=" + geometryGisInfos
				+ "]";
	}
	
	
}
