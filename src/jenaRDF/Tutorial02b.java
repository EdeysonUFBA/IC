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
import org.apache.jena.vocabulary.*;

/** Tutorial 2 resources as property values
 */
public class Tutorial02b extends Object {

	public static void main (String args[]) {
		Model model = ModelFactory.createDefaultModel();

		Person josé = new Person("José", "Assunção", "http://somewhere/JoseAssuncao");
		String fullName = josé.getFirstName() + " " + josé.getFamilyName();

		Resource resource = model.createResource(josé.getUri())
				.addProperty(VCARD.FN, fullName)
				.addProperty(VCARD.N, 
						model.createResource()
						.addProperty(VCARD.Given, josé.getFirstName())
						.addProperty(VCARD.Family, josé.getFamilyName()));

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
