package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CellTest {

    private Cell cell;

    @BeforeEach
    void setup() {
        this.cell = new Cell(1, 1);
    }

    @Test
    void testClearReturnsEnumEmpty() {

        Seed expected = Seed.EMPTY;
        this.cell.setContent(Seed.CROSS);
        this.cell.clear();
        assertEquals(expected, this.cell.getContent());
    }

    @Test
    void testSetterAndGetterReturnsProperValue() {

        Seed expected = Seed.CROSS;
        this.cell.setContent(Seed.CROSS);
        assertEquals(expected, this.cell.getContent());
    }

}