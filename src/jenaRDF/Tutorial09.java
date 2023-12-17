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

package jenaRDF ;

import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.FileManager;

import java.io.*;

/** Tutorial 9 - demonstrate graph operations
 */
public class Tutorial09 extends Object {
    
    static final String inputFileName1 = "vc-db-3.rdf";    
    static final String inputFileName2 = "vc-db-4.rdf";
    
    public static void main (String args[]) {
        // create an empty model
        Model model1 = ModelFactory.createDefaultModel();
        Model model2 = ModelFactory.createDefaultModel();
       
        try {
        	//read the RDF/XML file
	        model1.read( inputFileName1 );
	        model2.read( inputFileName2 );	        
        }
        catch (Exception e) {
			System.out.println(e.getMessage());
		}
         
        printModel(model1);
        printModel(model2);        
        
        // merge the graphs
        Model model = model1.union(model2);
        
        // print the graph as RDF/XML
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
