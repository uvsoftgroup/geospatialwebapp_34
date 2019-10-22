package uvsoftgroup.geospatialwebapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uvsoftgroup.geospatialwebapp.model.GeometryGisDataInfo;
import uvsoftgroup.geospatialwebapp.model.GeometryGisInfo;
import uvsoftgroup.geospatialwebapp.service.GeometryGisDataInfoService;

@Controller
@RequestMapping("/geometryGisDataInfo")
public class GeometryGisDataController {
@Autowired
private GeometryGisDataInfoService geometryGisInfoService;

@RequestMapping("/mapviewosm2")
public String mapViewOSM2() {
	 return "redirect:/mapviewosm2";
}

@RequestMapping("/mapviewleaflet2")
public String mapViewLeaflet2() {
	 return "redirect:/mapviewleaflet2";
}

@RequestMapping("/geoserveraddressportal")
public String geoServerApplicationPortal() {
	return "geoserveraddressportal";
}

@RequestMapping("/showGeometryGisDataInfos")
public ModelAndView findAllGeometryGisDataInfo() {
	List<GeometryGisDataInfo> geometryGisInfos =geometryGisInfoService.findAllGeometryGisDataInfo();
    Map<String, Object> params = new HashMap<>();
    params.put("geometryGisDataInfos", geometryGisInfos);
    return new ModelAndView("/showGeometryGisDataInfos",params);
	
}

@RequestMapping("/geometryGisDataInfoList")
public ModelAndView geometryGisDataInfoList() {
	List<GeometryGisDataInfo> geometryGisInfos =geometryGisInfoService.findAllGeometryGisDataInfo();
    Map<String, Object> params = new HashMap<>();
    params.put("geometryGisDataInfos", geometryGisInfos);
    params.put("counter", geometryGisInfos.size());
    return new ModelAndView("/geometryGisDataInfoList",params);
	
}

@RequestMapping(path = "/add", method = RequestMethod.POST)
public String saveGeometryGisDataInfo(@ModelAttribute("geometryGisDataInfo") GeometryGisDataInfo geometryGisInfo) throws Exception {
	geometryGisInfoService.saveGeometryGisDataInfo(geometryGisInfo);
    return "redirect:/geometryGisDataInfo/geometryGisDataInfoList";
    
}

@RequestMapping(path = "/updateGeometryGisDataInfo/{id}", method = RequestMethod.GET)
public ModelAndView editAddressInfo(@PathVariable(value = "id") long id,@ModelAttribute("geometryGisDataInfo") GeometryGisInfo geometryGisInfo) throws Exception {
	ModelAndView model = new ModelAndView();
	GeometryGisDataInfo geometryGisInfoExisting= geometryGisInfoService.findGeometryGisDataInfo(id);
	if(geometryGisInfoExisting.getGgdId()!=0){
		/*
		geometryGisInfo.setAdId(geometryGisInfoExisting.getAdId());
		geometryGisInfo.getGeometryGisData().setAdRefId(geometryGisInfoExisting.getGeometryGisData().getAdRefId());
		geometryGisInfo.getGeometryGisData().setAdType(geometryGisInfoExisting.getGeometryGisData().getAdType());
		geometryGisInfo.getGeometryGisData().setAdCity(geometryGisInfoExisting.getGeometryGisData().getAdCity());
		geometryGisInfo.getGeometryGisData().setAdRoad(geometryGisInfoExisting.getGeometryGisData().getAdRoad());
		geometryGisInfo.getGeometryGisData().setAdRoadType(geometryGisInfoExisting.getGeometryGisData().getAdRoadType());
		geometryGisInfo.getGeometryGisData().setAdHouseNumber(geometryGisInfoExisting.getGeometryGisData().getAdHouseNumber());
		geometryGisInfo.getGeometryGisData().setAdPostCode(geometryGisInfoExisting.getGeometryGisData().getAdPostCode());
		geometryGisInfo.getGeometryGisData().setAdCountry(geometryGisInfoExisting.getGeometryGisData().getAdCountry());
    	*/
    	 model.addObject("editGeometryGisDataInfo", geometryGisInfo);
    	 model.setViewName("editGeometryGisDataInfo");	
	}
	else{
		model.addObject("editGeometryGisDataInfo", geometryGisInfo);
   	    model.setViewName("editGeometryGisDataInfo");	
	}
	 return model;
}


@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
public String deleteGeometryGisDataInfo(@PathVariable(name = "id") long id) {
	geometryGisInfoService.deleteGeometryGisDataInfo(id);
    return "redirect:/geometryGisDataInfo/geometryGisDataInfoList";
}



}
