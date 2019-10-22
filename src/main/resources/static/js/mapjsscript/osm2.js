var map;
var COORD_SYSTEM_GPS = 'EPSG:4326'; // GPS (long/lat) coordinate system
var COORD_SYSTEM_OSM = 'EPSG:3857'; // SphericalMercatorCoords - Google and
// OSM's coordinate system
// set map view center
var centerCoordinate = [ 90.4048766, 23.72359 ];
// add OSM based Map
map = new ol.Map({
	target : 'map',
	layers : [ new ol.layer.Tile({
		source : new ol.source.OSM()
	}) ],
	view : new ol.View({
		center : ol.proj.fromLonLat(centerCoordinate),
		zoom : 10
	})
});
// add point style
var pointStyle = new ol.style.Style({
	image : new ol.style.Icon({
		anchor : [ 0.5, 0.5 ],
		anchorXUnits : "fraction",
		anchorYUnits : "fraction",
		src : "https://upload.wikimedia.org/wikipedia/commons/e/ec/RedDot.svg"
	})
});

// add point into the map
var coordinate = [ 90.38675308227536, 23.708273785712564 ];

var vectorPoint = new ol.layer.Vector({
	source : new ol.source.Vector({
		features : [ new ol.Feature({
			geometry : new ol.geom.Point(ol.proj.transform(coordinate,
					COORD_SYSTEM_GPS, COORD_SYSTEM_OSM)),
		}) ]
	}),
	style : pointStyle
});

map.addLayer(vectorPoint);
// add line and polygon style
var styles = [ new ol.style.Style({
	stroke : new ol.style.Stroke({
		color : 'red',
		width : 3
	}),
	fill : new ol.style.Fill({
		color : 'rgba(0, 0, 255, 0.1)'
	})
}), new ol.style.Style({
	image : new ol.style.Circle({
		radius : 5,
		fill : new ol.style.Fill({
			color : 'green'
		})
	}),
	geometry : function(feature) {
		// return the coordinates of the first ring of the polygon
		var coordinates = feature.getGeometry().getCoordinates()[0];
		return new ol.geom.MultiPoint(coordinates);
	}
}) ];


//add start Polygon3 into the Map
var coordinates3;
var featurePolygon3;
coordinates3 = [[
                  [90.371287,23.825549],
     			  [90.371260,23.825672],
     			  [90.371376,23.825692],
     			  [90.371402,23.825567],
     			  [90.371287,23.825549]
                  
              ]];

featurePolygon3 = new ol.Feature({
	geometry : new ol.geom.Polygon(coordinates3)

});
featurePolygon3.getGeometry().transform(COORD_SYSTEM_GPS, COORD_SYSTEM_OSM);
var vectorSource3 = new ol.source.Vector({
	features : [ featurePolygon3 ]
});
var vectorLayer3 = new ol.layer.Vector({
	source : vectorSource3,
	style : styles
});
map.addLayer(vectorLayer3);
//add end Polygon2 into the Map

//add start Polygon4 into the Map
var coordinates4;
var featurePolygon4;
coordinates4 = [[
                  [90.371458 ,23.825569],
			      [90.371432 ,23.825701],
			      [90.371522 ,23.825716],
			      [90.371548 ,23.825584],
			      [90.371458 ,23.825569]       
              ]];

featurePolygon4 = new ol.Feature({
	geometry : new ol.geom.Polygon(coordinates4)

});
featurePolygon4.getGeometry().transform(COORD_SYSTEM_GPS, COORD_SYSTEM_OSM);
var vectorSource4 = new ol.source.Vector({
	features : [ featurePolygon4 ]
});
var vectorLayer4 = new ol.layer.Vector({
	source : vectorSource4,
	style : styles
});
map.addLayer(vectorLayer4);
//add end Polygon4 into the Map

//add start Polygon5 into the Map
var coordinates5;
var featurePolygon5;
coordinates5 = [[
                  [90.371559 ,23.825594],
			      [90.371535 ,23.825720],
			      [90.371584 ,23.825729],
			      [90.371611 ,23.825602],
			      [90.371559 ,23.825594]       
              ]];

