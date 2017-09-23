package com.anna.junit5.ye.olde;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class Junit4Test {

    @Rule
    public final TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void oldTest() throws IOException {
        File file = tempFolder.newFile("test.txt");
        try (FileWriter writer = new FileWriter(file))  {
            writer.write("Hallo JUnit4!");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            assertEquals("This is not equal", "Hallo JUnit4!", reader.readLine());
        }
    }
}
