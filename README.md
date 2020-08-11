# DEV-TEST solutions
All 3 tasks can be launched via Gradle or simply in some IDE. 

## Default input data
Default input data provided in original task descriptions are stored in **example_input.txt** files in each submodule.

You can run those applications using following commands:
```
gradlew task1:run
gradlew task2:run
gradlew task3:run
```

## Custom input data
To use a different set of data the following commands should be used:
```
gradlew task1:run --args="<<filepath>>"
gradlew task2:run --args="<<filepath>>"
gradlew task3:run --args="<<filepath>>"
```