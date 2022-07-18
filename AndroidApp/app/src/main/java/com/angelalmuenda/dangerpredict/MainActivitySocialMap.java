package com.angelalmuenda.dangerpredict;

import android.graphics.Color;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import android.content.Context;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.ArrayList;

public class MainActivitySocialMap {

    public static LatLng startPoint = new LatLng(7.443533, 125.800278);
    public static final CameraPosition TAGUM =
            new CameraPosition.Builder().target(new LatLng(7.443533, 125.800278))
                                        .zoom(11.0f)
                                        .bearing(0)
                                        .tilt(0)
                                        .build();
    public static final CameraPosition PANABO =
            new CameraPosition.Builder().target(new LatLng(7.32160, 125.602399))
                                        .zoom(11.0f)
                                        .bearing(0)
                                        .tilt(0)
                                        .build();
    public static final CameraPosition SAMAL =
            new CameraPosition.Builder().target(new LatLng(7.03813, 125.754262))
                                        .zoom(11.0f)
                                        .bearing(0)
                                        .tilt(0)
                                        .build();

    public Button clickButtonTagum;
    public Button clickButtonPanabo;
    public Button clickButtonSamal;

    int boundaryColor = Color.rgb(138, 43, 226);
    float boundaryWidth = 2.0f;
    public String selectedLocation;

    ArrayList<LatLng> PanaboCity_AOFloirendo = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Buenavista = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Cacao = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Cagangohan = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Consolacion = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Dapco = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_DatuAbdulDadia = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Gredu = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_JPLaurel = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Kasilak = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Katipunan = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Katualan = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Kauswagan = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Kiotoy = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_LittlePanay = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_LowerPanaga = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Mabunao = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Maduao = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Malativas = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Manay = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Nanyo = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_NewMalaga = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_NewMalitbog = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_NewPandan = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_NewVisayas = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Quezon = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Salvacion = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_SanFrancisco = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_SanNicolas = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_SanPedro = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_SanRoque = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_SanVicente = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_SantaCruz = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_SantoNino = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Sindaton = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_SouthernDavao = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Tagpore = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Tibungol = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_UpperLicanan = new ArrayList<LatLng>();
    ArrayList<LatLng> PanaboCity_Waterfall = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Adecor1 = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Adecor2 = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Anonang = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Aumbay = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Aundanao = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Balet1 = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Balet2 = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Balet3 = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Bandera = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Caliclic = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Camudmud = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Catagman = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Cawag = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Cogon1 = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Cogon2 = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Dadatan = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_DelMonte = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Guilon = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Kanaan = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Kinawitnon = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Libertad = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Libuak = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Licup = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Limao = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Linosutan = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_MambagoA = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_MambagoB = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Miranda = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Moncado = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Pangubatan = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Penaplata = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Poblacion = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_SanAgustin = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_SanAntonio = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_SanIsidro1 = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_SanIsidro2 = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_SanJose = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_SanMiguel = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_SanRemigio = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_SantaCruz = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_SantoNino = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Sion = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Tagbaobo = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Tagbay = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_TagbitanAg = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Tagdaliao = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Tagpopongan = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Tambo1 = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Tambo2 = new ArrayList<LatLng>();
    ArrayList<LatLng> SamalCity_Toril = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_Apokon = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_Bincungan = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_Busaon = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_Canocotan = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_Cuambogan = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_LaFilipina = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_Liboganon = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_Madaum1 = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_Madaum2 = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_Magdum = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_MagugpoEast = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_MagugpoNorth = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_MagugpoPoblacion = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_MagugpoSouth = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_MagugpoWest = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_Mankilam = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_NewBalamban = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_NuevaFuerza = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_Pagsabangan = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_Pandapan = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_SanAgustin = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_SanIsidro = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_SanMiguel = new ArrayList<LatLng>();
    ArrayList<LatLng> TagumCity_VisayanVillage = new ArrayList<LatLng>();

    public void addPolylines(GoogleMap map, Context context) {

        try {
            Properties prop = AssetPropertyReader.getPolylineProperty(context);
            for (Map.Entry<Object, Object> entry : prop.entrySet()) {
                getLatLng(entry.getKey().toString(), entry.getValue().toString(), map);
            }
        }
        catch (IOException e){

        }
    }

