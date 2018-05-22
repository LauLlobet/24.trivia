package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class GameGoldenMasterTest {

	@Test
	public void goldenMasterTest() throws Exception {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(os);
		System.setOut(printStream);

		System.out.println("100x100");

		String output = os.toString("UTF8");

		assertEquals("100x100",output);
		//Approvals.verify(output);
	}
}
