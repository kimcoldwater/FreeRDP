package JNA;

import com.sun.jna.*;
import com.sun.jna.ptr.PointerByReference;
import struct.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class JNA_connect_image {



    private static final Logger logger = Logger.getLogger(JNA_connect_image.class.getName());

  //  public static native boolean mac_pre_connect(String a);
   // public static native String freerdp_get_version_string();
    //public static native void freerdp_new();
   // static long a = 1;
   public static native int RdpClientEntry(rdp_client_entry_points_v1 cls);
   public static native rdp_context freerdp_client_context_new(rdp_client_entry_points_v1 cls);
   public static native int freerdp_client_start(rdp_context rdp);
  public static native int freerdp_client_settings_parse_command_line(rdp_context_library.rdpSettings settings,int argc,PointerByReference argv,boolean bool);
  // public static native int freerdp_client_settings_command_line_status_print(rdp_context_library.rdpSettings settings,int status,int argc,PointerByReference arg);
   public static rdp_client_entry_points_v1 cls = new rdp_client_entry_points_v1();
   public static int argc = new rdp_context().argc;
   public static PointerByReference argv = new rdp_context().argv;
   //public static native void CreateContextJavaModul();
   // public static native int RdpClientEntry(rdp_client_entry_points_v1 cls);
   // public static native void rdp_new();
   // public static native void CreateContextTest();
  //  public static native void CreateContextTest2();
    public static native void CreateContextTest3();
   // public static native void CreateContextTest4();
  // static rdp_freerdp freerdp = new rdp_freerdp();
  //  public static native boolean freerdp_connect(rdp_freerdp rdp);
   public static native sig_t signal(int signal, sig_t sigfunc);
   public static native GDI_BITMAP imageTest(GDI_BITMAP bitmap);
   public static native GDI_BITMAP imageResult();
   public static native int jna_freerdp_parse_arguments(rdp_context context,StringArray array,int arraySize);
   static GDI_BITMAP bitmapp = new GDI_BITMAP();


    static {
        Native.register("/Users/kimfk567/Documents/IntelliSave/FreeRDP-Mac2/client/Mac/cli/MacFreeRDP.app/Contents/MacOS/MacFreeRDP");
    }

    public static void main(String[] args) throws InterruptedException {
    /*   CreateContextTest();
        int status =  freerdp_client_settings_parse_command_line(settings, argc , argv ,false);
        logger.info("status"+status);
        freerdp_client_settings_command_line_status_print(settings,status,argc , argv );
        CreateContextTest2();

     */

        Frame f = new Frame();

        f.setTitle("Frame Test");//제목

        f.setSize(300,300); //크기
        f.setVisible(true);//생성
        //logger.info(freerdp_get_version_string());

        start1();
        RdpClientEn(cls);
        rdp_context dd = freerdp_client_conNew(cls);

        ArrayList<String> info = new ArrayList<>();
        info.add("/Users/kimfk567/Documents/IntelliSave/FreeRDP-Mac2/client/Mac/cli/MacFreeRDP.app/Contents/MacOS/MacFreeRDPParseCommandLineArguments");
        info.add("/v:211.253.10.9:3389");
        info.add("/u:administrator");
        info.add("/p:Netand141)");
        String[] arrayInfo = info.toArray(new String[0]);
        int arrayInfoSize = arrayInfo.length;

       jna_freerdp_parse_arguments(dd,new StringArray(arrayInfo), arrayInfoSize);



     //   int status =  parse_line(settings, argc , argv ,false);
      //  logger.info("status"+status);
     //  line_status_print(settings,status,argc , argv );
       // logger.info("commandline"+commandline);
        freerdp_client_startCls(dd);
        logger.info("startCls 끝");
        // instantiate a callback wrapper instance




    //logger.info("aaa"+dd.channelErrorNum);

    }

    public static void start1(){
        CreateContextTest3();

    }

    public static void RdpClientEn(rdp_client_entry_points_v1 cls){
        RdpClientEntry(cls);
    }

    public static rdp_context freerdp_client_conNew(rdp_client_entry_points_v1 cls){
        return freerdp_client_context_new(cls);
    }

 /*   public static int parse_line(rdp_context_library.rdpSettings settings,int argc,PointerByReference argv,boolean bool){
         return freerdp_client_settings_parse_command_line(settings, argc , argv ,false);
    }

    public static void line_status_print(rdp_context_library.rdpSettings settings,int status,int argc,PointerByReference arg){
         freerdp_client_settings_command_line_status_print(settings,status,argc , argv );
    }*/

    public static void freerdp_client_startCls(rdp_context rdp){
         freerdp_client_start(rdp);
    }

  /*  public static boolean MRDP_view_mac_pre_connect(){
        String a = "0x14e89f400";
        boolean b = mac_pre_connect(a);
        return b;

    }*/
  public interface sig_t extends Callback {
      void apply(int int1);
  }

  /*public static boolean setInfo(){
      String arg;
      ArrayList<String> args = new ArrayList<>();


  }*/




}
