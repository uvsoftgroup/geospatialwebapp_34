package uvsoftgroup.geospatialwebapp.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class GeometryGisInfo  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="seq_geom", strategy="uvsoftgroup.geospatialwebapp.utility.GeometryGisInfoIdGenerator")
	@GeneratedValue(generator="seq_geom")
	long geoId;
	@Embedded
	GeometryGisData geometryGisData;

	public GeometryGisData getGeometryGisData() {
		return geometryGisData;
	}
	public void setGeometryGisData(GeometryGisData geometryGisData) {
		this.geometryGisData = geometryGisData;
	}
	
	public long getGeoId() {
		return geoId;
	}
	public void setGeoId(long geoId) {
		this.geoId = geoId;
	}
	
	
}
