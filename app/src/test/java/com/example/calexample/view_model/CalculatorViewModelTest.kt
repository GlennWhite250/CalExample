package com.example.calexample.view_model

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class CalculatorViewModelTest {

    @Test
    fun successfulAddition() {
        val testData = "2 2 +"
        val sut = CalculatorViewModel()
        val actualAnswer = sut.calculate(expr = testData)
        val expectedAnswer = 4.0
        assertEquals(expectedAnswer, actualAnswer)
    }

    @Test
    fun successfulSubtraction() {
        val testData = "8 4 -"
        val sut = CalculatorViewModel()
        val actualAnswer = sut.calculate(expr = testData)
        val expectedAnswer = 4.0
        assertEquals(expectedAnswer, actualAnswer)
    }

    @Test
    fun successfulMultiply() {
        val testData = "2 2 *"
        val sut = CalculatorViewModel()
        val actualAnswer = sut.calculate(expr = testData)
        val expectedAnswer = 4.0
        assertEquals(expectedAnswer, actualAnswer)
    }

    @Test
    fun successfulDivision() {
        val testData = "2 2 /"
        val sut = CalculatorViewModel()
        val actualAnswer = sut.calculate(expr = testData)
        val expectedAnswer = 1.0
        assertEquals(expectedAnswer, actualAnswer)
    }

    @Test
    fun complexMath1() {
        val testData = "5 5 5 8 + + - 13 +"
        val sut = CalculatorViewModel()
        val actualAnswer = sut.calculate(expr = testData)
        val expectedAnswer = 0.0
        assertEquals(expectedAnswer, actualAnswer)
    }

    @Test
    fun complexMath2() {
        val testData = "-3 -2 * 5 +"
        val sut = CalculatorViewModel()
        val actualAnswer = sut.calculate(expr = testData)
        val expectedAnswer = 11.0
        assertEquals(expectedAnswer, actualAnswer)
    }

    @Test
    fun complexMath3() {
        val testData = "5 9 1 - /"
        val sut = CalculatorViewModel()
        val actualAnswer = sut.calculate(expr = testData)
        val expectedAnswer = 0.625
        assertEquals(expectedAnswer, actualAnswer)
    }
}