import java.util.Scanner;
class despachadora{
    vaso a_vasos[];
    int a_vaso8, a_vaso12;
    contenedor a_contenedor;
    Scanner a_teclado;
    despachadora(){
        m_iniciar();
        do{
            if(a_contenedor.a_onzas>8){
                m_menu();
                switch(m_obtnDato()){
                    case 1:
                        if(!m_cobrar(a_vasos[0].a_precio)){
                            a_contenedor.a_onzas-=a_vasos[0].a_onza;
                            a_vaso8++;
                        }
                            break;
                    case 2:
                        if(a_contenedor.a_onzas>15){
                            if(!m_cobrar(a_vasos[1].a_precio)){
                                a_vaso12++;
                                a_contenedor.a_onzas-=a_vasos[1].a_onza;
                            }
                        }
                        else
                            System.out.println("No hay suficiente cafe");
                        break;
                    case 3:
                        System.out.println("Cantidad de litros actuales: "+a_contenedor.m_mostLitros());
                        break;
                    default:
                    System.out.println("Ha ocurrido algo, vuelva a intentar.");
                }
            }
            else{
                System.out.print("Bloqueado, ingrese password: ");
                if(m_obtnDato()==1987){
                    System.out.print("Cantidad a rellenar el contenedor: ");
                    a_contenedor.m_rellenar(a_teclado.nextLine());
                }
            }
            System.out.print("Desea salir?\n1) Si\n2) No\nOpcion: ");
        }while(m_obtnDato()!=1);
        m_mostDatoFinales();
    }
    boolean m_cobrar(float p_precio){
        boolean v_bandError=false;
        int v_cobro=0;
        do{
            System.out.print("Pago: ");
            try{
                v_cobro=Integer.parseInt(a_teclado.nextLine());
                v_bandError=(v_cobro>=p_precio)?false:true;
            }catch(Exception v_error){v_bandError=true; System.out.println("Algo a ocurrido, vuelva a intentar.");}
        }while(v_bandError);
        if(!v_bandError)
            if(v_cobro==p_precio)
                System.out.println("Gracias, vuelva pronto.");
                else{
                    System.out.println("Gracias, vuelva pronto.");
                    System.out.print("Su cambio es: ");
                v_cobro-=p_precio;
                System.out.println(v_cobro);
            }
        return v_bandError;
    }
    void m_iniciar(){
        a_vaso8=0;
        a_vaso12=0;
        a_teclado=new Scanner(System.in);
        a_vasos=new vaso[2];
        a_contenedor=new contenedor();
        int v_cont;
        for(v_cont=0;v_cont<a_vasos.length;v_cont++)
            a_vasos[v_cont]=new vaso();
        a_vasos[0].m_obtnDatos(10, 8);
        a_vasos[1].m_obtnDatos(15, 12);
        do{
            System.out.print("Litros del contenedor: ");
        }while(a_contenedor.m_obtnDato(a_teclado.nextLine()));
    }
    void m_menu(){
        System.out.println("Que vaso desea escoger?");
        System.out.println("1) 8  onzas $10");
        System.out.println("2) 12  onzas $15");
        System.out.println("3) Mostrar litros disponibles");
        System.out.print("Opcion: ");
    }
    int m_obtnDato(){
        int v_bandError=0;
        try{
            v_bandError=Integer.parseInt(a_teclado.nextLine());
        }catch(Exception v_error){v_bandError=0;}
        return v_bandError;
    }
    void m_mostDatoFinales(){
        System.out.println("Se han vendido: ");
        System.out.println(a_vaso8+" vasos de $10");
        System.out.println(a_vaso12+" vasos de $15");
        int v_dinero=(a_vaso8*10)+(a_vaso12*15);
        System.out.print("Total de dinero: "+v_dinero);
    }
}