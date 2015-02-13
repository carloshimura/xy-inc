package org.xy_poi.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.xy_poi.data.database.POIDatabaseAcess;
import org.xy_poi.data.POI;

/**
 * Classe de testes das entradas de banco de dados
 * @author carlos
 *
 */
public class DatabaseTests {
	
	@Test
	public void testDatabase() {
		POIDatabaseAcess acess = new POIDatabaseAcess();
		POI l_poi = new POI();
		l_poi.setName("TESTE");
		l_poi.setX(1);
		l_poi.setY(2);
		acess.insertPoi(l_poi);
		try
		{
			List<POI> list = acess.getAllPOIs();
			if(list.size() > 0)
			{
				boolean l_found = false;
				for(POI poi : list)
				{
					if(l_poi.getName().equals(poi.getName()) &&
							l_poi.getX() == poi.getX() &&
							l_poi.getY() == poi.getY())
					{
						l_found = true;
						break;
					}
				}
				if(!l_found)
				{
					fail("Inserted POIs not on database!");
				}
			}
			else
			{
				fail("No POIs on database!");
			}
		}
		catch(Exception e)
		{
			fail("An exception has ocurred!");
		}
	}

}
