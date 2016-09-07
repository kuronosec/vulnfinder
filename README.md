# VulnFinder
In order to run a developer instance of Vulnfinder you will need:

- [Java 8 or higher.] [Java8]
- [OWASP ZAP 2.4.3 or superior.] [ZAP]
- [Eclipse Modelling Tools Neon Release 2 or superior.] [EMT]
    -  [Sirius Plugin for Eclipse.] [Sirius]
    -  [Xtext Plugin for Eclipse.] [Xtext]
    -  [Acceleo Plugin for Eclipse.] [Acceleo]
    -  [Xpand Plugin for Eclipse.] [Xpand]
- [**Greasemonkey**] [GM] extension on Firefox / [**Tampermonkey**] [TM] extension on Google Chrome

### Installing & Getting Ready
The following steps are to be executed before trying to run or modify *Vulnfinder*. These steps will become simplier as soon as an stable version is ready to be launched.

Once you've installed the required software mentioned above, you must install the *userscript* on Greasemonkey/Tampermonkey, the script can be found on:
```sh
fields and attacks selection/userscript/vulnfinder.js
```
Then you have to build the *fields and attacks gathering module* which you can find in:
```sh
fields and attacks gathering/XMIGenerator
```
In order to execute the next step you must first open Eclipse Modelling Tools, then import the following modelling project:
```sh
display model/edu.udea.vulnfinder.escaneo
```
When the import is complete, open the *escaneo.genmodel* file which can be found on the project's *model* folder in the Eclipse's *Project Explorer* tab. In the Eclipse Editor, you must then right click on the *Escaneo* element and choose the *Generate All* option.

Make sure the automatic building is enabled on Eclipse, otherwise just right click the projects on the *Project Explorer* and select *Build Project*. If you don't build the projects you might face problems when trying to do the upcoming step.

Now it's time to include the grammar validation module, in order to do that, we will import into *Eclipse* the following *Xtext* projects:
```sh
model transformation/grammar validator/edu.udea.vulnfinder.gram
model transformation/grammar validator/edu.udea.vulnfinder.gram.sdk
model transformation/grammar validator/edu.udea.vulnfinder.gram.tests
model transformation/grammar validator/edu.udea.vulnfinder.gram.ui
```

Open the *SecLanguage.xtext* file which you can find on the package *edu.udea.vulnfinder.gram*. When you open it, right click on the editor, select  *Run As -> Generate Xtext Artifacts*.

If everything is going well at this point, we are ready to move on to the *Eclipse Instance*.

To launch the *Eclipse Instance*, you must either right click the *edu.udea.vulnfinder* or the *edu.udea.vulnfinder.gram* project, then select *Run As -> Eclipse Application*

The following steps must be carried out at the *Eclipse Instance* we just launched.

We will first import the *Sirius project* which will allow us to display and modify the *Graphical Model*. The project can be imported from:
```sh
display model/edu.udea.vulnfinder.design
```
Let's now import the *intermediate code generator*. It's the following *Acceleo Project*:
```sh
model transformation/intermediate code generator/edu.udea.vulnfinder.m2t
```
That was the last step, wasn't it easy? We're now ready to go!

### Running VulnFinder

So far, you only need to install the JARs into an Eclipse Modelling Tools instance ( on which you must also install Sirius in order for the Viewpoint Specification to to work)
**PENDING**



### Development

**PENDING**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [Java8]: <http://www.java.com/en/download>
   [ZAP]: <https://github.com/zaproxy/zaproxy/wiki/Downloads>
   [EMT]: <http://www.eclipse.org/downloads/packages/eclipse-modeling-tools/mars2>
   [Sirius]: <https://eclipse.org/sirius/index.html>
   [Xtext]: <https://eclipse.org/Xtext/>
   [Acceleo]: <https://eclipse.org/acceleo/>
   [Xpand]: <https://eclipse.org/modeling/m2t/?project=xpand>
   [GM]: <https://addons.mozilla.org/es/firefox/addon/greasemonkey/>
   [TM]: <https://tampermonkey.net/>
