package uvsoftgroup.geospatialwebapp.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Geometry;

import uvsoftgroup.geospatialwebapp.model.BuildingInfo;
import uvsoftgroup.geospatialwebapp.model.GeometryGisData;
import uvsoftgroup.geospatialwebapp.model.GeometryGisInfo;
import uvsoftgroup.geospatialwebapp.repository.BuildingInfoRepository;
import uvsoftgroup.geospatialwebapp.service.BuildingInfoService;
import uvsoftgroup.geospatialwebapp.utility.WktToGeometry;

@Service 
public class BuildingInfoServiceImpl implements BuildingInfoService {

	@Autowired
	private BuildingInfoRepository buildingInfoRepository;

	@Override
	public void saveBuildingInfo(BuildingInfo buildingInfo) {
        
		List<GeometryGisInfo> geometryGisInfos = buildingInfo.getGeometryGisInfos();
		List<GeometryGisInfo> addGeometryGisInfos = new ArrayList<GeometryGisInfo>();
	    GeometryGisData addGeometryGisData = new GeometryGisData();

		if (geometryGisInfos.size() > 0 && !geometryGisInfos.isEmpty()) {
			for (GeometryGisInfo geometryGisInfo : geometryGisInfos) {
				if (geometryGisInfo.getGeometryGisData().getWktToGeometry() != null) {
					// set GeometryGisData 
					addGeometryGisData = new GeometryGisData();
					Geometry geom = WktToGeometry.wktToGeometry(geometryGisInfo.getGeometryGisData().getWktToGeometry());
					geom.setSRID(4326);
					addGeometryGisData.setGeom(geom);
					addGeometryGisData.setGeoType(geom.getGeometryType().toUpperCase());
					addGeometryGisData.setWktToGeometry(geometryGisInfo.getGeometryGisData().getWktToGeometry());
		            // add GeometryGisData into GeometryGisInfo
					geometryGisInfo.setGeometryGisData(addGeometryGisData);
					// add into the GeometryGisInfo object list from
					// GeometryGisInfo object
					addGeometryGisInfos.add(geometryGisInfo);
					// add into the PlotInfo from GeometryGisInfo object list
					buildingInfo.setGeometryGisInfos(addGeometryGisInfos);
				}
			}
		}

		else {
			buildingInfo.setGeometryGisInfos(geometryGisInfos);
		}
		
		buildingInfoRepository.saveAndFlush(buildingInfo);

	}

	@Override
	public List<BuildingInfo> findAllBuildingInfo() {
		return buildingInfoRepository.findAll();
	}

	@Override
	public BuildingInfo findBuildingInfo(Long buId) {
		return buildingInfoRepository.findOne(buId);
	}

	@Override
	public void deleteBuildingInfo(Long buId) {
		buildingInfoRepository.delete(buId);
	}

	@Override
	public void updateBuildingInfo(Long buId, BuildingInfo buildingInfo) {
		// TODO Auto-generated method stub

	}

}

