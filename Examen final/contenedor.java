class contenedor{
    float a_onzas;
    float a_capacidad;
    contenedor(){
        a_onzas=0;
    }
    boolean m_obtnDato(String p_litros){
        boolean v_bandera=false;
        try{
            a_onzas=Float.parseFloat(p_litros)*33.814f;
            a_capacidad=a_onzas;
        }catch(Exception v_error){v_bandera=true;}
        if(a_onzas<0)
            v_bandera=true;
        return v_bandera;
    }
    boolean m_rellenar(String p_litros){
        boolean v_bandera=false;
        try{
            if((Float.parseFloat(p_litros)*33.814)>a_capacidad || (Float.parseFloat(p_litros)*33.814)<0 || ((Float.parseFloat(p_litros)*33.814)+a_onzas)>a_capacidad){
                v_bandera=true;
                System.out.println("Litros no validos, favor de llenar correctamente.");
                System.out.println("Capacidad maxima: "+(a_capacidad/33.814f));
                System.out.println("Cantidad de cafe actual: "+(a_onzas/33.814f));
            }
            else{
                a_onzas+=(Float.parseFloat(p_litros)*33.814f);
            }
        }catch(Exception v_error){v_bandera=true;}
        if(a_onzas<0)
            v_bandera=true;
        return v_bandera;
    }
    float m_mostLitros(){
        return a_onzas/33.814f;
    }
}