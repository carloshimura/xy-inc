package org.xy_poi.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.xy_poi.data.POI;
import org.xy_poi.data.POIManager;

/**
 * Classe de testes dos métodos do POIManager
 * @author carlos
 *
 */
public class ManagerTest {

	@Test
	public void testGetPOIs() {
		String[] expected_results = {"Lanchonete", "Joalheria", "Pub", "Supermercado"};
		try
		{
			List<POI> l_list = POIManager.getInstance().getPOIs(20, 10, 10);
			if(l_list.size() > 0)
			{
				for(POI poi : l_list)
				{
					boolean l_found = false;
					for(String s : expected_results)
					{
						if(s.equals(poi.getName()))
						{
							l_found = true;
							break;
						}
					}
					if(!l_found)
					{
						fail("Wrong result!");
					}
				}
			}
			else
			{
				fail("No results in range!");
			}
		}
		catch(Exception e)
		{
			fail("An exception has ocurred!");
		}
	}

}
