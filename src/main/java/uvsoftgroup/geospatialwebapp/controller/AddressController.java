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

import uvsoftgroup.geospatialwebapp.model.AddressInfo;
import uvsoftgroup.geospatialwebapp.service.AddressInfoService;

@Controller
@RequestMapping("/addressInfo")
public class AddressController {
	
	@Autowired
    private AddressInfoService addressInfoService;
    
    @RequestMapping("/showAddressInfos")
    public ModelAndView findAllAddressInfo() {
    	List<AddressInfo> addressInfos =addressInfoService.findAllAddressInfo();
        Map<String, Object> params = new HashMap<>();
        params.put("addressInfos", addressInfos);
        params.put("counter", addressInfos.size());
        return new ModelAndView("/showAddressInfos",params);
    	
    }
   
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String saveCreateAddressInfo(@ModelAttribute("addressInfo") AddressInfo addressInfo) throws Exception {
    	addressInfoService.saveAddressInfo(addressInfo);
        return "redirect:/addressInfo/showAddressInfos";
        
    }

    @RequestMapping(path = "/updateAddressInfo/{id}", method = RequestMethod.GET)
    public ModelAndView editAddressInfo(@PathVariable(value = "id") long id,@ModelAttribute("addressInfo") AddressInfo addressInfo) throws Exception {
    	
    	ModelAndView model = new ModelAndView();
    	AddressInfo addressInfoExisting= addressInfoService.findAddressInfo(id);
    	
    	if(addressInfoExisting.getAdId()!=null){
    		addressInfo.setAdId(addressInfoExisting.getAdId());
    		addressInfo.getGeometryGisData().setAdRefId(addressInfoExisting.getGeometryGisData().getAdRefId());
    		addressInfo.getGeometryGisData().setAdType(addressInfoExisting.getGeometryGisData().getAdType());
    		addressInfo.getGeometryGisData().setAdCity(addressInfoExisting.getGeometryGisData().getAdCity());
    		addressInfo.getGeometryGisData().setAdRoad(addressInfoExisting.getGeometryGisData().getAdRoad());
    		addressInfo.getGeometryGisData().setAdRoadType(addressInfoExisting.getGeometryGisData().getAdRoadType());
    		addressInfo.getGeometryGisData().setAdHouseNumber(addressInfoExisting.getGeometryGisData().getAdHouseNumber());
    		addressInfo.getGeometryGisData().setAdPostCode(addressInfoExisting.getGeometryGisData().getAdPostCode());
    		addressInfo.getGeometryGisData().setAdCountry(addressInfoExisting.getGeometryGisData().getAdCountry());
        	 model.addObject("editAddressInfo", addressInfo);
        	 model.setViewName("editAddressInfo");	
    	}
    	
    	else{
    		model.addObject("editAddressInfo", addressInfo);
       	    model.setViewName("editAddressInfo");	
    	}
    	
    	 return model;
    }
    
   
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deleteAddressInfo(@PathVariable(name = "id") long id) {
    	addressInfoService.deleteAddressInfo(id);
        return "redirect:/addressInfo/showAddressInfos";
    }

}
