package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by michalosak on 14/06/2017.
 */
class UiTest {

    Ui ui;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        this.ui = new Ui();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testPrintBoardExpectedTable() {
        String expected =
                "  |   |  \n" +
                "---------\n" +
                "  |   |  \n" +
                "---------\n" +
                "  |   |  \n";

        Cell[][] table =  new Cell[3][3];
        for (int x = 0; x <= 2; x++ ) {
            for (int  y = 0; y <= 2; y++){
                table[x][y] = new Cell(x, y);
                table[x][y].clear();
            }
        }

        this.ui.printBoard(table);
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testPrintWarningExpectedString() {

        String expected = "\u001B[33mWARNING: test warning\n" +
                "\u001B[0m\n";

        this.ui.printWarning("test warning");
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testPrintInformationExpectedString() {

        String expected = "\u001B[32mtest information\n" +
                "\u001B[0m\n";

        this.ui.printInformation("test information");
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testPrintHeaderExpectedString() {

        String expected = "\u001B[32mtest header\n" +
                "\u001B[0m\n";

        this.ui.printInformation("test header");
        assertEquals(expected, outContent.toString());
    }


}