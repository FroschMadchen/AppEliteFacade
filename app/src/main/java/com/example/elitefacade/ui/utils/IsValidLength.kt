package com.example.elitefacade.ui.utils


fun String.isValidLength(minLength: Int) : Boolean {
    return this.isNotEmpty() && this.length >= minLength
}