featurePolygon5 = new ol.Feature({
	geometry : new ol.geom.Polygon(coordinates5)

});
featurePolygon5.getGeometry().transform(COORD_SYSTEM_GPS, COORD_SYSTEM_OSM);
var vectorSource5 = new ol.source.Vector({
	features : [ featurePolygon5 ]
});
var vectorLayer5 = new ol.layer.Vector({
	source : vectorSource5,
	style : styles
});
map.addLayer(vectorLayer5);
//add end Polygon5 into the Map

//add start Polygon6 into the Map
var coordinates6;
var featurePolygon6;
coordinates6 = [[
                  [90.371614 ,23.825612],
			      [90.371594 ,23.825729],
			      [90.371647 ,23.825735],
			      [90.371666 ,23.825618],
			      [90.371614 ,23.825612]       
              ]];

featurePolygon6 = new ol.Feature({
	geometry : new ol.geom.Polygon(coordinates6)

});
featurePolygon6.getGeometry().transform(COORD_SYSTEM_GPS, COORD_SYSTEM_OSM);
var vectorSource6 = new ol.source.Vector({
	features : [ featurePolygon6 ]
});
var vectorLayer6 = new ol.layer.Vector({
	source : vectorSource6,
	style : styles
});
map.addLayer(vectorLayer6);
//add end Polygon6 into the Map

//add start Polygon7 into the Map
var coordinates7;
var featurePolygon7;
coordinates7 = [[
                  [90.371101 ,23.825305],
			      [90.371079 ,23.825436],
			      [90.371231 ,23.825460],
			      [90.371255 ,23.825327],
			      [90.371101 ,23.825305]       
              ]];

featurePolygon7 = new ol.Feature({
	geometry : new ol.geom.Polygon(coordinates7)

});
featurePolygon7.getGeometry().transform(COORD_SYSTEM_GPS, COORD_SYSTEM_OSM);
var vectorSource7 = new ol.source.Vector({
	features : [ featurePolygon7 ]
});
var vectorLayer7 = new ol.layer.Vector({
	source : vectorSource7,
	style : styles
});
map.addLayer(vectorLayer7);
//add end Polygon7 into the Map


//add start Polygon8 into the Map
var coordinates8;
var featurePolygon8;
coordinates8 = [[
                  [90.371343 ,23.825347],
                  [90.371323 ,23.825467],
                  [90.371390 ,23.825478],
                  [90.371411 ,23.825357],
                  [90.371343 ,23.825347]       
              ]];

featurePolygon8 = new ol.Feature({
	geometry : new ol.geom.Polygon(coordinates8)

});
featurePolygon8.getGeometry().transform(COORD_SYSTEM_GPS, COORD_SYSTEM_OSM);
var vectorSource8 = new ol.source.Vector({
	features : [ featurePolygon8 ]
});
var vectorLayer8 = new ol.layer.Vector({
	source : vectorSource8,
	style : styles
});
map.addLayer(vectorLayer8);
//add end Polygon8 into the Map

//add start Polygon9 into the Map
var coordinates9;
var featurePolygon9;
coordinates9 = [[
                  [90.371441 ,23.825363],
                  [90.371420 ,23.825487],
                  [90.371501 ,23.825498],
                  [90.371522 ,23.825374],
                  [90.371441 ,23.825363]      
              ]];

featurePolygon9 = new ol.Feature({
	geometry : new ol.geom.Polygon(coordinates9)

});
featurePolygon9.getGeometry().transform(COORD_SYSTEM_GPS, COORD_SYSTEM_OSM);
var vectorSource9 = new ol.source.Vector({
	features : [ featurePolygon9 ]
});
var vectorLayer9 = new ol.layer.Vector({
	source : vectorSource9,
	style : styles
});
map.addLayer(vectorLayer9);
//add end Polygon9 into the Map

