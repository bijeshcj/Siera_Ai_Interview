package com.example.roomandroidexample

import com.example.roomandroidexample.screens.Validators
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ValidatorsUnitTest {
    @Test
    fun validateUserInputs() {
        var validators = Validators()
        var ret = validators.validateUserInput("Bijesh","2323434")
        assertTrue(ret)
    }

    @Test
    fun validateEmptyUserInputs() {
        var validators = Validators()
        var ret = validators.validateUserInput("","")
        assertFalse(ret)
    }

    @Test
    fun validateEmptyUserNameInputs() {
        var validators = Validators()
        var ret = validators.validateUserInput("","234324")
        assertFalse(ret)
    }

    @Test
    fun validateEmptyNumberInputs() {
        var validators = Validators()
        var ret = validators.validateUserInput("","")
        assertFalse(ret)
    }
}
