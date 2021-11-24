package com.example.Kotlinspringdemo01

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*

val animais = mutableListOf<Animal>()

@SpringBootApplication
class KotlinSpringDemo01Application

fun main(args: Array<String>) {
//	animais.add(Animal("Rex", Especie.CACHORRO, 10.5))
	runApplication<KotlinSpringDemo01Application>(*args)
}

@RestController
@RequestMapping("Hello")
class helloworldController {

	@GetMapping("Hello")
	fun hello(): String{
		return "Hello World"
	}

	@GetMapping("Hello/2")
	fun helloWorld2(): String{
		return "Hello World 2"
	}
}
enum class Especie {CACHORRO, GATO, PASSARO}

data class Animal(val nome: String, val especie: Especie, val peso: Double)

//val animais = mutableListOf<Animal>()

@RestController
@RequestMapping("animais")
class AnimalController {

	@GetMapping
	fun index() = animais

	@PostMapping
	fun create(@RequestBody animal: Animal): Animal{
		animais.add(animal)
		return animal
	}
}

