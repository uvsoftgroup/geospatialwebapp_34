/**
 * 
 */
package uvsoftgroup.geospatialwebapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="userrole")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="seq_userrole", strategy="uvsoftgroup.geospatialwebapp.utility.UserRoleIdGenerator")
	@GeneratedValue(generator="seq_userrole")
	 private Long userRoleId;
	 private Long userRefNrId;
	 private String userRoleName,userRoleType;
	 private Date userRoleDate;
	 private Date userRoleMDate;
	 
	 
	public UserRole() {
		super();
		
	}
	
	
	public Date getUserRoleMDate() {
		return userRoleMDate;
	}


	public void setUserRoleMDate(Date userRoleMDate) {
		this.userRoleMDate = userRoleMDate;
	}


	public Long getUserRefNrId() {
		return userRefNrId;
	}
	public void setUserRefNrId(Long userRefNrId) {
		this.userRefNrId = userRefNrId;
	}
	public Long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	public String getUserRoleType() {
		return userRoleType;
	}
	public void setUserRoleType(String userRoleType) {
		this.userRoleType = userRoleType;
	}
	public Date getUserRoleDate() {
		return userRoleDate;
	}
	public void setUserRoleDate(Date userRoleDate) {
		this.userRoleDate = userRoleDate;
	}


	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userRefNrId=" + userRefNrId + ", userRoleName=" + userRoleName
				+ ", userRoleType=" + userRoleType + ", userRoleDate=" + userRoleDate + ", userRoleMDate="
				+ userRoleMDate + "]";
	}
	
	 
	 
}
