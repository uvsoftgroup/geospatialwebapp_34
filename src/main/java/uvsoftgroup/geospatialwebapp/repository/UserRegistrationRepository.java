package uvsoftgroup.geospatialwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uvsoftgroup.geospatialwebapp.model.UserRegistration;


public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long> {

}
