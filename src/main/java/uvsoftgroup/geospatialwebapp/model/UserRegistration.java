/**
 * 
 */
package uvsoftgroup.geospatialwebapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="userregistration")
public class UserRegistration implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="seq_useregistration", strategy="uvsoftgroup.geospatialwebapp.utility.UserRegistrationIdGenerator")
	@GeneratedValue(generator="seq_useregistration")
	 private Long userRegistrationId;
	 private Long userAddressId;
	 private String userRegistrationFName,userRegistrationMName,userRegistrationLName,userRegistrationName
	  ,userRegistrationPassword,userRegistrationfullName;
	 private Date userRegistrationCrDate,userRegistrationLDate;
	 private String userMail, userPhoneNr, userMobileNr, userWww;
	 
	 
	 @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	 @JoinColumn(name="ur_ur_id")
	 private List<UserRole> userRoles=new ArrayList<UserRole>();

	    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
		@JoinColumn(name="ur_id_id")
		List<GeometryGisInfo> geometryGisInfos=new ArrayList<GeometryGisInfo>();
	 
	
	public UserRegistration() {
		super();
	}


	public String getUserMail() {
		return userMail;
	}


	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}


	public String getUserPhoneNr() {
		return userPhoneNr;
	}


	public void setUserPhoneNr(String userPhoneNr) {
		this.userPhoneNr = userPhoneNr;
	}


	public String getUserMobileNr() {
		return userMobileNr;
	}


	public void setUserMobileNr(String userMobileNr) {
		this.userMobileNr = userMobileNr;
	}


	public String getUserWww() {
		return userWww;
	}


	public void setUserWww(String userWww) {
		this.userWww = userWww;
	}


	public Long getUserRegistrationId() {
		return userRegistrationId;
	}


	public void setUserRegistrationId(Long userRegistrationId) {
		this.userRegistrationId = userRegistrationId;
	}


	public Long getUserAddressId() {
		return userAddressId;
	}


	public void setUserAddressId(Long userAddressId) {
		this.userAddressId = userAddressId;
	}


	public String getUserRegistrationFName() {
		return userRegistrationFName;
	}


	public void setUserRegistrationFName(String userRegistrationFName) {
		this.userRegistrationFName = userRegistrationFName;
	}


	public String getUserRegistrationMName() {
		return userRegistrationMName;
	}


	public void setUserRegistrationMName(String userRegistrationMName) {
		this.userRegistrationMName = userRegistrationMName;
	}


	public String getUserRegistrationLName() {
		return userRegistrationLName;
	}


	public void setUserRegistrationLName(String userRegistrationLName) {
		this.userRegistrationLName = userRegistrationLName;
	}


	public String getUserRegistrationName() {
		return userRegistrationName;
	}


	public void setUserRegistrationName(String userRegistrationName) {
		this.userRegistrationName = userRegistrationName;
	}


	public String getUserRegistrationPassword() {
		return userRegistrationPassword;
	}


	public void setUserRegistrationPassword(String userRegistrationPassword) {
		this.userRegistrationPassword = userRegistrationPassword;
	}


	public String getUserRegistrationfullName() {
		return userRegistrationfullName;
	}


	public void setUserRegistrationfullName(String userRegistrationfullName) {
		this.userRegistrationfullName = userRegistrationfullName;
	}


	public Date getUserRegistrationCrDate() {
		return userRegistrationCrDate;
	}


	public void setUserRegistrationCrDate(Date userRegistrationCrDate) {
		this.userRegistrationCrDate = userRegistrationCrDate;
	}


	public Date getUserRegistrationLDate() {
		return userRegistrationLDate;
	}


	public void setUserRegistrationLDate(Date userRegistrationLDate) {
		this.userRegistrationLDate = userRegistrationLDate;
	}


	public List<UserRole> getUserRoles() {
		
		if (userRoles == null) {
			userRoles = new ArrayList<UserRole>();
	      }
		
		return userRoles;
	}


	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}


	public List<GeometryGisInfo> getGeometryGisInfos() {
		return geometryGisInfos;
	}


	public void setGeometryGisInfos(List<GeometryGisInfo> geometryGisInfos) {
		this.geometryGisInfos = geometryGisInfos;
	}


	@Override
	public String toString() {
		return "UserRegistration [userRegistrationId=" + userRegistrationId + ", userAddressId=" + userAddressId
				+ ", userRegistrationFName=" + userRegistrationFName + ", userRegistrationMName="
				+ userRegistrationMName + ", userRegistrationLName=" + userRegistrationLName + ", userRegistrationName="
				+ userRegistrationName + ", userRegistrationPassword=" + userRegistrationPassword
				+ ", userRegistrationfullName=" + userRegistrationfullName + ", userRegistrationCrDate="
				+ userRegistrationCrDate + ", userRegistrationLDate=" + userRegistrationLDate + ", userMail=" + userMail
				+ ", userPhoneNr=" + userPhoneNr + ", userMobileNr=" + userMobileNr + ", userWww=" + userWww
				+ ", userRoles=" + userRoles + ", geometryGisInfos=" + geometryGisInfos + "]";
	}


	

	
}
