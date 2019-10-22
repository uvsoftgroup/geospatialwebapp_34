package uvsoftgroup.geospatialwebapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uvsoftgroup.geospatialwebapp.model.BuildingInfo;
import uvsoftgroup.geospatialwebapp.service.BuildingInfoService;

@Controller
@RequestMapping(value="/buildingInfo")
public class BuildingController {
	@Autowired
	private BuildingInfoService buildingInfoService;
	
	@RequestMapping("/mapviewosm")
	public String mapViewOSM() {
		 return "redirect:/mapviewosm";
	}
	
	@RequestMapping("/mapviewleaflet")
	public String mapViewLeaflet() {
		 return "redirect:/mapviewleaflet";
	}
	
	@RequestMapping(value="/showBuildingInfos",method=RequestMethod.GET)
	public ModelAndView findAllBuildingInfo(){
		List<BuildingInfo> buildingInfos=buildingInfoService.findAllBuildingInfo();
        Map<String, Object> params = new HashMap<>();
        params.put("buildingInfos", buildingInfos);
        params.put("counter", buildingInfos.size());
        return new ModelAndView("showBuildingInfos",params);
        
	}
	
	@RequestMapping(value="/buildingInfoList",method=RequestMethod.GET)
	public ModelAndView buildingInfoList(){
		List<BuildingInfo> buildingInfos=buildingInfoService.findAllBuildingInfo();
        Map<String, Object> params = new HashMap<>();
        params.put("buildingInfos", buildingInfos);
        params.put("counter", buildingInfos.size());
        return new ModelAndView("buildingInfoList",params);
        
	}
	
	
	@RequestMapping(value="/{buId}",method=RequestMethod.GET)
	public BuildingInfo findBuildingInfo(@PathVariable("buId") Long buId){
		BuildingInfo buildingInfo=buildingInfoService.findBuildingInfo(buId);
		return buildingInfo;
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
    public String saveCreateBuildingInfo(@ModelAttribute("buildingInfo") BuildingInfo buildingInfo) throws Exception {
		buildingInfoService.saveBuildingInfo(buildingInfo);
        return "redirect:/buildingInfo/buildingInfoList";
    }
	
	@RequestMapping(value="/{buId}",method=RequestMethod.PUT)
	public void updateBuildingInfo(@RequestBody @Valid BuildingInfo buildingInfo,@PathVariable("buId") Long buId){
		buildingInfoService.updateBuildingInfo(buId,  buildingInfo);
		
	}
	
	@RequestMapping(path = "/delete/{buId}", method = RequestMethod.GET)
    public String deleteBuildingInfo(@PathVariable(name = "buId") long buId) {
		buildingInfoService.deleteBuildingInfo(buId);
		return "redirect:/buildingInfo/buildingInfoList";
    }
	
}
