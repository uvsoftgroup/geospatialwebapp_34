package uvsoftgroup.geospatialwebapp.service;

import java.util.List;

import uvsoftgroup.geospatialwebapp.model.GeometryGisDataInfo;

public interface GeometryGisDataInfoService {
	public void saveGeometryGisDataInfo(GeometryGisDataInfo geometryGisDataInfo) throws Exception;
	public List<GeometryGisDataInfo> findAllGeometryGisDataInfo();
	public GeometryGisDataInfo findGeometryGisDataInfo(Long geoId);
	public GeometryGisDataInfo deleteGeometryGisDataInfo(Long geoId);
	public void updateGeometryGisDataInfo(Long geoId, GeometryGisDataInfo geometryGisDataInfo);
	
}
