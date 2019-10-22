package uvsoftgroup.geospatialwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/geoMaps")
public class GeoMapController {
	@RequestMapping("/mapviewosm")
	public String mapViewOSM() {
		return "geoMaps/mapviewosm";
	}

	@RequestMapping("/mapviewleaflet")
	public String mapViewLeaflet() {
		return "geoMaps/mapviewleaflet";
	}
	
	
	
}
