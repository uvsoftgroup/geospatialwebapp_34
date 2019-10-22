package uvsoftgroup.geospatialwebapp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import uvsoftgroup.geospatialwebapp.model.GeometryGisData;
import uvsoftgroup.geospatialwebapp.model.GeometryGisInfo;
import uvsoftgroup.geospatialwebapp.model.PlotInfo;
import uvsoftgroup.geospatialwebapp.service.PlotInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlotInfoServiceTest {

	@Autowired
	private PlotInfoService plotInfoService;

	@Test
	@Ignore
	public void savePlotInfoTestCase() {
		String pointCoordinate = "POINT(90.4056285 23.7936486)";
		String lineStringCoordinate = "LINESTRING(91.8260383 22.3350247,91.826177 22.3355788)";
		String multilineStringCoordinate = "MULTILINESTRING((89.0502969 26.1757997,89.0551786 26.1796252))";
		String polygonCoordinate = "POLYGON((90.4048766 23.72359,90.4048648 23.7234267,90.4049919 23.7234214,90.4048766 23.72359))";
		String multiPolygonCoordinate = "MULTIPOLYGON(((90.4048766 23.72359,90.4048648 23.7234267,90.4049919 23.7234214,90.4048766 23.72359)),"
				+ "((90.4048767 23.72360,90.4048648 23.7234267,90.4049919 23.7234214,90.4048767 23.72360)))";
		
		String geometryCollection="GEOMETRYCOLLECTION(POINT(90.4048766 23.72359),POLYGON((90.4048766 23.72359,90.4048648 23.7234267,90.4049919 23.7234214,90.4048766 23.72359)))";
	
		//Geometry geom = WktToGeometry.wktToGeometry(multiPolygonCoordinate);
		
		List<GeometryGisInfo> addGeometryGisInfos = new ArrayList<GeometryGisInfo>();
		
		GeometryGisData gdataPolygon=new GeometryGisData();
		gdataPolygon.setWktToGeometry(polygonCoordinate);
		
		GeometryGisInfo geometryGisInfoPolygon=new GeometryGisInfo();
		geometryGisInfoPolygon.setGeometryGisData(gdataPolygon);
		
		addGeometryGisInfos.add(geometryGisInfoPolygon);
		
		
		PlotInfo plotInfopl = new PlotInfo();
		plotInfopl.setPlName("Final Test");
		plotInfopl.setPlType("Govt");
		plotInfopl.setPlCode("Test");
		plotInfopl.setPlCSNumber("Test");
		plotInfopl.setPlName("Test");
		plotInfopl.setPlMonzaNumber("Test");
		plotInfopl.setPlMSNumber("Test");
		plotInfopl.setPlNumber("Test");
		plotInfopl.setPlRemark("Test");
		plotInfopl.setPlCenterLatitude(90.568988000);
		plotInfopl.setPlCenterLongitude(23.45686);
		plotInfopl.setPlHeightFromMSL(25.689764);
		plotInfopl.setPlNumberOfBuilding(5.5);
		plotInfopl.setPlTotalArea(24.565);
		plotInfopl.setPlTotalBuildingCoverArea(45.678);
		plotInfopl.setPlAddressId(500L);
		plotInfopl.setGeometryGisInfos(addGeometryGisInfos);
		
		savePlotInfoTestCase(plotInfopl);
		
		
		GeometryGisData gdataPoint=new GeometryGisData();
		gdataPoint.setWktToGeometry(pointCoordinate);
		
		GeometryGisData gdataLine=new GeometryGisData();
		gdataLine.setWktToGeometry(lineStringCoordinate);
		
		GeometryGisData gdataMultiLine=new GeometryGisData();
		gdataMultiLine.setWktToGeometry(multilineStringCoordinate);
		
	
		GeometryGisData gdataMultiPolygon=new GeometryGisData();
		gdataMultiPolygon.setWktToGeometry(multiPolygonCoordinate);
	
		
		GeometryGisData gdataGeometryCollection=new GeometryGisData();
		gdataGeometryCollection.setWktToGeometry(geometryCollection);
		
		
		GeometryGisInfo geometryGisInfoPoint=new GeometryGisInfo();
		geometryGisInfoPoint.setGeometryGisData(gdataPoint);
		
		GeometryGisInfo geometryGisInfoLine=new GeometryGisInfo();
		geometryGisInfoLine.setGeometryGisData(gdataLine);
		
		GeometryGisInfo geometryGisInfoMultiLine=new GeometryGisInfo();
		geometryGisInfoMultiLine.setGeometryGisData(gdataMultiLine);
		
		
		
		GeometryGisInfo geometryGisInfoMultiPolygon=new GeometryGisInfo();
		geometryGisInfoMultiPolygon.setGeometryGisData(gdataMultiPolygon);
		
		GeometryGisInfo geometryGisInfoGeometryCollection=new GeometryGisInfo();
		geometryGisInfoGeometryCollection.setGeometryGisData(gdataGeometryCollection);
		

		//addGeometryGisInfos.add(geometryGisInfoPoint);
		//addGeometryGisInfos.add(geometryGisInfoLine);
		//addGeometryGisInfos.add(geometryGisInfoMultiLine);
		
		 //addGeometryGisInfos.add(geometryGisInfoMultiPolygon);
		// addGeometryGisInfos.add(geometryGisInfoGeometryCollection);
		
		
		PlotInfo plotInfo = new PlotInfo();
		plotInfo.setPlName("Test");
	
		PlotInfo plotInfomp = new PlotInfo();
		plotInfomp.setPlName("Test");
		
		PlotInfo plotInfols = new PlotInfo();
		plotInfols.setPlName("Test");
	
		// savePlotInfoTestCase(plotInfo);
		//savePlotInfoTestCase(plotInfomp);
		//savePlotInfoTestCase(plotInfols);
		
	}

	public void savePlotInfoTestCase(PlotInfo plotInfo) {
		plotInfoService.savePlotInfo(plotInfo);
	}

	

}
