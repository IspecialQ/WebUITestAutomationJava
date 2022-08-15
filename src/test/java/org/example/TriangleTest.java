package org.example;

import org.example.lesson4.SideOfTriangleIsZero;
import org.example.lesson4.TriangleArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class TriangleTest {

    @Test
    void isHeronsFormulaGetCorrectAnswer() throws SideOfTriangleIsZero {
        Assertions.assertEquals(6, TriangleArea.heronsFormula(3, 4, 5));
    }

    @ParameterizedTest
    @CsvSource({"0, 1, 2", "3, 0, 6", "5, 7, 0", "0, 0, 7"})
    void whenIsSideOfTriangleIsZero(int a, int b, int c) {
        Assertions.assertThrows(SideOfTriangleIsZero.class, () -> TriangleArea.heronsFormula(a, b, c));
    }
}
