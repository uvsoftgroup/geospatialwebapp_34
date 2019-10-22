var mymap = L.map('mapid').setView([ 23.825560, 90.371160], 12.00);

L.tileLayer(
				'https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw',
				{
					maxZoom : 28,
					attribution : 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, '
							+ '<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, '
							+ 'Imagery © <a href="http://mapbox.com">Mapbox</a>',
					id : 'mapbox.streets'
				}).addTo(mymap);
var about = "Point of Interest!"

L.marker([ 23.825560, 90.371160 ]).addTo(mymap).bindPopup(about).openPopup();

var f1 = "<table border=0>"
		+ "<th>Name</th> <th>Type</th> <th>Description</th> <th>Picture</th> <tr><td>Atif House</td><td>Residential</td><td>Residential 5 floor Building</td> <td><img src=atifHouse.jpg height=55 width=55></td></tr> <tr><td>Floor One</td><td>Flat 01</td><td>2 unit with 10(M:3 F:3 & C:4) person </td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Two</td><td>Flat 02</td><td>1 unit with 8(M:3 F:2 & C:3) person </td> <td><img src=floor.jpg height=55 width=55></td> </tr>  <tr><td>Floor Three</td><td>Flat 03</td><td>2 unit with 12(M:5 F:3 & C:4) person </td> <td><img src=floor.jpg height=55 width=55></td> </tr><tr><td>Floor Four</td><td>Flat 04</td><td>1 unit with 6(M:2 F:2 & C:2) person </td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Five</td><td>Flat 05</td><td>2 unit with 6(M:2 F:1 & C:3) person </td> <td><img src=floor.jpg height=55 width=55></td> </tr></table>";

var f2 = "<table border=0>"
		+ "<th>Name</th> <th>Type</th> <th>Description</th> <th>Picture</th> <tr><td>MDC School</td><td>Educational</td><td>Educational 5 floor Building</td> <td><img src=mdc.jpg height=55 width=55></td></tr> <tr><td>Floor One</td><td>Flat 01</td><td>2 unit with (class:6 M:80 F:40 ) Students </td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Two</td><td>Flat 02</td><td>1 unit with 8(class:7 M:80 F:40) Students </td> <td><img src=floor.jpg height=55 width=55></td> </tr>  <tr><td>Floor Three</td><td>Flat 03</td><td>2 unit with 12(class:8 M:70 F:35) Students </td> <td><img src=floor.jpg height=55 width=55></td> </tr><tr><td>Floor Four</td><td>Flat 04</td><td>1 unit with 6(class:9 M:60 F:30) Students </td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Five</td><td>Flat 05</td><td>2 unit with 6(class:10 M:60 F:30) Students </td> <td><img src=floor.jpg height=55 width=55></td> </tr></table>";

var f3 = "<table border=0>"
		+ "<th>Name</th> <th>Type</th> <th>Description</th> <th>Picture</th> <tr><td>Sport Club</td><td>Sports</td><td>Training 3 floor Building</td> <td><img src=cityClub.jpg height=55 width=55></td></tr> <tr><td>Floor One</td><td>Shopping</td><td> Shopping (Number of Shops 13) </td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Two</td><td>Trining & Schooling </td><td>Sports center  </td> <td><img src=floor.jpg height=55 width=55></td> </tr>  <tr><td>Floor Three</td><td>Payer Room</td><td>Perfome Payer</td> <td><img src=floor.jpg height=55 width=55></td> </tr></table>";

var f4 = "<table border=0>"
		+ "<th>Name</th> <th>Type</th> <th>Description</th> <th>Picture</th> <tr><td>Shopping Center</td><td>Shopping</td><td>Shopping 8 floor Building</td> <td><img src=anikplaza.jpg height=55 width=55></td></tr> <tr><td>Floor One</td><td>Shopping</td><td> Shopping (Number of Shops 13) </td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Two</td><td>shopping </td><td>Girls Shopping center(Number of Shops 25)  </td> <td><img src=floor.jpg height=55 width=55></td> </tr>  <tr><td>Floor Three</td><td>Kid Zone </td><td>Kids Play here</td> <td><img src=floor.jpg height=55 width=55></td> </tr> <tr><td>Floor Four</td><td>Sport Center </td><td>Number of Shops 15</td> <td><img src=floor.jpg height=55 width=55></td> </tr></table>";