//add start Polygon10 into the Map
var coordinates10;
var featurePolygon10;
coordinates10 = [[
                  [90.371618 ,23.825389],
                  [90.371589 ,23.825519],
                  [90.371661 ,23.825533],
			  	  [90.371692 ,23.825401],
			  	  [90.371618 ,23.825389]      
              ]];

featurePolygon10 = new ol.Feature({
	geometry : new ol.geom.Polygon(coordinates10)

});
featurePolygon10.getGeometry().transform(COORD_SYSTEM_GPS, COORD_SYSTEM_OSM);
var vectorSource10 = new ol.source.Vector({
	features : [ featurePolygon10 ]
});
var vectorLayer10 = new ol.layer.Vector({
	source : vectorSource10,
	style : styles
});
map.addLayer(vectorLayer10);
//add end Polygon10 into the Map

//add start Polygon11 into the Map
var co11;
var featurePolygon11;
var co11=[[[90.37171863019466,23.825708645821294],[90.37179104983805,23.825719687142993],[90.37181317806244 ,23.82558657781304 ],[90.37174075841904,23.82557492307258],[90.37171863019466,23.825708645821294]]]

featurePolygon11 = new ol.Feature({
	geometry : new ol.geom.Polygon(co11)

});
featurePolygon11.getGeometry().transform(COORD_SYSTEM_GPS, COORD_SYSTEM_OSM);
var vectorSource11 = new ol.source.Vector({
	features : [ featurePolygon11 ]
});
var vectorLayer11 = new ol.layer.Vector({
	source : vectorSource11,
	style : styles
});
map.addLayer(vectorLayer11);
//add end Polygon11 into the Map

//add start Polygon12 into the Map
var co12;
var featurePolygon12;
var co12=[[[90.37182860076427,23.825590871664517],[90.37180915474892,23.825723980990077 ],[90.37190906703472,23.82573931615707 ],[90.37192918360233,23.825606820254507],[90.37182860076427,23.825590871664517]]]

featurePolygon12 = new ol.Feature({
	geometry : new ol.geom.Polygon(co12)

});
featurePolygon12.getGeometry().transform(COORD_SYSTEM_GPS, COORD_SYSTEM_OSM);
var vectorSource12 = new ol.source.Vector({
	features : [ featurePolygon12 ]
});
var vectorLayer12 = new ol.layer.Vector({
	source : vectorSource12,
	style : styles
});
map.addLayer(vectorLayer12);
//add end Polygon11 into the Map



var coodinates = [];

map.on('click', function(evt) {
	var coords = ol.proj.toLonLat(evt.coordinate);
	var lat = coords[1];
	var lon = coords[0];
	var locTxt = "(Longitude,Latitude):[" + lon + "," + lat + "]";
	var locTxtLonLat =lon + " " + lat + "</br>";
	coodinates.push(locTxtLonLat);
	document.getElementById('formCoordinates').innerHTML ="POLYGON((</br>"+coodinates+"))";
	alert(locTxt);
});


//capture mouse move events so we can 'look' at the feature
//underneath the mouse
map.on('pointermove', onMouseMove);

function onMouseMove(browserEvent) {
//the mousemove event sends a browser event object that contains
//the geographic coordinate the event happened at
var coordinate = ol.proj.toLonLat(browserEvent.coordinate);
//we can get the closest feature from the source
var feature = vectorLayer12.getSource().getClosestFeatureToCoordinate(coordinate);
//to compute the area of a feature, we need to get it's geometry and do
//something a little different depeneding on the geometry type.
var geometry = feature.getGeometry();
var area;
switch (geometry.getType()) {
case 'MultiPolygon':
// for multi-polygons, we need to add the area of each polygon
area = geometry.getPolygons().reduce(function(left, right) {
 return left + right.getArea();
}, 0);
break;
case 'Polygon':
// for polygons, we just get the area
area = geometry.getArea();
break;
default:
// no other geometry types have area as far as we are concerned
area = 0;
}
area = area;
//display the country name and area now
var text =area.toFixed(0) + ' m<sup>2</sup>';
document.getElementById('areaFeature').innerHTML = text;
}
