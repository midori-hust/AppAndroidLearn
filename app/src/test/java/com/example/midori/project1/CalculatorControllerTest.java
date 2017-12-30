package com.example.midori.project1;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by midori on 2017/12/28.
 */
public class CalculatorControllerTest {
    @Test
    public void testConvertStringToList() {
        assertThat(new CalculatorController().convertStringToList("12+23-34"), Is.is(Arrays.asList("12", "+", "23", "-", "34")));
    }

    @Test
    public void testInvalidStringMathExpression() {
        assertThat(new CalculatorController().invalidStringMathExpression("12+23-34"), Is.is(true));
        assertThat(new CalculatorController().invalidStringMathExpression("-12+23-34"), Is.is(false));
        assertThat(new CalculatorController().invalidStringMathExpression("12+23-34-"), Is.is(false));
        assertThat(new CalculatorController().invalidStringMathExpression("12++23-34"), Is.is(false));
        assertThat(new CalculatorController().invalidStringMathExpression("12+23---34"), Is.is(false));
    }

    @Test
    public void testHandleOperationMultiplicationAndDivisionOnList() {
        assertThat(new CalculatorController().handleOperationMultiplicationAndDivisionOnList(Arrays.asList("12", "+", "23", "-", "34")), Is.is(Arrays.asList("12", "+", "23", "-", "34")));
//        assertThat(new CalculatorController().handleOperationMultiplicationAndDivisionOnList(new ArrayList(Arrays.asList("12.2", "/", "23", "*", "4", "-", "34"))), Is.<List>is(Arrays.asList("276", "-", "34")));
        assertThat(new CalculatorController().handleOperationMultiplicationAndDivisionOnList(Arrays.asList("12", "+", "23", "-", "34")), Is.is(Arrays.asList("12", "+", "23", "-", "34")));
    }

    @Test
    public void testGetResult() {
        CalculatorController test = new CalculatorController();
        if (test.invalidStringMathExpression("12*23-34")) {
            assertThat(test.getResult(), Is.is("276.0"));
        }
    }

    @Test
    public void testBla() {
        assertThat(new CalculatorController().convertStringToList("12*23-34"), Is.is(Arrays.asList("12", "*", "23", "-", "34")));
        assertThat(new CalculatorController().handleOperationMultiplicationAndDivisionOnList(new ArrayList<>(Arrays.asList("12", "*", "23", "-", "34"))), Is.is(Arrays.asList("276.0", "-", "34")));
        assertThat(new CalculatorController().handleOperation(new ArrayList(Arrays.asList("276", "-", "34"))), Is.is("242.0"));
    }

}