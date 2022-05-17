package JNA;

import com.sun.jna.*;
import com.sun.jna.ptr.PointerByReference;
import struct.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class JNA_connect {



    private static final Logger logger = Logger.getLogger(JNA_connect.class.getName());


    public static native int RdpClientEntry(rdp_client_entry_points_v1 cls);
    public static native rdp_context freerdp_client_context_new(rdp_client_entry_points_v1 cls);
    public static native int freerdp_client_start(rdp_context rdp);
    public static rdp_client_entry_points_v1 cls = new rdp_client_entry_points_v1();
    public static native int jna_freerdp_parse_arguments(rdp_context context,StringArray array,int arraySize);
    static {
        Native.register("/Users/kimfk567/Documents/IntelliSave/FreeRDP-Mac2/client/Mac/cli/MacFreeRDP.app/Contents/MacOS/MacFreeRDP");
    }
    public static void main(String[] args) throws InterruptedException {

        Frame f = new Frame();
        f.setTitle("Frame Test");//제목

        f.setSize(300,300); //크기
        f.setVisible(true);//생성
        //logger.info(freerdp_get_version_string());

        RdpClientEntry(cls);
        rdp_context dd = freerdp_client_context_new(cls);

        ArrayList<String> info = new ArrayList<>();
        info.add("/Users/kimfk567/Documents/IntelliSave/FreeRDP-Mac2/client/Mac/cli/MacFreeRDP.app/Contents/MacOS/MacFreeRDPParseCommandLineArguments");
        info.add("/v:211.253.10.9:3389");
        info.add("/u:administrator");
        info.add("/p:Netand141)");
        String[] arrayInfo = info.toArray(new String[0]);
        int arrayInfoSize = arrayInfo.length;

        jna_freerdp_parse_arguments(dd,new StringArray(arrayInfo), arrayInfoSize);

        freerdp_client_start(dd);
        logger.info("startCls 끝");

    }







}
