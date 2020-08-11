plugins {
	java
	application
}

tasks {
	jar {
		manifest.attributes["Main-Class"] = "pl.lsnova.task1.Task1"
	}
	run.configure {
		args = listOf("example_input.txt")
	}
}

application.mainClassName = "pl.lsnova.task1.Task1"