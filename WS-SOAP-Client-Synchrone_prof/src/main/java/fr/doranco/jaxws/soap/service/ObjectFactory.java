
package fr.doranco.jaxws.soap.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.doranco.jaxws.soap.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Exception_QNAME = new QName("http://service.jaxws.doranco.fr/", "Exception");
    private final static QName _GetCoursResponse_QNAME = new QName("http://service.jaxws.doranco.fr/", "getCoursResponse");
    private final static QName _GetCoursByIdResponse_QNAME = new QName("http://service.jaxws.doranco.fr/", "getCoursByIdResponse");
    private final static QName _GetCoursById_QNAME = new QName("http://service.jaxws.doranco.fr/", "getCoursById");
    private final static QName _GetCours_QNAME = new QName("http://service.jaxws.doranco.fr/", "getCours");
    private final static QName _AddCours_QNAME = new QName("http://service.jaxws.doranco.fr/", "addCours");
    private final static QName _AddCoursResponse_QNAME = new QName("http://service.jaxws.doranco.fr/", "addCoursResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.doranco.jaxws.soap.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCours }
     * 
     */
    public GetCours createGetCours() {
        return new GetCours();
    }

    /**
     * Create an instance of {@link AddCoursResponse }
     * 
     */
    public AddCoursResponse createAddCoursResponse() {
        return new AddCoursResponse();
    }

    /**
     * Create an instance of {@link AddCours }
     * 
     */
    public AddCours createAddCours() {
        return new AddCours();
    }

    /**
     * Create an instance of {@link GetCoursByIdResponse }
     * 
     */
    public GetCoursByIdResponse createGetCoursByIdResponse() {
        return new GetCoursByIdResponse();
    }

    /**
     * Create an instance of {@link GetCoursById }
     * 
     */
    public GetCoursById createGetCoursById() {
        return new GetCoursById();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link GetCoursResponse }
     * 
     */
    public GetCoursResponse createGetCoursResponse() {
        return new GetCoursResponse();
    }

    /**
     * Create an instance of {@link Cours }
     * 
     */
    public Cours createCours() {
        return new Cours();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.doranco.fr/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCoursResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.doranco.fr/", name = "getCoursResponse")
    public JAXBElement<GetCoursResponse> createGetCoursResponse(GetCoursResponse value) {
        return new JAXBElement<GetCoursResponse>(_GetCoursResponse_QNAME, GetCoursResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCoursByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.doranco.fr/", name = "getCoursByIdResponse")
    public JAXBElement<GetCoursByIdResponse> createGetCoursByIdResponse(GetCoursByIdResponse value) {
        return new JAXBElement<GetCoursByIdResponse>(_GetCoursByIdResponse_QNAME, GetCoursByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCoursById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.doranco.fr/", name = "getCoursById")
    public JAXBElement<GetCoursById> createGetCoursById(GetCoursById value) {
        return new JAXBElement<GetCoursById>(_GetCoursById_QNAME, GetCoursById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCours }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.doranco.fr/", name = "getCours")
    public JAXBElement<GetCours> createGetCours(GetCours value) {
        return new JAXBElement<GetCours>(_GetCours_QNAME, GetCours.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCours }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.doranco.fr/", name = "addCours")
    public JAXBElement<AddCours> createAddCours(AddCours value) {
        return new JAXBElement<AddCours>(_AddCours_QNAME, AddCours.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCoursResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.jaxws.doranco.fr/", name = "addCoursResponse")
    public JAXBElement<AddCoursResponse> createAddCoursResponse(AddCoursResponse value) {
        return new JAXBElement<AddCoursResponse>(_AddCoursResponse_QNAME, AddCoursResponse.class, null, value);
    }

}
