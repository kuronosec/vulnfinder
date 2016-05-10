package edu.udea.vulnfinder.gram

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource$Factory$Registry
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.resource.Resource
import securityTest.Test

class MyCodeGenerator {

  def static void main(String[] args) {
    new MyCodeGenerator().generate("My.securitytest")
  }

  def generate(String file) {
  /*  doEMFSetup
    val resourceSet = new ResourceSetImpl
    val resource = resourceSet.getResource(URI.createURI(file), true)
    for (SecurityTest content : resource.allContents.filter(SecurityTest).toIterable /*resource.contents*//* ) {
      generateCode(content)
    }*/
  }

  def dispatch generateCode(Test st) '''
    public class hola {
      
    }
  '''

  def doEMFSetup() {
//    EPackage$Registry.INSTANCE.put(MyPackage.eINSTANCE.nsURI, MyPackage.eINSTANCE)
    Resource$Factory.Registry.INSTANCE.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl);
  }

}