plugins {
	java
	application
}

tasks {
	jar {
		manifest.attributes["Main-Class"] = "pl.lsnova.task3.Task3"
	}
	run.configure {
		args = listOf("example_input.txt")
	}
}

application.mainClassName = "pl.lsnova.task3.Task3"