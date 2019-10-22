/**
 * 
 */
package uvsoftgroup.geospatialwebapp.model;

import java.util.List;

public class GeometryGisInfoDto {

	private List<GeometryGisInfo> geometryGisInfos;
	 
	public GeometryGisInfoDto() {
		super();
	}
	
	public GeometryGisInfoDto(List<GeometryGisInfo> geometryGisInfos) {
		super();
		this.geometryGisInfos=geometryGisInfos;
	}
	
    public void addGeometryGisInfo(GeometryGisInfo geometryGisInfo) {
        this.geometryGisInfos.add(geometryGisInfo);
    }

	

	public List<GeometryGisInfo> getGeometryGisInfos() {
		return geometryGisInfos;
	}

	public void setGeometryGisInfos(List<GeometryGisInfo> geometryGisInfos) {
		this.geometryGisInfos = geometryGisInfos;
	}
    
    
}
