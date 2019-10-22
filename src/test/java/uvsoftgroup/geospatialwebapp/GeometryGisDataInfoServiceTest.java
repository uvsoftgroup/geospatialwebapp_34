package uvsoftgroup.geospatialwebapp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import uvsoftgroup.geospatialwebapp.model.GeometryGisDataInfo;
import uvsoftgroup.geospatialwebapp.service.GeometryGisDataInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeometryGisDataInfoServiceTest {
	@Autowired
	private GeometryGisDataInfoService geometryGisInfoService;

	@Test
	@Ignore
	public void saveGeometryGisInfoTestCase() throws Exception {

		String co1 = "POLYGON((90.371287 23.825549,90.371260 23.825672,90.371376 23.825692,90.371402 23.825567,90.371287 23.825549))";
		String c02 = "POLYGON((90.371458 23.825569,90.371432 23.825701,90.371522 23.825716,90.371548 23.825584,90.371458 23.825569))";
		String c03 = "POLYGON((90.371559 23.825594,90.371535 23.825720,90.371584 23.825729,90.371611 23.825602,90.371559 23.825594))";
		String c04 = "POLYGON((90.371614 23.825612,90.371594 23.825729,90.371647 23.825735,90.371666 23.825618,90.371614 23.825612))";
		String c05 = "POLYGON((90.371101 23.825305,90.371079 23.825436,90.371231 23.825460,90.371255 23.825327,90.371101 23.825305))";
		String c06 = "POLYGON((90.371343 23.825347,90.371323 23.825467,90.371390 23.825478,90.371411 23.825357,90.371343 23.825347))";
		String c07 = "POLYGON((90.371441 23.825363,90.371420 23.825487,90.371501 23.825498,90.371522 23.825374,90.371441 23.825363))";
		String c08 = "POLYGON((90.371618 23.825389,90.371589 23.825519,90.371661 23.825533,90.371692 23.825401,90.371618 23.825389))";

		List<String> coordinates = new ArrayList<>();
		coordinates.add(co1);
		coordinates.add(c02);
		coordinates.add(c03);
		coordinates.add(c04);
		coordinates.add(c05);
		coordinates.add(c06);
		coordinates.add(c07);
		coordinates.add(c08);
		int i = 0;
		for (String coordinate : coordinates) {
			GeometryGisDataInfo geometryGisData = new GeometryGisDataInfo();

			geometryGisData.setAdCity("Test_" + i);
			geometryGisData.setAdCountry("Germany");
			geometryGisData.setAdHouseNumber("Test 01_" + i);
			geometryGisData.setAdPostCode("Test 01_" + i);
			geometryGisData.setAdRefId(403L + i);
			geometryGisData.setReferenceNr(140L + i);
			geometryGisData.setAdRoad("Test 001_" + i);
			geometryGisData.setAdRoadType("Primary");
			geometryGisData.setAdType("Plot Address_" + i);
			geometryGisData.setWktToGeometry(coordinate);
			
			geometryGisInfoService.saveGeometryGisDataInfo(geometryGisData);
			i++;
		}

	}

}
