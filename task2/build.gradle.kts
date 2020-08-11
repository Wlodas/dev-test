plugins {
	java
	application
}

tasks {
	jar {
		manifest.attributes["Main-Class"] = "pl.lsnova.task2.Task2"
	}
	run.configure {
		args = listOf("example_input.txt")
	}
}

application.mainClassName = "pl.lsnova.task2.Task2"