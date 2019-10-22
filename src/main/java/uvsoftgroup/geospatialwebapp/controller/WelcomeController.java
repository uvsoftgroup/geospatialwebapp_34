/**
 * 
 */
package uvsoftgroup.geospatialwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}

	@RequestMapping("/mapviewosm")
	public String mapViewOSM() {
		return "mapviewosm";
	}
	
	@RequestMapping("/mapviewosm2")
	public String mapViewOSM2(Model model) {
		 model.addAttribute("map", "Map Calling");
		return "mapviewosm2";
	}

	@RequestMapping("/mapviewleaflet")
	public String mapViewLeaflet() {
		return "mapviewleaflet";
	}
	
	
	@RequestMapping("/mapviewleaflet2")
	public String mapViewLeaflet2() {
		return "mapviewleaflet2";
	}
	
	
	@RequestMapping("/geoserverapplicationportal")
	public String geoServerApplicationPortal() {
		return "geoserverapplicationportal";
	}
	
	
}