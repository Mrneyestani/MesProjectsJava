
package fr.doranco.jaxws.soap.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "EtudiantService", targetNamespace = "http://service.jaxws.doranco.fr/", wsdlLocation = "http://localhost:9991/ws/soap/etudiant-service?wsdl")
public class EtudiantService_Service
    extends Service
{

    private final static URL ETUDIANTSERVICE_WSDL_LOCATION;
    private final static WebServiceException ETUDIANTSERVICE_EXCEPTION;
    private final static QName ETUDIANTSERVICE_QNAME = new QName("http://service.jaxws.doranco.fr/", "EtudiantService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9991/ws/soap/etudiant-service?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ETUDIANTSERVICE_WSDL_LOCATION = url;
        ETUDIANTSERVICE_EXCEPTION = e;
    }

    public EtudiantService_Service() {
        super(__getWsdlLocation(), ETUDIANTSERVICE_QNAME);
    }

    public EtudiantService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), ETUDIANTSERVICE_QNAME, features);
    }

    public EtudiantService_Service(URL wsdlLocation) {
        super(wsdlLocation, ETUDIANTSERVICE_QNAME);
    }

    public EtudiantService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ETUDIANTSERVICE_QNAME, features);
    }

    public EtudiantService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EtudiantService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EtudiantService
     */
    @WebEndpoint(name = "EtudiantPort")
    public EtudiantService getEtudiantPort() {
        return super.getPort(new QName("http://service.jaxws.doranco.fr/", "EtudiantPort"), EtudiantService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EtudiantService
     */
    @WebEndpoint(name = "EtudiantPort")
    public EtudiantService getEtudiantPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.jaxws.doranco.fr/", "EtudiantPort"), EtudiantService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ETUDIANTSERVICE_EXCEPTION!= null) {
            throw ETUDIANTSERVICE_EXCEPTION;
        }
        return ETUDIANTSERVICE_WSDL_LOCATION;
    }

}