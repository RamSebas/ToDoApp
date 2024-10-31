package aEnterpise.to_do_list

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class ToDoListApplication

fun main(args: Array<String>) {
	runApplication<ToDoListApplication>(*args)
}
