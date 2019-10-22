package uvsoftgroup.geospatialwebapp.service;

import java.util.List;

import uvsoftgroup.geospatialwebapp.model.GeometryGisInfo;

public interface GeometryGisInfoService {
	public void saveGeometryGisInfo(GeometryGisInfo geometryGisInfo) throws Exception;
	public List<GeometryGisInfo> findAllGeometryGisInfo();
	public List<GeometryGisInfo> findAllGeometryGisInfo2();
	public GeometryGisInfo findGeometryGisInfo(Long geoId);
	public GeometryGisInfo deleteGeometryGisInfo(Long geoId);
	public void updateGeometryGisInfo(Long geoId, GeometryGisInfo geometryGisInfo);
}
