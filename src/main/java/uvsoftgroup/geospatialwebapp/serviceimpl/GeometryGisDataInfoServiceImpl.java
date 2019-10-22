package uvsoftgroup.geospatialwebapp.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Geometry;

import uvsoftgroup.geospatialwebapp.model.GeometryGisDataInfo;
import uvsoftgroup.geospatialwebapp.repository.GeometryGisDataInfoRepository;
import uvsoftgroup.geospatialwebapp.service.GeometryGisDataInfoService;
import uvsoftgroup.geospatialwebapp.utility.WktToGeometry;

@Service
public class GeometryGisDataInfoServiceImpl implements GeometryGisDataInfoService{
	@Autowired
	private  GeometryGisDataInfoRepository  geometryGisInfoRepository;
	
	public void saveGeometryGisDataInfo(GeometryGisDataInfo geometryGisInfo) throws Exception {
		
		GeometryGisDataInfo geometryGisDateInfo=new GeometryGisDataInfo();
		
		if(geometryGisInfo.getWktToGeometry()!=null){
			
			geometryGisDateInfo=new GeometryGisDataInfo();
			
			Geometry geom = WktToGeometry.wktToGeometry(geometryGisInfo.getWktToGeometry());
			geom.setSRID(4326);
			geometryGisDateInfo.setGeom(geom);
			geometryGisDateInfo.setGeoType(geom.getGeometryType().toUpperCase());
			geometryGisDateInfo.setWktToGeometry(geometryGisInfo.getWktToGeometry());
			geometryGisDateInfo.setAdCity(geometryGisInfo.getAdCity());
			geometryGisDateInfo.setAdCountry(geometryGisInfo.getAdCountry());
			geometryGisDateInfo.setAdPostCode(geometryGisInfo.getAdPostCode());
			geometryGisDateInfo.setAdHouseNumber(geometryGisInfo.getAdHouseNumber());
			geometryGisDateInfo.setAdRefId(geometryGisInfo.getAdRefId());
			geometryGisDateInfo.setAdRoad(geometryGisInfo.getAdRoad());
			geometryGisDateInfo.setAdRoadType(geometryGisInfo.getAdRoadType());
			geometryGisDateInfo.setAdType(geometryGisInfo.getAdType());
			
			geometryGisInfoRepository.save(geometryGisDateInfo);
		}
		else{
			geometryGisInfoRepository.save(new GeometryGisDataInfo());
		}
		
	}

	public List<GeometryGisDataInfo> findAllGeometryGisDataInfo() {
		List<GeometryGisDataInfo> list =(List<GeometryGisDataInfo>) geometryGisInfoRepository.findAll();
	
		if (list.size() > 0 && !list.isEmpty()) {
			return list;
		} else {
			return new ArrayList<GeometryGisDataInfo>(list);
		}
		
	}
	

	public GeometryGisDataInfo findGeometryGisDataInfo(Long geoId) {
		GeometryGisDataInfo geometryGisInfo=geometryGisInfoRepository.findOne(geoId);
		if(geometryGisInfo!=null){
			return geometryGisInfo;		
		}
		else{
			return new GeometryGisDataInfo();
		}
	}

	
	public GeometryGisDataInfo deleteGeometryGisDataInfo(Long geoId) {
		GeometryGisDataInfo geometryGisInfo=geometryGisInfoRepository.findOne(geoId);
		
		if(geometryGisInfo!=null && geometryGisInfo.getGgdId()!=0){
			geometryGisInfoRepository.delete(geometryGisInfo.getGgdId());
			return geometryGisInfo;
		}
		else{
			return new GeometryGisDataInfo();
		}
	}

	@Override
	public void updateGeometryGisDataInfo(Long geoId, GeometryGisDataInfo geometryGisInfo) {
		GeometryGisDataInfo geometryGisInfoExisting=geometryGisInfoRepository.findOne(geoId);
		
		if(geometryGisInfoExisting!=null && geometryGisInfo.getGgdId()!=0){
			geometryGisInfoRepository.save(geometryGisInfoExisting);
			
		}
		
	}
	
	
}
