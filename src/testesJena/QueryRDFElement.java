/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package testesJena ;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;

import java.io.*;

/** Tutorial navigating a model
 */
public class QueryRDFElement extends Object {
    
    static final String inputFileName = "vc-db-1-latin.rdf";
   
    public static void main (String args[]) {
        Model model = ModelFactory.createDefaultModel();
       
        try {
	        model.read( inputFileName );
        }
        catch (Exception e) {
			System.out.println(e.getMessage());
		}

        
        Resource vcard = model.getResource("http://somewhere/JoseInacio");

        Resource name = (Resource) vcard.getRequiredProperty(VCARD.N)
                                        .getObject();
        String fullName = vcard.getRequiredProperty(VCARD.FN)
                               .getString();

        vcard.addProperty(VCARD.NICKNAME, "Lula")
             .addProperty(VCARD.NICKNAME, "Lulinha Paz e Amor");
        
        System.out.println("The nicknames of \"" + fullName + "\" are:");

        StmtIterator iter = vcard.listProperties(VCARD.NICKNAME);
        while (iter.hasNext()) {
            System.out.println("    " + iter.nextStatement().getObject()
                                            .toString());
        }
        
        printModel(model);
    }
    
    private static void printModel(Model model) {
		System.out.println("------------------");
		System.out.println("Arquivo em RDF/XML:");
		System.out.println("------------------");		
		RDFDataMgr.write(System.out, model, Lang.RDFXML);
		
		System.out.println("\n------------------");
		System.out.println("Arquivo em TTL:");
		System.out.println("------------------");		
		RDFDataMgr.write(System.out, model, Lang.TTL);	 
    }    
}
