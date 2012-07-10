package com.test.utils;

import static org.junit.Assert.*;
import java.io.File;
import java.util.List;
import org.junit.Test;
import com.bombitarodriguez.utils.Parser;

public class ParserTest {

	@Test
	public void testParsearMapXML() {
		String path = PathFile.getPathActual();
		path = path + "/testUnitarios/com/test/utils/MapaTest.xml";
		File file = new File(path);
	
		String fila1 = "1 0 0 0 0 0 21 0 0 0";
		String fila2 = "-1 -1 -1 -1 -1 -1 -1 -1 0 -1";
		List<String> filasParseadas = Parser.parsearMapXML(file);
		
		assertEquals(2, filasParseadas.size());
		assertEquals(fila1, filasParseadas.get(0));
		assertEquals(fila2, filasParseadas.get(1));
	}

	@Test
	public void testParsearLista() {
		String[] result = Parser.parsearLista("1 0 0 0 0 0 21 0 0 0");
		
		assertEquals(10, result.length);
		assertEquals("0", result[1]);
	}

}
