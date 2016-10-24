# Vulnfinder
Welcome to Vulnfinder, a tool for model based security testing on Web applications.

## How does it work?

Vulnfinder includes a visual and textual language definition to model security tests. The precise specification using a metamodel and grammar allows models expressed in the language to be transformed into specific commands for vulnerability testing tools like ZAP proxy and SQLmap. We will include other Web vulnerability scanners and fuzzers in the future.

The main steps involved in a Vulnfinder test can be seen in the following schema:

![](images/phases.png)


## Why model based testing?

This project explores methods to ensure standard results when a security analyst is testing a Web system. Our approach is intended to support a model-driven testing design; i.e. the security analyst defines a testing model, a framework executes a model-to-text transformation, the output is a set of commands to drive the use of fuzzing and scanners in order to detect vulnerabilities.

This way, the test becomes repeatable and reduces the influence of the tester's experience while applying a test. The standardization in the testing process can systematically improve quality on the results of any further test.


## What kind of tests is the tool focus on?

We consider black box testing technique, given that this kind of scenario is commonly the only available when the security analyst does not have access to the source code of the application.


## Where can I find more information on installation and usage?

Please follow the links to see the available documentation:
 * [How to install](https://gitlab.com/ryepesg/vulnfinder/wikis/installation)
 * [How to use](https://gitlab.com/ryepesg/vulnfinder/wikis/guide)