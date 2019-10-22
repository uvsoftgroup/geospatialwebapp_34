package uvsoftgroup.geospatialwebapp.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vividsolutions.jts.geom.Geometry;

import uvsoftgroup.geospatialwebapp.model.GeometryGisData;
import uvsoftgroup.geospatialwebapp.model.GeometryGisInfo;
import uvsoftgroup.geospatialwebapp.repository.GeometryGisInfoRepository;
import uvsoftgroup.geospatialwebapp.service.GeometryGisInfoService;
import uvsoftgroup.geospatialwebapp.utility.WktToGeometry;
@Service
public class GeometryGisInfoServiceImpl implements GeometryGisInfoService {

	@Autowired
	private  GeometryGisInfoRepository  geometryGisInfoRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${restfulapi.url}")
	private String baseUrl;

	public void saveGeometryGisInfo(GeometryGisInfo geometryGisInfo) throws Exception {
		
		GeometryGisData geometryGisData=new GeometryGisData();
		
		if(geometryGisInfo.getGeometryGisData().getWktToGeometry()!=null){
			
			geometryGisData=new GeometryGisData();
			
			Geometry geom = WktToGeometry.wktToGeometry(geometryGisInfo.getGeometryGisData().getWktToGeometry());
			geom.setSRID(4326);
			geometryGisData.setGeom(geom);
			geometryGisData.setGeoType(geom.getGeometryType().toUpperCase());
			
			geometryGisData.setWktToGeometry(geometryGisInfo.getGeometryGisData().getWktToGeometry());
			geometryGisData.setAdCity(geometryGisInfo.getGeometryGisData().getAdCity());
			geometryGisData.setAdCountry(geometryGisInfo.getGeometryGisData().getAdCountry());
			geometryGisData.setAdPostCode(geometryGisInfo.getGeometryGisData().getAdPostCode());
			geometryGisData.setAdHouseNumber(geometryGisInfo.getGeometryGisData().getAdHouseNumber());
			geometryGisData.setAdRefId(geometryGisInfo.getGeometryGisData().getAdRefId());
			geometryGisData.setAdRoad(geometryGisInfo.getGeometryGisData().getAdRoad());
			geometryGisData.setAdRoadType(geometryGisInfo.getGeometryGisData().getAdRoadType());
			geometryGisData.setAdType(geometryGisInfo.getGeometryGisData().getAdType());
			
			geometryGisInfo.setGeometryGisData(geometryGisData);
			
			geometryGisInfoRepository.save(geometryGisInfo);
		}
		else{
			geometryGisInfoRepository.save(new GeometryGisInfo());
		}
	}

	
	
	public List<GeometryGisInfo> findAllGeometryGisInfo2() {
		String url=baseUrl+"geometryGisInfo/all";
		GeometryGisInfo[] osmRoadFeatureOutputTOs = restTemplate.getForObject(url,GeometryGisInfo[].class);
		List<GeometryGisInfo> list = Arrays.asList(osmRoadFeatureOutputTOs);

		if (list.size() > 0 && !list.isEmpty()) {
			return list;
		} else {
			return new ArrayList<GeometryGisInfo>(list);
		}
		
	}

	public List<GeometryGisInfo> findAllGeometryGisInfo() {
		List<GeometryGisInfo> list =geometryGisInfoRepository.findAll();
		
		list.sort(Comparator.comparing(GeometryGisInfo::getGeoId));
	
		if (list.size() > 0 && !list.isEmpty()) {
			return list;
		} else {
			return new ArrayList<GeometryGisInfo>(list);
		}
		
	}
	

	public GeometryGisInfo findGeometryGisInfo(Long geoId) {
		GeometryGisInfo geometryGisInfo=geometryGisInfoRepository.findOne(geoId);
		if(geometryGisInfo!=null){
			return geometryGisInfo;		
		}
		else{
			return new GeometryGisInfo();
		}
	}

	
	public GeometryGisInfo deleteGeometryGisInfo(Long geoId) {
		GeometryGisInfo geometryGisInfo=geometryGisInfoRepository.findOne(geoId);
		
		if(geometryGisInfo!=null && geometryGisInfo.getGeoId()!=0){
			geometryGisInfoRepository.delete(geometryGisInfo.getGeoId());
			return geometryGisInfo;
		}
		else{
			return new GeometryGisInfo();
		}
	}

	@Override
	public void updateGeometryGisInfo(Long geoId, GeometryGisInfo geometryGisInfo) {
		GeometryGisInfo geometryGisInfoExisting=geometryGisInfoRepository.findOne(geoId);
		
		if(geometryGisInfoExisting!=null && geometryGisInfo.getGeoId()!=0){
			geometryGisInfoRepository.save(geometryGisInfoExisting);
			
		}
		
	}	
}
