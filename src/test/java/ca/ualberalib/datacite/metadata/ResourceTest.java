/**
 * 
 */
package ca.ualberalib.datacite.metadata;

import io.pcharoen.datacite.metadata.ObjectFactory;
import io.pcharoen.datacite.metadata.Resource;
import io.pcharoen.datacite.metadata.Resource.Creators;
import io.pcharoen.datacite.metadata.Resource.Identifier;
import io.pcharoen.datacite.metadata.Resource.Titles;
import io.pcharoen.datacite.metadata.Resource.Creators.Creator;
import io.pcharoen.datacite.metadata.Resource.Creators.Creator.NameIdentifier;
import io.pcharoen.datacite.metadata.Resource.Titles.Title;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import junit.framework.TestCase;

/**
 * @author Piyapong
 * 
 */
public class ResourceTest extends TestCase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link io.pcharoen.datacite.metadata.Resource#setIdentifier(io.pcharoen.datacite.metadata.Resource.Identifier)}
	 * .
	 */
	public void testMarshaller() {
		try {
			ObjectFactory of = new ObjectFactory();
			Resource res = of.createResource();

			Creators creators = of.createResourceCreators();
			Creator creator = of.createResourceCreatorsCreator();
			creator.setCreatorName("Piyapong");
			NameIdentifier nid = of.createResourceCreatorsCreatorNameIdentifier();
			nid.setValue("pc1405");
			creator.setNameIdentifier(nid);
			creators.getCreator().add(creator);
			res.setCreators(creators);
			
			Identifier id = of.createResourceIdentifier();
			id.setIdentifierType("DOI");
			id.setValue("10.5072/WDCC/CCSRNIES_SRES_B2");
			res.setIdentifier(id);
			
			Titles titles = of.createResourceTitles();
			Title title = of.createResourceTitlesTitle();
			title.setValue("National Institute for Environmental Studies and Center for Climate System Research Japan");
			titles.getTitle().add(title);
			res.setTitles(titles);

			res.setPublicationYear("2014");
			res.setPublisher("Piyapong");
			
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Resource.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(res, System.out);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
