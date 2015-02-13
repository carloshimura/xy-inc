package org.xy_poi.data;

import java.util.LinkedList;
import java.util.List;

import org.xy_poi.data.database.POIDatabaseAcess;

/**
 * Classe gerenciadora de funcionalidades
 * @author carlos
 *
 */
public class POIManager {
	private static POIManager m_instance = null;
	private POIDatabaseAcess m_database;
	
	private POIManager()
	{
		m_database = new POIDatabaseAcess();
	}
	
	public static POIManager getInstance()
	{
		if(m_instance == null)
			m_instance = new POIManager();
		return m_instance;
	}
	
	public void insertPOI(POI poi)
	{
		m_database.insertPoi(poi);
	}
	
	public List<POI> getAllPOIs()
	{
		return m_database.getAllPOIs();
	}
	
	public List<POI> getPOIs(double x, double y, double max_distance)
	{
		List<POI> l_list = m_database.getAllPOIs();
		List<POI> result = new LinkedList<POI>();
		for(POI poi : l_list)
		{
			if(Math.sqrt(Math.pow((double)poi.getX() - x, 2.0) + Math.pow((double)poi.getY() - y, 2.0)) < max_distance)
			{
				result.add(poi);
			}
		}
		return result;
	}
}
