package com.regera.news.basics

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegisterUtilTest{
    
    @Test
    fun `return nth fibonnaci number`(){

        val result = RegisterUtil.fib(3)
        assertThat(result).isNotEqualTo(1)
        assertThat(result).isNotEqualTo(0)

    }
}