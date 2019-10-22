package uvsoftgroup.geospatialwebapp.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Geometry;

import uvsoftgroup.geospatialwebapp.model.GeometryGisData;
import uvsoftgroup.geospatialwebapp.model.GeometryGisInfo;
import uvsoftgroup.geospatialwebapp.model.PlotInfo;
import uvsoftgroup.geospatialwebapp.repository.PlotInfoRepository;
import uvsoftgroup.geospatialwebapp.service.PlotInfoService;
import uvsoftgroup.geospatialwebapp.utility.WktToGeometry;

@Service
public class PlotInfoServiceImpl implements PlotInfoService {

	@Autowired
	private PlotInfoRepository plotInfoRepository;

	@Override
	public void savePlotInfo(PlotInfo plotInfo) {
        
		List<GeometryGisInfo> geometryGisInfos = plotInfo.getGeometryGisInfos();
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
					plotInfo.setGeometryGisInfos(addGeometryGisInfos);
				}
			}
		}

		else {
			plotInfo.setGeometryGisInfos(geometryGisInfos);
		}
		
		plotInfoRepository.saveAndFlush(plotInfo);

	}

	@Override
	public List<PlotInfo> findAllPlotInfo() {
		return plotInfoRepository.findAll();
	}

	@Override
	public PlotInfo findPlotInfo(Long urId) {
		return plotInfoRepository.findOne(urId);
	}

	@Override
	public void deletePlotInfo(Long urId) {
		plotInfoRepository.delete(urId);
	}

	@Override
	public void updatePlotInfo(Long urId, PlotInfo plotInfo) {
		// TODO Auto-generated method stub

	}

}
