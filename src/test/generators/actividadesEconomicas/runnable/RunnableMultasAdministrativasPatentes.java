package test.generators.actividadesEconomicas.runnable;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class RunnableMultasAdministrativasPatentes {
    public static void main(String[] args){
        XmlSuite suite = new XmlSuite();
        suite.setName("AECMultasAdministrativasPatentes");

        XmlTest test = new XmlTest(suite);
        test.setName("AECTest");

        List<XmlClass> classes = new ArrayList<XmlClass>();
        classes.add(new XmlClass("test.generators.actividadesEconomicas.multasAdministrativasPatentes.MultasAdministrativasPatentesGen"));
        test.setXmlClasses(classes);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}
