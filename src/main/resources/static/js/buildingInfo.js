var mymap = L.map('mapid').setView([23.825656, 90.371107], 15);

	L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
		maxZoom: 18,
		attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, ' +
			'<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
			'Imagery © <a href="http://mapbox.com">Mapbox</a>',
		id: 'mapbox.streets'
	}).addTo(mymap);
	var about="Here my study area"

	L.marker([23.825656, 90.371107]).addTo(mymap)
		.bindPopup(about).openPopup();

	
	var f1="<table border=0>"+
"<th>Name</th> <th>Type</th> <th>Description</th> <th>Picture</th> <tr><td>Atif House</td><td>Residential</td><td>Residential 5 floor Building</td> <td><img src=atifHouse.jpg height=55 width=55></td></tr> <tr><td>Floor One</td><td>Flat 01</td><td>2 unit with 10(M:3 F:3 & C:4) person </td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Two</td><td>Flat 02</td><td>1 unit with 8(M:3 F:2 & C:3) person </td> <td><img src=floor.jpg height=55 width=55></td> </tr>  <tr><td>Floor Three</td><td>Flat 03</td><td>2 unit with 12(M:5 F:3 & C:4) person </td> <td><img src=floor.jpg height=55 width=55></td> </tr><tr><td>Floor Four</td><td>Flat 04</td><td>1 unit with 6(M:2 F:2 & C:2) person </td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Five</td><td>Flat 05</td><td>2 unit with 6(M:2 F:1 & C:3) person </td> <td><img src=floor.jpg height=55 width=55></td> </tr></table>";

var f2="<table border=0>"+
"<th>Name</th> <th>Type</th> <th>Description</th> <th>Picture</th> <tr><td>MDC School</td><td>Educational</td><td>Educational 5 floor Building</td> <td><img src=mdc.jpg height=55 width=55></td></tr> <tr><td>Floor One</td><td>Flat 01</td><td>2 unit with (class:6 M:80 F:40 ) Students </td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Two</td><td>Flat 02</td><td>1 unit with 8(class:7 M:80 F:40) Students </td> <td><img src=floor.jpg height=55 width=55></td> </tr>  <tr><td>Floor Three</td><td>Flat 03</td><td>2 unit with 12(class:8 M:70 F:35) Students </td> <td><img src=floor.jpg height=55 width=55></td> </tr><tr><td>Floor Four</td><td>Flat 04</td><td>1 unit with 6(class:9 M:60 F:30) Students </td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Five</td><td>Flat 05</td><td>2 unit with 6(class:10 M:60 F:30) Students </td> <td><img src=floor.jpg height=55 width=55></td> </tr></table>";


var f3="<table border=0>"+
"<th>Name</th> <th>Type</th> <th>Description</th> <th>Picture</th> <tr><td>Sport Club</td><td>Sports</td><td>Training 3 floor Building</td> <td><img src=cityClub.jpg height=55 width=55></td></tr> <tr><td>Floor One</td><td>Shopping</td><td> Shopping (Number of Shops 13) </td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Two</td><td>Trining & Schooling </td><td>Sports center  </td> <td><img src=floor.jpg height=55 width=55></td> </tr>  <tr><td>Floor Three</td><td>Payer Room</td><td>Perfome Payer</td> <td><img src=floor.jpg height=55 width=55></td> </tr></table>";
 
 var f4="<table border=0>"+
"<th>Name</th> <th>Type</th> <th>Description</th> <th>Picture</th> <tr><td>Shopping Center</td><td>Shopping</td><td>Shopping 8 floor Building</td> <td><img src=anikplaza.jpg height=55 width=55></td></tr> <tr><td>Floor One</td><td>Shopping</td><td> Shopping (Number of Shops 13) </td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Two</td><td>shopping </td><td>Girls Shopping center(Number of Shops 25)  </td> <td><img src=floor.jpg height=55 width=55></td> </tr>  <tr><td>Floor Three</td><td>Kid Zone </td><td>Kids Play here</td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Four</td><td>Sport Center </td><td>Number of Shops 15</td> <td><img src=floor.jpg height=55 width=55></td> </tr></table>";

var f5="<table border=0>"+
"<th>Name</th> <th>Type</th> <th>Description</th> <th><tr><td>Raju Hotel</td><td>Resturent</td><td>Bangla Resturent</tr> </table>";

var f6="<table border=0>"+
"<th>Name</th> <th>Type</th> <th>Description</th> <th><tr><td>Molla Road</td><td>Primary</td><td>Pallabi bus station to My house</tr></table>";
 
	
	L.polygon([
		[23.825656, 90.371107],
		[23.825667, 90.371194],
		[23.825526, 90.371209],
		[23.825512, 90.371137]
	]).addTo(mymap).bindPopup(f1);
	
	L.polygon([
		[23.826236, 90.366260],
        [23.826324, 90.366762],
        [23.826025, 90.366810],
        [23.825949, 90.366322]
	]).addTo(mymap).bindPopup(f5);
	
	L.polygon([	
	[23.823937, 90.365553],
    [23.824080, 90.366625],
    [23.823120, 90.366813],
    [23.823019, 90.366440],
    [23.822903, 90.365802]
	]).addTo(mymap).bindPopup(f2);
	
	L.polygon([	
	[23.823741, 90.364475],
	[23.823931, 90.365506],
	[23.822927, 90.365729],
	[23.822714, 90.364529]
	]).addTo(mymap).bindPopup(f3);
	
	
	L.polygon([	
	[23.824257, 90.364452],
	[23.824336, 90.364964],
	[23.823983, 90.365036],
	[23.823912, 90.364519]
	]).addTo(mymap).bindPopup(f4);
	
var pointA=new L.LatLng(23.824331, 90.364334);
var pointB=new L.LatLng(23.823856, 90.364350);
var pointC=new L.LatLng(23.823981, 90.365381);
var pointD=new L.LatLng(23.824194, 90.366549);
var pointE=new L.LatLng(23.824376, 90.366628);
var pointF=new L.LatLng(23.824809, 90.369175);
var pointG=new L.LatLng(23.824980, 90.370192);
var pointH=new L.LatLng(23.825112, 90.371061);
var pointI=new L.LatLng(23.825379, 90.371011);
var pointJ=new L.LatLng(23.825466, 90.371004);
var pointK=new L.LatLng(23.825505, 90.371177);

var pointList = [pointA, pointB,pointC, pointD,pointE,pointF,pointG, pointH,pointI, pointJ, pointK];

	var firstpolyline = new L.Polyline(pointList, {
    color: 'green',
    weight: 5,
    opacity: 0.5,
    smoothFactor: 1
	
});
firstpolyline.bindPopup(f6).addTo(mymap);
	
	
	
	
	/*
	function basementDweller (feature,layer){
		
		layer.bindPopup("<h1> i am here to zzz </h1>");
	};
	
	var cityLayer=L.geoJSON(city).addTo(mymap);
	//mapid.fitBounds(cityLayer.getElementById());
	*/
	
	var popup = L.popup();

	function onMapClick(e) {
		popup
			.setLatLng(e.latlng)
			.setContent("You clicked the map at " + e.latlng.toString())
			.openOn(mymap);
	}

	mymap.on('click', onMapClick);
	
	
