package uvsoftgroup.geospatialwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uvsoftgroup.geospatialwebapp.model.GeometryGisInfo;

public interface GeometryGisInfoRepository extends JpaRepository<GeometryGisInfo, Long>  {

}