var f5 = "<table border=0>"
		+ "<th>Name</th> <th>Type</th> <th>Description</th> <th><tr><td>Raju Hotel</td><td>Resturent</td><td>Bangla Resturent</tr> </table>";

var f6 = "<table border=0>"
		+ "<th>Name</th> <th>Type</th> <th>Description</th> <th><tr><td>Molla Road</td><td>Primary</td><td>Pallabi bus station to My house</tr></table>";


var polygon2Coordinate = [ [ 23.826236, 90.366260 ], [ 23.826324, 90.366762 ],
		[ 23.826025, 90.366810 ], [ 23.825949, 90.366322 ] ];

L.polygon(polygon2Coordinate).addTo(mymap).bindPopup(f5);

var polygon3Coordinate = [ [ 23.823937, 90.365553 ], [ 23.824080, 90.366625 ],
		[ 23.823120, 90.366813 ], [ 23.823019, 90.366440 ],
		[ 23.822903, 90.365802 ] ];

L.polygon(polygon3Coordinate).addTo(mymap).bindPopup(f2);

var polygon4Coordinate = [ [ 23.823741, 90.364475 ], [ 23.823931, 90.365506 ],
		[ 23.822927, 90.365729 ], [ 23.822714, 90.364529 ] ];
L.polygon(polygon4Coordinate).addTo(mymap).bindPopup(f3);

var polygon5Coordinate = [ [ 23.824257, 90.364452 ], [ 23.824336, 90.364964 ],
		[ 23.823983, 90.365036 ], [ 23.823912, 90.364519 ] ];

L.polygon(polygon5Coordinate).addTo(mymap).bindPopup(f4);
var cl8=[[23.825593,90.372041],[23.825964,90.37199],[23.825809,90.370999],[23.82563,90.371029],[23.825448,90.371063]];
L.polygon(cl8).addTo(mymap);
var cl1=[[23.824374, 90.367007],[23.824457, 90.367489],[23.823132, 90.367785],[23.823058, 90.36727]];
L.polygon(cl1).addTo(mymap).bindPopup(f4);

var cl2=[[23.824472, 90.367565],[23.82455, 90.36808],[23.823215, 90.368321],[23.823142, 90.367849]];
L.polygon(cl2).addTo(mymap).bindPopup(f4);

var cl3=[[23.825485,90.371193],[23.82563,90.371166],[23.825647,90.37127],[23.825503,90.371297]];
L.polygon(cl3).addTo(mymap).bindPopup(f1);
var cl4=[[23.825662,90.371219],[23.82579,90.371212],[23.825797,90.371316],[23.825672,90.371326]];
L.polygon(cl4).addTo(mymap).bindPopup(f1);
var cl5=[[23.825683,90.371355],[23.825808,90.37134],[23.82582,90.37142],[23.825692,90.371436]];
L.polygon(cl5).addTo(mymap).bindPopup(f1);
var cl6=[[23.825689,90.371456],[23.825833,90.371434],[23.825846,90.371509],[23.825699,90.371531]];
L.polygon(cl6).addTo(mymap).bindPopup(f1);
var cl7=[[23.825676,90.37149],[23.825542,90.371511],[23.825554,90.371578],[23.825689,90.371557]];
L.polygon(cl7).addTo(mymap).bindPopup(f1);


var popup = L.popup();

var coodinates = [];

function onMapClick(e) {
	popup.setLatLng(e.latlng).setContent("You clicked the map at " + e.latlng).openOn(mymap);
	coodinates.push("["+e.latlng+"]<br>");
	document.getElementById('formCoordinates').innerHTML =coodinates;
}

mymap.on('click', onMapClick);
