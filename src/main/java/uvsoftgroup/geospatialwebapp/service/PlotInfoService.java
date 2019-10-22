package uvsoftgroup.geospatialwebapp.service;

import java.util.List;

import uvsoftgroup.geospatialwebapp.model.PlotInfo;


public interface PlotInfoService {
	
	public void savePlotInfo(PlotInfo plotInfo);
	public List<PlotInfo> findAllPlotInfo();
	public PlotInfo findPlotInfo(Long urId);
	public void deletePlotInfo(Long urId);
	public void updatePlotInfo(Long urId, PlotInfo plotInfo);

}
