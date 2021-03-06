package com.regera.news.basics

object RegisterUtil {

    /*
    * Returns the n-th fibonacci number
    *
    * */
    fun fib(n: Int): Long {
        if (n == 0 || n == 1) {
            return n.toLong()
        }
        var a = 0L
        var b = 1L
        var c = 1L

        (1..n-1).forEach {
            c = a +b
            a = b
            b = c
        }

        return c
    }

}