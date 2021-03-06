
/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:



Copyright (c) 2001-2004 World Wide Web Consortium, 
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University).  All 
Rights Reserved.  This program is distributed under the W3C's Software
Intellectual Property License.  This program is distributed in the 
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR 
PURPOSE.  

See W3C License http://www.w3.org/Consortium/Legal/ for more details.


*/

package org.w3c.domts.level2.core;

import org.w3c.dom.*;


import org.w3c.domts.DOMTestCase;
import org.w3c.domts.DOMTestDocumentBuilderFactory;



/**
 *  The importNode method imports a node from another document to this document. 
 *  The returned node has no parent; (parentNode is null). The source node is not 
 *  altered or removed from the original document but a new copy of the source node
 *  is created.
 *  
 *  Using the method importNode with deep=true/false, import two notaiton nodes into the 
 *  same and different documnet objects.  In each case check if valid public and systemids 
 *  are returned if any and if none, check if a null value was returned.
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
public final class documentimportnode22 extends DOMTestCase {

   /**
    * Constructor.
    * @param factory document factory, may not be null
    * @throws org.w3c.domts.DOMTestIncompatibleException Thrown if test is not compatible with parser configuration
    */
   public documentimportnode22(final DOMTestDocumentBuilderFactory factory)  throws org.w3c.domts.DOMTestIncompatibleException {

      org.w3c.domts.DocumentBuilderSetting[] settings = 
          new org.w3c.domts.DocumentBuilderSetting[] {
org.w3c.domts.DocumentBuilderSetting.namespaceAware
        };
        DOMTestDocumentBuilderFactory testFactory = factory.newInstance(settings);
        setFactory(testFactory);

    //
    //   check if loaded documents are supported for content type
    //
    String contentType = getContentType();
    preload(contentType, "staffNS", true);
    }

   /**
    * Runs the test case.
    * @throws Throwable Any uncaught exception causes test to fail
    */
   public void runTest() throws Throwable {
      Document doc;
      DocumentType docTypeNull = null;

      Document docImp;
      DOMImplementation domImpl;
      DocumentType docType;
      NamedNodeMap nodeMap;
      Notation notation1;
      Notation notation2;
      Notation notationImp1;
      Notation notationImp2;
      Notation notationImpNew1;
      Notation notationImpNew2;
      String publicId1;
      String publicId1Imp;
      String publicId1NewImp;
      String publicId2Imp;
      String publicId2NewImp;
      String systemId1Imp;
      String systemId1NewImp;
      String systemId2;
      String systemId2Imp;
      String systemId2NewImp;
      doc = (Document) load("staffNS", true);
      domImpl = doc.getImplementation();
      docType = doc.getDoctype();
      docImp = domImpl.createDocument("http://www.w3.org/DOM/Test", "a:b", docTypeNull);
      nodeMap = docType.getNotations();
      assertNotNull("notationsNotNull", nodeMap);
      notation1 = (Notation) nodeMap.getNamedItem("notation1");
      notation2 = (Notation) nodeMap.getNamedItem("notation2");
      notationImp1 = (Notation) doc.importNode(notation1, true);
      notationImp2 = (Notation) doc.importNode(notation2, false);
      notationImpNew1 = (Notation) docImp.importNode(notation1, false);
      notationImpNew2 = (Notation) docImp.importNode(notation2, true);
      publicId1 = notation1.getPublicId();
      publicId1Imp = notation1.getPublicId();
      publicId1NewImp = notation1.getPublicId();
      systemId1Imp = notation1.getSystemId();
      systemId1NewImp = notation1.getSystemId();
      publicId2Imp = notation2.getPublicId();
      publicId2NewImp = notation2.getPublicId();
      systemId2 = notation2.getSystemId();
      systemId2Imp = notation2.getSystemId();
      systemId2NewImp = notation2.getSystemId();
      assertEquals("documentimportnode22_N1PID", publicId1, publicId1Imp);
      assertEquals("documentimportnode22_N1NPID", publicId1, publicId1NewImp);
      assertNull("documentimportnode22_N1SID", systemId1Imp);
      assertNull("documentimportnode22_N1NSID", systemId1NewImp);
      assertEquals("documentimportnode22_N2SID", systemId2, systemId2Imp);
      assertEquals("documentimportnode22_N2NSID", systemId2, systemId2NewImp);
      assertNull("documentimportnode22_N2PID", publicId2Imp);
      assertNull("documentimportnode22_N2NPID", publicId2Imp);
      }
   /**
    *  Gets URI that identifies the test.
    *  @return uri identifier of test
    */
   public String getTargetURI() {
      return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/documentimportnode22";
   }
   /**
    * Runs this test from the command line.
    * @param args command line arguments
    */
   public static void main(final String[] args) {
        DOMTestCase.doMain(documentimportnode22.class, args);
   }
}

