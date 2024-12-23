package com.example.dam_examen_sustitutorio_valdivieso;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NotaFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private NotasInteractionListener mListener;
    private List<Nota> notaList;
    private MyNotaRecyclerViewAdapter adapterNotas;


    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
                int numeroColumnas = (int) (dpWidth / 180);

                recyclerView.setLayoutManager(new StaggeredGridLayoutManager( numeroColumnas, StaggeredGridLayoutManager.VERTICAL));
            }
            notaList = new ArrayList<>();
            notaList.add(new Nota("Playas y fauna marina afectadas: lo que se sabe del derrame de petróleo de Petroperú en Talara","Un equipo de RPP llegó hasta la playa Las Capullanas, en Talara, y constató que varios animales marinos, entre ellos caballitos de mar y cangrejos, han aparecido sin vida y manchados de petróleo en las orillas del balneario norteño.\n",  true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Incremento de sueldo mínimo se conocerá antes de fin de año, asegura José Arista", "En Ampliación de Noticias, el titular del MEF indicó que se ha tomado en cuenta cuatro variables para definir el monto del nuevo sueldo mínimo, que actualmente asciende a S/ 1,025.\n",false, android.R.color.holo_green_light));
            notaList.add(new Nota("¡Ya tiene rival! Universitario se enfrentará a la Selección de Panamá en la Noche Crema 2025","Universitario se enfrentará a la Selección de Panamá en la Noche Crema 2025. Las entradas para el cotejo ya salieron a la venta.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("Dina Boluarte elogió gestión de ministro del Interior: \"Muchas veces es criticado injustamente, pero felicito su valentía\"","Durante dos actividades oficiales realizadas este lunes, la mandataria elogió la labor de Juan José Santiváñez, de quien dijo está \"haciendo cosas innovadoras\" en el Mininter. Además, dijo que su gobierno tiene \"importantes avances en seguridad ciudadana.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("El volcán Kilauea entra en erupción en Hawái con fuentes de lava de hasta 80 metros [VIDEO]","La erupción, que comenzó alrededor de las 02:20 (hora local), se produjo dentro del cráter Halema'uma'u y al poco de entrar en actividad \"se observaron fuentes de lava con alturas de hasta 80 metros", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("Me decía 'No me quiero morir': el testimonio que marcó a Christian Domínguez tras el accidente de Gran Orquesta Internacional","Christian Domínguez compartió conmovedores detalles sobre el accidente que involucró a cinco integrantes de Gran Orquesta Internacional. El cantante relató el impacto emocional de escuchar a sus compañeros expresar su miedo durante el incidente.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("¿Qué son las arritmias cardíacas y cómo reducir el riesgo de que aparezcan?","La arritmia es un trastorno del corazón que afecta el ritmo del mismo, que empieza a latir muy rápido o muy despacio, explica el doctor Elmer Huerta, consultor médico de RPP. Conoce más detalles en esta nota.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("Compromiso y respeto: conoce cómo cuidar la salud mental de los adultos mayores","¿Cómo garantizar el bienestar mental de los adultos mayores? Carla Marcos, psicóloga clínica y psicoterapeuta, ofrece valiosos consejos sobre el manejo de situaciones cruciales para su cuidado.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("¡Enfrenta el frío con calor! Estas son las 3 infusiones recomendadas para combatir el intenso frío","Jonathan Yupanqui, nutricionista de EsSalud, recomendó tres bebidas calientes ideales para aliviar síntomas inflamatorios, dolores de cabeza y posibles resfriados.", true, android.R.color.holo_orange_light));

            adapterNotas = new MyNotaRecyclerViewAdapter(notaList,mListener);
            recyclerView.setAdapter(adapterNotas);

        }
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof NotasInteractionListener){
            mListener = (NotasInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + "Debe implementarse NotasInteractionListener");
        }
    }

}