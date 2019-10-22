package uvsoftgroup.geospatialwebapp.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="addressinfo")
public class AddressInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="seq_address", strategy="uvsoftgroup.geospatialwebapp.utility.AddressInfoIdGenerator")
	@GeneratedValue(generator="seq_address")
	Long adId;
	private Long userRefNrId;
	@Embedded
	GeometryGisData geometryGisData;
	
	
	public AddressInfo() {
		super();
		
	}

	public Long getUserRefNrId() {
		return userRefNrId;
	}

	public void setUserRefNrId(Long userRefNrId) {
		this.userRefNrId = userRefNrId;
	}
	public GeometryGisData getGeometryGisData() {
		return geometryGisData;
	}
	public void setGeometryGisData(GeometryGisData geometryGisData) {
		this.geometryGisData = geometryGisData;
	}
	public Long getAdId() {
		return adId;
	}

	public void setAdId(Long adId) {
		this.adId = adId;
	}

	@Override
	public String toString() {
		return "AddressInfo [adId=" + adId + ", userRefNrId=" + userRefNrId + ", geometryGisData=" + geometryGisData
				+ "]";
	}
	
}
