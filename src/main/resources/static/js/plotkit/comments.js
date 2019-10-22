var comment_entry = null;
var comment_slider = null;
var comment_default_button = null;
var comment_sending_button = "Sending ..";
var comment_prefilled = false;
var comment_default_link = null;
var comment_default_name = null;
var comment_obj_class = null;
var comment_obj_id = null;

var comment_delete_id = null;

comment_form_init = function() {
    // initialise globals
    comment_entry = $('commententry');
    if ($('commentform').prefilled && $('commentform').prefilled.value == 1) {
        comment_prefilled = true;
    }
    
    if (!comment_prefilled) {
        comment_default_name = $('commentfieldname').value;
        comment_default_link = $('commentfieldlink').value;
    }
    
    comment_default_button = $('commentsubmit').value;
    
    var objclasses = document.getElementsByName('obj-class');
    var objids = document.getElementsByName('obj-id');
    if (objclasses && objclasses.length > 0) {
        comment_obj_class = objclasses[0].content;
    }
    if (objids && objids.length > 0) {
        comment_obj_id = objids[0].content;
    }
    
    // if the comment elements aren't found, there is no point iniitalising
    // the slider
    
    if (!comment_entry) {
        return;
    }
    
    if (!comment_obj_class || !comment_obj_id) {
        return;
    }

    // initialise slider effect
    comment_entry.setStyle('display', 'block');
    comment_slider = new Fx.Slide(comment_entry);
 
    $('togglecomment').addEvent('click', function(e) {
		e = new Event(e);
		if (!window.ie) {
		    comment_slider.toggle();
	    }
		e.stop();
	});
	
	// modify onclick behaviour for the comment form entries
	if (!comment_prefilled) {
    	$('commentfieldname').addEvent('click', function(e) {
    	    e = new Event(e);
    	    if (e.target.value == comment_default_name) {
    	        e.target.value = "";
            }
        });
    
        $('commentfieldname').addEvent('blur', function(e) {
            e = new Event(e);
            if (e.target.value == "") {
                e.target.value = comment_default_name;
            }
        });
    }
    
	// take over form submission
	$('commentform').addEvent('submit', function(e) {
	    e = new Event(e);
        comment_form_submit();
        e.stop();
    });
	
    if (!window.ie) {
	    comment_slider.hide();
    }
	
};
window.addEvent('domready', comment_form_init);

comment_form_validation_error = function(field) {
    alert("The " + field + " field has not been filled in.");
    return false;
};

comment_form_submit = function() {
    var info = new Array();
    var comment_form = $('commentform');
    
    info['name'] = $('commentfieldname').getValue();
    info['link'] = $('commentfieldlink').getValue();
    info['comment'] = $('commentfieldbody').getValue();
    
    if (info['name'] == '' || info['name'] == comment_default_name) {
        comment_form_validation_error('name');
        return false;
    }
    
    if (info['link'] == comment_default_link) {
        info['link'] = '';
    }
    
    if (info['comment'] == '') {
        comment_form_validation_error('comment');
        return false;
    }
    
    var req_body = Object.toQueryString(info);
    var url = '/comments/api/post/' + comment_obj_class + '/' + comment_obj_id + '/';
    var req = new Ajax(url, {method: 'post', data: req_body});
    req.addEvent('onComplete', comment_form_completed);
    req.addEvent('onFailure', comment_form_failed);
    req.request();
    
    $('commentsubmit').value = comment_sending_button;
    
    return true;
};

comment_form_completed = function(responseText, responseXml) {
    // reset the form
    $('commentsubmit').value = comment_default_button;
    $('commentform').comment.value = '';
    if (!window.ie)  {
        comment_slider.slideOut();
    }
    
    // insert the new HTML
    var insertion = $('commentnew');
    var json_data = Json.evaluate(responseText);
    if (json_data) {
        var new_div = new Element('div');
        new_div.innerHTML = json_data['comment_html'];
        new_div.injectTop(insertion);

        var new_slide = new Fx.Slide(new_div);
        new_slide.hide();
        new_slide.slideIn();
    }
};  

comment_form_failed = function() {
    $('commentsubmit').value = comment_default_button;
    alert('Unable to post comment. Please try again later.');
}

comment_delete = function(comment_id) {
    if (comment_delete_id != null) {
        return false;
    }
    comment_delete_id = comment_id;
    var req = new Ajax('/comments/delete/' + comment_id + '/', {method: 'get'});
    req.addEvent('onSuccess', comment_delete_completed);
    req.addEvent('onFailure', comment_delete_failed);
    req.request();
    return false;
};

comment_delete_completed = function(request) {
    var slide = new Fx.Slide('comment-' + comment_delete_id);
    slide.slideOut();
    slide.addEvent('onComplete', function(e) {
        slide.element.remove();
    });
    comment_delete_id = null;
};

comment_delete_failed = function(request) {
    alert('Failed to delete comment.');
    comment_delete_id = null;
};



