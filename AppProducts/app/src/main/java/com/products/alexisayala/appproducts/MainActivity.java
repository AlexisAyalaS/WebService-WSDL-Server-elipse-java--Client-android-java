package com.products.alexisayala.appproducts;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import static com.products.alexisayala.appproducts.R.layout.activity_main;

public class MainActivity extends Activity {

    Context context;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(activity_main);
        Log.d("Informe","Inicio de Activity");
        new ClaseAsincrona().execute("");
        pd = ProgressDialog.show(context, "Por favor espere","Consultando Productos", true, false);
    }
    private class ClaseAsincrona extends AsyncTask<String, Void, Object> {
        protected String doInBackground(String... args) {
            Log.d("MENSAJE", "XMLParser abierto");
            String METHOD_NAME = "getDetails";
            String NAMESPACE = "http://productos/";
            String URL = "http://10.0.2.2:8080/api.productos.com/ProductsWS?WSDL";
            String SOAP_ACTION = NAMESPACE + METHOD_NAME;

            SoapObject so = new SoapObject(NAMESPACE, METHOD_NAME);
            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.bodyOut = so;
            soapEnvelope.dotNet = true;
            try {
                HttpTransportSE htse = new HttpTransportSE(URL);
                htse.call(SOAP_ACTION, soapEnvelope);
                SoapObject response = (SoapObject) soapEnvelope.bodyIn;
                int cantidad = response.getPropertyCount();
                System.out.println("********Response : " + response.toString());
                System.out.println("********Nº Productos : "+cantidad);
                for (int i = 0; i < cantidad; i++) {
                    Object propiedadRaiz = response.getProperty(i);
                    SoapObject producto = (SoapObject) propiedadRaiz;
                    String nombre = producto.getProperty("name").toString();
                    String descripcion = producto.getProperty("description").toString();
                    //String existencias = producto.getProperty("stock").toString();
                    Log.d("Nombre",nombre);
                    Log.d("Descripcion",descripcion);
                    //Log.d("Existencias:",existencias);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return null;
        }

        protected void onPostExecute(Object result) {
            Log.d("Informe","Inicio del onPostExecute");
            pd.dismiss();
            Toast.makeText(context, "Aplicacion Corriendo con Exito", Toast.LENGTH_LONG).show();
            super.onPostExecute(result);
        }
    }
}