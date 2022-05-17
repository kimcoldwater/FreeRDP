package callback;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import struct.BITMAP_UPDATE;
import struct.rdp_client_entry_points_v1;
import struct.rdp_context;

import java.awt.*;
import java.util.logging.Logger;

public class CallBackBitmap {

    public static Logger log = Logger.getLogger(CallBackBitmap.class.getSimpleName());

    public interface CLibrary extends Library {

        public interface bitmapTest1 extends Callback {
            void invoke(Pointer data);
        }

        public static class bitmapTest1Impl implements bitmapTest1 {
            @Override
            public void invoke(Pointer data) {
                log.info("java mehtod, callback: "+data);

            }
        }

        public interface pBitmapUpdate extends Callback {
            boolean apply(rdp_context context, BITMAP_UPDATE bitmap);
        }
        public static class pBitmapUpdateImpl implements pBitmapUpdate{
            @Override
            public boolean apply(rdp_context context, BITMAP_UPDATE bitmap){
                log.info("pBitmapUpdate 호출");
                return true;
            }
        }

        //boolean gdi_bitmap_update(rdp_context context,BITMAP_UPDATE bitmapUpdate);
        public void callUpdate(pBitmapUpdate callback);
        public int giveup(bitmapTest1 callback);
        public int RdpClientEntry(rdp_client_entry_points_v1 cls);
        public rdp_context freerdp_client_context_new(rdp_client_entry_points_v1 cls);
        public  int freerdp_client_start(rdp_context rdp);

    }


    static public void main(String argv[]) {

        CLibrary clib = (CLibrary) Native.loadLibrary("/Users/kimfk567/Documents/IntelliSave/FreeRDP-Mac2/client/Mac/cli/MacFreeRDP.app/Contents/MacOS/MacFreeRDP", CLibrary.class);

        // instantiate a callback wrapper instance
        CLibrary.bitmapTest1Impl callbackImpl = new CLibrary.bitmapTest1Impl();
        CLibrary.pBitmapUpdateImpl pBitmapUpdateImpl = new CLibrary.pBitmapUpdateImpl();
        rdp_client_entry_points_v1 cls = new rdp_client_entry_points_v1();


        Frame f = new Frame();

        f.setTitle("Frame Test");//제목

        f.setSize(300,300); //크기
        f.setVisible(true);//생성

        // pass the callback wrapper to the C library
        clib.RdpClientEntry(cls);
        rdp_context dd = clib.freerdp_client_context_new(cls);
        clib.freerdp_client_start(dd);
        clib.giveup(callbackImpl);
        clib.callUpdate(pBitmapUpdateImpl);


    }
}
