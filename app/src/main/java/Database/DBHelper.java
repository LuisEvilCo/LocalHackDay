package Database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.Time;
import android.util.Log;
import android.database.SQLException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by mikesaurio on 19/09/15.
 */
public class DBHelper extends SQLiteOpenHelper {
    /** Path donde se encontrara alojada la BD en el tel�fono **/
    private static String DB_PATH = "";
    /** Nombre de la base de datos **/
    private final static String DB_NAME = "LocalHackDay";

    private SQLiteDatabase myDataBase;
    private final Context myContext;

    /** Constructor **/
    @SuppressLint("SdCardPath")
    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;

        DB_PATH = "/data/data/" + myContext.getPackageName() + "/databases/";
    }


    /**
     * Comprueba si ya existe nuestra base de datos
     *
     * @return true si ya existe, false si no
     **/
    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
            //TODO: bug en linea 48 'cannot open file'

        } catch (Exception e) {
            Log.i("Base de datos", "falla en checkDataBAse");
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return  (checkDB != null);
    }

    /**
     * Crea una base de datos vac�a y escribe en ella nuestra propia Base de
     * Datos
     **/
    public void createDataBase(Context contexto) throws IOException {

        /** Comprueba si ya existe la base de datos **/
        boolean dbExist = checkDataBase();

        if (dbExist) {
            /** Si existe la base de datos no hace nada **/
        } else {
            /**
             * Si no existe se llama a este metodo que crea una nueva base de
             * datos en la ruta por defecto
             **/
            this.getReadableDatabase();
            try {
                /**
                 * Copia nuestra database.sqlite en la nueva base de datos
                 * creada
                 **/
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copiando la Base de Datos");
            }
        }
    }

    /**
     * Copia nuestra base de datos sqlite de la carpeta assets a nuestra nueva
     * Base de Datos
     **/
    private void copyDataBase() throws IOException {

        /** Abre nuestra base de datos del fichero **/
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        /** La direcci�n de nuestra nueva Base de Datos **/
        String outFileName = DB_PATH + DB_NAME;

        /** Abre la nueva Base de Datos **/
        OutputStream myOutput = new FileOutputStream(outFileName);

        /** Transfiere bytes desde nuestro archivo a la nueva base de datos **/
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        /** Cierra los stream **/
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    /**
     * Abre la base de datos
     *
     * @throws SQLException
     **/
    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}


    public SQLiteDatabase loadDataBase(Context context, DBHelper helper) throws IOException {
        helper.createDataBase(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        return db;
    }

    /* Inserta en la BDlITE la informacion de horario */

    public boolean sethorario(SQLiteDatabase bd, String grupo, String materia, String profesor, String lunes, String martes, String miercoles, String jueves, String viernes){
        Time now = new Time();
        now.setToNow();
        String date = Long.toString(now.toMillis(false));
        try{
            if(deletehorario(bd)){
                bd.execSQL("insert into horario (horario_materia, horario_profesor, horario_lunes, horario_martes, horario_miercoles, horario_jueves, horario_viernes ) values ('" + grupo + "','" + materia + "','" + profesor + "','" + lunes + "','" + martes + "','" + miercoles + "','" + jueves + "','" + viernes + "');");
                Log.d("***********","Insertando en base de datos");
                return true;
            }
            Log.d("*****FALLA******","No se insertó en base de datos");
            return false;
        }catch(Exception e){
            Log.d("******FALLA****", "Insertando en base de datos");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletehorario(SQLiteDatabase bd){
        try{
            bd.execSQL("delete from horario");
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public String getGrupo(SQLiteDatabase bd){
        Cursor c = null;
        String json = null;
        c = bd.rawQuery("select * from horario", null); //name of db
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            json = c.getString(c.getColumnIndex("infractions_json"));
        }
        c.close();
        return json;
    }

    public String getMateria(SQLiteDatabase bd){

        Cursor c = null;
        String  materia= null;

        c = bd.rawQuery("select * from horario", null);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            materia = c.getString(c.getColumnIndex("horario_materia"));
        }
        c.close();
        return materia;
    }

    public String getProfesor(SQLiteDatabase bd){

        Cursor c = null;
        String  profesor= null;

        c = bd.rawQuery("select * from horario", null);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            profesor = c.getString(c.getColumnIndex("horario_profesor"));
        }
        c.close();
        return profesor;
    }

    public String getLunes(SQLiteDatabase bd){

        Cursor c = null;
        String  lunes= null;

        c = bd.rawQuery("select * from horario", null);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            lunes = c.getString(c.getColumnIndex("horario_lunes"));
        }
        c.close();
        return lunes;
    }

    public String getMartes(SQLiteDatabase bd){

        Cursor c = null;
        String  martes= null;

        c = bd.rawQuery("select * from horario", null);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            martes = c.getString(c.getColumnIndex("horario_martes"));
        }
        c.close();
        return martes;
    }

    public String getMiercoles(SQLiteDatabase bd){

        Cursor c = null;
        String  miercoles= null;

        c = bd.rawQuery("select * from horario", null);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            miercoles = c.getString(c.getColumnIndex("horario_miercoles"));
        }
        c.close();
        return miercoles;
    }

    public String getJueves(SQLiteDatabase bd){

        Cursor c = null;
        String  jueves= null;

        c = bd.rawQuery("select * from horario", null);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            jueves = c.getString(c.getColumnIndex("horario_jueves"));
        }
        c.close();
        return jueves;
    }

    public String getViernes(SQLiteDatabase bd){

        Cursor c = null;
        String  viernes= null;

        c = bd.rawQuery("select * from horario", null);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            viernes = c.getString(c.getColumnIndex("horario_virnes"));
        }
        c.close();
        return viernes;
    }

    /**
     * inserta en la BDLite la informacion de un viaje
    // * @param bd
     //* @param placa
     * @return
     */

    /*public boolean setCops(SQLiteDatabase bd,String placa){
        Time now = new Time();
        now.setToNow();
        String date = Long.toString(now.toMillis(false));
        try{
            if(deleteCops(bd)){
                bd.execSQL("insert into cops (cops_json,cops_date) values ('" + placa + "','" + date + "');");
                Log.d("***********","Insertando Cops en base de datos");
                return true;
            }
            Log.d("*****FALLA******","No se insertó Cops en base de datos");
            return false;
        }catch(Exception e){
            Log.d("******FALLA****", "Insertando Cops en base de datos");
            e.printStackTrace();
            return false;
        }
    }*/

    /**
     * Regresa el Json de policias
  //   * @param bd
     * @return
     */
 /*
    public String getPolicias(SQLiteDatabase bd){
        Cursor c = null;
        String json = null;
        c = bd.rawQuery("select * from cops", null);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            json = c.getString(c.getColumnIndex("cops_json"));
        }
        c.close();
        return json;
    }
*/
    /**
     * inserta en la BDLite la informacion de un viaje
    // * @param bd
  //   * @param placa
     * @return
     */
 /*
    public boolean setInfractions(SQLiteDatabase bd,String placa){
        Time now = new Time();
        now.setToNow();
        String date = Long.toString(now.toMillis(false));
        try{
            if(deleteInfractions(bd)){
                bd.execSQL("insert into infractions (infractions_json,infractions_date) values ('" + placa + "','" + date + "');");
                Log.d("***********","Insertando infractions en base de datos");
                return true;
            }
            Log.d("*****FALLA******","No se insertó infractions en base de datos");
            return false;
        }catch(Exception e){
            Log.d("******FALLA****", "Insertando infractions en base de datos");
            e.printStackTrace();
            return false;
        }
    }


    public boolean deleteInfractions(SQLiteDatabase bd){
        try{
            bd.execSQL("delete from infractions");
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * Regresa el Json de policias
     * @param bd
     * @return
     */
   /*
    public String getInfractions(SQLiteDatabase bd){
        Cursor c = null;
        String json = null;
        c = bd.rawQuery("select * from infractions", null);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            json = c.getString(c.getColumnIndex("infractions_json"));
        }
        c.close();
        return json;
    }

*/
}