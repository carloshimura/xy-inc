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
	
	/**
	 * construtor
	 */
	private POIManager()
	{
		m_database = new POIDatabaseAcess();
	}
	
	/**
	 * Retorna a instância única da classe nesse projeto
	 * @return instância da classe POIManager
	 */
	public static POIManager getInstance()
	{
		if(m_instance == null)
			m_instance = new POIManager();
		return m_instance;
	}
	
	/**
	 * insere um POI
	 * @param poi POI a ser inserido
	 */
	public void insertPOI(POI poi)
	{
		m_database.insertPoi(poi);
	}
	
	/**
	 * retorna todos os POIs registrados
	 * @return todos os POIs registrados
	 */
	public List<POI> getAllPOIs()
	{
		return m_database.getAllPOIs();
	}
	
	/**
	 * método que retorna os POIs num determinado raio
	 * @param x coordenada x da posição
	 * @param y coordenada y da posição
	 * @param max_distance raio de busca
	 * @return lista dos POIs no raio determinado
	 */
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
