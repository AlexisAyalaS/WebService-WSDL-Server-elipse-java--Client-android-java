package com.products.alexisayala.appproducts;

import android.provider.DocumentsContract;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by alexis on 20/06/16.
 */
public class XMLParser {
    public XMLParser() {

    }

    public String getXMLUsingSoap() {
        Log.d("MENSAJE", "XMLParser abierto");
        String xml = null;
        String METHOD_NAME = "getDetails";
        String NAMESPACE = "http://productos/";
        String URL = "http://10.0.2.2:8080/api.productos.com/ProductsWS?WSDL";
        String SOAP_ACTION = NAMESPACE + METHOD_NAME;
        /*
        Instanciamos el objeto de Soap en el cual se indican los datos del servidor
         */
        SoapObject so = new SoapObject(NAMESPACE, METHOD_NAME);
        //añadimos las propiedades que requiere el servicio web, CityName & CountryName
        //so.addProperty("CityName",ciudad);
        //wrap it in a SOAP envelope
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.bodyOut = so;
        soapEnvelope.dotNet = true;
        //listo para enviar peticion
        try {
            HttpTransportSE htse = new HttpTransportSE(URL);
            htse.call(SOAP_ACTION, soapEnvelope);
            //obtenemos la respuesta
            SoapObject response = (SoapObject) soapEnvelope.bodyIn;
            System.out.println("********Response : " + response.toString());
            //parseando el resultado
            //SoapObject firstProperty = (SoapObject) response.getProperty(3); //obtiene el la primer propiedad Anytype
            //xml = firstProperty.getProperty(2).toString(); //obtiene la segunda propiedad anytype atributo 2

            System.out.println("********Nª Productos : " + response.getPropertyCount());

            for (int i = 0; i < response.getPropertyCount(); i++) {
                //String nombre = response.getProperty("name").toString();
                //Log.d("Lista",nombre);
                Object property = response.getProperty(i);
                if (property instanceof SoapObject) {
                    SoapObject info = (SoapObject) property;
                    String nombre = info.getProperty("name").toString();
                    String descripcion = info.getProperty("description").toString();
                    Log.d("Nompre: ", nombre);
                    Log.d("Descripcion: ", descripcion);
                }//if (property instanceof SoapObject) {

            }
            Log.d("Informe", xml);


            //Log.d("Informe",firstProperty);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            xml = e.getMessage();
            Log.e("Informe", xml);
        }
        return xml;
    }
}