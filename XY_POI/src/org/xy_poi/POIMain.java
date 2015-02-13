package org.xy_poi;

import java.util.List;

import org.xy_poi.data.POI;
import org.xy_poi.data.POIManager;

/**
 * Interface de entrada dos dados do webservice
 * @author carlos
 *
 */
public class POIMain {
	
	/**
	 * insere um POI
	 * @param name nome do POI
	 * @param x valor da coordenada X
	 * @param y valor da coordenada Y
	 * @return mensagem de resultado da operação
	 */
	public String insertPOI(String name, int x, int y)
	{
		try
		{
			POI poi = new POI();
			poi.setName(name);
			poi.setX(x);
			poi.setY(y);
			POIManager.getInstance().insertPOI(poi);
		}
		catch(Exception e)
		{
			return "Ocorreu um erro na inserção do POI";
		}
		return "Inserção feita com sucesso";
	}
	
	/**
	 * Função que retorna todos os POIs
	 * @return
	 */
	public String getAllPOIs()
	{
		List<POI> list = POIManager.getInstance().getAllPOIs();
		String l_return = "";
		for(POI poi : list)
		{
			l_return += poi.getName() + ";" + poi.getX() + ";" + poi.getY() + "\n";
		}
		return l_return;
	}
	
	/**
	 * método que retorna os POIs num determinado raio
	 * @param x valor da coordenada X para busca
	 * @param y valor da coordenada Y para busca
	 * @param max_dist distância máxima
	 * @return Lista de POIs no raio desejado
	 */
	public String getNearestPOIs(int x, int y, int max_dist)
	{
		List<POI> list = POIManager.getInstance().getPOIs((double)x, (double)y, (double)max_dist);
		String l_return = "";
		for(POI poi : list)
		{
			l_return += poi.getName() + "\n";
		}
		return l_return;
	}
}
