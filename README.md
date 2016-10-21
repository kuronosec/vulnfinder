# Vulnfinder
Welcome to Vulnfinder, a tool for model based security testing for Web applications.

## How it Works?

Vulnfinder includes a definition of a visual and textual language to model security tests. The precise specification using a metamodel and a grammar allows to the models expressed in the language to be transformed into specific commands for vulnerability testing tools like ZAP proxy and SQLmap. We will include other Web vulnerability scanners and fuzzers in the future.

The main phases for doing a test with Vulnfinder are:

![](images/phases.png)


## Why model based testing?

This project explores methods to ensure standardization of results when a security analyst is testing a Web system. Our approach is intended to support a model-driven testing design; i.e. the security analyst defines the testing model, a framework executes a model-to-text transformation, the output is a set of commands to drive the use of fuzzing and scanners in order to detect vulnerabilities.

This way, the test becomes repeatable and reduces the influence of the tester's experience from the test itself. The standardization in the testing process can systematically improve quality on the results of any further test.


## Which kind of tests?

We consider only the black box testing technique because this kind of scenario is frequently the only available when the security analyst does not have access to the source code of the application.


## Where can I find the technical guides?

Please follow the links to see the available documentation:
 * [How to install](https://gitlab.com/ryepesg/vulnfinder/wikis/installation)
 * [How to use](https://gitlab.com/ryepesg/vulnfinder/wikis/beginners-guide)