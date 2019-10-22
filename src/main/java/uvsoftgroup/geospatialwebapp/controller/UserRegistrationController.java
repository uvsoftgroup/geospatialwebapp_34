package uvsoftgroup.geospatialwebapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uvsoftgroup.geospatialwebapp.model.UserRegistration;
import uvsoftgroup.geospatialwebapp.service.UserRegistrationService;

@Controller
@RequestMapping("/userregistration")
public class UserRegistrationController {
	@Autowired
    private UserRegistrationService userRegistrationService;
   
    @RequestMapping("/showUserRegistrations")
    public String findAllUserRegistration(Model model) {
    	List<UserRegistration> userRegistrations =userRegistrationService.findAllUserRegistration();
        model.addAttribute("userregistrations", userRegistrations);
        model.addAttribute("counter", userRegistrations.size());
        return "showUserRegistrations";
    	
    }
    
    @RequestMapping("/userRegistrationList")
    public String userRegistrationList(Model model) {
    	List<UserRegistration> userRegistrations =userRegistrationService.findAllUserRegistration();
        model.addAttribute("userregistrations", userRegistrations);
        model.addAttribute("counter", userRegistrations.size());
        return "userRegistrationList";
    	
    }
    
    
    
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("userRegistration") UserRegistration userRegistration,
    		BindingResult errors, Model model) throws Exception {
    	userRegistrationService.saveUserRegistration(userRegistration);
    	
        return "redirect:/userregistration/showUserRegistrations";
    }


    @RequestMapping(path = "/edit/{id}",method = RequestMethod.GET)
    public String editUserRegistration(@PathVariable(value = "id") long id,Model model) throws Exception {
    	UserRegistration userRegistration=userRegistrationService.findUserRegistration(id);
    	model.addAttribute("userRegistration", userRegistration);
    	 return "editUserRegistration";	 
    }
    
    @RequestMapping(path = "/editSave/{id}", method = RequestMethod.POST)
    public String editSave(@PathVariable("id") long id,@Valid UserRegistration userRegistration,
    		BindingResult result, Model model) throws Exception {
    
    	if(result.hasErrors()){
    		userRegistration.setUserRegistrationId(id);
    		return "editUserRegistration";
	    }
	    
        userRegistrationService.saveUserRegistration(userRegistration);
        
    	model.addAttribute("userregistrations", userRegistrationService.findAllUserRegistration());
    	return "redirect:/userregistration/showUserRegistrations";
    			 
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id") long id) {
    	System.out.println("Delete Record Id:"+id);
    	userRegistrationService.deleteUserRegistration(id);
        return "redirect:/userregistration/userRegistrationList";
    }
    
    @ModelAttribute("pCount")
    public List<String> pConter(){
    	int total=20;
    	List<String> pCount=new ArrayList<>();
    	
    	int count=userRegistrationService.findAllUserRegistration().size();
    	int result=((count/total)+(count%total));
    	for(int k=0;k<result;k++){
    		pCount.add(new Integer(k).toString());
    	}
    	return pCount;
    }
}
