package org.example

import kotlinx.coroutines.runBlocking

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(): Unit = runBlocking {
    val config = Config()
    val cache = Cache()
    val menu = UserMenu(config, cache)
    println(config.greeting)
    menu.getUserInfo()
}