    private void getLatLng(String barangay, String polylines, GoogleMap map) {
        switch (barangay) {
            case "PanaboCity_AOFloirendo":
                addPolylinesToMap(PanaboCity_AOFloirendo, polylines, map);
                break;
            case "PanaboCity_Buenavista":
                addPolylinesToMap(PanaboCity_Buenavista, polylines, map);
                break;
            case "PanaboCity_Cacao":
                addPolylinesToMap(PanaboCity_Cacao, polylines, map);
                break;
            case "PanaboCity_Cagangohan":
                addPolylinesToMap(PanaboCity_Cagangohan, polylines, map);
                break;
            case "PanaboCity_Consolacion":
                addPolylinesToMap(PanaboCity_Consolacion, polylines, map);
                break;
            case "PanaboCity_Dapco":
                addPolylinesToMap(PanaboCity_Dapco, polylines, map);
                break;
            case "PanaboCity_DatuAbdulDadia":
                addPolylinesToMap(PanaboCity_DatuAbdulDadia, polylines, map);
                break;
            case "PanaboCity_Gredu":
                addPolylinesToMap(PanaboCity_Gredu, polylines, map);
                break;
            case "PanaboCity_JPLaurel":
                addPolylinesToMap(PanaboCity_JPLaurel, polylines, map);
                break;
            case "PanaboCity_Kasilak":
                addPolylinesToMap(PanaboCity_Kasilak, polylines, map);
                break;
            case "PanaboCity_Katipunan":
                addPolylinesToMap(PanaboCity_Katipunan, polylines, map);
                break;
            case "PanaboCity_Katualan":
                addPolylinesToMap(PanaboCity_Katualan, polylines, map);
                break;
            case "PanaboCity_Kauswagan":
                addPolylinesToMap(PanaboCity_Kauswagan, polylines, map);
                break;
            case "PanaboCity_Kiotoy":
                addPolylinesToMap(PanaboCity_Kiotoy, polylines, map);
                break;
            case "PanaboCity_LittlePanay":
                addPolylinesToMap(PanaboCity_LittlePanay, polylines, map);
                break;
            case "PanaboCity_LowerPanaga":
                addPolylinesToMap(PanaboCity_LowerPanaga, polylines, map);
                break;
            case "PanaboCity_Mabunao":
                addPolylinesToMap(PanaboCity_Mabunao, polylines, map);
                break;
            case "PanaboCity_Maduao":
                addPolylinesToMap(PanaboCity_Maduao, polylines, map);
                break;
            case "PanaboCity_Malativas":
                addPolylinesToMap(PanaboCity_Malativas, polylines, map);
                break;
            case "PanaboCity_Manay":
                addPolylinesToMap(PanaboCity_Manay, polylines, map);
                break;
            case "PanaboCity_Nanyo":
                addPolylinesToMap(PanaboCity_Nanyo, polylines, map);
                break;
            case "PanaboCity_NewMalaga":
                addPolylinesToMap(PanaboCity_NewMalaga, polylines, map);
                break;
            case "PanaboCity_NewMalitbog":
                addPolylinesToMap(PanaboCity_NewMalitbog, polylines, map);
                break;
            case "PanaboCity_NewPandan":
                addPolylinesToMap(PanaboCity_NewPandan, polylines, map);
                break;
            case "PanaboCity_NewVisayas":
                addPolylinesToMap(PanaboCity_NewVisayas, polylines, map);
                break;
            case "PanaboCity_Quezon":
                addPolylinesToMap(PanaboCity_Quezon, polylines, map);
                break;
            case "PanaboCity_Salvacion":
                addPolylinesToMap(PanaboCity_Salvacion, polylines, map);
                break;
            case "PanaboCity_SanFrancisco":
                addPolylinesToMap(PanaboCity_SanFrancisco, polylines, map);
                break;
            case "PanaboCity_SanNicolas":
                addPolylinesToMap(PanaboCity_SanNicolas, polylines, map);
                break;
            case "PanaboCity_SanPedro":
                addPolylinesToMap(PanaboCity_SanPedro, polylines, map);
                break;
            case "PanaboCity_SanRoque":
                addPolylinesToMap(PanaboCity_SanRoque, polylines, map);
                break;
            case "PanaboCity_SanVicente":
                addPolylinesToMap(PanaboCity_SanVicente, polylines, map);
                break;
            case "PanaboCity_SantaCruz":
                addPolylinesToMap(PanaboCity_SantaCruz, polylines, map);
                break;
            case "PanaboCity_SantoNino":
                addPolylinesToMap(PanaboCity_SantoNino, polylines, map);
                break;
            case "PanaboCity_Sindaton":
                addPolylinesToMap(PanaboCity_Sindaton, polylines, map);
                break;
            case "PanaboCity_SouthernDavao":
                addPolylinesToMap(PanaboCity_SouthernDavao, polylines, map);
                break;
            case "PanaboCity_Tagpore":
                addPolylinesToMap(PanaboCity_Tagpore, polylines, map);
                break;
            case "PanaboCity_Tibungol":
                addPolylinesToMap(PanaboCity_Tibungol, polylines, map);
                break;
            case "PanaboCity_UpperLicanan":
                addPolylinesToMap(PanaboCity_UpperLicanan, polylines, map);
                break;
            case "PanaboCity_Waterfall":
                addPolylinesToMap(PanaboCity_Waterfall, polylines, map);
                break;
            case "SamalCity_Adecor1":
                addPolylinesToMap(SamalCity_Adecor1, polylines, map);
                break;
            case "SamalCity_Adecor2":
                addPolylinesToMap(SamalCity_Adecor2, polylines, map);
                break;
            case "SamalCity_Anonang":
                addPolylinesToMap(SamalCity_Anonang, polylines, map);
                break;
            case "SamalCity_Aumbay":
                addPolylinesToMap(SamalCity_Aumbay, polylines, map);
                break;
            case "SamalCity_Aundanao":
                addPolylinesToMap(SamalCity_Aundanao, polylines, map);
                break;
            case "SamalCity_Balet1":
                addPolylinesToMap(SamalCity_Balet1, polylines, map);
                break;
            case "SamalCity_Balet2":
                addPolylinesToMap(SamalCity_Balet2, polylines, map);
                break;
            case "SamalCity_Balet3":
                addPolylinesToMap(SamalCity_Balet3, polylines, map);
                break;
            case "SamalCity_Bandera":
                addPolylinesToMap(SamalCity_Bandera, polylines, map);
                break;
            case "SamalCity_Caliclic":
                addPolylinesToMap(SamalCity_Caliclic, polylines, map);
                break;
            case "SamalCity_Camudmud":
                addPolylinesToMap(SamalCity_Camudmud, polylines, map);
                break;
            case "SamalCity_Catagman":
                addPolylinesToMap(SamalCity_Catagman, polylines, map);
                break;
            case "SamalCity_Cawag":
                addPolylinesToMap(SamalCity_Cawag, polylines, map);
                break;
            case "SamalCity_Cogon1":
                addPolylinesToMap(SamalCity_Cogon1, polylines, map);
                break;
            case "SamalCity_Cogon2":
                addPolylinesToMap(SamalCity_Cogon2, polylines, map);
                break;
            case "SamalCity_Dadatan":
                addPolylinesToMap(SamalCity_Dadatan, polylines, map);
                break;
            case "SamalCity_DelMonte":
                addPolylinesToMap(SamalCity_DelMonte, polylines, map);
                break;
            case "SamalCity_Guilon":
                addPolylinesToMap(SamalCity_Guilon, polylines, map);
                break;
            case "SamalCity_Kanaan":
                addPolylinesToMap(SamalCity_Kanaan, polylines, map);
                break;
            case "SamalCity_Kinawitnon":
                addPolylinesToMap(SamalCity_Kinawitnon, polylines, map);
                break;
            case "SamalCity_Libertad":
                addPolylinesToMap(SamalCity_Libertad, polylines, map);
                break;
            case "SamalCity_Libuak":
                addPolylinesToMap(SamalCity_Libuak, polylines, map);
                break;
            case "SamalCity_Licup":
                addPolylinesToMap(SamalCity_Licup, polylines, map);
                break;
            case "SamalCity_Limao":
                addPolylinesToMap(SamalCity_Limao, polylines, map);
                break;
            case "SamalCity_Linosutan":
                addPolylinesToMap(SamalCity_Linosutan, polylines, map);
                break;
            case "SamalCity_MambagoA":
                addPolylinesToMap(SamalCity_MambagoA, polylines, map);
                break;
            case "SamalCity_MambagoB":
                addPolylinesToMap(SamalCity_MambagoB, polylines, map);
                break;
            case "SamalCity_Miranda":
                addPolylinesToMap(SamalCity_Miranda, polylines, map);
                break;
            case "SamalCity_Moncado":
                addPolylinesToMap(SamalCity_Moncado, polylines, map);
                break;
            case "SamalCity_Pangubatan":
                addPolylinesToMap(SamalCity_Pangubatan, polylines, map);
                break;
            case "SamalCity_Penaplata":
                addPolylinesToMap(SamalCity_Penaplata, polylines, map);
                break;
            case "SamalCity_Poblacion":
                addPolylinesToMap(SamalCity_Poblacion, polylines, map);
                break;
            case "SamalCity_SanAgustin":
                addPolylinesToMap(SamalCity_SanAgustin, polylines, map);
                break;
            case "SamalCity_SanAntonio":
                addPolylinesToMap(SamalCity_SanAntonio, polylines, map);
                break;
            case "SamalCity_SanIsidro1":
                addPolylinesToMap(SamalCity_SanIsidro1, polylines, map);
                break;
            case "SamalCity_SanIsidro2":
                addPolylinesToMap(SamalCity_SanIsidro2, polylines, map);
                break;
            case "SamalCity_SanJose":
                addPolylinesToMap(SamalCity_SanJose, polylines, map);
                break;
            case "SamalCity_SanMiguel":
                addPolylinesToMap(SamalCity_SanMiguel, polylines, map);
                break;
            case "SamalCity_SanRemigio":
                addPolylinesToMap(SamalCity_SanRemigio, polylines, map);
                break;
            case "SamalCity_SantaCruz":
                addPolylinesToMap(SamalCity_SantaCruz, polylines, map);
                break;
            case "SamalCity_SantoNino":
                addPolylinesToMap(SamalCity_SantoNino, polylines, map);
                break;
            case "SamalCity_Sion":
                addPolylinesToMap(SamalCity_Sion, polylines, map);
                break;
            case "SamalCity_Tagbaobo":
                addPolylinesToMap(SamalCity_Tagbaobo, polylines, map);
                break;
            case "SamalCity_Tagbay":
                addPolylinesToMap(SamalCity_Tagbay, polylines, map);
                break;
            case "SamalCity_TagbitanAg":
                addPolylinesToMap(SamalCity_TagbitanAg, polylines, map);
                break;
            case "SamalCity_Tagdaliao":
                addPolylinesToMap(SamalCity_Tagdaliao, polylines, map);
                break;
            case "SamalCity_Tagpopongan":
                addPolylinesToMap(SamalCity_Tagpopongan, polylines, map);
                break;
            case "SamalCity_Tambo1":
                addPolylinesToMap(SamalCity_Tambo1, polylines, map);
                break;
            case "SamalCity_Tambo2":
                addPolylinesToMap(SamalCity_Tambo2, polylines, map);
                break;
            case "SamalCity_Toril":
                addPolylinesToMap(SamalCity_Toril, polylines, map);
                break;
            case "TagumCity_Apokon":
                addPolylinesToMap(TagumCity_Apokon, polylines, map);
                break;
            case "TagumCity_Bincungan":
                addPolylinesToMap(TagumCity_Bincungan, polylines, map);
                break;
            case "TagumCity_Busaon":
                addPolylinesToMap(TagumCity_Busaon, polylines, map);
                break;
            case "TagumCity_Canocotan":
                addPolylinesToMap(TagumCity_Canocotan, polylines, map);
                break;
            case "TagumCity_Cuambogan":
                addPolylinesToMap(TagumCity_Cuambogan, polylines, map);
                break;
            case "TagumCity_LaFilipina":
                addPolylinesToMap(TagumCity_LaFilipina, polylines, map);
                break;
            case "TagumCity_Liboganon":
                addPolylinesToMap(TagumCity_Liboganon, polylines, map);
                break;
            case "TagumCity_Madaum1":
                addPolylinesToMap(TagumCity_Madaum1, polylines, map);
                break;
            case "TagumCity_Madaum2":
                addPolylinesToMap(TagumCity_Madaum2, polylines, map);
                break;
            case "TagumCity_Magdum":
                addPolylinesToMap(TagumCity_Magdum, polylines, map);
                break;
            case "TagumCity_MagugpoEast":
                addPolylinesToMap(TagumCity_MagugpoEast, polylines, map);
                break;
            case "TagumCity_MagugpoNorth":
                addPolylinesToMap(TagumCity_MagugpoNorth, polylines, map);
                break;
            case "TagumCity_MagugpoPoblacion":
                addPolylinesToMap(TagumCity_MagugpoPoblacion, polylines, map);
                break;
            case "TagumCity_MagugpoSouth":
                addPolylinesToMap(TagumCity_MagugpoSouth, polylines, map);
                break;
            case "TagumCity_MagugpoWest":
                addPolylinesToMap(TagumCity_MagugpoWest, polylines, map);
                break;
            case "TagumCity_Mankilam":
                addPolylinesToMap(TagumCity_Mankilam, polylines, map);
                break;
            case "TagumCity_NewBalamban":
                addPolylinesToMap(TagumCity_NewBalamban, polylines, map);
                break;
            case "TagumCity_NuevaFuerza":
                addPolylinesToMap(TagumCity_NuevaFuerza, polylines, map);
                break;
            case "TagumCity_Pagsabangan":
                addPolylinesToMap(TagumCity_Pagsabangan, polylines, map);
                break;
            case "TagumCity_Pandapan":
                addPolylinesToMap(TagumCity_Pandapan, polylines, map);
                break;
            case "TagumCity_SanAgustin":
                addPolylinesToMap(TagumCity_SanAgustin, polylines, map);
                break;
            case "TagumCity_SanIsidro":
                addPolylinesToMap(TagumCity_SanIsidro, polylines, map);
                break;
            case "TagumCity_SanMiguel":
                addPolylinesToMap(TagumCity_SanMiguel, polylines, map);
                break;
            case "TagumCity_VisayanVillage":
                addPolylinesToMap(TagumCity_VisayanVillage, polylines, map);
                break;
        }
    }

