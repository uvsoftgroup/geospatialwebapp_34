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

import uvsoftgroup.geospatialwebapp.model.GeometryGisInfo;
import uvsoftgroup.geospatialwebapp.service.GeometryGisInfoService;

@Controller
@RequestMapping("/geometryGisInfo")
public class GeometryGisController {
@Autowired
private GeometryGisInfoService geometryGisInfoService;

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

@RequestMapping("/showGeometryGisInfos")
public ModelAndView findAllAddressInfo() {
	List<GeometryGisInfo> geometryGisInfos =geometryGisInfoService.findAllGeometryGisInfo();
    Map<String, Object> params = new HashMap<>();
    params.put("geometryGisInfos", geometryGisInfos);
    return new ModelAndView("/showGeometryGisInfos",params);
	
}

@RequestMapping("/geometryGisInfoList")
public ModelAndView geometryGisInfoList() {
	List<GeometryGisInfo> geometryGisInfos =geometryGisInfoService.findAllGeometryGisInfo();
    Map<String, Object> params = new HashMap<>();
    params.put("geometryGisInfos", geometryGisInfos);
    params.put("counter", geometryGisInfos.size());
    return new ModelAndView("/geometryGisInfoList",params);
	
}

@RequestMapping(path = "/add", method = RequestMethod.POST)
public String saveCreateAddressInfo(@ModelAttribute("geometryGisInfo") GeometryGisInfo geometryGisInfo) throws Exception {
	geometryGisInfoService.saveGeometryGisInfo(geometryGisInfo);
    return "redirect:/geometryGisInfo/geometryGisInfoList";
    
}

@RequestMapping(path = "/updateGeometryGisInfo/{id}", method = RequestMethod.GET)
public ModelAndView editAddressInfo(@PathVariable(value = "id") long id,@ModelAttribute("geometryGisInfo") GeometryGisInfo geometryGisInfo) throws Exception {
	ModelAndView model = new ModelAndView();
	GeometryGisInfo geometryGisInfoExisting= geometryGisInfoService.findGeometryGisInfo(id);
	if(geometryGisInfoExisting.getGeoId()!=0){
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
    	 model.addObject("editGeometryGisInfo", geometryGisInfo);
    	 model.setViewName("editGeometryGisInfo");	
	}
	else{
		model.addObject("editGeometryGisInfo", geometryGisInfo);
   	    model.setViewName("editGeometryGisInfo");	
	}
	 return model;
}


@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
public String deleteGeometryGisInfo(@PathVariable(name = "id") long id) {
	geometryGisInfoService.deleteGeometryGisInfo(id);
    return "redirect:/geometryGisInfo/geometryGisInfoList";
}



}
