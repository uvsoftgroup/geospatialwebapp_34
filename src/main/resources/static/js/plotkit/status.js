twitter_status = function(json) {
    var url = 'twitter.com/statuses/user_timeline/liquidx.json?count=1';
    var proxy_url = 'http://www.liquidx.net/bridge/' + url;

    var req = new Json.Remote(proxy_url, {'method': 'get'});
    req.addEvent('onComplete', function(resp) {
        if (resp.length > 0) {
           $('twitterstatus').setText(resp[0]["text"]);
        }
    });
    req.send();
};

status_init = function() {
    if ($("statusbox") != null) {
        twitter_status();
        jaiku_status();
        fireeagle_status();
    }
};

jaiku_status = function() {
    var url = 'liquidx.jaiku.com/presence/json/';
    var proxy_url = 'http://www.liquidx.net/bridge/' + url;

    var req = new Json.Remote(proxy_url, {'method': 'get'});
    req.addEvent('onComplete', function(resp) {
       var fields = ["neighbourhood", "city", "country"];
       var elem = resp["location"];
       var location = "";
       var i;
       for (i = 0; i < fields.length; i++) {
          if (elem[fields[i]]) {
             location += elem[fields[i]] + ", ";
          }
       }
         
       if (location.length > 0) {
          location = location.substring(0, location.length - 2);
       }
       $('jaikustatus').setText(location);
    });
    req.send();
};

fireeagle_status = function() {
    var user_token = "Mc4fr.oOImYApQSc_NI5Y2YzJi8-";
    var url = "fireeagle.research.yahoo.com/api/queryLoc.php?public=";
    var proxy_url = "http://www.liquidx.net/bridge/" + url + user_token;
    
    var request = new Ajax(proxy_url, {'method': 'get'});
    request.addEvent('onComplete', function(text, xml) {
        var fields = ["neighborhood", "city", "country"];
        var i;
        var location = "";
        for (i = 0; i < fields.length; i++) {
           var elem = xml.getElementsByTagName(fields[i])[0] || null;
           if (elem) { 
              location += $pick(elem.innerText, elem.textContent) + ", ";
           }
        }
        // cut off last comma
        if (location.length > 0) {
           location = location.substring(0, location.length - 2);
        }

        $('fireeaglestatus').setText(location);
        
        var lat = xml.getElementsByTagName("latitude")[0] || null;
        var lng = xml.getElementsByTagName("longitude")[0] || null;
        var radius = xml.getElementsByTagName("radius")[0] || null;
        
        if (lat && lng) {
           lat = $pick(lat.innerText, lat.textContent);
           lng = $pick(lng.innerText, lng.textContent);
           var gmap_q = lat + "," + lng + " (Alastair is Here)";
           var gmap_params = {"q": gmap_q, "f": "q", "z": 13 };
           var gmap_query = Object.toQueryString(gmap_params);
           var gmap_url = "http://maps.google.com/maps?" + gmap_query;

           var gmap_link = new Element("a", {"href": gmap_url});
           gmap_link.appendText("on a map");
           $('fireeaglestatus').appendText(" (");
           $('fireeaglestatus').appendChild(gmap_link);
           $('fireeaglestatus').appendText(")");
        }
     });
    
    request.request();
    
};

window.addEvent('domready', status_init);