    private void addPolylinesToMap(ArrayList<LatLng> barangay, String polylines, GoogleMap map) {

        polylines = polylines.replace("], [", "-");
        polylines = polylines.replace("[[", "");
        polylines = polylines.replace("]]", "");
        polylines = polylines.replace(" ", "");
        String[] latLngStr = polylines.split("-");

        for (String s: latLngStr) {
            String[] latLngArray =  s.split(",");
            double latitude = Double.parseDouble(latLngArray[1]);
            double longitude = Double.parseDouble(latLngArray[0]);
            LatLng location = new LatLng(latitude, longitude);
            barangay.add(location);
        }

        map.addPolyline(new PolylineOptions()
                .color(boundaryColor)
                .width(boundaryWidth)
                .addAll(barangay));
    }

    public void checkMarkerLocation(LatLng point, MarkerOptions markerOptions, Context context) {

        if (PolyUtil.containsLocation(point,PanaboCity_AOFloirendo,false)) {
            selectedLocation = "PanaboCity_AOFloirendo";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Buenavista,false)) {
            selectedLocation = "PanaboCity_Buenavista";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Cacao,false)) {
            selectedLocation = "PanaboCity_Cacao";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Cagangohan,false)) {
            selectedLocation = "PanaboCity_Cagangohan";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Consolacion,false)) {
            selectedLocation = "PanaboCity_Consolacion";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Dapco,false)) {
            selectedLocation = "PanaboCity_Dapco";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_DatuAbdulDadia,false)) {
            selectedLocation = "PanaboCity_DatuAbdulDadia";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Gredu,false)) {
            selectedLocation = "PanaboCity_Gredu";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_JPLaurel,false)) {
            selectedLocation = "PanaboCity_JPLaurel";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Kasilak,false)) {
            selectedLocation = "PanaboCity_Kasilak";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Katipunan,false)) {
            selectedLocation = "PanaboCity_Katipunan";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Katualan,false)) {
            selectedLocation = "PanaboCity_Katualan";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Kauswagan,false)) {
            selectedLocation = "PanaboCity_Kauswagan";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Kiotoy,false)) {
            selectedLocation = "PanaboCity_Kiotoy";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_LittlePanay,false)) {
            selectedLocation = "PanaboCity_LittlePanay";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_LowerPanaga,false)) {
            selectedLocation = "PanaboCity_LowerPanaga";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Mabunao,false)) {
            selectedLocation = "PanaboCity_Mabunao";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Maduao,false)) {
            selectedLocation = "PanaboCity_Maduao";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Malativas,false)) {
            selectedLocation = "PanaboCity_Malativas";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Manay,false)) {
            selectedLocation = "PanaboCity_Manay";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Nanyo,false)) {
            selectedLocation = "PanaboCity_Nanyo";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_NewMalaga,false)) {
            selectedLocation = "PanaboCity_NewMalaga";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_NewMalitbog,false)) {
            selectedLocation = "PanaboCity_NewMalitbog";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_NewPandan,false)) {
            selectedLocation = "PanaboCity_NewPandan";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_NewVisayas,false)) {
            selectedLocation = "PanaboCity_NewVisayas";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Quezon,false)) {
            selectedLocation = "PanaboCity_Quezon";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Salvacion,false)) {
            selectedLocation = "PanaboCity_Salvacion";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_SanFrancisco,false)) {
            selectedLocation = "PanaboCity_SanFrancisco";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_SanNicolas,false)) {
            selectedLocation = "PanaboCity_SanNicolas";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_SanPedro,false)) {
            selectedLocation = "PanaboCity_SanPedro";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_SanRoque,false)) {
            selectedLocation = "PanaboCity_SanRoque";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_SanVicente,false)) {
            selectedLocation = "PanaboCity_SanVicente";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_SantaCruz,false)) {
            selectedLocation = "PanaboCity_SantaCruz";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_SantoNino,false)) {
            selectedLocation = "PanaboCity_SantoNino";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Sindaton,false)) {
            selectedLocation = "PanaboCity_Sindaton";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_SouthernDavao,false)) {
            selectedLocation = "PanaboCity_SouthernDavao";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Tagpore,false)) {
            selectedLocation = "PanaboCity_Tagpore";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Tibungol,false)) {
            selectedLocation = "PanaboCity_Tibungol";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_UpperLicanan,false)) {
            selectedLocation = "PanaboCity_UpperLicanan";
        }
        else if (PolyUtil.containsLocation(point,PanaboCity_Waterfall,false)) {
            selectedLocation = "PanaboCity_Waterfall";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Adecor1,false)) {
            selectedLocation = "SamalCity_Adecor1";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Adecor2,false)) {
            selectedLocation = "SamalCity_Adecor2";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Anonang,false)) {
            selectedLocation = "SamalCity_Anonang";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Aumbay,false)) {
            selectedLocation = "SamalCity_Aumbay";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Aundanao,false)) {
            selectedLocation = "SamalCity_Aundanao";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Balet1,false)) {
            selectedLocation = "SamalCity_Balet1";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Balet2,false)) {
            selectedLocation = "SamalCity_Balet2";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Balet3,false)) {
            selectedLocation = "SamalCity_Balet3";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Bandera,false)) {
            selectedLocation = "SamalCity_Bandera";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Caliclic,false)) {
            selectedLocation = "SamalCity_Caliclic";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Camudmud,false)) {
            selectedLocation = "SamalCity_Camudmud";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Catagman,false)) {
            selectedLocation = "SamalCity_Catagman";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Cawag,false)) {
            selectedLocation = "SamalCity_Cawag";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Cogon1,false)) {
            selectedLocation = "SamalCity_Cogon1";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Cogon2,false)) {
            selectedLocation = "SamalCity_Cogon2";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Dadatan,false)) {
            selectedLocation = "SamalCity_Dadatan";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_DelMonte,false)) {
            selectedLocation = "SamalCity_DelMonte";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Guilon,false)) {
            selectedLocation = "SamalCity_Guilon";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Kanaan,false)) {
            selectedLocation = "SamalCity_Kanaan";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Kinawitnon,false)) {
            selectedLocation = "SamalCity_Kinawitnon";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Libertad,false)) {
            selectedLocation = "SamalCity_Libertad";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Libuak,false)) {
            selectedLocation = "SamalCity_Libuak";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Licup,false)) {
            selectedLocation = "SamalCity_Licup";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Limao,false)) {
            selectedLocation = "SamalCity_Limao";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Linosutan,false)) {
            selectedLocation = "SamalCity_Linosutan";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_MambagoA,false)) {
            selectedLocation = "SamalCity_MambagoA";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_MambagoB,false)) {
            selectedLocation = "SamalCity_MambagoB";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Miranda,false)) {
            selectedLocation = "SamalCity_Miranda";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Moncado,false)) {
            selectedLocation = "SamalCity_Moncado";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Pangubatan,false)) {
            selectedLocation = "SamalCity_Pangubatan";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Penaplata,false)) {
            selectedLocation = "SamalCity_Penaplata";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Poblacion,false)) {
            selectedLocation = "SamalCity_Poblacion";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_SanAgustin,false)) {
            selectedLocation = "SamalCity_SanAgustin";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_SanAntonio,false)) {
            selectedLocation = "SamalCity_SanAntonio";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_SanIsidro1,false)) {
            selectedLocation = "SamalCity_SanIsidro1";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_SanIsidro2,false)) {
            selectedLocation = "SamalCity_SanIsidro2";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_SanJose,false)) {
            selectedLocation = "SamalCity_SanJose";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_SanMiguel,false)) {
            selectedLocation = "SamalCity_SanMiguel";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_SanRemigio,false)) {
            selectedLocation = "SamalCity_SanRemigio";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_SantaCruz,false)) {
            selectedLocation = "SamalCity_SantaCruz";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_SantoNino,false)) {
            selectedLocation = "SamalCity_SantoNino";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Sion,false)) {
            selectedLocation = "SamalCity_Sion";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Tagbaobo,false)) {
            selectedLocation = "SamalCity_Tagbaobo";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Tagbay,false)) {
            selectedLocation = "SamalCity_Tagbay";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_TagbitanAg,false)) {
            selectedLocation = "SamalCity_TagbitanAg";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Tagdaliao,false)) {
            selectedLocation = "SamalCity_Tagdaliao";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Tagpopongan,false)) {
            selectedLocation = "SamalCity_Tagpopongan";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Tambo1,false)) {
            selectedLocation = "SamalCity_Tambo1";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Tambo2,false)) {
            selectedLocation = "SamalCity_Tambo2";
        }
        else if (PolyUtil.containsLocation(point,SamalCity_Toril,false)) {
            selectedLocation = "SamalCity_Toril";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_Apokon,false)) {
            selectedLocation = "TagumCity_Apokon";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_Bincungan,false)) {
            selectedLocation = "TagumCity_Bincungan";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_Busaon,false)) {
            selectedLocation = "TagumCity_Busaon";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_Canocotan,false)) {
            selectedLocation = "TagumCity_Canocotan";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_Cuambogan,false)) {
            selectedLocation = "TagumCity_Cuambogan";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_LaFilipina,false)) {
            selectedLocation = "TagumCity_LaFilipina";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_Liboganon,false)) {
            selectedLocation = "TagumCity_Liboganon";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_Madaum1,false)) {
            selectedLocation = "TagumCity_Madaum1";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_Madaum2,false)) {
            selectedLocation = "TagumCity_Madaum2";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_Magdum,false)) {
            selectedLocation = "TagumCity_Magdum";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_MagugpoEast,false)) {
            selectedLocation = "TagumCity_MagugpoEast";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_MagugpoNorth,false)) {
            selectedLocation = "TagumCity_MagugpoNorth";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_MagugpoPoblacion,false)) {
            selectedLocation = "TagumCity_MagugpoPoblacion";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_MagugpoSouth,false)) {
            selectedLocation = "TagumCity_MagugpoSouth";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_MagugpoWest,false)) {
            selectedLocation = "TagumCity_MagugpoWest";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_Mankilam,false)) {
            selectedLocation = "TagumCity_Mankilam";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_NewBalamban,false)) {
            selectedLocation = "TagumCity_NewBalamban";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_NuevaFuerza,false)) {
            selectedLocation = "TagumCity_NuevaFuerza";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_Pagsabangan,false)) {
            selectedLocation = "TagumCity_Pagsabangan";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_Pandapan,false)) {
            selectedLocation = "TagumCity_Pandapan";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_SanAgustin,false)) {
            selectedLocation = "TagumCity_SanAgustin";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_SanIsidro,false)) {
            selectedLocation = "TagumCity_SanIsidro";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_SanMiguel,false)) {
            selectedLocation = "TagumCity_SanMiguel";
        }
        else if (PolyUtil.containsLocation(point,TagumCity_VisayanVillage,false)) {
            selectedLocation = "TagumCity_VisayanVillage";
        }
        else {
            markerOptions.title("Invalid Location");
            markerOptions.snippet("Please select point inside city boundaries");
            selectedLocation = "";
            return;
        }

        try {
            String loc = AssetPropertyReader.getCityBarangayPropertyValue(selectedLocation, context);
            markerOptions.title("Selected point is within");
            markerOptions.snippet(loc);
        }
        catch (IOException e){

        }
    }

}
