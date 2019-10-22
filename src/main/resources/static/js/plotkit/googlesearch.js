var searcher = null;
var menu_slider = null;
var menu_area = null;
var has_result = false;
var button_search = null;
var button_searching = 'searching..';

google_search_init = function() {
    // initialise some globals
    button_search = $('searchbutton').value;
    menu_area = $('headerextracontent');
    menu_area.setStyle('display', 'block');
	menu_slider = new Fx.Slide(menu_area);
	
	$('headermenu').addEvent('click', function(e) {
		e = new Event(e);
        if (menu_slider.wrapper.offsetHeight == 0) {
           $('query').focus();
        }
		menu_slider.toggle();
		e.stop();
	});

    menu_slider.element.setStyle('height', 50);
	menu_slider.hide();
};
window.addEvent('domready', google_search_init);

google_onload = function() {
	searcher = new GblogSearch();
	searcher.setSiteRestriction("liquidx.net");
	searcher.setNoHtmlGeneration();
	searcher.setResultOrder(GSearch.ORDER_BY_RELEVANCE);
	searcher.setLinkTarget(GSearch.LINK_TARGET_SELF);
	searcher.setSearchCompleteCallback(this, google_search_complete);  

    $('blogsearch').onsubmit = google_search_submit;
};

google_search_submit = function(event) {
    if ($('query').value) {
        $('searchbutton').value = button_searching;
        menu_slider.element.setStyle('height', 100);
        menu_slider.slideIn();
        searcher.execute($('query').value);
    }
    return false;
};

crude_date_strip = function(dateString) {
    // Tue, 05 Jan 2007 00:00:00 -0000
    // 0123456789012345
    return dateString.slice(5, 16);
}

google_search_complete = function() {
    var resultsDiv = $("sitesearchresults").empty();
    
    if (searcher.results.length > 0) {
        $('searchbutton').value = button_search;
            
        for (var i = 0; i < searcher.results.length; i++) { 
            var result = searcher.results[i];
            var d = new Element('div', {'class': 'searchresult'});
            var a = new Element('a', {'href': result.postUrl});
            a.appendText(result.titleNoFormatting);
            d.appendChild(a);
            d.appendText(' - ' + crude_date_strip(result.publishedDate));
            resultsDiv.appendChild(d);
            has_result = true;
        }

    }
    else {
        var d = new Element('div', {'class': 'searchresult'});
        d.appendText('No results found');
        resultsDiv.appendChild(d);
        has_result = false;
    }
}


GSearch.setOnLoadCallback(google_onload);
