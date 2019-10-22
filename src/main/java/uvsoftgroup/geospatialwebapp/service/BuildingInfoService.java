package uvsoftgroup.geospatialwebapp.service;

import java.util.List;

import uvsoftgroup.geospatialwebapp.model.BuildingInfo;

public interface BuildingInfoService {
	public void saveBuildingInfo(BuildingInfo buildingInfo);
	public List<BuildingInfo> findAllBuildingInfo();
	public BuildingInfo findBuildingInfo(Long buId);
	public void deleteBuildingInfo(Long buId);
	public void updateBuildingInfo(Long buId, BuildingInfo buildingInfo);

}
