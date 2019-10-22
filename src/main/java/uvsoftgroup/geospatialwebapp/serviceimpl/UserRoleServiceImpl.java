package uvsoftgroup.geospatialwebapp.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uvsoftgroup.geospatialwebapp.model.UserRole;
import uvsoftgroup.geospatialwebapp.repository.UserRoleRepository;
import uvsoftgroup.geospatialwebapp.service.UserRoleService;


@Service
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	private  UserRoleRepository userRoleRepository;



	public void saveUserRole(UserRole userRole) throws Exception {
		userRoleRepository.save(userRole);
		
	}

	
	public List<UserRole> findAllUserRole() {
		List<UserRole> listUR=(List<UserRole>) userRoleRepository.findAll();
		if(!listUR.isEmpty()){
			return listUR;		
		}
		else{
			return new ArrayList<UserRole>(listUR);
		}
	}


	public UserRole findUserRole(Long urId) {
		UserRole userRole=userRoleRepository.findOne(urId);
		if(userRole!=null){
			return userRole;		
		}
		else{
			return new UserRole();
		}
	}

	
	public UserRole deleteUserRole(Long urId) {
		UserRole userRole=userRoleRepository.findOne(urId);
		
		if(userRole!=null && userRole.getUserRoleId()!=null){
			userRoleRepository.delete(userRole.getUserRoleId());
			return userRole;
		}
		else{
			return new UserRole();
		}
	}

	@Override
	public void updateUserRole(Long urId, UserRole userRole) {
		UserRole userRoleExisting=userRoleRepository.findOne(urId);
		
		if(userRoleExisting!=null && userRoleExisting.getUserRoleId()!=null){
			userRoleRepository.save(userRole);
			
		}
		
	
		
	}

}