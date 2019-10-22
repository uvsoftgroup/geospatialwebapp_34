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

import uvsoftgroup.geospatialwebapp.model.PlotInfo;
import uvsoftgroup.geospatialwebapp.service.PlotInfoService;

@Controller
@RequestMapping(value="/plotInfo")
public class PlotController {
	
	@Autowired
	private PlotInfoService plotInfoService;
	
	@RequestMapping("/mapviewosm")
	public String mapViewOSM() {
		 return "redirect:/mapviewosm";
	}
	
	@RequestMapping("/mapviewleaflet")
	public String mapViewLeaflet() {
		 return "redirect:/mapviewleaflet";
	}
	
	@RequestMapping(value="/showPlotInfos",method=RequestMethod.GET)
	public ModelAndView findAllPlotInfo(){
		List<PlotInfo> plotInfos=plotInfoService.findAllPlotInfo();
        Map<String, Object> params = new HashMap<>();
        params.put("plotInfos", plotInfos);
        return new ModelAndView("showPlotInfos",params);
        
	}
	
	@RequestMapping(value="/plotInfoList",method=RequestMethod.GET)
	public ModelAndView plotInfoList(){
		List<PlotInfo> plotInfos=plotInfoService.findAllPlotInfo();
        Map<String, Object> params = new HashMap<>();
        params.put("plotInfos", plotInfos);
        params.put("counter", plotInfos.size());
        return new ModelAndView("plotInfoList",params);
        
	}
	
	@RequestMapping(value="/{plId}",method=RequestMethod.GET)
	public PlotInfo findPlotInfo(@PathVariable("plId") Long plId){
		PlotInfo plotInfo=plotInfoService.findPlotInfo(plId);
		return plotInfo;
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
    public String saveCreateUserRole(@ModelAttribute("plotInfo") PlotInfo plotInfo) throws Exception {
		plotInfoService.savePlotInfo(plotInfo);
        return "redirect:/plotInfo/plotInfoList";
    }
	
	@RequestMapping(value="/{plId}",method=RequestMethod.PUT)
	public void updatePlotInfo(@RequestBody @Valid PlotInfo plotInfo,@PathVariable("plId") Long plId){
		plotInfoService.updatePlotInfo(plId, plotInfo);
		
	}
	
	@RequestMapping(path = "/delete/{geoId}", method = RequestMethod.GET)
    public String deletePlotInfo(@PathVariable(name = "geoId") long geoId) {
		plotInfoService.deletePlotInfo(geoId);
		return "redirect:/plotInfo/plotInfoList";
    }
	

}
